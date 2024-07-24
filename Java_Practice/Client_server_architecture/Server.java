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
import java.net.ServerSocket;

public class Server {
    private Socket socket=null;
    private DataInputStream input=null;
    private DataOutputStream out=null;
    private ServerSocket server=null;

    Scanner sc=new Scanner(System.in);
    List<String> inbox=new ArrayList<>();
    helper h=new helper();
    public Server(int port)
    {
        try {
            server=new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for the client...");

            socket=server.accept();//accept the client to connect

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
        catch (Exception e)
        {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Server s=new Server(8000);
    }

    

    
}
