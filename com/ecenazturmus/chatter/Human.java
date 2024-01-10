package com.ecenazturmus.chatter;
interface Human {
    public void send(String msg);

    public void receive(String msg);

    public void store(int sender, String msg);

    public void deleteMe();

    public void addMe();

    public int myID();
}
