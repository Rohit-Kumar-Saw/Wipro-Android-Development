data class Event(val id: Int, val name: String, val description: String)

class EventManager {
    private val events = mutableListOf<Event>()

    fun addEvent(event: Event): Boolean {
        return if (events.none { it.id == event.id }) {
            events.add(event)
            true
        } else {
            false
        }
    }

    fun removeEvent(eventId: Int): Boolean {
        return events.removeIf { it.id == eventId }
    }

    fun listEvents(): List<Event> {
        return events.toList()
    }
}
