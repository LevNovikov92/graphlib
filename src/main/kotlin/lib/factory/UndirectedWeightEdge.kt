package lib.factory

import lib.base.Node

class UndirectedWeightEdge(from: Node, to: Node, private val weight: Int) : BaseEdge(from, to) {
    fun getWeight() = weight
}