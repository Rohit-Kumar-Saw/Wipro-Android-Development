import java.time.LocalDate

class User(private val username: String, private val password: String) {
    private var loggedIn: Boolean = false
    private val expenses: MutableList<Expense> = mutableListOf()

    fun login(username: String, password: String) {
        if (this.username == username && this.password == password) {
            loggedIn = true
            println("Welcome, $username!")
        } else {
            println("Invalid username or password.")
        }
    }

    fun addExpense(amount: Double, description: String, date: LocalDate = LocalDate.now()) {
        if (loggedIn) {
            expenses.add(Expense(amount, description, date))
            println("Added expense: $description - $amount on $date")
        } else {
            println("Please log in to add expenses.")
        }
    }

    fun displayExpensesSummary(
        filter: (Expense) -> Boolean = { true },
        sort: Comparator<Expense> = compareBy { it.date }
    ) {
        if (loggedIn) {
            val filteredExpenses = expenses.filter(filter)
            val sortedExpenses = filteredExpenses.sortedWith(sort)
            if (sortedExpenses.isNotEmpty()) {
                val totalExpenses = sortedExpenses.sumOf { it.amount }
                println("Total expenses: $totalExpenses")
                for (expense in sortedExpenses) {
                    println("${expense.date}: ${expense.description} - ${expense.amount}")
                }
            } else {
                println("No expenses recorded.")
            }
        } else {
            println("Please log in to view expenses.")
        }
    }

    public data class Expense(val amount: Double, val description: String, val date: LocalDate)
}