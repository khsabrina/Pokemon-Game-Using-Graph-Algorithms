package ex4_java_client.Tests;

import ex4_java_client.elements.*;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class AgentTest {

    geoLocation pos1 = new geoLocation(35.19589389346247,32.10152879327731,0.0);
    Agent kh = new Agent(0, 3.2, 1, 4, 1.7, new geoLocation(35.19589389346247,32.10152879327731,0.0));
    Agent sh = new Agent(1, 2.0, 2, 1, 2.2, new geoLocation(0.0, 0.0, 0.0));

    @Test
    void getId() {
        int check1 = kh.getId();
        int check2 = sh.getId();
        assertEquals(check1, 0);
        assertEquals(check2, 1);
//        assertTimeoutPreemptively(1000,kh.getId());
    }

    @Test
    void getSrc() {
        int check1 = kh.getSrc();
        int check2 = sh.getSrc();
        assertEquals(check1, 1);
        assertEquals(check2, 2);
    }

    @Test
    void getDest() {
        int check1 = kh.getDest();
        int check2 = sh.getDest();
        assertEquals(check1, 4);
        assertEquals(check2, 1);
    }

    @Test
    void getLocation() {
        geoLocation check = kh.getLocation();
        assertEquals(pos1,check);
    }

    @Test
    void getSpeed() {
        double check1 = kh.getSpeed();
        double check2 = sh.getSpeed();
        assertEquals(check1, 1.7);
        assertEquals(check2, 2.2);
    }

    @Test
    void isEmptyPath() {
        assertTrue(kh.isEmptyPath());
    }

    @Test
    void getPath() {
        Queue<Integer> check = sh.getPath();
        assertTrue(check.isEmpty());
    }

    @Test
    void setId() {
        kh.setId(1);
        sh.setId(0);
        int check1 = kh.getId();
        int check2 = sh.getId();
        assertEquals(check1, 1);
        assertEquals(check2, 0);
    }

    @Test
    void setValue() {
        kh.setValue(4.4);
        sh.setValue(2.444);
        double check1 = kh.getValue();
        double check2 = sh.getValue();
        assertEquals(check1, 4.4);
        assertEquals(check2, 2.444);
    }

    @Test
    void setSrc() {
        kh.setSrc(3);
        sh.setSrc(0);
        int check1 = kh.getSrc();
        int check2 = sh.getSrc();
        assertEquals(check1, 3);
        assertEquals(check2, 0);
    }

    @Test
    void setDest() {
        kh.setDest(0);
        sh.setDest(0);
        int check1 = kh.getDest();
        int check2 = sh.getDest();
        assertEquals(check1, 0);
        assertEquals(check2, 0);
    }

    @Test
    void setPos() {
        sh.setPos(pos1);
        assertEquals(pos1,sh.getLocation());
    }

    @Test
    void setSpeed() {
        kh.setSpeed(0.5);
        sh.setSpeed(0.5);
        double check1 = kh.getSpeed();
        double check2 = sh.getSpeed();
        assertEquals(check1, 0.5);
        assertEquals(check2, 0.5);
    }
}