//Task 8: Construct subclass SpecialEvent with additional features like VIP lists and premium services.


fun main() {
    val specialEvent = SpecialEvent(1, "Exclusive Gala", "A high-profile gala event")

    specialEvent.addVIP("Rohit")
    specialEvent.addVIP("Basant")
    specialEvent.addVIP("Chintu")

    specialEvent.addVIP("Rohit")

    specialEvent.removeVIP("Basant")

    specialEvent.removeVIP("Basant")

    specialEvent.listVIPs()

    specialEvent.addPremiumService("Catering")
    specialEvent.addPremiumService("Live Music")
    specialEvent.addPremiumService("Photography")

    specialEvent.addPremiumService("Catering")

    specialEvent.removePremiumService("Live Music")

    specialEvent.removePremiumService("Live Music")

    specialEvent.listPremiumServices()

    println("Special Event Details:")
    println(specialEvent)
}
