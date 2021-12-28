package ex4_java_client.elements;

import java.util.LinkedList;
import java.util.Queue;

public class Agent {
    int id;
    int src;
    int dest;
    GeoLocation pos;
    double speed;
    Queue<Integer> path = new LinkedList<>();

    public Agent(int id,int src,int dest, double speed,GeoLocation pos){
        this.id=id;
        this.src=src;
        this.dest=dest;
        this.speed=speed;
        this.pos=pos;
    }

    public int GetId(){
        return this.id;
    }
    public int GetSrc(){
        return this.src;
    }
    public int GetDest(){
        return this.dest;
    }
    public GeoLocation GetLocation(){
        return this.pos;
    }
    public double GetSpeed(){
        return this.speed;
    }

    public boolean isEmptyPath() {
        return this.path.isEmpty();
    }

    public Queue<Integer> getPath() {
        return path;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setValue(double value){
        this.value=value;
    }
    public void setSrc(int src){
        this.src=src;
    }
    public void setDest(int dest){
        this.dest=dest;
    }
    public void setPos(geoLocation p){
        this.pos=p;
    }
    public void setSpeed(double speed){
        this.speed=speed;
    }

    public geoLocation getLocation() {
        return this.pos;
    }
}


