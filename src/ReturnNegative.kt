import kotlin.math.abs
import kotlin.math.absoluteValue

/**
 * In this simple assignment, you are given a number and have to make it negative. But maybe the number is
 * negative already?
 *
 * Notes:
 *
 *      The number can be negative already, in which case no change is required.
 *      0 is not checked for any specific sign. Negative zeros make no mathematical sense
 */
class Kata {

    fun makeNegative(x: Int) = -abs(x)
}