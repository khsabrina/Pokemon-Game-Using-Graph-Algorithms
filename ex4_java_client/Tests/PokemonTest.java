package ex4_java_client.Tests;

import ex4_java_client.elements.Edge;
import ex4_java_client.elements.Pokemon;
import ex4_java_client.elements.geoLocation;
import org.junit.jupiter.api.Test;
import ex4_java_client.*;

import static org.junit.jupiter.api.Assertions.*;


class PokemonTest {
    geoLocation pos1 = new geoLocation(0.0, 0.0, 0.0);
    geoLocation pos2 = new geoLocation(35.20273974670703, 32.10439601193746, 0.0);
    Pokemon kh = new Pokemon(33.3, 1, new geoLocation(0.0, 0.0, 0.0), new Edge(1, 2, 2.1));
    Pokemon sh = new Pokemon(0, -1, pos2, new Edge(3, 2, 3.2));

    @Test
    void getValue() {
        double check1 = kh.getValue();
        assertEquals(check1, 33.3);
    }

    @Test
    void getType() {
        int check1 = kh.getType();
        assertEquals(check1, 1);
    }

    @Test
    void getLocation() {
    geoLocation check = kh.getLocation();
    assertEquals(check,pos1);
    assertEquals(sh.getLocation(),pos2);

    }

    @Test
    void getEdge() {
        Edge check = kh.getEdge();
        Edge answer = new Edge(1,2,2.1);
        assertEquals(check.getSrc(),answer.getSrc());
        assertEquals(check.getDest(),answer.getDest());
        assertEquals(check.getWeight(),answer.getWeight());
    }

    @Test
    void testEquals() {
        assertFalse(kh.equals(sh));
    }

    @Test
    void getAssign() {
        assertFalse(sh.getAssign());
    }

    @Test
    void setAssign() {
        sh.setAssign(Boolean.TRUE);
        assertTrue(sh.getAssign());
    }
}