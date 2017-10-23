package lib.factory

import lib.base.Node

open class BaseEdge(private val from: Node, private val to: Node) {
    fun from() = from
    fun to() = to
}