package ex4_java_client.Tests;
import ex4_java_client.elements.geoLocation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestGeoLocation {
    geoLocation P1 = new geoLocation(5,6,7);
    geoLocation P2 = new geoLocation(7,8,9);
    geoLocation P3 = new geoLocation(10,11,1);
    geoLocation P5 = new geoLocation(18,19,21);
    geoLocation P4 = new geoLocation(1,2,3);


        @Test
        void x() {
            assertEquals(5, P1.x());
            assertEquals(7, P2.x());
            assertEquals(10, P3.x());
            assertEquals(1, P4.x());
            assertEquals(18,P5.x());
        }

        @Test
        void y() {
            assertEquals(6,P1.y());
            assertEquals(8,P2.y());
            assertEquals(11,P3.y());
            assertEquals(2,P4.y());
            assertEquals(19,P5.y());
        }

        @Test
        void z() {
            assertEquals(7,P1.z());
            assertEquals(9,P2.z());
            assertEquals(1,P3.z());
            assertEquals(3,P4.z());
            assertEquals(21,P5.z());
        }

        @Test
        void distance() {
            assertEquals(2*Math.sqrt(3),P1.distance(P2));
            assertEquals(Math.sqrt(82),P2.distance(P3));
        }

}
