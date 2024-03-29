/**
 * Given an array of integers.
 *
 * Return an array where the first element is the count of positives numbers and the second element is sum
 * of negative numbers.
 *
 * if the input array is empty or null, return an empty array
 *
 * Example
 * For input [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15], you should return [10, -65]
 */
fun countPositivesSumNegatives(input : Array<Int>?) : Array<Int> {
    if (input.isNullOrEmpty()) return emptyArray()

    val n = arrayListOf<Int>()
    val g = input.groupBy { it < 0 }

    n.add(g[false]?.count{ it != 0 }?: 0)
    n.add(g[true]?.sum()?: 0)

    return n.toTypedArray()
}