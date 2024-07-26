class Appointment(private val title: String) : Event {
    private var description: String? = null

    override fun schedule(description: String) {
        this.description = description
        println("Appointment '$title' scheduled with details: '$description'.")
    }

    override fun reschedule(newDescription: String) {
        this.description = newDescription
        println("Appointment '$title' rescheduled with new details: '$newDescription'.")
    }
}