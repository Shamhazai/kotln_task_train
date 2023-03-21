import kotlin.random.Random

fun main() {
    val cities = listOf("Москва", "Санкт-Петербург", "Екатеринбург", "Казань", "Краснодар", "Новосибирск", "Омск", "Ростов-на-Дону", "Самара", "Уфа", "Челябинск", "Пермь", "Красноярск", "Воронеж", "Волгоград")

    do {
        // Создаем направление
        val departureCity = cities.random()
        var destinationCity = departureCity
        while (destinationCity == departureCity) {
            destinationCity = cities.random()
        }
        println("Направление: $departureCity - $destinationCity")

        // Продаем билеты
        val passengers = Random.nextInt(5, 201)
        println("Продано билетов: $passengers")

        // Сформируем поезд
        val train = mutableListOf<Wagon>()
        var totalSeats = 0
        while (totalSeats < passengers) {
            val wagonCapacity = Random.nextInt(5, 26)
            val wagon = Wagon(wagonCapacity)

            train.add(wagon)
            totalSeats += wagon.capacity
        }
        println("Сформировано вагонов: ${train.size}")

        // Отправляем поезд
        println("Отправляем поезд: $departureCity - $destinationCity, состоящий из ${train.size} вагонов.")
        var total = 0
        train.forEachIndexed { i, wagon ->
            println("Вагон №${i + 1} вмещает ${wagon.capacity} пассажиров")
            total += wagon.capacity
        }
        println("Поезд вмещает ${total} пассажиров")


        // Запрашиваем продолжение работы
        println("Введите 'EXIT' для выхода из программы, чтобы продолжить нажмите Enter")
    } while (readlnOrNull() != "EXIT")
}

class Wagon(val capacity: Int) {
}
