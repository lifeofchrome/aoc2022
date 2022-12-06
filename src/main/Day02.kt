package main
import readInput

fun main() {
    val input = readInput("Day02")
    val day2 = Day02(input)
    day2.process()
    print("Part 1: ${day2.part1()}\n")
    print("Part 2: ${day2.part2()}")
}
class Day02(private val input: List<String>) {

    private val rounds = mutableListOf<Pair<Shape, Shape>>()
    fun process() {
        var first: Shape
        var second: Shape
        for (round in input) {
            first = when (round[0]) {
                'A' -> Shape.ROCK
                'B' -> Shape.PAPER
                'C' -> Shape.SCISSORS
                else -> error("Opponent's shape is invalid: $round")
            }
            second = when (round[2]) {
                'X' -> Shape.ROCK
                'Y' -> Shape.PAPER
                'Z' -> Shape.SCISSORS
                else -> error("Player's shape is invalid: $round")
            }
            rounds.add(Pair(first, second))
        }
    }

    private fun isTie(round: Pair<Shape, Shape>): Boolean {
        return round.first == round.second
    }

    private fun isWin(round: Pair<Shape, Shape>): Boolean {
        if (round.second == Shape.ROCK && round.first == Shape.SCISSORS) {
            return true
        } else if (round.second == Shape.PAPER && round.first == Shape.ROCK) {
            return true
        } else if (round.second == Shape.SCISSORS && round.first == Shape.PAPER) {
            return true
        }
        return false
    }

    private fun isLoss(round: Pair<Shape, Shape>): Boolean {
        return !isTie(round) && !isWin(round)
    }


    fun part1(): Int {
        var score = 0
        for (round in rounds) {
            score += round.second.value
            score += if (isLoss(round)) {
                0
            } else if(isWin(round)) {
                6
            } else {
                3
            }
        }
        return score
    }

    fun part2(): Int {
        var score = 0
        val table: List<List<Shape>> = listOf(listOf(Shape.SCISSORS, Shape.ROCK, Shape.PAPER), listOf(Shape.ROCK, Shape.PAPER, Shape.SCISSORS), listOf(Shape.PAPER, Shape.SCISSORS, Shape.ROCK))
        for(round in rounds) {
            val playerShape = table[round.first.value - 1][round.second.value - 1]
            val newRound = Pair(round.first, playerShape)
            score += playerShape.value
            score += if (isLoss(newRound)) {
                0
            } else if(isWin(newRound)) {
                6
            } else {
                3
            }
        }
        return score
    }
}


enum class Shape(val value: Int) {
    ROCK(1), PAPER(2), SCISSORS(3)
}