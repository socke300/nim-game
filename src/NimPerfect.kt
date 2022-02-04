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