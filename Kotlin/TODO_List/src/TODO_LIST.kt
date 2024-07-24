data class  TODO(
    val nextid: Int,
    val item: String
)
class TODO_LIST {

    val todolist = mutableListOf<TODO>()
    var Id = 1

    fun add(item: String?) {
        if (item.isNullOrBlank()) {
            println("item can not be null")
        } else {
            val todo = TODO(
                nextid = Id++,
                item = item
            )
            todolist.add(todo)
            println("item addes : $item")
        }

        fun display() {
            if (todolist.isEmpty()) {
                println("No item found")
            } else {
                println("TODO LIST: ")
                todolist.forEach { item ->
                    println("${item.nextid}. ${item.item}")
                }
            }
        }
    }
}