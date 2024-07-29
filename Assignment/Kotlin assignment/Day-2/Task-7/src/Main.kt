// Task 7: Utilize higher-order functions to implement a simple notification system for event updates.

fun main() {
    val eventManager = EventManager()
    val notificationSystem = SimpleNotification()

    val notify: (String) -> Unit = { message -> notificationSystem.sendNotification(message) }

    val event1 = Event(1, "Conference", "Tech conference")
    val event2 = Event(2, "Meetup", "Community meetup")
    val event3 = Event(3, "Workshop", "Hands-on workshop")

    eventManager.addEvent(event1, notify)
    eventManager.addEvent(event2, notify)
    eventManager.addEvent(event3, notify)

    println("Events after adding:")
    eventManager.showAllEvents()

    eventManager.removeEvent(2, notify)

    println("Events after removing event with ID 2:")
    eventManager.showAllEvents()
}

