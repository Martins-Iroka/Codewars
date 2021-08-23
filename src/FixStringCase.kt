import java.util.*

/**
 * In this Kata, you will be given a string that may have mixed uppercase and lowercase letters and your task is to
 * convert that string to either lowercase only or uppercase only based on :
 *
 *      make a few changes as possible.
 *      if the string contains equal number of uppercase and lowercase letters, convert the string to lowercase.
 *
 *
 *
 *  #FUNDAMENTALS
 */

fun main() {
    val a = "cODE"

    val uppNum = a.count { it.isUpperCase() }
    val lowerNum = a.count { it.isLowerCase() }

    when {
        uppNum > lowerNum -> {
            println(a.uppercase(Locale.getDefault()))
        }
        uppNum < lowerNum -> {
            println(a.lowercase(Locale.getDefault()))
        }
        else -> println(a.lowercase(Locale.getDefault()))
    }
}