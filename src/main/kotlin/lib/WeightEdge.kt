package lib

import lib.base.Edge
import lib.base.Vertex

open class WeightEdge<V>(private val vertex: V, private val weight: Int) : Edge<V> {
    override fun target() = vertex

    fun getWeight() = weight
}