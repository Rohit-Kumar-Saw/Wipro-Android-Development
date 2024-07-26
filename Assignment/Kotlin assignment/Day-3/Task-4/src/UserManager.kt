data class User(val id: Int, val name: String)

class UserManager {
    private val users = mutableSetOf<User>()

    fun addUser(user: User): Boolean {
        return if (users.any { it.id === user.id }) {
            false
        } else {
            users.add(user)
            true
        }
    }

    fun removeUser(userId: Int): Boolean {
        val userToRemove = users.find { it.id === userId } ?: return false
        return users.remove(userToRemove)
    }

    fun getUsers(): List<User> {
        return users.toList()
    }

}