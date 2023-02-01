package parking

fun main() {
    val spots = mutableListOf<String>()
    var exit = false
    do {
        val inputs = readln().replace("\\s+".toRegex(), " ").split(" ")
        when(inputs[0]) {
            "create" -> {
                spots.clear()
                repeat(inputs[1].toInt()) { spots.add("0") }
                println("Created a parking lot with ${inputs[1]} spots.")
            }
            "park" -> {
                if (spots.isEmpty()) println("Sorry, a parking lot has not been created.")
                else {
                    val index = spots.indexOf("0")
                    if (index != -1) {
                        spots[index] = "${inputs[1]} ${inputs[2]}"
                        println("${inputs[2]} car parked in spot ${index + 1}.")
                    } else println("Sorry, the parking lot is full.")
                }
            }
            "leave" -> {
                if (spots.isEmpty()) println("Sorry, a parking lot has not been created.")
                else {
                    val spot = inputs[1].toInt() - 1
                    if (spot >= 0 && spot <= spots.size - 1) {
                        if (spots[spot] != "0") {
                            spots[spot] = "0"
                            println("Spot ${inputs[1].toInt()} is free.")
                        } else println("There is no car in spot ${inputs[1].toInt()}.")
                    } else {
                        println("There is no car in spot ${inputs[1].toInt()}.")
                    }
                }
            }
            "status" -> {
                if (spots.isEmpty()) println("Sorry, a parking lot has not been created.")
                else {
                    var cars = ""
                    for (i in spots.indices) {
                        if (spots[i] != "0") {
                            if (cars.isBlank()) cars = "${i + 1} ${spots[i]}"
                            else cars += "\n${i + 1} ${spots[i]}"
                        }
                    }
                    if (cars.isBlank()) println("Parking lot is empty.")
                    else println(cars)
                }
            }
            "reg_by_color" -> {
                if (spots.isEmpty()) println("Sorry, a parking lot has not been created.")
                else {
                    var cars = ""
                    for (i in spots.indices) {
                        if (spots[i] != "0") {
                            if (spots[i].split(" ")[1].lowercase().contains(inputs[1].lowercase())) {
                                if (cars.isBlank()) cars = spots[i].split(" ")[0]
                                else cars += ", ${spots[i].split(" ")[0]}"
                            }
                        }

                    }
                    if (cars.isBlank()) println("No cars with color ${inputs[1]} were found.")
                    else println(cars)
                }
            }
            "spot_by_color" -> {
                if (spots.isEmpty()) println("Sorry, a parking lot has not been created.")
                else {
                    var cars = ""
                    for (i in spots.indices) {
                        if (spots[i] != "0") {
                            if (spots[i].split(" ")[1].lowercase().contains(inputs[1].lowercase())) {
                                if (cars.isBlank()) cars = (i + 1).toString()
                                else cars += ", ${i + 1}"
                            }
                        }
                    }
                    if (cars.isBlank()) println("No cars with color ${inputs[1]} were found.")
                    else println(cars)
                }
            }
            "spot_by_reg" -> {
                if (spots.isEmpty()) println("Sorry, a parking lot has not been created.")
                else {
                    var cars = ""
                    for (i in spots.indices) {
                        if (spots[i] != "0") {
                            if (spots[i].split(" ")[0].lowercase().contains(inputs[1].lowercase())) {
                                if (cars.isBlank()) cars = (i + 1).toString()
                                else cars += ", ${i + 1}"
                            }
                        }
                    }
                    if (cars.isBlank()) println("No cars with registration number ${inputs[1]} were found.")
                    else println(cars)
                }
            }
            else -> exit = true
        }
    } while (!exit)
}
