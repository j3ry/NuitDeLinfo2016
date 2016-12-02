package com.bubbletext.ai;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by charles on 12/1/16.
 */
public class SearchWiki {
    public static String getWikiHead(String subject){
        String rawUrl = "https://fr.wikipedia.org/wiki/"+subject;
        Document doc = null;
        try {
            doc = Jsoup.connect(rawUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(doc != null) {
            Elements large_p = doc.select("div#mw-content-text > p:first-of-type");
            String result = large_p.text();
            System.out.println(result);
        }
        return null;
    }
}
