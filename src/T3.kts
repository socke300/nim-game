/**
 * Name: Marcel Gode
 * Matrikelnummer: 5277676
 * Studiengang: Informatik Bachelor | Semester 2
 */

while (true) {
    try {
        main()
    } catch (e: Exception) {
        println("\n\n!!!Falsche Eingabe!!!\nBeginne von vorne.\n\n\n")
    }
}

fun main() {
    while (true) {
//--------------------------------------------------------Menü----------------------------------------------------------
        placeholderText()
        chooseEnemyText()
        var enemy = readLine()
        placeholderText()
        while (enemy != "1" && enemy != "2" && enemy != "q" && enemy != "e" && enemy != "t" && enemy != "t2") {
            println("\n!!!Warnung Falsche Eingabe!!!\nEingabe (Bestätigen mit Enter): ")
            enemy = readLine()
        }
        if (enemy == "q" || enemy == "e") System.exit(1)
        if (enemy != "t" && enemy != "t2") {
            chooseWoodNumberText()
            var numberOfWoods = "" + readLine()
            placeholderText()
            while (checkWoodNumber(numberOfWoods)) {
                println("\n!!!Warnung Falsche Eingabe!!!")
                println("Eingabe (Bestätigen mit Enter): ")
                numberOfWoods = "" + readLine()
            }
            if (numberOfWoods == "q" || numberOfWoods == "e")
                System.exit(1)
            if (numberOfWoods == "r") numberOfWoods = random()
            if (numberOfWoods == "") numberOfWoods = "1-3-5-7"

//-----------------------------------------------------Nim Perfect------------------------------------------------------
            if (enemy == "1") {
                var list = numberOfWoods.split("-")
                var array = IntArray(list.size)
                for (i in array.indices) {
                    array[i] = list[i].toInt()
                }
                var nimPerfect = NimPerfect(array)
                var player = (1..2).random()

                //Spiel
                while (true) {

                    //Winner
                    if (nimPerfect.calculateBestMove()[0] == 0 && nimPerfect.calculateBestMove()[1] == 0) {
                        if (player == 2) {
                            println("\n\n!!!Spiel Zuende. Gewonnen hat Computer!!!")
                        } else {
                            println("\n\n!!!Spiel Zuende. Gewonnen hast Du!!!")
                        }
                        println("\nDrücke:" +
                                "\nEnter um ein neues Spiel zu starten" +
                                "\n1 für Zug Rückgängig machen" +
                                "\ne oder q für Spiel beenden")
                        print("\n\nEingabe (Bestätigen mit Enter): ")
                        var move = readLine()
                        if (move == "") break
                        if (move == "1"){
                            nimPerfect.removeMove()
                            if (player == 1) {
                                player = 2
                            } else {
                                player = 1
                            }
                        }
                        if (move == "e" || move == "q") System.exit(1)
                    }

                    //Ausgabe Hölzer
                    println("\n-----------------------------Spielfeld-Anfang----------------------------")
                    println(nimPerfect.toString())
                    println("------------------------------Spielfeld-Ende-----------------------------\n")

                    //Ausgabe Spieler
                    if (player == 1) {
                        println("Computer ist dran\n")
                        player = 2
                    } else {
                        println("Du bist dran\n")
                        player = 1
                    }

                    //Auswahl Spielzug
                    chooseMoveText()
                    var move = readLine()
                    while (move != "1" && move != "2" && move != "3" && move != "e" && move != "q") {
                        println("\n!!!Warnung Falsche Eingabe!!!")
                        println("Eingabe (Bestätigen mit Enter): ")
                        move = readLine()
                    }

                    //Computer soll den Zug machen
                    if (move == "1") {
                        nimPerfect.makeMove(nimPerfect.calculateBestMove())
                    }

                    //Selber den Zug machen
                    if (move == "2") {
                        makeMoveText()
                        var moveMake = "" + readLine()
                        var list = moveMake.split(".")
                        while (checkMoveMake(nimPerfect, list)) {
                            println("\n!!!Warnung Falsche Eingabe!!!")
                            println("Eingabe (Bestätigen mit Enter): ")
                            moveMake = "" + readLine()
                            list = moveMake.split(".")
                        }
                    }

                    //Zug rückgängig machen
                    if (move == "3") {
                        if (!nimPerfect.removeMove()) {
                            println("Spielfeld ist wie am Anfang.\nEs kann kein Zug mehr Rückgängig gemacht werden.")
                            if (player == 1) {
                                player = 2
                            } else {
                                player = 1
                            }
                        }
                    }

                    //Spiel abbrechen
                    if (move == "e" || move == "q") {
                        System.exit(1)
                    }
                }

//--------------------------------------------------------Nim-----------------------------------------------------------
            } else {
                var list = numberOfWoods.split("-")
                var array = IntArray(list.size)
                for (i in array.indices) {
                    array[i] = list[i].toInt()
                }
                var nim = Nim(array)
                var player = (1..2).random()
                while (true) {
                    //Winner
                    if (nim.generatePossibleMoves().size == 0) {
                        if (player == 2) {
                            println("\n\n!!!Spiel Zuende. Gewonnen hat Computer!!!")
                        } else {
                            println("\n\n!!!Spiel Zuende. Gewonnen hast Du!!!")
                        }
                        println("\nDrücke:" +
                                "\nEnter um ein neues Spiel zu starten" +
                                "\n1 für Zug Rückgängig machen" +
                                "\ne oder q für Spiel beenden")
                        print("\n\nEingabe (Bestätigen mit Enter): ")
                        var move = readLine()
                        if (move == "") break
                        if (move == "1"){
                            nim.removeMove()
                            if (player == 1) {
                                player = 2
                            } else {
                                player = 1
                            }
                        }
                        if (move == "e" || move == "q") System.exit(1)
                    }

                    //Ausgabe Hölzer
                    println("\n-----------------------------Spielfeld-Anfang----------------------------")
                    println(nim.toString())
                    println("-----------------------------Spielfeld-Ende-----------------------------\n")

                    //Ausgabe Spieler
                    if (player == 1) {
                        println("Computer ist dran\n")
                        player = 2
                    } else {
                        println("Du bist dran\n")
                        player = 1
                    }

                    //Auswahl Spielzug
                    chooseMoveText()
                    var move = readLine()
                    while (move != "1" && move != "2" && move != "3" && move != "e" && move != "q") {
                        println("\n!!!Warnung Falsche Eingabe!!!")
                        println("Eingabe (Bestätigen mit Enter): ")
                        move = readLine()
                    }

                    //Computer soll den Zug machen
                    if (move == "1") {
                        nim.makeMove(nim.calculateBestMove())
                    }

                    //Selber den Zug machen
                    if (move == "2") {
                        makeMoveText()
                        var moveMake = "" + readLine()
                        var list = moveMake.split(".")
                        while (checkMoveMake(nim, list)) {
                            println("\n!!!Warnung Falsche Eingabe!!!")
                            println("Eingabe (Bestätigen mit Enter): ")
                            moveMake = "" + readLine()
                            list = moveMake.split(".")
                        }
                    }

                    //Zug rückgängig machen
                    if (move == "3") {
                        if (!nim.removeMove()) {
                            println("Spielfeld ist wie am Anfang. \nEs kann kein Zug mehr Rückgängig gemacht werden.")
                            if (player == 1) {
                                player = 2
                            } else {
                                player = 1
                            }
                        }
                    }

                    //Spiel abbrechen
                    if (move == "e" || move == "q") {
                        System.exit(1)
                    }

                }
            }
//------------------------------------------------------TestModus-------------------------------------------------------
        } else {
            var gamesOfNim = 0
            var gamesOfNimPerfect = 0
            for (i in 1..40) {
                println("Spiel: " + i)
                var numberOfWoods = ""
                if (enemy=="t2") {
                    numberOfWoods = random2()
                }else{
                    numberOfWoods = random()
                }
                var list = numberOfWoods.split("-")
                var array = IntArray(list.size)
                for (k in array.indices) {
                    array[k] = list[k].toInt()
                }
                var nimPerfect = NimPerfect(array)
                var nim = Nim(array)
                var player = (1..2).random() //1 ist NimPerfect 2 ist Nim
                var mustBeAWinner: Int
                if (nimPerfect.isWinSituation(array)) {
                    if (player == 1) {
                        println("NimPerfect muss gewinnen.")
                        mustBeAWinner = 1
                    } else {
                        println("Nim muss gewinnen.")
                        mustBeAWinner = 2
                    }
                } else {
                    if (player == 1) {
                        println("Nim muss gewinnen.")
                        mustBeAWinner = 2
                    } else {
                        println("NimPerfect muss gewinnen.")
                        mustBeAWinner = 1
                    }
                }
                while (nim.generatePossibleMoves().size != 0) {
                    if (player == 1) {
                        nimPerfect.makeMove(nimPerfect.calculateBestMove())
                        nim = Nim(nimPerfect.array)
                        player = 2
                    } else {
                        nim.makeMove(nim.calculateBestMove())
                        nimPerfect = NimPerfect(nim.array)
                        player = 1
                    }
                }
                if (player == 1) {
                    println("Nim hat gewonnen")
                    if (mustBeAWinner == 1) {
                        println("Bedingung nicht erfüllt!")
                        System.exit(1)
                    }
                    println("Bedingung erfüllt!")
                    gamesOfNim++
                } else {
                    println("NimPerfect hat gewonnen")
                    if (mustBeAWinner == 2) {
                        println("Bedingung nicht erfüllt!")
                        System.exit(1)
                    }
                    println("Bedingung erfüllt!")
                    gamesOfNimPerfect++
                }
                println("")
            }
            placeholderText()
            println("Nim hat $gamesOfNim-mal Gewonnen.")
            println("NimPerfect hat $gamesOfNimPerfect-mal Gewonnen.")
        }
    }
}

//-----------------------------------------------------Funktionen-------------------------------------------------------
fun checkWoodNumber(list: String): Boolean {
    if (list == "r" || list == "" || list == "q" || list == "e")
        return false
    try {
        var list = list.split("-")
        var array = IntArray(list.size)
        for (i in array.indices) {
            array[i] = list[i].toInt()
        }
    } catch (e: Exception) {
        return true
    }
    return false
}

fun checkMoveMake(nimPerfect: NimPerfect, list: List<String>): Boolean {
    if (list[1].toInt() <= 0 || list[0].toInt() <= 0)
        return true
    if (nimPerfect.array.size < list[0].toInt()) {
        return true
    }
    if (nimPerfect.array[list[0].toInt() - 1] < list[1].toInt())
        return true
    try {
        nimPerfect.makeMove(intArrayOf(list[0].toInt() - 1, list[1].toInt()))
    } catch (e: Exception) {
        return true
    }
    return false
}

fun checkMoveMake(nim: Nim, list: List<String>): Boolean {
    if (list[1].toInt() <= 0 || list[0].toInt() <= 0)
        return true
    if (nim.array.size < list[0].toInt())
        return true
    if (nim.array[list[0].toInt() - 1] < list[1].toInt())
        return true
    try {
        nim.makeMove(intArrayOf(list[0].toInt() - 1, list[1].toInt()))
    } catch (e: Exception) {
        return true
    }
    return false
}

fun random2(): String {
    var returnString = ""
    val randomRow = (2..4).random()
    for (i in 1..randomRow) {
        if (i == randomRow) {
            returnString += (1..4).random()
        } else {
            returnString = returnString + (1..4).random() + "-"
        }
    }
    println(returnString)
    return returnString
}  //4 mal 4

fun random(): String {
    var returnString = ""
    val randomRow = (2..5).random()
    for (i in 1..randomRow) {
        if (i == randomRow) {
            returnString += (1..7).random()
        } else {
            returnString = returnString + (1..7).random() + "-"
        }
    }
    println(returnString)
    return returnString
}  //4 mal 4

fun chooseEnemyText() {
    println("Herzlich Wilkommen zum Nim Game! :)" +
            "\n\nBitte wähle. Drücke:" +
            "\n1 für den NimPerfect als Gegner" +
            "\n2 für den Nim als Gegner" +
            "\nt für den Testmode" +
            "\nt2 für den performanten Testmode" +
            "\nq oder e um das Spiel zu beenden\n\n")
    print("Eingabe (Bestätigen mit Enter): ")
}

fun placeholderText() {
    println("\n-------------------------------------------------------------------------\n")
}

fun chooseWoodNumberText() {
    println("Bitte gebe nun ein wieviele Hölzer" +
            "\npro Reihe auf dem Spielfeld liegen" +
            "\nsollen, in dieser Form:" +
            "\n3-4-5 oder 1-2-3-4-5" +
            "\nOder drücke für die Standard Variante" +
            "\neinfach Enter. Für eine Zufalls-" +
            "\nausgangssituation r eingeben." +
            "\nOder q oder e um das Spiel zu beenden.")
    print("\n\nEingabe (Bestätigen mit Enter): ")
}

fun chooseMoveText() {
    println("Möchtest du selber ziehen oder soll der Computer ziehen?" +
            "\nDrücke:" +
            "\n1 für Computer" +
            "\n2 wenn du selber ziehen möchtest" +
            "\n3 für Zug Rückgängig machen" +
            "\ne oder q um das Spiel zu beenden.")
    print("\n\nEingabe (Bestätigen mit Enter): ")
}

fun makeMoveText() {
    println("\nGebe erst die Reihe, dann die Anzahl an." +
            "\n(Im Format z.B. 2.2 oder 1.2)")
    print("\n\nEingabe (Bestätigen mit Enter): ")
}

class Nim(array1: IntArray) : NimGame {

    val array = array1
    val arrayPreviouse = ArrayList<IntArray>()
    val savedMove = IntArray(2)

    override fun calculateBestMove(): IntArray {
        max("true", Int.MIN_VALUE, Int.MAX_VALUE)
        return savedMove
    }

    override fun makeMove(array1: IntArray): Boolean {
        arrayPreviouse.add(array.clone())
        array[array1[0]] -= array1[1]
        return true
    }

    override fun removeMove(): Boolean {
        if (!arrayPreviouse.isEmpty()) {
            for (i in array.indices)
                array[i] = arrayPreviouse.last()[i]
            arrayPreviouse.remove(arrayPreviouse.last())
            return true
        }
        return false
    }

    fun generatePossibleMoves(): ArrayList<IntArray> {
        val possibleMoves = ArrayList<IntArray>()
        for (i in array.indices) {
            if (array[i] > 0) {
                for (k in 1..array[i]) {
                    possibleMoves.add(intArrayOf(i, k))
                }
            }
        }
        return possibleMoves
    }

    override fun toString(): String {
        val temp = arrayOf("")
        for (i in array.indices) {
            for (j in 0 until array[i]) {
                temp[0] += "I "
            }
            if (i != array.size - 1)
                temp[0] += "\n"
        }
        return temp[0]
    }

    fun max(tiefe: String, alpha: Int, beta: Int): Int {
        if (generatePossibleMoves().size == 0)
            return -1000
        val maxWert = intArrayOf(alpha)
        val possibleMoves = generatePossibleMoves().shuffled()
        for (i in possibleMoves.indices) {
            makeMove(possibleMoves[i])
            val wert = min("", maxWert[0], beta)
            removeMove()
            if (wert > maxWert[0]) {
                maxWert[0] = wert
                if (tiefe == "true") {
                    savedMove[0] = possibleMoves[i][0]
                    savedMove[1] = possibleMoves[i][1]
                }
                if (tiefe == "true" && wert == 1000)
                    break
                if (maxWert[0] >= beta)
                    break
            }
        }
        return maxWert[0]
    }

    fun min(tiefe: String, alpha: Int, beta: Int): Int {
        if (generatePossibleMoves().size == 0)
            return 1000
        val minWert = intArrayOf(beta)
        val possibleMoves = generatePossibleMoves().shuffled()
        for (i in possibleMoves.indices) {
            makeMove(possibleMoves[i])
            val wert = max("", alpha, minWert[0])
            removeMove()
            if (wert < minWert[0]) {
                minWert[0] = wert
                if (minWert[0] <= alpha)
                    break
            }
        }
        return minWert[0]
    }
}

class NimPerfect(array1: IntArray) : NimGame {

    val array = array1
    val arrayPreviouse = ArrayList<IntArray>()

    fun isWinSituation(arrayTemp: IntArray): Boolean {
        val temp = intArrayOf(0)
        for (i in arrayTemp.indices) {
            temp[0] = temp[0] xor arrayTemp[i]
        }
        if (temp[0] == 0)
            return false
        return true
    }

    override fun calculateBestMove(): IntArray {
        for (i in array.indices) {
            if (array[i] != 0)
                break
            if (array.size - 1 == i)
                return intArrayOf(0, 0)
        }
        if (isWinSituation(array)) {
            val randomRow = (array.indices).random()
            val randomNumber = (0..array[randomRow]).random()
            val arrayTemp = array.clone()
            arrayTemp[randomRow] -= randomNumber
            if (!isWinSituation(arrayTemp))
                return intArrayOf(randomRow, randomNumber)
            return calculateBestMove()
        }
        val randomRow = (array.indices).random()
        if (array[randomRow] > 0)
            return intArrayOf(randomRow, (1..array[randomRow]).random())
        return calculateBestMove()
    }

    override fun makeMove(array1: IntArray): Boolean {
        arrayPreviouse.add(array.clone())
        array[array1[0]] -= array1[1]
        return true
    }

    override fun removeMove(): Boolean {
        if (!arrayPreviouse.isEmpty()) {
            for (i in array.indices)
                array[i] = arrayPreviouse.last()[i]
            arrayPreviouse.remove(arrayPreviouse.last())
            return true
        }
        return false
    }

    override fun toString(): String {
        val temp = arrayOf("")
        for (i in array.indices) {
            for (j in 0 until array[i]) {
                temp[0] += "I "
            }
            if (i != array.size - 1)
                temp[0] += "\n"
        }
        return temp[0]
    }
}

interface NimGame {
    fun calculateBestMove(): IntArray
    fun makeMove(array: IntArray): Boolean
    fun removeMove(): Boolean
}