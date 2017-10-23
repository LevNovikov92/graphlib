package lib.factory

import lib.*
import lib.base.Edge
import lib.base.Node
import lib.base.Vertex

class GraphFactory {

    fun createSimpleDirectedGraph(nodes: List<Node>, edge: List<DirectedEdge>): DirectedGraph<Node, SimpleEdge> {
        val verticesList = mutableListOf<Vertex<Node, SimpleEdge>>()
        nodes.forEach { node -> verticesList.add(SimpleVertex(node)) }
        edge.forEach {
            val from = findVertexByNode(verticesList, it.from())
            val to = findVertexByNode(verticesList, it.to())
            if (from == null || to == null) {
                throw Exception("Wrong data set")
            }
            from.addEdge(SimpleEdge(to))
        }
        return DirectedGraph(verticesList)
    }

    fun createSimpleUndirectedGraph(nodes: List<Node>, edge: List<UndirectedEdge>): UndirectedGraph<Node, SimpleEdge> {
        val verticesList = mutableListOf<Vertex<Node, SimpleEdge>>()
        nodes.forEach { node -> verticesList.add(SimpleVertex(node)) }
        edge.forEach {
            val from = findVertexByNode(verticesList, it.from())
            val to = findVertexByNode(verticesList, it.to())
            if (from == null || to == null) {
                throw Exception("Wrong data set")
            }
            from.addEdge(SimpleEdge(to))
            to.addEdge(SimpleEdge(from))
        }
        return UndirectedGraph(verticesList)
    }

    fun createWeightUndirectedGraph(nodes: List<Node>, edge: List<UndirectedWeightEdge>): UndirectedWeightGraph<Node, WeightEdge> {
        val verticesList = mutableListOf<Vertex<Node, WeightEdge>>()
        nodes.forEach { node -> verticesList.add(SimpleVertex(node)) }
        edge.forEach {
            val from = findVertexByNode(verticesList, it.from())
            val to = findVertexByNode(verticesList, it.to())
            if (from == null || to == null) {
                throw Exception("Wrong data set")
            }
            from.addEdge(WeightEdge(to, it.getWeight()))
            to.addEdge(WeightEdge(from, it.getWeight()))
        }
        return UndirectedWeightGraph(verticesList)
    }

    private fun <N, E> findVertexByNode(vertices: List<Vertex<N, E>>, node: N): Vertex<N, E>? where N : Node, E : Edge =
            vertices.firstOrNull { it.getNode() == node }
}