package ex4_java_client.elements;


public class Edge{
    private int src;
    private int dest;
    private double weight;


    public Edge(int src,int dst,double weight){
        this.src=src;
        this.dest =dst;
        this.weight=weight;
    }

    public int getSrc() {
        return this.src;
    }

    public int getDest() {
        return this.dest;
    }

    public double getWeight() {
        return this.weight;
    }
}
