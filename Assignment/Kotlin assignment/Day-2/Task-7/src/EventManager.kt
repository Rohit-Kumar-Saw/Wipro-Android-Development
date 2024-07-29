
data class Event(val id: Int, val name: String, val description: String)
class EventManager : Display {
    private val events = mutableListOf<Event>()

    // Higher-order function to notify on event updates
    private fun notifyUpdate(action: String, event: Event, notify: (String) -> Unit) {
        notify("Event $action: ID = ${event.id}, Name = ${event.name}, Description = ${event.description}")
    }

    fun addEvent(event: Event, notify: (String) -> Unit): Boolean {
        return if (events.none { it.id == event.id }) {
            events.add(event)
            notifyUpdate("added", event, notify)
            true
        } else {
            false
        }
    }

    fun removeEvent(eventId: Int, notify: (String) -> Unit): Boolean {
        val event = events.find { it.id == eventId }
        return if (event != null) {
            events.remove(event)
            notifyUpdate("removed", event, notify)
            true
        } else {
            false
        }
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

// Example implementation of the Notification interface
class SimpleNotification : Notification {
    override fun sendNotification(message: String) {
        println("Notification: $message")
    }
}