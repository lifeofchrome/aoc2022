package main
import readInput

fun main() {
    val input = readInput("Day05")
    val day5 = Day05(input)
    print("Part 1: ${day5.part1()}\n")
    print("Part 2: ${day5.part2()}")
}
class Day05(input: List<String>) {
    private val numStacks = input[input.indexOf("") - 1].split(" ").last().toInt()
    private val stacksRaw: List<List<Char>> = input.slice(0 until input.indexOf("") - 1).map { row ->
        val newRow = mutableListOf<Char>()
        for(i in 1 until row.length step 4) {
            newRow.add(row[i])
        }
        for(slot in 0 until numStacks) {
            if(slot > newRow.size - 1) {
                newRow.add(' ')
            }
        }
        return@map newRow
    }
    private var stacksInput = mutableListOf<ArrayDeque<Char>>()
    private val instructions: List<String> = input.drop(input.indexOf("") + 1)

    init {
        for(col in 0 until numStacks) {
            stacksInput.add(ArrayDeque())
            for(row in stacksRaw.indices) {
                stacksInput[col].addLast(stacksRaw[row][col])
            }
        }
        stacksInput = stacksInput.map { stack -> ArrayDeque(stack.filterNot { it == ' ' }) }.toMutableList()
    }

    private fun makeStackCopy(input: MutableList<ArrayDeque<Char>>): MutableList<ArrayDeque<Char>> {
        val out = mutableListOf<ArrayDeque<Char>>()
        for(stack in input) {
            val tmp = ArrayDeque<Char>()
            for(item in stack) {
                tmp.addLast(item)
            }
            out.add(tmp)
        }
        return out
    }

    private fun interpretInstruction(input: String) =
        Regex("(\\d+)").findAll(input).map { it.groupValues[1].toInt() }.toList()

    private fun computeFirstCrates(input: MutableList<ArrayDeque<Char>>) =
        input.map { it.first() }.joinToString("")

    fun part1(): String {
        val stacks = makeStackCopy(stacksInput)
        for(instr in instructions) {
            val (qty, from, to) = interpretInstruction(instr)
            for(i in 0 until qty) {
                val tmp = stacks[from - 1].removeFirst()
                stacks[to - 1].addFirst(tmp)
            }
        }
        return computeFirstCrates(stacks)
    }

    fun part2(): String {
        val stacks = makeStackCopy(stacksInput)
        for(instr in instructions) {
            val (qty, from, to) = interpretInstruction(instr)
            val slice = stacks[from - 1].slice(0 until qty)
            stacks[from - 1] = ArrayDeque(stacks[from - 1].drop(qty))
            stacks[to - 1].addAll(0, slice)
        }
        return computeFirstCrates(stacks)
    }
}
