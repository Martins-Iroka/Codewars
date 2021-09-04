/**
 * Two read beads are placed between every two blue beads. There are N blue beads. After looking at
 * the arrangement below, work out the number of red beads.
 *
 * @ @@ @ @@ @ @@ @ @@ @ @@ @
 *
 * if there are less than 2 blue beads, return 0
 */
fun countReadBeads(nBlue: Int): Int {
    if (nBlue < 0) return 0

    return (nBlue * 2) - 2
}