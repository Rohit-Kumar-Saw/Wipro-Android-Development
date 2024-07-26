
//Task 3: Create generic functions to handle different types of collections (List, Set, Map) of transactions.

data class Transaction(val id: String, val amount: Double)

object GenericCollectionsHandler {

    // Add transaction to a Collection (List, Set)
    fun <T : MutableCollection<Transaction>> addTransaction(collection: T, transaction: Transaction) {
        collection.add(transaction)
    }

    // Remove transaction from a Collection (List, Set)
    fun <T : MutableCollection<Transaction>> removeTransaction(collection: T, transaction: Transaction): Boolean {
        return collection.remove(transaction)
    }

    // List all transactions in a Collection (List, Set)
    fun <T : Collection<Transaction>> listTransactions(collection: T) {
        collection.forEach { println(it) }
    }

    // Add transaction to a Map
    fun addTransaction(map: MutableMap<String, Transaction>, transaction: Transaction) {
        map[transaction.id] = transaction
    }

    // Remove transaction from a Map
    fun removeTransaction(map: MutableMap<String, Transaction>, transactionId: String): Transaction? {
        return map.remove(transactionId)
    }

    // List all transactions in a Map
    fun listTransactions(map: Map<String, Transaction>) {
        map.values.forEach { println(it) }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        // List example
        val transactionList: MutableList<Transaction> = mutableListOf()
        val t1 = Transaction("1", 100.0)
        val t2 = Transaction("2", 200.0)

        println("List Example")

        addTransaction(transactionList, t1)
        addTransaction(transactionList, t2)
        listTransactions(transactionList)
        removeTransaction(transactionList, t1)
        listTransactions(transactionList)

        // Set example
        println("Set Example")
        val transactionSet: MutableSet<Transaction> = mutableSetOf()
        addTransaction(transactionSet, t1)
        addTransaction(transactionSet, t2)
        listTransactions(transactionSet)
        removeTransaction(transactionSet, t1)
        listTransactions(transactionSet)

        // Map example
        println("Map Example")
        val transactionMap: MutableMap<String, Transaction> = mutableMapOf()

        addTransaction(transactionMap, t1)
        addTransaction(transactionMap, t2)
        listTransactions(transactionMap)
        removeTransaction(transactionMap, "1")
        listTransactions(transactionMap)
    }
}