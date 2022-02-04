interface NimGame {
    fun calculateBestMove(): IntArray
    fun makeMove(array: IntArray): Boolean
    fun removeMove(): Boolean
}