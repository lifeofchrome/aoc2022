package main
import readInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day07Test {

    private val day7test = Day07(readInput("Day07_test"))

    @Test
    fun part1() {
        val expected = 95437
        assertEquals(expected, day7test.part1())
    }

    @Test
    fun part2() {
        val expected = 24933642
        assertEquals(expected, day7test.part2())
    }
}