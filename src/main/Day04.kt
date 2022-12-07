package main
import readInput

fun main() {
    val input = readInput("Day04")
    val day4 = Day04(input)
    print("Part 1: ${day4.part1()}\n")
    print("Part 2: ${day4.part2()}")
}
class Day04(input: List<String>) {

    private val ranges : List<Pair<IntRange, IntRange>>
    init {
        ranges = input.map { line ->
            val (p1, p2) = line.split(',')
            val (p1start, p1end) = p1.split('-').map { it.toInt() }
            val (p2start, p2end) = p2.split('-').map { it.toInt() }
            return@map Pair(p1start..p1end, p2start..p2end)
        }
    }

    private fun process(how: (IntRange, IntRange) -> Boolean) = ranges.count { how(it.first, it.second) }
    private fun rangeFullOverlap(first: IntRange, second: IntRange) =
        first.toSet().containsAll(second.toSet()) || second.toSet().containsAll(first.toSet())

    private fun rangePartialOverlap(first: IntRange, second: IntRange) =
        first.toSet().intersect(second.toSet()).isNotEmpty()
    fun part1() = process(this::rangeFullOverlap)
    fun part2() = process(this::rangePartialOverlap)
}
