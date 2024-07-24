public class interfacerunner {
    public static void main(String[] args) {
        in obj =() -> System.out.println("Running");
        obj.run();
    }
}
interface in{
    public void run();
}
