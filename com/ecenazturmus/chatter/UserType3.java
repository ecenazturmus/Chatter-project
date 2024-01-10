package com.ecenazturmus.chatter;

import java.io.IOException;
import java.io.FileWriter;
import java.util.*;
public class UserType3 implements Human {
    private String[][] msgquote = {{"programming is good", "I hate what you are doing"},
            {"every day being single is a vacation for me", "I love cooking rabbit"}};
    private int id;

    public UserType3() {
        id = CenteralObject.newId();
        addMe();
    }

    public void send(String msg) {
        String quote = msg.split(":")[1];
        if (quote.equals("quote")) {
            Random randomNumber = new Random();
            quote = msgquote[randomNumber.nextInt(2)][randomNumber.nextInt(2)];
        }
        CenteralObject.receiveMessage(id + ":" + msg.split(":")[0] + ":" + quote);
        store(id, quote);
    }

    public void receive(String msg) {
        String parsed[] = msg.split(":");
        store(Integer.parseInt(parsed[0]), parsed[2]);
    }

    public void store(int sender, String msg) {
        try {
            FileWriter fw = new FileWriter(id + ".txt", true);
            fw.write(sender + " ->" + msg);
            fw.write("\n");
            fw.flush();
            fw.close();
        } catch (IOException exception) {
            System.out.println("Error");
        }
    }

    public int myID() {
        return id;
    }

    public void addMe() {
        CenteralObject.add(this);
    }

    public void deleteMe() {
        CenteralObject.delete(this);
    }
}
