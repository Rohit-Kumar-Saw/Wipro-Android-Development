package Client_server_architecture;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.io.IOException;

public class helper {
      
    Scanner sc=new Scanner (System.in);
    public void sendMessage(DataOutputStream out, String message)
    {
        try{
            out.writeUTF(message);
            out.flush();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            
        }
    }
    public String receiveMessage(DataInputStream input)
    {
        try{
            String message=input.readUTF();
            return message;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return "Error while sending Message";
        }
    }
    public int showOptions()
    {
        System.out.println("1. Send Message");
        System.out.println("2. Inbox");
        System.out.println("3. Exit");

        System.out.print("Enter your choice");
        int choice=sc.nextInt();

        return choice;
    }
    
}
