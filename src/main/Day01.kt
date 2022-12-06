fun main() {
    val input = readInput("Day01")
    val day1 = Day01(input)
    day1.calculateElves()
    print("Part 1: ${day1.part1()}\n")
    print("Part 2: ${day1.part2()}")
}
class Day01(private val input: List<String>) {
    private val elves = mutableListOf<Int>()
    fun calculateElves() {
        var current = 0
        for (line in input) {
            if (line == "") {
                elves.add(current)
                current = 0
            } else {
                current += line.toInt()
            }
        }
        elves.add(current)
    }
    fun part1(): Int {
        return elves.max()
    }

    fun part2(): Int {
        return elves.sortedDescending().slice(0..2).sum()
    }
}