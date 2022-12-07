package main
import readInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day04Test {

    private val day4test = Day04(readInput("Day04_test"))

    @Test
    fun part1() {
        val expected = 2
        assertEquals(expected, day4test.part1())
    }

    @Test
    fun part2() {
        val expected = 4
        assertEquals(expected, day4test.part2())
    }
}