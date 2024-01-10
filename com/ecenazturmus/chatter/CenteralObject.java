package com.ecenazturmus.chatter;
import java.util.*;

public class CenteralObject {
    private static int uniqueId = 0;
    private static HashMap<Integer, Human> everyObject = new HashMap<Integer, Human>();
    private static ArrayList<Integer> everyID = new ArrayList<Integer>();

    public static void sendMessage(int id, String msg) {
        if (everyObject.get(id).myID() == Integer.parseInt(msg.split(":")[0])) {
            // Do not forward the message to the owner
        } else {
            everyObject.get(id).receive(msg);
        }
    }

    public static void sendMessageEveryone(String msg) {
        for (int i = 0; i < everyID.size(); i++) {
            if (everyID.get(i) == Integer.parseInt(msg.split(":")[0])) {
                // Do not forward the message to the owner
            } else {
                everyObject.get(everyID.get(i)).receive(msg);
            }
        }
    }

    public static void receiveMessage(String msg) {
        String parts[] = msg.split(":");
        if (parts[1].equals("all")) {
            sendMessageEveryone(msg);
        } else {
            String users[] = parts[1].split(",");
            for (int i = 0; i < users.length; i++) {
                sendMessage(Integer.parseInt(users[i]), msg);
            }
        }
    }

    public static int newId() {
        uniqueId = uniqueId + 2;
        return uniqueId;
    }

    public static void add(Human user) {
        everyObject.put(user.myID(), user);
        everyID.add(user.myID());
        sendMessageEveryone(user.myID() + ":all:" + user.myID() + " joined.");
    }

    public static void delete(Human user) {
        everyObject.remove(user.myID());
        everyID.remove(user.myID());
        sendMessageEveryone(user.myID() + ":all:" + user.myID() + " disconnected.");
    }
}