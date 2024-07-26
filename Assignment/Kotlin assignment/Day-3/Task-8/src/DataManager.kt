class DataManager<T> {
    private val items = mutableListOf<T>()

    fun addItem(item: T) {
        items.add(item)
    }

    fun removeItem(item: T) {
        items.remove(item)
    }

    fun getAllItems(): List<T> {
        return items.toList()
    }

    fun filterItems(predicate: (T) -> Boolean): List<T> {
        return items.filter(predicate)
    }

    fun displayItems() {
        items.forEach { println(it) }
    }
}
data class Event(
    val id: String,
    val name: String,
    val date: String,
    val type: String
)

data class Attendee(
    val id: String,
    val name: String,
    val email: String
)