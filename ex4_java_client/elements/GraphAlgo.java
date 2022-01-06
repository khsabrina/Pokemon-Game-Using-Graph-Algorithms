package ex4_java_client.elements;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.PrintWriter;
import java.util.*;
import java.util.Iterator;
import java.util.List;

public class GraphAlgo {
    private Graph graph;

    public GraphAlgo(Graph gr) {
        Iterator<Node> ourNodes = gr.nodeIter();
        Iterator<Edge> ourEdges = gr.edgeIter();
        this.graph = new Graph();
        while (ourNodes.hasNext()) {
            Node grNode = ourNodes.next();
            this.graph.addNode(new Node(grNode.getKey(), new geoLocation(grNode.getLocation().x(), grNode.getLocation().y(), grNode.getLocation().z())));
        }
        while (ourEdges.hasNext()) {
            Edge grEdge = ourEdges.next();
            this.graph.connect(grEdge.getSrc(), grEdge.getDest(), grEdge.getWeight());
        }

    }

    //Default Builder c'tor
    public GraphAlgo() {
        this.graph = new Graph();
    }

    public GraphAlgo(String json) {
        Graph graph = new Graph();
        try {
            graph = new Graph(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.graph = graph;
    }

    //Initialize our DWGA by given DirectedWeightedGraph object
    public void init(Graph g) {
        Iterator<Node> ourNodes = g.nodeIter();
        Iterator<Edge> ourEdges = g.edgeIter();
        this.graph = new Graph();
        while (ourNodes.hasNext()) {
            Node grNode = ourNodes.next();
            this.graph.addNode(new Node(grNode.getKey(), new geoLocation(grNode.getLocation().x(), grNode.getLocation().y(), grNode.getLocation().z())));
        }
        while (ourEdges.hasNext()) {
            Edge grEdge = ourEdges.next();
            this.graph.connect(grEdge.getSrc(), grEdge.getDest(), grEdge.getWeight());
        }

    }

    public Graph getGraph() {
        return this.graph;
    }

    //Deep copy of self object DWGA

    public Graph copy() {
        Graph here = new Graph();
        Iterator<Node> it = this.graph.nodeIter();
        while (it.hasNext()) {
            Node node = it.next();
            Node k = new Node(node.getKey(), (geoLocation) node.getLocation());
            here.addNode(k);
        }
        Iterator<Node> it2 = this.graph.nodeIter();
        while (it2.hasNext()) {
            Iterator<Edge> it3 = this.graph.edgeIter(it2.next().getKey());
            while (it3.hasNext()) {
                Edge edge = it3.next();
                here.connect(edge.getSrc(), edge.getDest(), edge.getWeight());
            }
        }
        return here;
    }

    //Checking if the self DWGA is composed of only one component
    public boolean isConnected() {
        Iterator<Node> iterator = this.graph.nodeIter();
        while (iterator.hasNext()) {
            HashMap<Integer, Double> routes = routes(iterator.next().getKey());
            Iterator<Double> iterator1 = routes.values().iterator();
            while (iterator1.hasNext()) {
                if (iterator1.next() == -1.0) {
                    return false;
                }
            }
        }
        return true;
    }

    //Checking what is the weight of the shortest path between two nodes
    public double shortestPathDist(int src, int dest) {
        HashMap<Integer, Double> routes = routes(src);
        return routes.get(dest);
    }

    public HashMap<Integer, Double> routes(int src) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(graph.getNode(src));
        // List<Double> weight= new LinkedList<>();
        HashMap<Integer, Double> weight = new HashMap<Integer, Double>();
        Iterator<Node> n = graph.nodeIter();
        for (int i = 0; i < graph.nodeSize(); i++) {
            Node n1 = n.next();
            if (n1.getKey() != src) {
                weight.put(n1.getKey(), Double.MAX_VALUE);
            }
        }
        weight.put(src, 0.0);
        while (!q.isEmpty()) {
            Node discover = q.poll();
            Iterator<Edge> edge_node = this.graph.edgeIter(discover.getKey());
            while (edge_node.hasNext()) {
                Edge edge = edge_node.next();
                if (weight.get(edge.getDest()) > weight.get(discover.getKey()) + edge.getWeight()) {
                    weight.put(edge.getDest(), weight.get(discover.getKey()) + edge.getWeight());
                    q.add(graph.getNode(edge.getDest()));
                }
            }
        }
        for (Integer i : weight.keySet()) {
            if (weight.get(i) == Double.MAX_VALUE) {
                weight.put(i, -1.0);
            }
        }
        return weight;
    }

    //Checking the route of the shortest path between two given nodes
    public List<Node> shortestPath(int src, int dest) {
        HashMap<Integer, Double> routes = routes(src);
        if (routes.get(dest) == -1) {
            return null;
        }
        List<Node> returnList = new ArrayList<>();
        Node node = graph.getNode(dest);
        returnList.add(node);
        double leftToGo = routes.get(dest);
        while (leftToGo > 0) {
            for (Integer i : this.graph.toMe.get(node.getKey()).keySet()) {
                if (node.getKey() == src) {
                    break;
                }
                if (routes.get(i) == -1) {
                    continue;
                }
                double somthing = this.graph.getEdge(i, node.getKey()).getWeight();
                if (Math.abs(leftToGo - (routes.get(i) + somthing)) < 0.00001) {
                    leftToGo = leftToGo - somthing;
                    node = graph.getNode(i);
                    returnList.add(node);
                    break;
                }
            }
            if (leftToGo < 0.00001) {
                break;
            }
        }
        Collections.reverse(returnList);
        return returnList;
    }

    //return the node that is the center of the graph (footnote - center node is the node which the max the shortest path to all the other nodes is minimized.)
    public Node center() {
        Node ans = null;
        double min = Double.MAX_VALUE;
        Iterator<Node> iterator = this.graph.nodeIter();
        while (iterator.hasNext()) {
            double max = 0;
            Node srcNode = iterator.next();
            HashMap<Integer, Double> routes = routes(srcNode.getKey());
            for (Integer i : routes.keySet()) {
                if (routes.get(i) == -1.0) {
                    return null;
                }
                if (routes.get(i) > max) {
                    max = routes.get(i);
                }
            }
            if (max < min) {
                min = max;
                ans = srcNode;
            }
        }
        return ans;
    }

    public List<Node> tsp(List<Node> cities) {
        if (cities.size() == 0) {
            return null;
        }
        List<Node> ans = new ArrayList<>();
        int idxToDelete = 0;
        Node here = cities.get(0);
        //ans.add(here);
        cities.remove(cities.get(idxToDelete));
        while (cities.size() > 0) {
            double min = Double.MAX_VALUE;
            HashMap<Integer, Double> routes = routes(here.getKey());
            for (int i = 0; i < cities.size(); i++) {
                if (routes.get(cities.get(i).getKey()) < min) {
                    min = routes.get(cities.get(i).getKey());
                    idxToDelete = i;
                }
            }
            List<Node> path = shortestPath(here.getKey(), cities.get(idxToDelete).getKey());
            ans.addAll(path);
            ans.remove(ans.size() - 1);
            here = cities.get(idxToDelete);
            cities.remove(cities.get(idxToDelete));
        }
        ans.add(here);
        return ans;
    }


    public boolean save(String file) {
        try {
            JSONObject jo = new JSONObject();
            JSONArray ja = new JSONArray();
            Map m;
            Iterator<Edge> iterator = this.graph.edgeIter();
            while (iterator.hasNext()) {
                m = new LinkedHashMap(3);
                Edge e = iterator.next();
                m.put("src", e.getSrc());
                m.put("w", e.getWeight());
                m.put("dest", e.getDest());
                ja.add(m);
            }
            jo.put("Edges", ja);
            ja = new JSONArray();
            Iterator<Node> iterator1 = this.graph.nodeIter();
            while (iterator1.hasNext()) {
                m = new LinkedHashMap(2);
                Node n = iterator1.next();
                m.put("pos", n.getLocation().x() + "," + n.getLocation().y() + "," + n.getLocation().z());
                m.put("id", n.getKey());
                ja.add(m);
            }
            jo.put("Nodes", ja);
            PrintWriter pw = new PrintWriter(file);
            pw.write(jo.toJSONString());
            pw.flush();
            pw.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean load(String file) {
        try {
            this.graph = new Graph(file);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}