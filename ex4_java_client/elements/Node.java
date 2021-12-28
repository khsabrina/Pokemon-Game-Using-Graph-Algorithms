package ex4_java_client.elements;



public class Node {
    private final int key;
    private geoLocation point;




    public Node(int key, geoLocation loc){
        this.key = key;
        this.point = loc;
    }

    public int getKey() {
        return this.key;
    }

    public geoLocation getLocation() {
        return this.point;
    }

    public void setLocation(geoLocation p) {
        this.point = (geoLocation) p;
    }
}
