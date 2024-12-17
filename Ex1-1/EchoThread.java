import java.io.*;
import java.net.*;
import java.util.*;

public class EchoThread extends Thread{

  private Socket connectionSocket;

  public EchoThread(Socket connectionSocket) {
    this.connectionSocket = connectionSocket;
  }

  public void run() {
    Scanner inFromClient = null;
    DataOutputStream outToClient = null;
    int num1, num2, answer;
    try{
      inFromClient = new Scanner(connectionSocket.getInputStream());
      outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      num1 = Integer.parseInt(inFromClient.next());

      inFromClient = new Scanner(connectionSocket.getInputStream());
      outToClient = new DataOutputStream(connectionSocket.getOutputStream());
      num2 = Integer.parseInt(inFromClient.next());
      answer = num1 + num2;
      String capitalizedSentence = answer + "\n";
      outToClient.writeBytes(capitalizedSentence);
    }catch (IOException e){
      System.out.println("Closing Socket connection");
    }finally{
      try{
        if(inFromClient != null) inFromClient.close();
        if(outToClient != null) outToClient.close();
        if(connectionSocket != null) connectionSocket.close();
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
}
