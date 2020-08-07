/**
 * Reversing the values in a Map
 *
 * Using the functional techniques, write a function called flipValues that allows you to flip-flop the keys and values
 * in a map. For example:
 *
 *      val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)
 *      {Josh=4.0, Alex=2.0, Jane=3.0}
 *
 *      flipValues(gradesByStudent)
 *      {4.0=Josh, 2.0=Alex, 3.0=Jane}
 */
fun main() {

    val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)

    println(flipValues(gradesByStudent))
}

private fun flipValues(gradesByStudent: Map<String, Double>) =
    gradesByStudent.map {
        it.value to it.key
    }.toMap()