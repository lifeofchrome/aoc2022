package main
import readInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day03Test {

    private val day3test = Day03(readInput("Day03_test"))

    @Test
    fun part1() {
        val expected = 157
        assertEquals(expected, day3test.part1())
    }

    @Test
    fun part2() {
        val expected = 70
        assertEquals(expected, day3test.part2())
    }
}