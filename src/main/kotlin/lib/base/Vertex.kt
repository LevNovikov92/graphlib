package lib.base

interface Vertex<N, E> where N : Node, E : Edge {
    fun getNode(): N
    fun getEdges(): List<E>
    fun addEdges(e: List<E>)
    fun addEdge(e: E)
    fun setEdges(e: List<E>)
}