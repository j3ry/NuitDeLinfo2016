package com.bubbletext.ai;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
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
        AI ai = new AI(TOKEN);

        String msg = "";
        while(!msg.equals("exit")) {

            System.out.print(">");

            Scanner sc = new Scanner(System.in);
            msg = sc.nextLine();
            try {
                if(!msg.isEmpty())
                    ai.sendMessage(msg);
            } catch (AIServiceException e) {
                e.printStackTrace();
            }
        }
    }

}
