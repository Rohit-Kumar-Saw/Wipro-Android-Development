//Task 6: Secure the event data with proper encapsulation and visibility modifiers.

class Event(
    private val id: String,
    private val name: String,
    private val date: String
) {
    val eventId: String
        get() = id

    val eventName: String
        get() = name

    val eventDate: String
        get() = date

    // Method to display event details
    fun displayEventInfo() {
        println("Event ID: $eventId")
        println("Event Name: $eventName")
        println("Event Date: $eventDate")
    }
}

fun main() {
    val event = Event("001", "Annual Meeting", "2024-08-15")
    event.displayEventInfo()
}