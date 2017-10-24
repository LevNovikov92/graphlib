package lib

import lib.base.Edge
import lib.base.Node
import lib.base.Vertex

class SimpleEdge(private val to: Any) : Edge {
    override fun target(): Any = to
}
