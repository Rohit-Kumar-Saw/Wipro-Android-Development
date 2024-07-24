public class loops {
    public static void main(String[] args) {
        System.out.println("Rohit");//10 times
        //For loop
        for(int i=1;i<=10;i++)
        {
            System.out.println("Rohit");
        }
        ///while loop
        int i=0;
        while(i<10)
        {
            if(i%2!=0)
            {
                i++;
                continue;
            }
            if(i==50)
            {
                break;
            }
            i++;

        }
        //do-while loops
        int j=0;
        do{
            j++;
        }while(j<0);
    }
    
}
