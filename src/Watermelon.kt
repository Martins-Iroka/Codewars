/**
 * It's too hot, and they can't even...
 *
 * One hot summer day Pete and his friend Billy decided to buy watermelons. They chose the biggest crate.
 * They rushed home, dying of thirst, they decided to divide their loot. However, they faced a hard problem.
 *
 * Pete and Billy are great fans of even numbers, that's why they want to divide the number of watermelons
 * in such a way that each of the parts consists of an even number of watermelons. However, it is not
 * obligatory that the parts are equal.
 *
 * Example: the boys can divide a stack of 8 watermelons into 2 + 6 melons or 4 + 4 melons.
 *
 */
object Watermelon {
    fun divide(weight: Int): Boolean {
        return if (weight == 2) false else {
            weight % 2 == 0
        }
    }
}

