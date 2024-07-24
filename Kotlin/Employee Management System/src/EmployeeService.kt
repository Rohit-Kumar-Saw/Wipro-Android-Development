data class Employee (
    val id: Int,
    var name: String,
    var position: String,
    var salary : Double
)

class EmployeeService {
    val employees=mutableListOf<Employee>()

    fun addEmployee(employee: Employee)
    {
        employees.add(employee)
        println(" Employee added: $employee")
    }

    fun updateEmployee(id: Int, name: String, position: String, salary: Double)

    {
        val employee = employees.find{it.id == id}
        if(employee!=null)
        {
            employee.name =name
            employee.position=position
            employee.salary=salary
            println("Employee update: $employee")
        }
        else
        {
            println("Employee not found")
        }
    }

    fun deleteEmployee(id: Int)
    {
        val employee = employees.find{ it.id==id}
        if(employee != null)
        {
            employees.remove(employee)
            println("Employee deleted: $employee")
        }
        else
        {
            println("Employee not found")
        }
    }
    fun viewEmployees()
    {
        employees.forEach { println(it) }
    }
}