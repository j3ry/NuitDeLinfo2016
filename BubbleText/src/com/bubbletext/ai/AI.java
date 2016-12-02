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
                result += SearchWiki.getWikiHead(response.getResult().getStringParameter("content"));
                break;
            case "send_mail":
                result += "Je ne peux pas faire ça";
                break;
            case "time_in":
                result += TimeAction.timeInCity(response.getResult().getStringParameter("geo_city"));
                break;
            case "current_time":
                result += TimeAction.currentTime();
                break;
            case "current_date":
                result += TimeAction.currentDate();
                break;
            case "access_website":
                if(!response.getResult().getParameters().isEmpty())
                    OpenUrlAction.openUrl(response.getResult().getStringParameter("url"));
                break;
            default:
                break;
        }
        result += "\n";
        return result;
    }
}
