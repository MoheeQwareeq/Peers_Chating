package Peers_Chating;

import java.net.*;


public class Main {
 public static void main(String[] args) throws UnknownHostException  {
       
        ClientChat client1 =new ClientChat("/Users/MMM/Desktop/Peers_Chating/");
        client1.setVisible(true);
        
        ClientChat client2 =new ClientChat("/Users/MMM/Desktop/Peers_Chating/");
        client2.setVisible(true);
        
        ClientChat client3 =new ClientChat("/Users/MMM/Desktop/Peers_Chating/");
        client3.setVisible(true);

        Server server=new Server();
        server.setVisible(true);
        
 }
}  

    
    