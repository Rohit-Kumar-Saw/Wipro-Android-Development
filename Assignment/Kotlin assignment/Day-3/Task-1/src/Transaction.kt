import java.io.File


data class Transaction(val id: String, val date: String, val amount: Double) : Exportable {
    override fun exportToCSV(filePath: String) {
        try {
            val file = File(filePath)
            file.printWriter().use { out ->
                out.println("ID,Date,Amount")
                out.println("$id,$date,$amount")
            }
            println("Data exported to CSV successfully.")
        } catch (e: Exception) {
            println("Error while exporting data to CSV: ${e.message}")
        }
    }

    companion object {
        fun exportTransactionsToCSV(transactions: List<Transaction>, filePath: String) {
            try {
                val file = File(filePath)
                file.printWriter().use { out ->
                    out.println("ID,Date,Amount")
                    transactions.forEach { transaction ->
                        out.println("${transaction.id},${transaction.date},${transaction.amount}")
                    }
                }
                println("Data exported to CSV successfully.")
            } catch (e: Exception) {
                println("Error while exporting data to CSV: ${e.message}")
            }
        }
    }
}