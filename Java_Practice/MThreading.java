public class MThreading {

    public static void printHelloWorld()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hello");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread th=new Thread(()->printHelloWorld());
        Thread th2 =new Thread(() -> System.out.println(2+2));
        //System.out.println(3+3);

        Thread.sleep(3000);
        th.start();
        //th.join();
        th2.start();
        
    }

    
}
