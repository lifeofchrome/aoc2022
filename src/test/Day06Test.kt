package main
import readInputLine
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day06Test {

    private val day6test = Day06(readInputLine("Day06_test"))

    @Test
    fun part1() {
        val expected = 7
        assertEquals(expected, day6test.part1())
    }

    @Test
    fun part2() {
        val expected = 19
        assertEquals(expected, day6test.part2())
    }
}