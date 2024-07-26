
//Task 2: Apply encapsulation to Transaction properties using getters and setters ensuring sensitive data is protected.

fun main() {
    val transaction = Transaction("TXN123", 1000.0, "2023-07-26", "Payment for services")

    // Accessing properties using getters
    println(transaction.transactionId)  // Output: TXN123
    println(transaction.amount)         // Output: 1000.0

    // Modifying properties using setters
    transaction.amount = 1200.0
    println(transaction.amount)         // Output: 1200.0

    // Attempting to set a negative amount will raise an error
    try {
        transaction.amount = -500.0
    } catch (e: IllegalArgumentException) {
        println(e.message)  // Output: Amount cannot be negative
    }
}