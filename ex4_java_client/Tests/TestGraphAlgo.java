package ex4_java_client.Tests;

import static org.junit.jupiter.api.Assertions.*;

import ex4_java_client.elements.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestGraphAlgo {
    Graph gr = generate();
    GraphAlgo graph = new GraphAlgo(gr);


    @Test
    void getGraph() {
        Iterator<Edge> original = gr.edgeIter();
        Iterator<Edge> initgraph = graph.getGraph().edgeIter();
        while (original.hasNext()) {
            assertEquals(original.next().getWeight(), initgraph.next().getWeight());
        }
    }

    @Test
    void copy() {
        Graph copy = (Graph) graph.copy();
        assertEquals(copy.edgeSize(), gr.edgeSize());
        assertEquals(copy.nodeSize(), gr.nodeSize());
        Iterator<Node> iterator = copy.nodeIter();
        Iterator<Node> iterator1 = gr.nodeIter();
        while (iterator.hasNext()) {
            assertEquals(iterator.next().getLocation(), iterator1.next().getLocation());
        }
        Iterator<Edge> iterator2 = copy.edgeIter();
        Iterator<Edge> iterator3 = gr.edgeIter();
        while (iterator.hasNext()) {
            assertEquals(iterator2.next().getSrc(), iterator3.next().getSrc());
        }
    }

    @Test
    void isConnected() {
        assertEquals(true, graph.isConnected());
        graph.getGraph().removeEdge(5, 0);
        assertEquals(false, graph.isConnected());
        graph.getGraph().connect(2, 0, 0.9);
        assertEquals(true, graph.isConnected());
    }

    @Test
    void shortestPathDist() {
        assertEquals(graph.shortestPathDist(2, 6), 12.9, 0.0001);
        assertEquals(graph.shortestPathDist(0, 2), 7.8, 0.0001);
        assertEquals(graph.shortestPathDist(2, 4), 1.5, 0.0001);
        graph.getGraph().connect(2, 0, 0.2);
        graph.getGraph().removeEdge(0, 4);
        graph.getGraph().connect(0, 4, 0.3);
        assertEquals(graph.shortestPathDist(2, 4), 0.5, 0.0001);
    }

    @Test
    void shortestPath() {
        List<Node> route = graph.shortestPath(2, 4);
        Iterator<Node> iterator = route.iterator();
        assertEquals(iterator.next(), graph.getGraph().getNode(2));
        assertEquals(iterator.next(), graph.getGraph().getNode(3));
        assertEquals(iterator.next(), graph.getGraph().getNode(4));
        graph.getGraph().removeEdge(5, 0);
        List<Node> route1 = graph.shortestPath(2, 1);
        iterator = route1.listIterator();
        assertEquals(iterator.next(), graph.getGraph().getNode(2));
        assertEquals(iterator.next(), graph.getGraph().getNode(3));
        assertEquals(iterator.next(), graph.getGraph().getNode(4));
        assertEquals(iterator.next(), graph.getGraph().getNode(5));
        assertEquals(iterator.next(), graph.getGraph().getNode(6));
        assertEquals(iterator.next(), graph.getGraph().getNode(7));
        assertEquals(iterator.next(), graph.getGraph().getNode(8));
        assertEquals(iterator.next(), graph.getGraph().getNode(9));
        assertEquals(iterator.next(), graph.getGraph().getNode(1));
        List<Node> route2 = graph.shortestPath(0, 8);
        iterator = route2.listIterator();
        assertEquals(iterator.next(), graph.getGraph().getNode(0));
        assertEquals(iterator.next(), graph.getGraph().getNode(8));
    }

    @Test
    void center() {
        assertEquals(graph.center().getKey(), 0);
    }

    @Test
    void tsp() {
        List<Node> check = new ArrayList<>(), check2 = new ArrayList<>(), check3 = new ArrayList<>();
        for (int i = 0; i < 9; i = i + 2) {
            check.add(this.gr.getNode(i));
        }
        check2.add(this.gr.getNode(0));
        check2.add(this.gr.getNode(3));
        check2.add(this.gr.getNode(7));
        List<Node> ans = new ArrayList<>(), ans2 = new ArrayList<>(), ans3 = new ArrayList<>();
        ans.add(this.gr.getNode(0));
        ans.add(this.gr.getNode(8));
        ans.add(this.gr.getNode(9));
        ans.add(this.gr.getNode(1));
        ans.add(this.gr.getNode(2));
        ans.add(this.gr.getNode(3));
        ans.add(this.gr.getNode(4));
        ans.add(this.gr.getNode(5));
        ans.add(this.gr.getNode(6));

        ans2.add(this.gr.getNode(0));
        ans2.add(this.gr.getNode(7));
        ans2.add(this.gr.getNode(8));
        ans2.add(this.gr.getNode(9));
        ans2.add(this.gr.getNode(1));
        ans2.add(this.gr.getNode(2));
        ans2.add(this.gr.getNode(3));

        check3.add(this.gr.getNode(0));
        check3.add(this.gr.getNode(5));
        check3.add(this.gr.getNode(4));

        ans3.add(this.gr.getNode(0));
        ans3.add(this.gr.getNode(5));
        ans3.add(this.gr.getNode(0));
        ans3.add(this.gr.getNode(4));

        List<Node> test = this.graph.tsp(check);
        List<Node> test2 = this.graph.tsp(check2);
        List<Node> test3 = this.graph.tsp(check3);

        assertEquals(test.get(0).getKey(), ans.get(0).getKey());
        assertEquals(test2.get(1).getKey(), ans2.get(1).getKey());
        assertEquals(test3.get(2).getKey(), ans3.get(2).getKey());
    }

    @Test
    void save() throws IOException {
        graph.save("data\\G1TEST.json");
        GraphAlgo graph2 = new GraphAlgo();
        Path fileName = Path.of("data\\G1TEST.json");
        String content = Files.readString(fileName);
        graph2.load(content);
        assertEquals(graph.getGraph().nodeSize(), graph2.getGraph().nodeSize());
    }

    @Test
    void load() throws IOException {
        graph.save("data\\G1TEST.json");
        GraphAlgo graph2 = new GraphAlgo();
        Path fileName = Path.of("data\\G1TEST.json");
        String content = Files.readString(fileName);
        graph2.load(content);
        assertEquals(graph.getGraph().nodeSize(), graph2.getGraph().nodeSize());
    }

    public Graph generate() {
        Graph gr = new Graph();
        Node a0 = new Node(0, new geoLocation(0, 0, 0));
        Node a1 = new Node(1, new geoLocation(1, 6, 0));
        Node a2 = new Node(2, new geoLocation(4, 5, 0));
        Node a3 = new Node(3, new geoLocation(-1, 4, 0));
        Node a4 = new Node(4, new geoLocation(3, 0, 0));
        Node a5 = new Node(5, new geoLocation(2, -2, 0));
        Node a6 = new Node(6, new geoLocation(-1, -8, 0));
        Node a7 = new Node(7, new geoLocation(-6, -6, 0));
        Node a8 = new Node(8, new geoLocation(-7, -1, 0));
        Node a9 = new Node(9, new geoLocation(-4, -1, 0));
        gr.addNode(a0);
        gr.addNode(a1);
        gr.addNode(a2);
        gr.addNode(a3);
        gr.addNode(a4);
        gr.addNode(a5);
        gr.addNode(a6);
        gr.addNode(a7);
        gr.addNode(a8);
        gr.addNode(a9);
        gr.connect(0, 1, 1.5);
        gr.connect(0, 2, 20);
        gr.connect(0, 3, 8.2);
        gr.connect(0, 4, 5.2);
        gr.connect(0, 5, 4.9);
        gr.connect(0, 6, 2.3);
        gr.connect(0, 7, 1.3);
        gr.connect(0, 8, 0.4);
        gr.connect(0, 9, 1.2);
        gr.connect(9, 1, 4.2);
        gr.connect(1, 2, 6.3);
        gr.connect(2, 3, 1.2);
        gr.connect(3, 4, 0.3);
        gr.connect(4, 5, 5.3);
        gr.connect(5, 6, 6.1);
        gr.connect(6, 7, 4.3);
        gr.connect(7, 8, 3.9);
        gr.connect(8, 9, 9.2);
        gr.connect(5, 0, 10);
        return gr;
    }

}
