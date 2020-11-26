/**
 * Sums of Parts
 *
 * Let us consider this example(array written in general format):
 *
 *      ls = [0, 1, 3, 6, 10]
 *
 *      its following parts:
 *
 *      ls = [0, 1, 3, 6, 10]
 *      ls = [1, 3, 6, 10]
 *      ls = [3, 6, 10]
 *      ls = [6, 10]
 *      ls = [10]
 *      ls = [] or [0]
 *
 * The corresponding sums are (put together in a list):[20, 20, 19, 16, 10, 0]
 *
 * The function parts_sums (or its variants in other languages) will take as parameter a list and return a list of the
 * sums of its parts as defined above.
 *
 * Other Examples:
 *
 *      ls = [744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358]
 *      parts_sums(ls) -> [10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0]
 *
 * Notes
 *
 *  Some lists can be long
 *  Please ask before translating: some translations are already written and published when/if the kata is approved
 *
 *
 *  #ALGORITHMS     #FUNDAMENTALS       #PERFORMANCE
 */
fun main() {

    val t = intArrayOf(0, 1, 3, 6, 10)
    val b: ArrayList<Int> = arrayListOf<Int>()
    val c = 0


}

fun sumParts(ls: IntArray): IntArray {
    val b = arrayListOf<Int>()
    var c = 0

    while (c <= ls.size) {
        val lst = ls.drop(c).sum()
        b.add(lst)
        c += 1
    }

    return b.toIntArray()
}