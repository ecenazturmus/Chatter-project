import com.ecenazturmus.chatter.*;

/*
Firstly, I would like to talk about the Human interface here. I defined the functions used in classes like UserType1, cat, car, etc., by implementing the functions from the 'Insan' interface.
The main reason for having it is to be able to put all objects into a single list, and I chose to use a HashMap type for this because otherwise, I would have to put the values into two separate ArrayLists and access them like list0[x], list1[x].
However, using a map seemed more intelligent. After saving the IDs, I instructed the object to register itself in the message transmission class. 
I transferred its own reference to the central object using the 'this' keyword in order to access its ID later. In the 'myID' function, I accessed the IDs and stored the 'id' and 'Insan' pairs in the HashMap.
Sending messages is straightforward. After entering the IDs of the recipients and your message following the colon, the 'send' function formats the message as 'sender:recipient:message' and sends it to the 'CenteralObject's receiveMessage' section. 
Then, it saves the message to a file (created with its own ID).

The 'receiveMessage' function checks if the message contains 'all'. If yes, it splits the message by ',' and sends the message to all users using the 'sendMessageEveryone' function. If not, it splits the message by ',' and sends the message individually to each user using the 'sendMessage' function.

The 'sendMessage' function, using the 'parseInt' method, converts the ID to a number, sends the message to itself, and checks if it has sent it to itself.
If it didn't send it to itself, the message is forwarded, and the message reaches the specified object. 
The object, in turn, saves the message using the 'store' function, and the code ends. The 'addme' and 'delete me' functions call the 'add' and 'delete' functions inside the 'central object,' respectively, for registration or deletion.

*/
public class Ece {
    public static void main(String args[]) {

        UserType2 nil = new UserType2();
        UserType4 ahmet = new UserType4();
        UserType1 resul = new UserType1();
        UserType3 ece = new UserType3();
        nil.send(ahmet.myID() + ":You're doing great!");
        ahmet.send(nil.myID() + ":quote");
        resul.send(ece.myID() + "," + ece.myID() + ":quote");
        ece.send("all:quote");
    }
}


