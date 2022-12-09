package main

import readInput

fun main() {
    val input = readInput("Day08")
    val day08 = Day08(input)
    println("Part 1: " + day08.part1())
    println("Part 2: " + day08.part2())
}

class Day08(input: List<String>) {
    private var map: List<List<Int>>

    init {
        val tmp = mutableListOf<MutableList<Int>>()
        for(line in input) {
            val list = mutableListOf<Int>()
            for(tree in line) {
                list.add(tree.toString().toInt())
            }
            tmp.add(list)
        }
        map = tmp
    }

    private fun List<List<Int>>.isVisible(row: Int, col: Int): Boolean {
        val results = MutableList(4) { false }
        for(i in 0 until row) { // up
            if(this[i][col] >= this[row][col]) {
                results[0] = false
                break
            }
            results[0] = true
        }
        for(i in row + 1 until this.size) { // down
            if(this[i][col] >= this[row][col]) {
                results[1] = false
                break
            }
            results[1] = true
        }
        for(i in 0 until col) { // left
            if(this[row][i] >= this[row][col]) {
                results[2] = false
                break
            }
            results[2] = true
        }
        for(i in col + 1 until this[row].size) { // right
            if(this[row][i] >= this[row][col]) {
                results[3] = false
                break
            }
            results[3] = true
        }
        return results.any { it }
    }

    private fun List<List<Int>>.viewDistances(row: Int, col: Int): List<Int> {
        val results = MutableList(4) { 0 }
        for(i in row - 1 downTo 0 ) { // up
            if(this[i][col] < this[row][col]) {
                results[0]++
            } else {
                results[0]++
                break
            }
        }
        for(i in row + 1 until this.size) { // down
            if(this[i][col] < this[row][col]) {
                results[1]++
            } else {
                results[1]++
                break
            }
        }
        for(i in col - 1 downTo 0) { // left
            if(this[row][i] < this[row][col]) {
                results[2]++
            } else {
                results[2]++
                break
            }
        }
        for(i in col + 1 until this[row].size) { // right
            if(this[row][i] < this[row][col]) {
                results[3]++
            } else {
                results[3]++
                break
            }
        }
        return results
    }

    fun part1(): Int {
        var numVisible = (map.size * 2) + ((map[0].size - 2) * 2)
        for(row in 1..map.size - 2) {
            for(col in 1..map[row].size - 2) {
                if(map.isVisible(row, col)) {
                    numVisible++
                }
            }
        }
        return numVisible
    }

    fun part2(): Int {
        var highest = 0
        for(row in 1..map.size - 2) {
            for(col in 1..map[row].size - 2) {
                var current = 1
                map.viewDistances(row, col).forEach {
                    current *= it
                }
                if(current > highest) {
                    highest = current
                }
            }
        }
        return highest
    }
}