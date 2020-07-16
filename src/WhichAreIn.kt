/**
 * Which are in?
 *
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the string of a1 which are
 * substrings of strings of a2.
 *
 * #Example 1: a1 = ["arp", "live", "strong"]
 *
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *
 * return ["arp", "live", "strong"]
 *
 * #Example 2: a1 = ["tarp", "mice", "bull"]
 *
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *
 * return []
 *
 * NOTES:
 *
 * * Arrays are written in "general" notation. See "Your Test Cases" for examples in your language
 *
 * * In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
 *
 * * Beware: r must be without duplicates.
 *
 * * Don't mutate the inputs
 */
fun main() {

    val a1 = arrayOf("oint", "pini", "by", "omm", "wh", "ou", "ect", "pini")
    val a2 = arrayOf("here", "perfect", "pointed", "have", "am", "have", "1.9.2.", "here", "Ruby,", "have", "am",
        "sample;", "I", "using", "opinion,", "should", "would", "you", "using", "I")

    whichAreIn(a1, a2)

    whichAreInRefactored(a1, a2)

}

/**
 * This is the original solution
 */
private fun whichAreIn(a1: Array<String>, a2: Array<String>): Array<String> {

    val a3 = arrayListOf<String>()
    a2.forEach { word ->
        val pair = word.findAnyOf(a1.toList())
        pair?.let { a3.add(it.second) }
    }

    return a3.toSet().sorted().toTypedArray()
}

/**
 * This is a refactored solution
 */
private fun whichAreInRefactored(a1: Array<String>, a2: Array<String>): Array<String> {
    return a1.filter{ e -> a2.any { it.contains(e) } }
        .distinct().sorted().toTypedArray()
}