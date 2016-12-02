package com.bubbletext.ai;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

/**
 * Created by charles on 12/1/16.
 */
public class AI {

    private String token;
    private AIConfiguration conf;
    private AIDataService dataService;

    public AI(String token) {
        this.token = token;
        this.conf = new AIConfiguration(this.token);
        this.dataService = new AIDataService(this.conf);
    }

    public String sendMessage(String msg) throws AIServiceException {
        String result = "";
        AIResponse response = this.dataService.request(new AIRequest(msg));

        if (response.getStatus().getCode() == 200) {
            result += response.getResult().getFulfillment().getSpeech() + " ";
        } else {
            result += response.getStatus().getErrorDetails();
        }

        switch (response.getResult().getAction()){
            case "search_wikipedia":
                String wikiHead;
                if ((wikiHead = SearchWiki.getWikiHead(response.getResult().getStringParameter("content"))) == null) {
                    result = "Je n'ai rien trouvé sur le sujet sur Wikipedia.";
                } else {
                    result = wikiHead;
                }
                break;
            case "send_mail":
                //TODO
                break;
            case "time_in":
                String time;
                if ((time = TimeAction.timeInLocation(response.getResult().getStringParameter("geo-city"))) == null) {
                    result = "Je n'ai pas pu localisé cet endroit, désolé ...";
                } else {
                    result += time;
                }
                break;
            case "current_time":
                result += TimeAction.currentTime() + ".";
                break;
            case "current_date":
                result += TimeAction.currentDate() + ".";
                break;
            case "access_website":
                if(!response.getResult().getParameters().isEmpty())
                    OpenUrlAction.openUrl(response.getResult().getStringParameter("url"));
                break;
            default:
                break;
        }
        result = (char) 27 + "[33mBubbleText >  " + (char) 27 + "[0m" + result;
        return result;
    }
}
