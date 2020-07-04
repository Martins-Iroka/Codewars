/**
 * Encrypt This!
 *
 * You want to create secret messages which can be deciphered by the Decipher this! kata.
 * Here are the conditions:
 *
 *  1. Your message is a string containing space separated words
 *
 *  2. You need to encrypt each word in the message using the following rules:
 *     a. The first letter needs to be converted to its ASCII.
 *     b. The second letter needs to be switched with the last letter
 *
 *  3. Keeping it simple: There are no special characters in input.
 */
fun main() {

    val text = "A wise old owl lived in an oak"

    println(encryptThis(text))

    println(encryptThisRefactored(text))
}

/**
 * This is the original solution
 */
fun encryptThis(text:String): String{
    val words = text.split(" ")

    val encryptedWord = StringBuilder()

    words.forEach { c ->
        val firstLetter = c[0]
        val secondLetter: Char
        val lastLetter: Char
        val encrypt = StringBuilder()
        val e: String
        if (c.length > 1) {
            secondLetter = c[1]
            lastLetter = c.last()
            encrypt.append(c)
            encrypt[1] = lastLetter
            encrypt[c.length.minus(1)] = secondLetter
            e = encrypt.toString().replaceFirst(firstLetter.toString(), firstLetter.toInt().toString())
            encrypt.clear()
        } else {
            e = c.replace(firstLetter.toString(), firstLetter.toInt().toString())
        }
        encryptedWord.append("$e ")
    }
    return encryptedWord.toString().trimEnd()
}

/**
 * This is a refactored solution
 */
fun encryptThisRefactored(text:String): String{
    return text.split(" ").joinToString(" ") {
        println(it)
        it.first().toInt().toString() + it.drop(2).takeLast(1) + it.drop(2).dropLast(1) + it.drop(1).take(1)
    }
}