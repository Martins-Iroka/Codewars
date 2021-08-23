/**
 * Consecutive strings
 *
 * You are given an array(list) strarr of strings and an integer k. Your task is to return the first longest string
 * consisting of k consecutive strings taken in the array.
 *
 * Example:
 *          longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
 *
 *          n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 *
 * Note: consecutive strings follow one after another without an interruption
 */
fun main() {
    val consec = arrayOf("zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail")

    longestConsec(consec, 3)

}

fun longestConsec(strarr: Array<String>, k: Int): String {

    val n = strarr.size
    return if ((n == 0) or (k > n) or (k <= 0)) ""
    else strarr.toList().windowed(k).map { it.joinToString("") }.maxByOrNull { it.length } ?: ""
}