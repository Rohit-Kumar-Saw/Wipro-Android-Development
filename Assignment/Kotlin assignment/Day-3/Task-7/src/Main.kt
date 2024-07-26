
//Task 7: Manage a collection of events allowing filtering by date or type using Kotlin's powerful collection operations.
import java.time.LocalDate
fun main() {
    val eventManager = EventManager()

    // Adding events
    eventManager.addEvent(Event("001", "Annual Meeting", LocalDate.of(2024, 8, 15), "Meeting"))
    eventManager.addEvent(Event("002", "Conference", LocalDate.of(2024, 9, 10), "Conference"))
    eventManager.addEvent(Event("003", "Workshop", LocalDate.of(2024, 8, 15), "Workshop"))

    // Display all events
    println("All Events:")
    eventManager.displayEvents()

    // Filter events by date
    println("\nEvents on 2024-08-15:")
    val eventsOnDate = eventManager.filterEventsByDate(LocalDate.of(2024, 8, 15))
    eventsOnDate.forEach { println(it) }

    // Filter events by type
    println("\nConference Events:")
    val conferenceEvents = eventManager.filterEventsByType("Conference")
    conferenceEvents.forEach { println(it) }
}