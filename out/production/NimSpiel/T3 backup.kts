/**
 *
 * Name: Marcel Gode
 * Matrikelnummer: 5277676
 *
 */

while (true) {
//--------------------------------------------------------Menü----------------------------------------------------------
    placeholderText()
    chooseEnemyText()
    var enemy = readLine()
    placeholderText()
    while (enemy != "1" && enemy != "2" && enemy != "q" && enemy != "e" && enemy != "t") {
        println("\n!!!Warnung Falsche Eingabe!!!\nEingabe (Bestätigen mit Enter): ")
        enemy = readLine()
    }
    if (enemy == "q" || enemy == "e") System.exit(1)
    if (enemy != "t") {
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
                    if (move == "1") nimPerfect.removeMove()
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
                    nimPerfect.removeMove()
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
                    if (move == "1") nim.removeMove()
                    if (move == "e" || move == "q") System.exit(1)
                }

                //Ausgabe Hölzer
                println("\n-----------------------------Spielfeld-Anfang----------------------------")
                println(nim.toString())
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
                    nim.removeMove()
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
            var numberOfWoods = random()
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
    if (nimPerfect.array[list[0].toInt() - 1] < list[1].toInt())
        return true
    println("test")
    try {
        nimPerfect.makeMove(intArrayOf(list[0].toInt() - 1, list[0].toInt()))
    } catch (e: Exception) {
        return true
    }
    return false
}

fun checkMoveMake(nim: Nim, list: List<String>): Boolean {
    if (list[1].toInt() <= 0 || list[0].toInt() <= 0)
        return true
    if (nim.array[list[0].toInt() - 1] < list[1].toInt())
        return true
    println("test")
    try {
        nim.makeMove(intArrayOf(list[0].toInt() - 1, list[0].toInt()))
    } catch (e: Exception) {
        return true
    }
    return false
}

fun random(): String {
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

fun chooseEnemyText() {
    println("Herzlich Wilkommen zum Nim Game! :)" +
            "\n\nBitte wähle. Drücke:" +
            "\n1 für den NimPerfect als Gegner" +
            "\n2 für den Nim als Gegner" +
            "\nt für den Testmode" +
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

interface NimGame {
    fun calculateBestMove(): IntArray
    fun makeMove(array: IntArray)
    fun removeMove()
}

class NimPerfect(array1: IntArray) : NimGame {

    var array = array1
    var arrayPreviouse = ArrayList<IntArray>()

    fun isWinSituation(arrayTemp: IntArray): Boolean {
        var temp = 0
        for (i in arrayTemp.indices) {
            temp = temp xor arrayTemp[i]
        }
        if (temp == 0) return false

        return true
    }

    override fun calculateBestMove(): IntArray {
        if (isWinSituation(array)) {
            val randomRow = (array.indices).random()
            val randomNumber = (0..array[randomRow]).random()
            val arrayTemp = array.clone()
            arrayTemp[randomRow] -= randomNumber
            if (!isWinSituation(arrayTemp)) return intArrayOf(randomRow, randomNumber)
            return calculateBestMove()
        }
        for (i in array.indices) {
            if (array[i] > 0) {
                return intArrayOf(i, (1..array[i]).random())
            }
        }
        return intArrayOf(0, 0)
    }

    override fun makeMove(bestMovearray: IntArray) {
        arrayPreviouse.add(array.clone())
        array[bestMovearray[0]] -= bestMovearray[1]
    }

    override fun removeMove() {
        if (!arrayPreviouse.isEmpty()) {
            array = arrayPreviouse.last()
            arrayPreviouse.remove(arrayPreviouse.last())
        }
    }

    override fun toString(): String {
        var temp = ""
        for (i in array.indices) {
            for (j in 0 until array[i]) {
                temp += "I "
            }
            if (i != array.size - 1)
                temp += "\n"
        }
        return temp
    }
}

class Nim(array1: IntArray) : NimGame {

    var array = array1
    var arrayPreviouse = ArrayList<IntArray>()
    var savedMove = IntArray(2)

    override fun calculateBestMove(): IntArray {
        max("true", Int.MIN_VALUE, Int.MAX_VALUE)
        return savedMove
    }

    override fun makeMove(array1: IntArray) {
        arrayPreviouse.add(array.clone())
        array[array1[0]] -= array1[1]
    }

    override fun removeMove() {
        if (!arrayPreviouse.isEmpty()) {
            array = arrayPreviouse.last()
            arrayPreviouse.remove(arrayPreviouse.last())
        }
    }

    fun generatePossibleMoves(): ArrayList<IntArray> {
        var possibleMoves = ArrayList<IntArray>()
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
        var temp = ""
        for (i in array.indices) {
            for (j in 0 until array[i]) {
                temp += "I "
            }
            if (i != array.size - 1)
                temp += "\n"
        }
        return temp
    }

    fun max(tiefe: String, alpha: Int, beta: Int): Int {
        if (generatePossibleMoves().size == 0)
            return -1000
        var maxWert = alpha
        var possibleMoves = generatePossibleMoves().shuffled()
        for (i in possibleMoves.indices) {
            makeMove(possibleMoves[i])
            var wert = min("", maxWert, beta)
            removeMove()
            if (wert > maxWert) {
                maxWert = wert
                if (tiefe == "true")
                    savedMove = possibleMoves[i]
                if (tiefe == "true" && wert == 1000)
                    break
                if (maxWert >= beta)
                    break
            }
        }
        return maxWert
    }

    fun min(tiefe: String, alpha: Int, beta: Int): Int {
        if (generatePossibleMoves().size == 0)
            return 1000
        var minWert = beta
        var possibleMoves = generatePossibleMoves().shuffled()
        for (i in possibleMoves.indices) {
            makeMove(possibleMoves[i])
            var wert = max("", alpha, minWert)
            removeMove()
            if (wert < minWert) {
                minWert = wert
                if (minWert <= alpha)
                    break
            }
        }
        return minWert
    }
}