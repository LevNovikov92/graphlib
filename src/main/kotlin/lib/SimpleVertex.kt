package lib

import lib.base.Edge
import lib.base.Node
import lib.base.Vertex

class SimpleVertex<E>(private val node: Node) : Vertex<Node, E> where E : Edge{
    private val edges = mutableListOf<E>()

    override fun getNode() = node

    override fun getEdges(): List<E> = edges

    override fun addEdge(e: E) {
        edges.add(e)
    }

    override fun addEdges(e: List<E>) {
        edges.addAll(e)
    }

    override fun setEdges(e: List<E>) {
        edges.clear()
        edges.addAll(e)
    }

    override fun toString(): String {
        return node.getName()
    }
}