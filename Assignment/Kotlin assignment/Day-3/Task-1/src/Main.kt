
//Task 1: Define an Exportable interface with a method to export transaction data to CSV.

fun main() {
    val transaction1 = Transaction("1", "2023-07-25", 100.0)
    val transaction2 = Transaction("2", "2023-07-26", 150.0)

    // Export a single transaction to CSV
    transaction1.exportToCSV("transaction1.csv")

    // Export a list of transactions to CSV
    val transactions = listOf(transaction1, transaction2)
    Transaction.exportTransactionsToCSV(transactions, "transactions.csv")
}