package lib.factory

import lib.SimpleEdge
import lib.SimpleNode
import lib.WeightEdge
import lib.base.Edge
import lib.base.Graph
import lib.base.Node
import lib.base.Vertex
import org.junit.Test

class GraphFactoryTest {

    @Test
    fun createDirectedGraph() {
        val a = SimpleNode("a")
        val b = SimpleNode("b")
        val c = SimpleNode("c")
        val d = SimpleNode("d")

        val nodes = listOf(a, b, c, d)
        val edges = listOf(DirectedEdge(a, b), DirectedEdge(a, c), DirectedEdge(b, d))
        val factory = GraphFactory()
        val graph = factory.createSimpleDirectedGraph(nodes, edges)
        printSimpleGraph(graph)
    }

    @Test
    fun createUndirectedGraph() {
        val a = SimpleNode("a")
        val b = SimpleNode("b")
        val c = SimpleNode("c")
        val d = SimpleNode("d")

        val nodes = listOf(a, b, c, d)
        val edges = listOf(UndirectedEdge(a, b), UndirectedEdge(a, c), UndirectedEdge(b, d))
        val factory = GraphFactory()
        val graph = factory.createSimpleUndirectedGraph(nodes, edges)
        printSimpleGraph(graph)
    }

    private fun printSimpleGraph(graph: Graph<Vertex<Node, SimpleEdge>>) {
        graph.vertices.forEach { v ->
            v.getEdges().forEach { e ->
                println("${v.getNode().getName()} -> ${e.target().getNode().getName()}")
            }
        }
    }

    @Test
    fun createWeightUndirectedGraph() {
        val sf = SimpleNode("SF")
        val sj = SimpleNode("SJ")
        val lv = SimpleNode("LV")
        val la = SimpleNode("LA")
        val sd = SimpleNode("SD")

        val nodes = listOf(sf, sj, lv, la, sd)
        val edges = listOf(
                UndirectedWeightEdge(sf, lv, 5),
                UndirectedWeightEdge(sf, sj, 1),
                UndirectedWeightEdge(sj, la, 3),
                UndirectedWeightEdge(la, sd, 1),
                UndirectedWeightEdge(la, lv, 2),
                UndirectedWeightEdge(sd, lv, 1))
        val factory = GraphFactory()
        val graph = factory.createWeightUndirectedGraph(nodes, edges)
        printWeightGraph(graph)
    }

    private fun printWeightGraph(graph: Graph<Vertex<Node, WeightEdge>>) {
        graph.vertices.forEach { v ->
            v.getEdges().forEach { e ->
                println("${v.getNode().getName()} -${e.getWeight()}-> ${e.target().getNode().getName()}")
            }
        }
    }
}