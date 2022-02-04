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