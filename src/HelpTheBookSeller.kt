/**
 * Help the bookseller!
 *
 * A bookseller has lots of books classified in 26 categories labeled A,B,...Z. Each book has a code
 * of 3,4,5 or more characters. The 1st character of a code is a capital letter which defines the book category.
 * In the bookseller's stocklist each code is followed by a space and by a positive integer n(int n >= 0) which
 * indicates the quantity of books of this code in stock.
 *
 * For example an extract of a stocklist could be:
 *     L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}.
 *
 * You will be given a stocklist(e.g.:L) and a list of categories in capital letters e.g:
 *     M = {"A", "B", "C", "W"}
 * and your task is to find all the books of L with codes belonging to each catergory of M and to sum their quantity
 * according to each category.
 *
 * For the lists L and M of example you have to return the string(in Haskell/Clojure/Racket a list of pairs):
 *     (A : 20) - (B : 114) - (C : 50) - (W : 0)
 * where A,B,C,W are the categories, 20 is the sum of the unique book of category A, 114 the sum corresponding to
 * "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to category 'W' since there are no code beginning with W.
 *
 * If L or M are empty return string is "" (Clojure and Racket should return an empty array/list instead).
 *
 * Note:
 * In the result codes and their values are in the same order as in M.
 *
 * FUNDAMENTALS ALGORITHMS
 */
fun main() {

    val b = arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600", "EFTG 34", "TEDS 43")
    val c = arrayOf("A", "B")

    println(stockSummary(b, c))

    println(stockSummaryRefactored(b, c))
}

/**
 * This is the original solution
 *
 * @author Me
 */
private fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {

    if (lstOfArt.isEmpty()) return ""

    val result = StringBuilder()

    lstOfCat.forEachIndexed { index, s ->
        val b = lstOfArt.filter { s.first() == it.first() }

        var j = 0
        var count = -1
        while (count != b.size - 1) {
            val i = b[count + 1].split(" ")[1].toInt()
            j += i
            count+=1
        }
        if (index == lstOfCat.size - 1) {
            result.append("($s : $j)")
            return@forEachIndexed
        }
        result.append("($s : $j) - ")
    }

    return result.toString()
}

/**
 * This is a refactored solution
 */
fun stockSummaryRefactored(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
    if (lstOfArt.isEmpty()) return ""
    val counts = lstOfArt.groupingBy { it.take(1) }.fold(0) { acc, s -> acc + s.split(" ")[1].toInt() }
    return lstOfCat.joinToString(" - ") { "($it : ${counts.getOrDefault(it, 0)})" }
}