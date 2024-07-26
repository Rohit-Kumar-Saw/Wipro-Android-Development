interface Event {
    fun schedule(description: String)
    fun reschedule(newDescription: String)
}