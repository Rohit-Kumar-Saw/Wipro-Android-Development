class Meeting(private val title: String) : Event {
    private var description: String? = null

    override fun schedule(description: String) {
        this.description = description
        println("Meeting '$title' scheduled with description: '$description'.")
    }

    override fun reschedule(newDescription: String) {
        this.description = newDescription
        println("Meeting '$title' rescheduled with new description: '$newDescription'.")
    }
}