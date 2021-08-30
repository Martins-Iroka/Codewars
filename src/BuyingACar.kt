import kotlin.math.roundToInt

/**
 * Let us begin with an example:
 *
 * A man has a rather old car being worth $2,000. He saw a secondhand car worth $8,000. He wants to keep his old car
 * until he can buy the secondhand one.
 *
 * He thinks he can save $1,000 each month but the prices of his old car and of the new one decrease by 1.5% per
 * month. Furthermore, this percent of loss increases by 0.5% at the end of every two months. Our man finds it
 * difficult to make all these calculations.
 *
 * Can you help him?
 *
 * How many months will it take him to save up enough money to buy the car he wants and how much money will he have
 * left over?
 *
 * Note:
 *
 * Selling, buying and saving are normally done at end of month. Calculations are processed at the end of each
 * considered month but if by chance from the start, the value of the old car is bigger than the value of the new one or
 * equal, there is no saving to be made, no need to wait. So he can at the beginning of the month buy the new car.
 *
 * #FUNDAMENTALS #MATHEMATICS #ALGORITHMS #NUMBERS
 */
object BuyCar {
    fun nbMonths(
        startPriceOld: Int,
        startPriceNew: Int,
        savingperMonth: Int,
        percentLossByMonth: Double
    ): Pair<Int, Int> {
        // your code

        if (startPriceOld > startPriceNew) return Pair(0, startPriceOld - startPriceNew)

        if (startPriceOld == startPriceNew) return Pair(0, 0)

        var month = 1
        var startOld = startPriceOld.toDouble()
        var startNew = startPriceNew.toDouble()
        var saving = savingperMonth
        var percentLoss = percentLossByMonth
        var newSavings = -1

        while (newSavings < 0) {
            percentLoss = if (month % 2 == 0) percentLoss + 0.5 else percentLoss
            val percent = 1 - (percentLoss / 100)
            startOld *= percent
            startNew *= percent
            val ss = startOld + saving

            month++
            saving+= savingperMonth
            newSavings = (ss - startNew).roundToInt()
        }
        return Pair(month - 1, newSavings)
    }
}