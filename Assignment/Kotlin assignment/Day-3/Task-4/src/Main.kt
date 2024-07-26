//Task4:- Utilize Kotlin's collection libraries to manage a collection of User objects, enabling the addition and removal of users.

fun main() {
    val userManager = UserManager()

    val user1 = User(1, "Rohit")
    val user2 = User(2, "Bablu")

    println(userManager.addUser(user1))
    println(userManager.addUser(user2))
    println(userManager.addUser(user1))
    println(userManager.getUsers())
    println(userManager.removeUser(1))
    println(userManager.getUsers())
}