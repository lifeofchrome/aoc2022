package main
import readInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day05Test {

    private val day5test = Day05(readInput("Day05_test"))

    @Test
    fun part1() {
        val expected = "CMZ"
        assertEquals(expected, day5test.part1())
    }

    @Test
    fun part2() {
        val expected = "MCD"
        assertEquals(expected, day5test.part2())
    }
}