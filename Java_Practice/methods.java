public class methods {
    public static void sum(int a, int b)
    {
        System.out.println("Sum= "+(a+b));
    }
    public static void sub(int a, int b)
    {
        System.out.println("Sub= "+(a-b));
    }
    public static double sine(int a)
    {
        return Math.sin(a);
    }
    public static int prod(int a, int b)
    {
        return a*b;
    }
    public static void main(String[] args) {
        methods m= new methods();
        m.sum(5,6);
        m.sum(6,9);
        sub(4,1);
        int result=prod(5,6);
        System.out.println("product:" + result);
        System.out.println("sine: "+sine(0));
        
    }
}
