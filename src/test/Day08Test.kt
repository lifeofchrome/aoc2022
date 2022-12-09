package main

import readInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day08Test {

    private val day08test = Day08(readInput("Day08_test"))

    @Test
    fun part1() {
        val expected = 21
        assertEquals(expected, day08test.part1())
    }

    @Test
    fun part2() {
        val expected = 8
        assertEquals(expected, day08test.part2())
    }
}