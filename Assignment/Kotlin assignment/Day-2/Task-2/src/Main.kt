
//Task 2: Develop a simple User class with methods to login and display a summary of expenses.

fun main() {
    val user = User("Rajesh", "password123")
    user.login("Rajesh", "password123")
    user.addExpense(25.50, "Lunch")
    user.addExpense(100.00, "Groceries")
    user.displayExpensesSummary()
}
