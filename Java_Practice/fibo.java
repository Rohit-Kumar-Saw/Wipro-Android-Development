public class fibo {
    public static void main(String[] args) {
        printfibo(10);
    }
    public static void printfibo(int n)
    {
        int pre1=0,pre2=1;
        for(int i=0;i<n;i++)
        {
            System.out.print(pre1+" ");
            int temp=pre2+pre1;
            pre1=pre2;
            pre2=temp;
        }
    
    }
       
}
