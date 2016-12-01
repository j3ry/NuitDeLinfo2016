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

    public AIResponse sendMessage(String msg) throws AIServiceException {
        AIResponse response = this.dataService.request(new AIRequest(msg));

        if (response.getStatus().getCode() == 200) {
            System.out.println(response.getResult().getFulfillment().getSpeech());
        } else {
            System.err.println(response.getStatus().getErrorDetails());
        }

        switch (response.getResult().getAction()){
            case "search_wikipedia":
                System.out.println("g pa cherché mdr");
                break;
            case "send_mail":
                System.out.println("g pas envoyé xd");
                break;
            default:
                break;
        }
        return response;
    }
}
