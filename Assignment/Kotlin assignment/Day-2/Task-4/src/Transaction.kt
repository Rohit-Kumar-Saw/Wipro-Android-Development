open class Transaction(val amount: Double, val description: String) {
    open fun getDetails(): String {
        return "Amount: $amount, Description: $description"
    }
}

class Income(amount: Double, description: String, val source: String) : Transaction(amount, description) {
    override fun getDetails(): String {
        return "Income - Amount: $amount, Description: $description, Source: $source"
    }
}

class Expense(amount: Double, description: String, val category: String) : Transaction(amount, description) {
    override fun getDetails(): String {
        return "Expense - Amount: $amount, Description: $description, Category: $category"
    }
}