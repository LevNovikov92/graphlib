package lib

import lib.base.Edge
import lib.base.Graph
import lib.base.Node
import lib.base.Vertex
import java.util.*

class UndirectedWeightGraph<N>(vertices: List<Vertex<N, WeightEdge>>) : Graph<Vertex<N, WeightEdge>>(vertices)
    where N : Node {

    fun findShortestPath(from: String, to: String): Int {
        val fromV = vertices
                .firstOrNull { it.getNode().getName().equals(from, true) } ?: throw Exception("Wrong target")
        val toV = vertices
                .firstOrNull { it.getNode().getName().equals(to, true) } ?: throw Exception("Wrong target")

        val visited = mutableListOf<Vertex<*, *>>()
        val priorityQueue = PriorityQueue<Pair<Vertex<N, E>, Int>>(
                kotlin.Comparator { v1, v2 -> v1.second.compareTo(v2.second) })
        priorityQueue.add(fromV to 0)
        while (priorityQueue.isNotEmpty()) {
            val pair = priorityQueue.remove()
            val v = pair.first
            val length = pair.second
            if (v == toV) {
                return length
            }

            visited.add(v)
            v.getEdges().filter { !visited.contains(it.target()) }
                    .forEach { edge ->
                        val newV: Vertex<N, E> = edge.target()
                        priorityQueue.add(newV to length + edge.getWeight())
                    }
        }
        throw Exception("Target vertex not found")
    }
}