
//Task 5: Design a EventManager class with methods to add and remove events.

fun main() {
    val eventManager = EventManager()

    val event1 = Event(1, "Conference", "Tech conference")
    val event2 = Event(2, "Meetup", "Community meetup")
    val event3 = Event(3, "Workshop", "Hands-on workshop")

    eventManager.addEvent(event1)
    eventManager.addEvent(event2)
    eventManager.addEvent(event3)

    println("Events after adding:")
    eventManager.listEvents().forEach { println(it) }

    eventManager.removeEvent(2)

    println("Events after removing event with ID 2:")
    eventManager.listEvents().forEach { println(it) }
}
