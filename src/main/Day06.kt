package main
import readInputLine

fun main() {
    val input = readInputLine("Day06")
    val day6 = Day06(input)
    print("Part 1: ${day6.part1()}\n")
    print("Part 2: ${day6.part2()}")
}
class Day06(private val input: String) {

    private fun findUniqueSequence(len: Int): Int {
        for(i in (len - 1) until input.length) {
            val set = mutableSetOf<Char>()
            set.addAll(input.substring(i - (len - 1) .. i).toList())
            if(set.size == len) {
                return i + 1
            }
        }
        error("Couldn't find valid start-of-packet marker")
    }
    fun part1() = findUniqueSequence(4)
    fun part2() = findUniqueSequence(14)
}
