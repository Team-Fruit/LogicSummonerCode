/**
 * Main.javaのKotlinバージョン。もっと良い書き方あるかも?
 * 移植してから気がついた。Kotlinサポートされてないやん...
 */
package 旅立ちの街_フンケ.生け贄.夜との契約.sjcl

import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val size = sc.nextLine().toInt()
    val magic = Array(size, { IntArray(size) })
    for (w in 0..size - 1) {
        val line = sc.nextLine().split(" ")
        for (i in 0..size - 1)
            magic[w][i] = line[i].toInt()
    }
    var total = 0
    var validTotal = false
    val zeroPos = arrayListOf<Pos>()
    for (w in 0..size - 1) {
        var zero = false
        for (i in 0..size - 1) {
            if (magic[w][i] == 0) {
                zero = true
                zeroPos.add(Pos(w, i))
            }
            if (!validTotal)
                total += magic[w][i]
        }
        if (!zero)
            validTotal = true
        if (!validTotal)
            total = 0
    }
    for ((x, y) in zeroPos) {
        var lineTotal = 0
        var zeroCount = 0
        for (w in 0..size - 1) {
            if (magic[w][y] == 0)
                zeroCount++
            lineTotal += magic[w][y]
        }
        if (zeroCount >= 2) {
            lineTotal = 0
            (0..size - 1).forEach { i -> lineTotal += magic[x][i] }
        }
        magic[x][y] = total - lineTotal
    }
    val op = buildString {
        for (w in 0..size - 1)
            appendln(magic[w].joinToString(" "))
    }
    println(op)
}

data class Pos(val x: Int, val y: Int)
