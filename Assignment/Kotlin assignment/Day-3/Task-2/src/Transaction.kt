
class Transaction(transactionId: String, amount: Double, date: String, description: String) {
        private var _transactionId: String = transactionId
        private var _amount: Double = amount
            set(value) {
                if (value < 0) throw IllegalArgumentException("Amount cannot be negative")
                field = value
            }
        private var _date: String = date
        private var _description: String = description

        var transactionId: String
            get() = _transactionId
            set(value) {
                _transactionId = value
            }

        var amount: Double
            get() = _amount
            set(value) {
                if (value < 0) throw IllegalArgumentException("Amount cannot be negative")
                _amount = value
            }

        var date: String
            get() = _date
            set(value) {
                _date = value
            }

        var description: String
            get() = _description
            set(value) {
                _description = value
            }
    }

