
class SpecialEvent(
    id: Int,
    name: String,
    description: String,
    val vipList: MutableList<String> = mutableListOf(),
    val premiumServices: MutableList<String> = mutableListOf()
) : Event(id, name, description) {

    fun addVIP(vip: String) {
        if (vip !in vipList) {
            vipList.add(vip)
        } else {
            println("$vip is already on the VIP list.")
        }
    }

    fun removeVIP(vip: String) {
        if (vip in vipList) {
            vipList.remove(vip)
        } else {
            println("$vip is not on the VIP list.")
        }
    }

    fun listVIPs() {
        println("VIP List: $vipList")
    }

    fun addPremiumService(service: String) {
        if (service !in premiumServices) {
            premiumServices.add(service)
        } else {
            println("$service is already a premium service.")
        }
    }

    fun removePremiumService(service: String) {
        if (service in premiumServices) {
            premiumServices.remove(service)
        } else {
            println("$service is not a premium service.")
        }
    }

    fun listPremiumServices() {
        println("Premium Services: $premiumServices")
    }

    override fun toString(): String {
        return super.toString() + ", VIP List: $vipList, Premium Services: $premiumServices"
    }
}