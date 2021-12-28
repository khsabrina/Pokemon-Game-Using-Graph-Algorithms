package ex4_java_client.ex4_java_client;


public class Edge{
    int src;
    int dst;
    double weight;
    int tag;
    String info;

    public Edge(int src,int dst){
        this.src=src;
        this.dst=dst;
        this.weight=0;
        this.tag=-0;
        this.info="0";
    }

    public Edge(int src,int dst,double weight){
        this.src=src;
        this.dst=dst;
        this.weight=weight;
        this.tag=0;
        this.info="0";
    }

    public int getSrc() {
        return this.src;
    }

    public int getDest() {
        return this.dst;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getInfo() {
        return this.info;
    }


    public void setInfo(String s) {
        this.info=s;
    }


    public int getTag() {
        return this.tag;
    }


    public void setTag(int t) {
        this.tag=t;
    }
}
