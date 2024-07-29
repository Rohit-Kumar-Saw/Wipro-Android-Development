
//Task 3: Use lambdas and higher-order functions to filter and sort transactions by date or amount.
import java.time.LocalDate
fun main() {
    val user = User("Rakesh", "password123")
    user.login("Rakesh", "password123")
    user.addExpense(25.50, "Lunch", LocalDate.of(2024, 7, 27))
    user.addExpense(100.00, "Groceries", LocalDate.of(2024, 7, 28))
    user.addExpense(50.00, "Books", LocalDate.of(2024, 7, 26))

    println("All expenses sorted by date:")
    user.displayExpensesSummary()

    println("\nAll expenses sorted by amount:")
    user.displayExpensesSummary(sort = compareBy { it.amount })

    println("\nExpenses above 50 sorted by amount:")
    user.displayExpensesSummary(
        filter = { it.amount > 50 },
        sort = compareBy { it.amount }
    )
}

