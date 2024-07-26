
//Task 8: Use generics to create a flexible DataManager class capable of handling different data types, including attendees and events.

fun main() {

    val eventManager = DataManager<Event>()
    eventManager.addItem(Event("001", "Annual Meeting", "2024-08-15", "Meeting"))
    eventManager.addItem(Event("002", "Conference", "2024-09-10", "Conference"))

    println("All Events:")
    eventManager.displayItems()

    println("\nFiltered Events (type: Conference):")
    val filteredEvents = eventManager.filterItems { it.type == "Conference" }
    filteredEvents.forEach { println(it) }

    val attendeeManager = DataManager<Attendee>()
    attendeeManager.addItem(Attendee("A001", "John Doe", "john@example.com"))
    attendeeManager.addItem(Attendee("A002", "Jane Smith", "jane@example.com"))

    println("\nAll Attendees:")
    attendeeManager.displayItems()

    println("\nFiltered Attendees (name contains 'Jane'):")
    val filteredAttendees = attendeeManager.filterItems { it.name.contains("Jane") }
    filteredAttendees.forEach { println(it) }
}