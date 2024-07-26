class Schedule {
    private val events: MutableList<Event> = mutableListOf()

    fun addEvent(event: Event) {
        events.add(event)
        println("Event added: $event")
    }

    fun scheduleEvent(event: Event, description: String) {
        event.schedule(description)
    }

    fun rescheduleEvent(event: Event, newDescription: String) {
        event.reschedule(newDescription)
    }
}