package ex4_java_client.ex4_java_client;

import java.util.LinkedList;
import java.util.List;
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





}
