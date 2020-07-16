/**
 * Find The Parity Outlier
 *
 * You are given an array(which will have a length of at least 3, but could be very large) containing integers.
 * The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single
 * integer N. Write a method that takes the array as an argument and returns this "outlier" N.
 *
 * Examples:
 *          [2, 4, 0, 100, 4, 11, 2602, 36]
 *          Should return: 11 (the only odd number)
 *
 *          [160, 3, 1719, 19, 11, 13, -21]
 *          Should return: 160 (the only even number)
 */
fun main() {

    val i = arrayOf(160, 3, 1719, 19, 11, 13, -21)
    val j = arrayOf(2, -6, 8, -10, -3)

    findTheParityOutlier(i)

    findTheParityOutlierRefactored(j)
}

/**
 * This is the original solution
 */
private fun findTheParityOutlier(integer: Array<Int>): Int {

    val isEven = integer.groupBy {
        it.rem(2) == 0
    }

    return if (isEven[true]?.size == 1) isEven[true]?.get(0)!! else isEven[false]?.get(0)!!
}

/**
 * This is the refactored solution
 */
private fun findTheParityOutlierRefactored(integer: Array<Int>): Int {

    return integer.singleOrNull { it.rem(2) == 0 } ?: integer.single { it.rem(2) != 0 }
}