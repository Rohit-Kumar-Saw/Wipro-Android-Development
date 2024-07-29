class User(private val username: String, private val password: String) {
    private var loggedIn: Boolean = false
    private val expenses: MutableList<Expense> = mutableListOf()

    fun login(username: String, password: String) {
        if (this.username === username && this.password === password) {
            loggedIn = true
            println("Welcome, $username!")
        } else {
            println("Invalid username or password.")
        }
    }

    fun addExpense(amount: Double, description: String) {
        if (loggedIn) {
            expenses.add(Expense(amount, description))
            println("Added expense: $description - $amount")
        } else {
            println("Please log in to add expenses.")
        }
    }

    fun displayExpensesSummary() {
        if (loggedIn) {
            if (expenses.isNotEmpty()) {
                val totalExpenses = expenses.sumOf { it.amount }
                println("Total expenses: $totalExpenses")
                for (expense in expenses) {
                    println("${expense.description}: ${expense.amount}")
                }
            } else {
                println("No expenses recorded.")
            }
        } else {
            println("Please log in to view expenses.")
        }
    }

    private data class Expense(val amount: Double, val description: String)
}