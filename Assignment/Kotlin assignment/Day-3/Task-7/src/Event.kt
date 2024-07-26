import java.time.LocalDate

data class Event(
    val id: String,
    val name: String,
    val date: LocalDate,
    val type: String
)

class EventManager {
    private val events = mutableListOf<Event>()

    // Add an event to the collection
    fun addEvent(event: Event) {
        events.add(event)
    }

    // Filter events by date
    fun filterEventsByDate(date: LocalDate): List<Event> {
        return events.filter { it.date == date }
    }

    // Filter events by type
    fun filterEventsByType(type: String): List<Event> {
        return events.filter { it.type.equals(type, ignoreCase = true) }
    }

    // Display all events
    fun displayEvents() {
        events.forEach { println(it) }
    }
}
