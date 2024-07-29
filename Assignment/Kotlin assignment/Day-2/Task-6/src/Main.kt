//Task 6: Create a Display interface with a method to show event details and implement it in the EventManager.

fun main() {
    val eventManager = EventManager()

    val event1 = Event(1, "Conference", "Tech conference")
    val event2 = Event(2, "Meetup", "Community meetup")
    val event3 = Event(3, "Workshop", "Hands-on workshop")

    eventManager.addEvent(event1)
    eventManager.addEvent(event2)
    eventManager.addEvent(event3)

    println("Events after adding:")
    eventManager.showAllEvents()

    eventManager.removeEvent(2)

    println("Events after removing event with ID 2:")
    eventManager.showAllEvents()
}
