import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day02Test {

    private val day2test = Day02(readInput("Day02_test"))

    @Test
    fun part1() {
        day2test.process()
        val expected = 15
        assertEquals(expected, day2test.part1())
    }

    @Test
    fun part2() {
        day2test.process()
        val expected = 12
        assertEquals(expected, day2test.part2())
    }
}