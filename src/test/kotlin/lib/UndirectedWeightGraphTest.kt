package lib

import lib.factory.GraphFactory
import lib.factory.UndirectedWeightEdge
import org.junit.Test

import org.junit.Assert.*

class UndirectedWeightGraphTest {
    @Test
    fun findShortestPath() {
        val sf = SimpleNode("SF")
        val sj = SimpleNode("SJ")
        val lv = SimpleNode("LV")
        val la = SimpleNode("LA")
        val sd = SimpleNode("SD")

        val nodes = listOf(sf, sj, lv, la, sd)
        var edges = listOf(
                UndirectedWeightEdge(sf, lv, 5),
                UndirectedWeightEdge(sf, sj, 1),
                UndirectedWeightEdge(sj, la, 3),
                UndirectedWeightEdge(la, sd, 1),
                UndirectedWeightEdge(la, lv, 2),
                UndirectedWeightEdge(sd, lv, 3))
        var factory = GraphFactory()
        var graph = factory.createWeightUndirectedGraph(nodes, edges)
        assertEquals(5, graph.findShortestPath("sd", "sf"))

        edges = listOf(
                UndirectedWeightEdge(sf, lv, 5),
                UndirectedWeightEdge(sf, sj, 5),
                UndirectedWeightEdge(sj, la, 3),
                UndirectedWeightEdge(la, sd, 1),
                UndirectedWeightEdge(la, lv, 2),
                UndirectedWeightEdge(sd, lv, 3))
        factory = GraphFactory()
        graph = factory.createWeightUndirectedGraph(nodes, edges)
        assertEquals(8, graph.findShortestPath("sd", "sf"))

        edges = listOf(
                UndirectedWeightEdge(sf, lv, 5),
                UndirectedWeightEdge(sf, sj, 5),
                UndirectedWeightEdge(sj, la, 3),
                UndirectedWeightEdge(la, sd, 1),
                UndirectedWeightEdge(la, lv, 1),
                UndirectedWeightEdge(sd, lv, 3))
        factory = GraphFactory()
        graph = factory.createWeightUndirectedGraph(nodes, edges)
        assertEquals(7, graph.findShortestPath("sd", "sf"))
    }

}