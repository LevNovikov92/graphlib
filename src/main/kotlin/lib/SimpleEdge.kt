package lib

import lib.base.Edge
import lib.base.Node
import lib.base.Vertex

class SimpleEdge<V>(private val to: V) : Edge<V> {
    override fun target(): V = to
}
