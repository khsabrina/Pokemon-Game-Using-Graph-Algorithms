package ex4_java_client.elements;

import java.util.LinkedList;
import java.util.Queue;

public class Agent {
    private int id;
    private double value;
    private int src;
    private int dest;
    private geoLocation pos;
    private double speed;
    private Queue<Integer> path = new LinkedList<>();

    public Agent(int id, double value, int src, int dest, double speed, geoLocation pos) {
        this.id = id;
        this.value = value;
        this.src = src;
        this.dest = dest;
        this.speed = speed;
        this.pos = pos;
    }

    public int getId() {
        return this.id;
    }
    public int getSrc() {
        return this.src;
    }
    public int getDest() {
        return this.dest;
    }
    public geoLocation GetLocation() {
        return this.pos;
    }
    public double getSpeed() {
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