package File_Handling;
import java.io.*;
import java.util.Scanner;

public class FileHandling {
    public static void main(String[] args) throws Exception{
        
          /*  int ch;
          FileReader fr=new FileReader(new File("File1.txt"));
          while((ch=fr.read())!=-1)
          {
         System.out.println((char) ch);
          }
          fr.close();*/

          /*
          Scanner sc=new Scanne(new File("File1.txt"));
          while(sc.hasNextLine())
          {
            System.out.println(sc.nextLine());
          }
          sc.close();
          InputStreamReader isr=new InputStreamReader(new FileInputStream(File1.txt));
          BufferReader br=new BufferReader(isr);

          br.lines().forEach(System.out::println);
          br.close();
           */

           /*
            FileWriter fr=new FileWriter(new File("File1.txt"));
            String str="This is my new text";

            for(int i=0;i<str.length();i++)
            {
                //fr.write(str.charAt(i));
            }
            fr.close();
            */

            File f =new File("./File1.txt");
            InputStreamReader isr=new InputStreamReader(new FileInputStream("./File1.txt"));
            BufferedReader br=new BufferedReader(isr);

            br.lines().filter(name -> name.startsWith("N"))
            .forEach(System.out::println);
         
    }
    
}
