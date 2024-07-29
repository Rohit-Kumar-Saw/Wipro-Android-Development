data class Event(val id: Int, val name: String, val description: String)

class EventManager : Display {
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

    override fun showEventDetails(event: Event) {
        println("Event Details: ID = ${event.id}, Name = ${event.name}, Description = ${event.description}")
    }

    // Display details of all events
    fun showAllEvents() {
        for (event in events) {
            showEventDetails(event)
        }
    }
}