package Collections.EMS;
import java.util.*;
import java.io.IOException;

public class Runner {
    Runner(){

    }
    public static void main(String[] args) throws IOException {
        
        List<emp>list=new ArrayList<>();
        Console con=new Console();
        Listdb db=new Listdb();

        while(true)
        {
            switch(con.showOptions())
            {
                case 1:
                  db.getAllEmp(list);
                  break;
                case 2:
                  emp e=con.acceptEmp();
                  boolean inserted=db.addEmp(list,e);
                    if(inserted)
                    {
                        System.out.println("Employee inserted successfully");
                        System.out.println("Employee ID: " +e.id+"\n");
                    }
                    else
                    {
                        System.out.println("Error while interesting the employee");
                    }
                    break;
                case 3:
                  String id=con.getEmpId();
                  if(!db.empExist(list,id))
                  {
                    System.out.println("Employee doesn't exist with this id");
                    break;
                  }
                  emp updatedEmp=con.editEmp(db.getEmpById(list,id));
                  db.updateEmp(list,id,updatedEmp);
                  System.out.println("Employee updated successfully");
                  break;
                   
                case 4:
                   String empid= con.removeEmp();
                   //fetching the emp obj by id
                   Optional<emp> oe= list.stream().filter(d -> d.id.equals(empid)).findFirst();
                   if(!oe.isPresent())
                   {
                    System.out.println("Employee with this id doesn't exist");
                    break;
                   }
                   db.deleteEmp(list, oe.get());
                   System.out.println("Employee deleted successfully");
                   break;
                case 5:
                    System.out.println("Thank you for using our employee management system");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
            
        }
    }
    
}
