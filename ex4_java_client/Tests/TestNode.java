package ex4_java_client.Tests;
import ex4_java_client.elements.Node;
import ex4_java_client.elements.geoLocation;
import org.junit.jupiter.api.Test;
import ex4_java_client.*;

import static org.junit.jupiter.api.Assertions.*;
public class TestNode {
    geoLocation P5 = new geoLocation(18,19,21);
    geoLocation P4 = new geoLocation(1,2,3);
    geoLocation P3 = new geoLocation(5,6,7);
    geoLocation P1 = new geoLocation(8,9,10);
    Node n1= new Node(1,P1);
    Node n2 = new Node(2,P3);
    Node n3 = new Node(3,P4);
    Node n4 = new Node(4,P5);
        @Test
        void getKey() {
            assertEquals(1, n1.getKey());
            assertEquals(2,n2.getKey());
            assertEquals(3,n3.getKey());
            assertEquals(4,n4.getKey());
        }

        @Test
        void getLocation() {
            assertEquals(8, n1.getLocation().x());
            assertEquals(9, n1.getLocation().y());
            assertEquals(6, n2.getLocation().y());
            assertEquals(3,n3.getLocation().z());
        }

        @Test
        void setLocation() {
            geoLocation P6 = new geoLocation(1,2,3);
            n2.setLocation(P6);
            assertEquals(1, n2.getLocation().x());
            assertEquals(2,n2.getLocation().y());

        }



}
