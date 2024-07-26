// Task-5:-  Develop a Schedule class that uses interfaces to ensure that all event types can be scheduled and rescheduled.

fun main() {

    val mySchedule = Schedule()

    val meeting = Meeting("Project Discussion")
    val appointment = Appointment("Dentist Visit")

    mySchedule.addEvent(meeting)
    mySchedule.addEvent(appointment)

    mySchedule.scheduleEvent(meeting, "Discuss project milestones and deliverables.")
    mySchedule.scheduleEvent(appointment, "Annual dental checkup.")

    mySchedule.rescheduleEvent(meeting, " Final project status")
    mySchedule.rescheduleEvent(appointment, "Dental cleaning status.")
}

