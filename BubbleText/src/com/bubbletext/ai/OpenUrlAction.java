package com.bubbletext.ai;

import java.awt.*;
import java.net.URL;

/**
 * Created by charles on 12/2/16.
 */
public class OpenUrlAction {
    public static boolean openUrl(String url){
        try {
            Desktop.getDesktop().browse(new URL("http://" + url).toURI());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
