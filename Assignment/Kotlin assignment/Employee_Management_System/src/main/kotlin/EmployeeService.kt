package org.example

class EmployeeService {
    private val employees = mutableListOf<Employee>()
    private val departments = mutableListOf(
        Department(1, "HR"),
        Department(2, "IT"),
        Department(3, "Finance")
    )

    fun addEmployee(id: Int, name: String, age: Int, departmentId: Int): String {
        val department = departments.find { it.id == departmentId }
        return if (department != null) {
            val employee = Employee(id, name, age, department)
            employees.add(employee)
            "Employee added successfully."
        } else {
            "Invalid Department ID."
        }
    }

    fun viewEmployees(): List<Employee> {
        return employees
    }

    fun updateEmployee(id: Int, newName: String, newAge: Int, newDepartmentId: Int): String {
        val employee = employees.find { it.id == id }
        val department = departments.find { it.id == newDepartmentId }
        return if (employee != null && department != null) {
            employee.name = newName
            employee.age = newAge
            employee.department = department
            "Employee updated successfully."
        } else {
            "Employee or Department not found."
        }
    }

    fun deleteEmployee(id: Int): String {
        val employee = employees.find { it.id == id }
        return if (employee != null) {
            employees.remove(employee)
            "Employee deleted successfully."
        } else {
            "Employee not found."
        }
    }

    fun getDepartments(): List<Department> {
        return departments
    }
}
