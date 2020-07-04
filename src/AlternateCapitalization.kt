
/**
 * Given a string, capitalize the letters that occupy even indexes and odd indexes separately, and return a as shown below.
 * Index 0 will be considered even.
 *
 *  For example; capitalize("abcdef") = ['AbCdEf', 'aBcDeF']. See test cases for more examples.
 *
 * The input will be a lowercase string with no spaces.
 */
import java.lang.StringBuilder

fun main() {

    val text = "abcdefgh"

    println(capitalize(text))

    println(capitalizeRefactored(text))
}

/**
 * This is the original solution
 */
fun capitalize(text: String): List<String> {
    val even = StringBuilder()
    val odd = StringBuilder()

    var evenCount = 2
    var oddCount = 1

    text.forEachIndexed { i, c ->
        even.append(
            when (i) {
                0 -> c.toUpperCase()
                evenCount -> {
                    evenCount += 2
                    c.toUpperCase()
                }
                else -> c
            }
        )

        odd.append(
            when (i) {
                0 -> c
                oddCount -> {
                    oddCount += 2
                    c.toUpperCase()
                }
                else -> c
            }
        )
    }
    return listOf(even.toString(), odd.toString())
}

/**
 * This is a refactored solution
 */
fun capitalizeRefactored(text: String) = listOf(
    text.mapIndexed {index, c -> if (index % 2 == 0) c.toUpperCase() else c }.fold("") {acc, c -> acc + c.toString() },
    text.mapIndexed {index, c -> if (index % 2 != 0) c.toUpperCase() else c }.fold("") {acc, c -> acc + c.toString() })