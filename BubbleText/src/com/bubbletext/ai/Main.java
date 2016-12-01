package com.bubbletext.ai;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Sylvain DUPOUY on 12/1/16.
 */
public class Main {

    public static final String TOKEN = "5e854aa33c104c7e856ca03ae4e0ade0";

    public static void main(String args[]){
        AIConfiguration conf = new AIConfiguration(TOKEN);
        AIDataService dataService = new AIDataService(conf);

        String msg = "";
        while(!msg.equals("exit")) {

            System.out.print(">");

            Scanner sc = new Scanner(System.in);
            msg = sc.nextLine();
            try {
                AIRequest request = new AIRequest(msg);

                AIResponse response = dataService.request(request);

                if (response.getStatus().getCode() == 200) {
                    System.out.println(response.getResult().getFulfillment().getSpeech());
                } else {
                    System.err.println(response.getStatus().getErrorDetails());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
