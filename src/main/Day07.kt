package main
import readInput

fun main() {
    val input = readInput("Day07")
    val day7 = Day07(input)
    print("Part 1: ${day7.part1()}\n")
    print("Part 2: ${day7.part2()}")
}
class Day07(input: List<String>) {

    private val root = Node("/", false, 0, mutableListOf())
    private var path = ArrayDeque<Node>()

    init {
        path.addLast(root)
        for(line in input.drop(1)) {
            if(line[0] == '$') {
                val rawCmd = line.drop(2).split(" ")
                val cmd = rawCmd[0]
                val args = if(rawCmd[0] == "ls") "" else rawCmd[1]
                when(cmd) {
                    "ls" -> continue
                    "cd" -> if(args != "..") {
                        path.addLast(path.last().children.find { it.name == args } ?: error("[\$ cd $args]: Can't find directory $args"))
                    } else {
                        path.removeLast()
                    }
                    else -> error("Invalid command: $cmd")
                }
            } else { // reading files from ls
                path.last().children.add(fileToNode(line))
            }
        }
    }

    private fun fileToNode(file: String) =
        if(file[0] == 'd') Node(file.drop(4), false, 0, mutableListOf())
        else Node(file.split(" ")[1], true, file.split(" ")[0].toInt(), mutableListOf())

    private fun calculateSize(node: Node): Int {
        return if(node.children.size == 0) {
            node.size
        } else {
            var total = 0
            node.children.forEach { total += calculateSize(it) }
            total
        }
    }

    private fun getAllDirs(node: Node): List<Node> {
        return if(node.children.size == 0) {
            if(!node.isFile) listOf(node) else listOf()
        } else {
            val dirs = mutableListOf<Node>()
            if(!node.isFile) {
                dirs.add(node)
            }
            node.children.forEach {
                dirs.addAll(getAllDirs(it)) }
            dirs.toList()
            return dirs
        }
    }

    fun part1(): Int {
        var total = 0
        for(dir in getAllDirs(root)) {
            val size = calculateSize(dir)
            if(size <= 100000) {
                total += size
            }
        }
        return total
    }
    fun part2(): Int {
        val needed = 30000000 - (70000000 - calculateSize(root)) // needed: 3M - free space: (7M - used space)
        var smallest = Int.MAX_VALUE
        for(dir in getAllDirs(root)) {
            val size = calculateSize(dir)
            if(size in needed until smallest) {
                smallest = size
            }
        }
        return smallest
    }
}

class Node(var name: String, var isFile: Boolean, var size: Int, var children: MutableList<Node>)
