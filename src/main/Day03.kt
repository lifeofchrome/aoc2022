package main
import readInput

fun main() {
    val input = readInput("Day03")
    val day3 = Day03(input)
    print("Part 1: ${day3.part1()}\n")
    print("Part 2: ${day3.part2()}")
}
class Day03(private val input: List<String>) {

    private fun itemToPriority(item: Char): Int {
        return when(item.code) {
            in 97..122 -> item.code - 96
            in 65..90 -> (item.code - 64) + 26
            else -> error("Invalid item: $item")
        }
    }

    fun part1(): Int {
        var prioritySum = 0
        for(sack in input) {
            val left = sack.substring(0, sack.length / 2)
            val right = sack.substring(sack.length / 2)

            for(item in left) {
                if(item in right) {
                    prioritySum += itemToPriority(item)
                    break
                }
            }
        }
        return prioritySum
    }

    fun part2(): Int {
        var prioritySum = 0
        for(group in input.chunked(3)) {
            for(item in group[0]) {
                if(item in group[1] && item in group[2]) {
                    prioritySum += itemToPriority(item)
                    break
                }
            }
        }
        return prioritySum
    }
}
