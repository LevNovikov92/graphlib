package lib.base
abstract class Graph<out V> (
        val vertices: List<V>) where V: Vertex<*, *> {

    fun getBaseVertex() = vertices.first()
}