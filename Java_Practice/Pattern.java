public class Pattern {

    public static void main(String[] args) {
        for(int i=1;i<=5;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=5;i>=1;i--)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for(int i=1;i<=5;i++)
        {
            for(int j=5;j>=i;j--)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
            
        }
//Hollow Triangle
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5-i-1;j++)
            {
                System.out.print(" ");
            }
            for(int k=0;k<2*i+1;k++)
            {
                if(k==0||k==2*i||i==5-1)
                {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


        
        
       
       
    }
}