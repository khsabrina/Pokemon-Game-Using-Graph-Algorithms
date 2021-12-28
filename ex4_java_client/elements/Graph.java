package ex4_java_client.elements;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;
import java.util.function.Consumer;

public class Graph {
    private HashMap<Integer, Node> Nodes;
    private HashMap<Integer, HashMap<Integer,Edge>> Edges;
    public HashMap<Integer,HashMap<Integer,Integer>> toMe;
    private int MC;


    public Graph(String json) throws Exception {
        this.Nodes = new HashMap<Integer, Node>();
        this.Edges = new HashMap<Integer, HashMap<Integer, Edge>>();
        this.toMe = new HashMap<Integer, HashMap<Integer, Integer>>();
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(json);
        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        // getting Nodes
        JSONArray ja = (JSONArray) jo.get("Nodes");
        Iterator nodeIterator = ja.iterator();
        while (nodeIterator.hasNext()) {
            Object[] data = new Object[3];
            Iterator<Map.Entry> nodeData = ((Map) nodeIterator.next()).entrySet().iterator();
            int i = 0;
            while (nodeData.hasNext()) {
                data[i] = nodeData.next().getValue();
                i++;
            }
            data[2] = ((Long) data[1]).intValue();
            String n = (String) data[0];
            String[] split = n.split(",");
            Double[] loc = new Double[]{Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2])};
            Node node = new Node((Integer) data[2], new geoLocation(loc[0], loc[1], loc[2]));
            addNode(node);
        }
        ja = (JSONArray) jo.get("Edges");
        Iterator edgeIterator = ja.iterator();
        while (edgeIterator.hasNext()) {
            Object[] data = new Object[3];
            Iterator<Map.Entry> edgeData = ((Map) edgeIterator.next()).entrySet().iterator();
            int i = 0;
            while (edgeData.hasNext()) {
                data[i] = edgeData.next().getValue();
                i++;
            }
            connect(((Long) data[0]).intValue(), ((Long) data[2]).intValue(), (Double) data[1]);
            this.MC = 0;
        }
    }

//    public Graph(String json) throws Exception {
//        this.Nodes = new HashMap<Integer, Node>();
//        this.Edges = new HashMap<Integer, HashMap<Integer, Edge>>();
//        this.toMe = new HashMap<Integer, HashMap<Integer, Integer>>();
//        // parsing file "JSONExample.json"
//        Object obj = new JSONParser().parse(json);
//        // typecasting obj to JSONObject
//        JSONObject jo = (JSONObject) obj;
//        // getting Nodes
//        JSONArray ja = (JSONArray) jo.get("Nodes");
//        Iterator nodeIterator = ja.iterator();
//        while (nodeIterator.hasNext()) {
//            Object[] data = new Object[3];
//            Iterator<Map.Entry> nodeData = ((Map) nodeIterator.next()).entrySet().iterator();
//            int i = 0;
//            while (nodeData.hasNext()) {
//                data[i] = nodeData.next().getValue();
//                i++;
//            }
//            data[2] = ((Long) data[1]).intValue();
//            String n = (String) data[0];
//            String[] split = n.split(",");
//            Double[] loc = new Double[]{Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2])};
//            Node node = new Node((Integer) data[2], new GeoLocation(loc[0], loc[1], loc[2]));
//            addNode(node);
//        }
//        ja = (JSONArray) jo.get("Edges");
//        Iterator edgeIterator = ja.iterator();
//        while (edgeIterator.hasNext()) {
//            Object[] data = new Object[3];
//            Iterator<Map.Entry> edgeData = ((Map) edgeIterator.next()).entrySet().iterator();
//            int i = 0;
//            while (edgeData.hasNext()) {
//                data[i] = edgeData.next().getValue();
//                i++;
//            }
//            connect(((Long) data[0]).intValue(), ((Long) data[2]).intValue(), (Double) data[1]);
//            this.MC = 0;
//        }
//    }

    public Graph(){
        this.Nodes = new HashMap<Integer, Node>();
        this.Edges = new HashMap<Integer, HashMap<Integer, Edge>>();
        this.toMe = new HashMap<Integer,HashMap<Integer,Integer>>();
        this.MC = 0;
    }

    public Node getNode(int key) {
            return this.Nodes.get(key);
        }

    public Edge getEdge(int src, int dest) {
        if (Edges.containsKey(src) && Edges.get(src).containsKey(dest)) {
            return this.Edges.get(src).get(dest);
        }
        else {
            return null;
        }
    }

    public void addNode(Node n) {
        if (!Nodes.containsKey(n.getKey())){
            Nodes.put(n.getKey(), n);
            toMe.put(n.getKey(), new HashMap<Integer, Integer>());
            this.MC++;
        }
    }

    public void connect(int src, int dest, double w) {
        if (!Nodes.containsKey(src)){
            return;
        }
        if (!Nodes.containsKey(dest)){
            return;
        }
        else {
            if (!Edges.containsKey(src)){
                Edges.put(src, new HashMap<>());
            }
            if (!toMe.containsKey(dest)){
                toMe.put(dest, new HashMap<>());
            }
            if (Edges.get(src).containsKey(dest)){
                return;
            }
            else {
                Edge edge = new Edge(src, dest, w);
                Edges.get(src).put(dest, edge);
                toMe.get(dest).put(src, src);
                this.MC++;
            }
        }
    }


    public Iterator<Node> nodeIter() {
        return new Iterator<Node>() {
            public int hereMC = MC;
            private final Iterator<Node> iterator = Nodes.values().iterator();

            @Override
            public boolean hasNext() {
                if (this.hereMC != MC){
                    throw new RuntimeException ("graph was changed since the iterator was constructed");
                }
                return iterator.hasNext();
            }

            @Override
            public Node next() {
                if (this.hereMC != MC){
                    throw new RuntimeException ("graph was changed since the iterator was constructed");
                }
                return iterator.next();
            }

            @Override
            public void remove(){
                if (this.hereMC != MC){
                    throw new RuntimeException ("graph was changed since the iterator was constructed");
                }
                if (this.next()!=null){
                    Graph.this.removeNode(this.next().getKey());
                    this.hereMC =Graph.this.MC;
                }
            }
            @Override
            public void forEachRemaining(Consumer<? super Node> action){
                if (this.hereMC != MC){
                    throw new RuntimeException ("graph was changed since the iterator was constructed");
                }
                Iterator.super.forEachRemaining(action);
                }
            };
    }


    public Iterator<Edge> edgeIter() {
        return new Iterator<Edge>() {
            private final Iterator<HashMap<Integer,Edge>> iterator = Edges.values().iterator();
            public int hereMC = MC;
            private Iterator<Edge> iterator1 = null;
            @Override
            public boolean hasNext() {
                if (this.hereMC != MC){
                    throw new RuntimeException ("graph was changed since the iterator was constructed");
                }
                return (iterator.hasNext() || (iterator1!=null &&(iterator1.hasNext() || iterator1 == null)));
            }

            @Override
            public Edge next() {
                if (this.hereMC != MC){
                    throw new RuntimeException ("graph was changed since the iterator was constructed");
                }
                if (iterator1 == null || !iterator1.hasNext()){
                        iterator1 = iterator.next().values().iterator();
                }
                return iterator1.next();
            }

            @Override
            public void remove(){
                if (this.hereMC != MC){
                    throw new RuntimeException ("graph was changed since the iterator was constructed");
                }
                if (this.next()!=null){
                    Graph.this.removeEdge(this.next().getSrc(),this.next().getDest());
                    this.hereMC =Graph.this.MC;
                }
            }
            @Override
            public void forEachRemaining(Consumer<? super Edge> action){
                if (this.hereMC != MC){
                    throw new RuntimeException ("graph was changed since the iterator was constructed");
                }
                Iterator.super.forEachRemaining(action);
            }
            };
        }

    public Iterator<Edge> edgeIter(int node_id) {
        if (Edges.containsKey(node_id)) {
            return new Iterator<Edge>() {
                public int hereMC = MC;
                public final Iterator<Edge> iterator = Edges.get(node_id).values().iterator();

                @Override
                public boolean hasNext() {
                    if (this.hereMC != MC) {
                        throw new RuntimeException("graph was changed since the iterator was constructed");
                    }
                    return iterator.hasNext();
                }

                @Override
                public Edge next() {
                    if (this.hereMC != MC) {
                        throw new RuntimeException("graph was changed since the iterator was constructed");
                    }
                    return iterator.next();
                }

                @Override
                public void remove() {
                    if (this.hereMC != MC) {
                        throw new RuntimeException("graph was changed since the iterator was constructed");
                    }
                    if (this.next() != null) {
                        Graph.this.removeEdge(this.next().getSrc(), this.next().getDest());
                        this.hereMC = Graph.this.MC;
                    }
                }

                @Override
                public void forEachRemaining(Consumer<? super Edge> action) {
                    if (this.hereMC != MC) {
                        throw new RuntimeException("graph was changed since the iterator was constructed");
                    }
                    Iterator.super.forEachRemaining(action);
                }
            };
        }
            List<Edge> noNodes = new ArrayList<>();
            return noNodes.iterator();
        }

    public Node removeNode(int key) {
        Node node = this.Nodes.get(key);
        if (this.Edges.containsKey(key)) {
            for (Integer i : this.Edges.get(key).keySet()) {
                this.toMe.get(i).remove(key);
            }
            this.Edges.remove(key);
        }
        if (this.toMe.containsKey(key)) {
            for (Integer i : this.toMe.get(key).keySet()) {
                this.Edges.get(i).remove(key);
                if (Edges.get(i).size()==0){
                    Edges.remove(i);
                }
            }
        }
        this.Nodes.remove(key);
        this.MC++;
        return node;
    }


    public Edge removeEdge(int src, int dest) {
        Edge edge = this.Edges.get(src).get(dest);
        this.toMe.get(dest).remove(src);
        this.Edges.get(src).remove(dest);
        if (Edges.get(src).size()==0){
            this.Edges.remove(src);
        }
        if (toMe.get(dest).size()==0){
            this.toMe.remove(dest);
        }
        this.MC++;
        return edge;
    }

    public int nodeSize() {
            return this.Nodes.size();
        }

    public int edgeSize() {
        int counter = 0;
        for (Integer i: this.Edges.keySet()){
            counter = counter + this.Edges.get(i).size();
        }
        return counter;
    }

    public int getMC() {
        return MC;
    }
}


