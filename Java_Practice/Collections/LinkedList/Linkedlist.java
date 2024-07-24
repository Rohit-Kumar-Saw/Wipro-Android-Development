package Collections.LinkedList;

public class Linkedlist {
    public static void main(String[] args) {
    
        Node head=new Node(20);
        Node node=new Node(23);
        Node n2=new Node(45);
        head.next=node;
        head.next.next=n2;

        Node mynode=head;
        while(mynode.next !=null)
        {
            System.out.println(mynode.data);
            mynode=mynode.next;
        
        }
    }

}
