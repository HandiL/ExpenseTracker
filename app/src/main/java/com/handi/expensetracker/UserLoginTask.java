package com.handi.expensetracker;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.handi.expensetracker.Entity.UserData;
import com.handi.expensetracker.Utilities.MyUtilities;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Handi on 2/26/2018.
 */

public class UserLoginTask extends AsyncTask<String,Void,UserData>{
    private Context context;

    public UserLoginTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPostExecute(UserData userData) {
        super.onPostExecute(userData);
        ((Login)context).openMainActivity(userData);
    }

    @Override
    protected UserData doInBackground(String... strings) {
        Uri uri= Uri.parse(MyUtilities.LOGIN_URL).buildUpon().build();
        HttpURLConnection urlConnection=null;
        UserData user=null;
        try {
            URL url=new URL(uri.toString());
            urlConnection= (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(6000);
            urlConnection.setRequestMethod("POST");

            StringBuilder builder=new StringBuilder("email=")
                    .append(URLEncoder.encode(strings[0],"UTF-8"))
                    .append("&password=")
                    .append(URLEncoder.encode(strings[1],"UTF-8"));

            DataOutputStream dataOutputStream=new DataOutputStream(urlConnection.getOutputStream());
            dataOutputStream.writeBytes(builder.toString());
            dataOutputStream.flush();
            dataOutputStream.close();

            urlConnection.connect();
            int responseCode= urlConnection.getResponseCode();
            if(responseCode==urlConnection.HTTP_OK){
                InputStream inputStream=new BufferedInputStream(urlConnection.getInputStream());
                ObjectMapper objectMapper=new ObjectMapper();
                user=objectMapper.readValue(inputStream,UserData.class);
                inputStream.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection!=null){
                urlConnection.disconnect();
            }
        }
        return user;
    }
}
