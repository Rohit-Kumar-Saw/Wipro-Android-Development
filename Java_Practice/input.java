import java.util.Scanner;
public class input {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        if(num%2==0)
        {
            System.out.println(num+" is an  even number");
        }
        else{
            System.out.println(num+" is a odd number");
        }
        sc.close();

    }
}
