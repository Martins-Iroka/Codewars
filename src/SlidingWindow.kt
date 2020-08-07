/**
 * Sliding Window
 *
 * Using a functional programming approach, perform the following operations on the list:
 *
 *      listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)
 *
 *   1) Exclude any number less than 5
 *   2) Group the numbers in pairs
 *   3) Multiply the two numbers in each pair
 *   4)Sum the result products to produce a final number
 */
fun main() {

    val valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)

    val v = listComputation(valuesToAdd)

    println(v)

}

private fun listComputation(values: List<Int>) = values.filter { it >= 5 }.chunked(2) {
    it.fold(1){acc, i ->
        acc * i
    }
}.sum()