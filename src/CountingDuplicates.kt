/**
 * Count the number of Duplicates
 * Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits
 * that occur more than once in the input string. The input string can be assumed
 * to contain only alphabets (both uppercase and lowercase) and numeric digits.

    Example
    "abcde" -> 0 # no characters repeats more than once
    "aabbcde" -> 2 # 'a' and 'b'
    "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
    "indivisibility" -> 1 # 'i' occurs six times
    "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
    "aA11" -> 2 # 'a' and '1'
    "ABBA" -> 2 # 'A' and 'B' each occur twice
 */
fun main() {

    val text = "aBcDEDffa"

    println(duplicateCount(text))

    println(duplicateCountRefactored(text))
}

/**
 * This is the original solution
 */
fun duplicateCount(text: String): Int {
    val duplicates = arrayListOf<String>()
    var duplicate = ""

    text.forEachIndexed { i, c ->
        val ch = c.toLowerCase()
        val count = text.drop(i + 1).plus(text.take(i)).count { it.toLowerCase() == ch }
        if (count != 0) duplicate = ch.toString()
        if (duplicate.isNotEmpty() and !duplicates.contains(duplicate)) duplicates.add(duplicate)
    }

    return duplicates.size
}

/**
 * This is a refactored solution
 */
fun duplicateCountRefactored(text: String): Int {
    return text.groupingBy { it.toLowerCase() }.eachCount().values.count { it > 1 }
}