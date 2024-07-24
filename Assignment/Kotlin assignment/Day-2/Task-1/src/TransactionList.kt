data class Transaction (
    val  id: Int,
    var amount: Double,
    var description: String
)

class TransactionList
{

    private val transactions= mutableListOf<Transaction>()
    private var nextId =1

    fun addTransaction(amount: Double, description: String): Transaction {
        val transaction= Transaction(nextId, amount, description)
        transactions.add(transaction)
        nextId++
        return transaction
    }

    fun deleteTransaction(transactionId: Int): Transaction? {
        val transaction = transactions.find{ it.id==transactionId }
        return if (transaction != null)
        {
            transactions.remove(transaction)
            transaction
        }
        else
        {
            null
        }
    }

    fun editTransaction(transactionId: Int, amount: Double? = null, description: String?=null): Transaction? {
        val transaction = transactions.find { it.id == transactionId }
        transaction?.let {
            if(amount != null) it.amount = amount
            if(description != null) it.description = description
        }
        return transaction
    }
    fun getTransactions() : List<Transaction>
    {
        return transactions
    }
}


