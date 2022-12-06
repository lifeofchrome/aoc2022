import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day01Test {

    private val day1test = Day01(readInput("Day01_test"))

    @Test
    fun part1() {
        val expected = 24000
        day1test.calculateElves()
        assertEquals(expected, day1test.part1())
    }

    @Test
    fun part2() {
        val expected = 45000
        day1test.calculateElves()
        assertEquals(expected, day1test.part2())
    }
}