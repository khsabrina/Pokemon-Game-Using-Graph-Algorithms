package ex4_java_client.ex4_java_client;



public class Node {
    private final int key;
    private GeoLocation point;
    private double weight;
    private String info;
    private int tag;




    public Node(int key,GeoLocation loc){
        this.key = key;
        this.point=loc;
        this.info="";
        this.tag=0;
        this.weight = 0;
    }

    public int getKey() {
        return this.key;
    }

    public GeoLocation getLocation() {
        return this.point;
    }

    public void setLocation(GeoLocation p) {
        this.point = (GeoLocation)p;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double w) {
        this.weight=w;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String s) {
        this.info = s;
    }

    public int getTag() {
        return this.tag;
    }

    public void setTag(int t) {
        this.tag=t;
    }

    public boolean equals(Object ot){
        if (ot == this) return true;
        if (ot == null || ot.getClass() != this.getClass()) return false;
        Node other = (Node) ot;
        return this.getKey()== other.getKey() && this.getWeight()== other.getWeight() && this.point.equals(other.getLocation()) && this.tag == other.getTag() && this.getInfo().equals(other.getInfo());
    }
}
