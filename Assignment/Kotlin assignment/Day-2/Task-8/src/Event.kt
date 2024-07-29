open class Event(val id: Int, val name: String, val description: String) {
    override fun toString(): String {
        return "Event(ID: $id, Name: $name, Description: $description)"
    }
}
