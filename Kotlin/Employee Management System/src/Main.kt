import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val employeeService=EmployeeService()

    while(true){
        println("\nEmployee Management System")
        println("1. Add Employee")
        println("2. Update Employee")
        println("3. Delete Employee")
        println("4. View Employees")
        println("5. Exit")
        println(" Enter your choice:  ")

        when(scanner.nextInt()) {
            1->{
                print("Enter Employee ID")
                val id=scanner.nextInt()
                scanner.nextLine()
                print("Enter Employee Name")
                val name=scanner.nextLine()
                print("Enter Employee Position")
                val position=scanner.nextLine()
                print("Enter Employee Salary")
                val salary=scanner.nextDouble()

                employeeService.addEmployee(Employee(id, name, position, salary))
            }
            2->{
                print("Enter Employee ID to Update:  ")
                val id = scanner.nextInt()
                scanner.nextLine()
                print("Enter new name:  ")
                val name=scanner.nextLine()
                print(" Enter new position ")
                val position=scanner.nextLine()
                print(" Enter new salary ")
                val salary=scanner.nextDouble()

                employeeService.updateEmployee(id, name, position, salary)
            }
            3->{
                print ("Enter Employee ID to delete")
                val id=scanner.nextInt()
                employeeService.deleteEmployee(id)
            }
            4-> {
                println("Employee List: ")
                employeeService.viewEmployees()
            }
            5->{
                println(" Exiting...")
                return
            }
            else ->{
                println("Invalid choice. please chose another option.")
            }

        }

    }

}

