/**
 * Delete occurrences of an element if it occurs more than n times
 *
 * Enough is enough!
 *
 * Alice and Bob were on a holiday. Both of them took many pictures of the places they've been, and now they want to
 * show Charlie their entire collection. However, Charlie doesn't like these sessions, since the motive usually repeats.
 * He isn't fond of seeing the Eiffel tower 40 times. He tells them that he will only sit during the session if they
 * show the same motive at most N times. Luckily, Alice and Bob are able to encode the motive as a number. Can you help
 * them to remove numbers such that their list contains each number only up to N times, without changing the order?
 *
 * Task
 *
 * Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering.
 * For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] since this would
 * lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].
 *
 * #FUNDAMENTALS    #LISTS  #DATA STRUCTURES
 */
fun main() {

    val a = intArrayOf(3, 2, 3, 4, 5, 6, 7, 4, 3, 2, 2, 3)

    deleteNth(a, 2)
    deleteNthRefactored(a, 3)

}

/**
 * This is the original solution
 *
 * @author Me
 */
private fun deleteNth(elements: IntArray, maxOccurrences: Int): IntArray {

    if (elements.isEmpty()) return intArrayOf()

    var newElements = elements
    var count: Int

    elements.toSet().forEach {e ->
        count = newElements.count { it == e }
        if (count > maxOccurrences) {
            while (count > maxOccurrences) {
                val n = newElements.indexOfLast { it == e }
                if (n > -1) newElements = (newElements.take(n) + newElements.drop(n + 1)).toIntArray()
                count -= 1
            }
        }
    }
    return newElements
}

/**
 * This is a refactored solution
 */
private fun deleteNthRefactored(elements: IntArray, maxOccurrences: Int): IntArray {
    val counts = mutableMapOf<Int, Int>()

    fun countFilter(x: Int) = counts.compute(x) { _, count ->
        count?.plus(1) ?: 1
    }?.let { it <= maxOccurrences }!!

    return elements.filter {
        countFilter(it) }.toIntArray()
}