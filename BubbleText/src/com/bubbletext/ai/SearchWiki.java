package com.bubbletext.ai;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * Created by charles on 12/1/16.
 */
public class SearchWiki {
    public static void getWikiHead(String subject){
        String subjectEncoded = "";
        try {
            subjectEncoded = URLEncoder.encode(subject, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String rawUrl = "https://fr.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="+subjectEncoded;

        JSONObject jsonObject = null;
        try {
            jsonObject = readJsonFromUrl(rawUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONObject query = jsonObject.getJSONObject("query");
        JSONObject jsonObject1 = query.getJSONObject("pages");
        JSONObject jsonObject2 = jsonObject1.getJSONObject(jsonObject1.keySet().toArray()[0].toString());
        if(jsonObject2.keySet().contains("missing"))
            return;

        String extract = jsonObject2.getString("extract");
        if(extract.isEmpty()) {
            extract = " go to \"https://fr.wikipedia.org/wiki/" + subject+"\"";
        }

        System.out.println(extract);

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        }
    }

}
