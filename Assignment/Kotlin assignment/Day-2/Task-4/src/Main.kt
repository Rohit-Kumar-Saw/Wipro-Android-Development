
// Task :4 -Implement inheritance by creating specific transaction classes like Income and Expense that inherit from Transaction.

fun main() {
    val income = Income(1000.0, "Salary for July", "Company XYZ")
    val expense = Expense(200.0, "Groceries", "Food")

    println(income.getDetails())
    println(expense.getDetails())
}
