package com.hhs.studybook.util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class SwingUtil {

    private final static String USER_AGENT = "Gorilla/5.0";

    /**
     * GET. Request data from a specified resource.
     *
     * @param url The URL of the database
     * @return
     */
    public static ActionResult sendGet(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Gson g = new Gson();
        return g.fromJson(response.toString(), ActionResult.class);
    }

    /**
     * POST. Responsible for sending data to a server to create/update a resource
     *
     * @param url        the URL of the database
     * @param parameters Data stored in the database
     * @return response code
     */
    public static int sendPost(String url, HashMap<String, String> parameters) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        //add reuqest header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "";
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            urlParameters += key + "=" + value + "&";
        }
        urlParameters.substring(0, urlParameters.length() - 1);
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        String returnTemp = response.substring(response.indexOf("\"code\":") + "\"code\":".length());
        return Integer.parseInt(returnTemp.substring(0, returnTemp.indexOf(",")));
    }
}
