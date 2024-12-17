import java.io.*;
import java.net.*;
import java.util.*;
public class TCPConcurrentServer {
  public static void main(String[] args) {

    String clientSentence;
    String capitalizedSentence;
    ServerSocket socket = null;

    try{
      socket = new ServerSocket(1667);
    }catch (IOException e) {
      System.out.println("Cannot create a welcome socket");
    }

    while (true) {
      try {
        System.out.println("Waiting for client connection at port number 1667");
        Socket connectiSocket = socket.accept();
        EchoThread echoThread = new EchoThread(connectiSocket);
        echoThread.start();

      }
      catch (IOException e){
        System.out.println("Cannot create this connection");
      }
    }
  }
}
