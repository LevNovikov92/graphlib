package lib

import lib.base.Node

class SimpleNode(private val name: String) : Node {
    override fun getName() = name
}