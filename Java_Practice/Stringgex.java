public class Stringgex {
    public static void split()
    {
        String str= "Aryan,Naveen,Arush,Rohit";
        String[] arr=str.split(",");
        for (String s:arr)
        {
            System.out.print(s+" ");
        }
    }
    public static void main(String[] args) {
        String str="   aaRyan   ";
        String str2="Aaryan";

        System.out.println(str.trim());
        System.out.println(str2.charAt(str2.length()-1));

        char[]ch=str2.toCharArray();
        for(char c:ch)
        {
            System.out.println(c);
        }
        if(str.equalsIgnoreCase(str2))
        {
            System.out.println("Both string are equal");
        }
        else{
            System.out.println("Both string are not equal");
        }
        split();
       
    }
    
}
