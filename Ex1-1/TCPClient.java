import java.io.*;
import java.net.*;
import java.util.*;
public class TCPClient {
  public static void main(String[] args) {
    String num1, num2, answer;
    Scanner inFromUser = null;
    Socket clienSocket = null;
    DataOutputStream outToServer = null;
    Scanner inFromServer = null;
    try{
      inFromUser = new Scanner(System.in);
      clienSocket = new Socket("localhost",1667);
      outToServer = new DataOutputStream(clienSocket.getOutputStream());
      inFromServer = new Scanner(clienSocket.getInputStream());
      System.out.print("enter number 1 (to end just press enter): ");
      num1 = inFromUser.next();
      if(num1.equals("")){
        try{
          if(inFromServer != null) inFromServer.close();
          if(outToServer != null) outToServer.close();
          if(clienSocket != null) clienSocket.close();
        }catch(IOException e){
          e.printStackTrace();
        }
      }
      outToServer.writeBytes(num1+'\n');

      System.out.print("enter number 2 (to end just press enter): ");
      num2 = inFromUser.next();
      if(num2.equals("")){
        try{
          if(inFromServer != null) inFromServer.close();
          if(outToServer != null) outToServer.close();
          if(clienSocket != null) clienSocket.close();
        }catch(IOException e){
          e.printStackTrace();
        }
      }
      outToServer.writeBytes(num2+'\n');
      answer = inFromServer.nextLine();
      System.out.println("The result is: "+answer);
    }catch(IOException e){
      System.out.println("Error occurred: Closing the connection");
    }finally{
      try{
        if(inFromServer != null) inFromServer.close();
        if(outToServer != null) outToServer.close();
        if(clienSocket != null) clienSocket.close();
      }catch(IOException e){
        e.printStackTrace();
      }
    }
  }
}
