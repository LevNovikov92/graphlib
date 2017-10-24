package lib

import lib.base.Edge
import lib.base.Vertex

open class WeightEdge(private val vertex: Any, private val weight: Int) : Edge {
    override fun target() = vertex

    fun getWeight() = weight
}