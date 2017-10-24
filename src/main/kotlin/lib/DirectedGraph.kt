package lib

import lib.base.Edge
import lib.base.Graph
import lib.base.Node
import lib.base.Vertex

class DirectedGraph<N, E>(vertices: List<Vertex<N, E>>) : Graph<Vertex<N, E>>(vertices)
    where N : Node, E : Edge