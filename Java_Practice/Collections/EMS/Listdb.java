package Collections.EMS;
import java.util.List;

public class Listdb {
    //Add an employee
    public boolean addEmp(List<emp> list,emp e)
    {
        return list.add(e);
    }
    //fetch all employee
    public void getAllEmp(List<emp> list)
    {
        list.forEach(e->System.out.println(e.toString()));
    }
    //delete an employee
    public boolean deleteEmp(List<emp> list, emp e)
    {
       return list.remove(e);
    }
    //update an employee
    public boolean empExist(List<emp> list,String id)
    {
       return list.stream().filter(e-> e.id.equals(id)).count()!=0 ? true:false;   
    }
    public emp getEmpById(List<emp> list, String id)
    {
        return list.stream().filter(e-> e.id.equals(id)).findFirst().get();
    }

    //update an employee
    public void updateEmp(List<emp> list, String id, emp updatedEmp)
    {
        list.remove(getEmpById(list, id));
        list.add(updatedEmp);
    }

    
}
