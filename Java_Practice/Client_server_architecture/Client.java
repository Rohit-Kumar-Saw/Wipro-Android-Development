package Client_server_architecture;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.net.Socket;

public class Client {
    private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream out=null;

    Scanner sc=new Scanner(System.in);
    helper h=new helper();

    List<String> inbox=new ArrayList<>();

    public Client(String address, int  port)
    {
        try{
            socket=new Socket(address,port);
            System.out.println("Conneted");

            input=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            while(true)
            {
                int choice=h.showOptions();
                switch(choice)
                {
                    case 1:
                    System.out.print("Enter your message");
                    String message=sc.nextLine();
                    h.sendMessage(out, message);
                    break;

                    case 2:
                    inbox.add(h.receiveMessage(input));
                    System.out.println("Inbox");
                    inbox.forEach(System.out::println);
                    break;

                    case 3:
                    System.out.println("Thanks for using Java Networking Services");
                    sc.close();
                    input.close();
                    out.close();
                    socket.close();
                    System.exit(0);
                    break;

                    default:
                    System.out.println("Wrong choice");
                    break;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        Client c =new Client("127.0.0.1",8000);
    }
}
