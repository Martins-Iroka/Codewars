/**
 * Return the number (count) of vowels in the given string.
 *
 * We will consider a, e, i, o, u as vowels for this Kata (but not y).
 *
 * The input string will only consist of lower case letters and/or spaces.
 */
fun getCount(str : String) : Int {
    var count = 0

    str.forEach {
        when(it) {
            'a', 'e', 'i', 'o', 'u' -> count++
        }
    }
    return count
}