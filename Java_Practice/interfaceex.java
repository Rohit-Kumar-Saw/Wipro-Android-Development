public class interfaceex {
    public void walk();
    public void talk();
    public void eat();
}
class inner implements interfaceex{
    
    public void walk()
    {
        System.out.println("Walk");
    }

    public void talk()
    {
        System.out.println("talk");
    }
    public void eat()
    {
        System.out.println("eat");
    }
}

