package main
import readInput

fun main() {
    val input = readInput("Day04")
    val day4 = Day04(input)
    print("Part 1: ${day4.part1()}\n")
    print("Part 2: ${day4.part2()}")
}
class Day04(input: List<String>) {

    private var ranges = mutableListOf<Pair<IntRange, IntRange>>()
    init {
        val extractRanges = Regex("(\\d+)-(\\d+),(\\d+)-(\\d+)")
        for(line in input) {
            val results = extractRanges.matchEntire(line) ?: error("Unable to extract ranges for pair: $line")
            if (results.groupValues.size < 4) {
                error("Not enough values for pair: $line")
            }
            val first = results.groupValues[1].toInt()..results.groupValues[2].toInt()
            val second = results.groupValues[3].toInt()..results.groupValues[4].toInt()
            ranges.add(Pair(first, second))
        }
    }

    private fun process(how: (IntRange, IntRange) -> Boolean): Int {
        var matches = 0
        for(group in ranges) {
            if(how(group.first, group.second)) {
                matches++
            }
        }
        return matches
    }

    private fun rangeFullOverlap(first: IntRange, second: IntRange) : Boolean {
        return (first.first in second && first.last in second) ||
                (second.first in first && second.last in first)
    }

    private fun rangePartialOverlap(first: IntRange, second: IntRange) : Boolean {
        return (first.first in second) || (first.last in second) || (second.first in first) || (second.last in first)
    }

    fun part1() = process(this::rangeFullOverlap)
    fun part2() = process(this::rangePartialOverlap)
}
