package org.example

import java.util.*

fun main() {
    val employeeService = EmployeeService()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Employee Management System")
        println("1. Add Employee")
        println("2. View Employees")
        println("3. Update Employee")
        println("4. Delete Employee")
        println("5. Exit")
        print("Enter your choice: ")

        when (scanner.nextInt()) {
            1 -> addEmployee(scanner, employeeService)
            2 -> viewEmployees(employeeService)
            3 -> updateEmployee(scanner, employeeService)
            4 -> deleteEmployee(scanner, employeeService)
            5 -> {
                println("Exiting...")
                break
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}

fun addEmployee(scanner: Scanner, employeeService: EmployeeService) {
    println("Add New Employee")
    print("Enter Employee ID: ")
    val id = scanner.nextInt()
    scanner.nextLine()  // Consume newline
    print("Enter Employee Name: ")
    val name = scanner.nextLine()
    print("Enter Employee Age: ")
    val age = scanner.nextInt()
    scanner.nextLine()  // Consume newline

    println("Select Department:")
    employeeService.getDepartments().forEach { println("${it.id}. ${it.name}") }
    val deptId = scanner.nextInt()
    scanner.nextLine()  // Consume newline

    val result = employeeService.addEmployee(id, name, age, deptId)
    println(result)
}

fun viewEmployees(employeeService: EmployeeService) {
    println("Employee List:")
    val employees = employeeService.viewEmployees()
    if (employees.isEmpty()) {
        println("No employees found.")
    } else {
        employees.forEach {
            println("ID: ${it.id}, Name: ${it.name}, Age: ${it.age}, Department: ${it.department.name}")
        }
    }
}

fun updateEmployee(scanner: Scanner, employeeService: EmployeeService) {
    println("Update Employee")
    print("Enter Employee ID to update: ")
    val id = scanner.nextInt()
    scanner.nextLine()  // Consume newline

    print("Enter new name: ")
    val newName = scanner.nextLine()
    print("Enter new age: ")
    val newAge = scanner.nextInt()
    scanner.nextLine()  // Consume newline

    println("Select new Department:")
    employeeService.getDepartments().forEach { println("${it.id}. ${it.name}") }
    val newDeptId = scanner.nextInt()
    scanner.nextLine()  // Consume newline

    val result = employeeService.updateEmployee(id, newName, newAge, newDeptId)
    println(result)
}

fun deleteEmployee(scanner: Scanner, employeeService: EmployeeService) {
    println("Delete Employee")
    print("Enter Employee ID to delete: ")
    val id = scanner.nextInt()
    scanner.nextLine()  // Consume newline

    val result = employeeService.deleteEmployee(id)
    println(result)
}
