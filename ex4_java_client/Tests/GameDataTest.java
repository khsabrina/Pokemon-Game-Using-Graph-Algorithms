package ex4_java_client.Tests;

import ex4_java_client.GameData;
import ex4_java_client.elements.Graph;
import ex4_java_client.elements.GraphAlgo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameDataTest {

    String checkPokemon = "{\"Pokemons\":[{\"Pokemon\":{\"value\":5.0,\"type\":-1,\"pos\":\"35.197656770719604,32.10191878639921,0.0\"}}]}";
    String checkAgent = "{\"Agents\":[{\"Agent\":{\"id\":0,\"value\":0.0,\"src\":7,\"dest\":-1,\"speed\":1.0,\"pos\":\"35.20746249717514,32.10254648739496,0.0\"}}]}\n";
    String anotherCheckPokemon = "{\"Pokemons\":[{\"Pokemon\":{\"value\":5.0,\"type\":-1,\"pos\":\"35.20273974670703,32.10439601193746,0.0\"}},{\"Pokemon\":{\"value\":8.0,\"type\":-1,\"pos\":\"35.189541903742466,32.10714473742062,0.0\"}},{\"Pokemon\":{\"value\":13.0,\"type\":1,\"pos\":\"35.198546018801096,32.10442041371198,0.0\"}},{\"Pokemon\":{\"value\":5.0,\"type\":-1,\"pos\":\"35.20418622066997,32.10618391544376,0.0\"}},{\"Pokemon\":{\"value\":9.0,\"type\":-1,\"pos\":\"35.207511563168026,32.10516145234799,0.0\"}},{\"Pokemon\":{\"value\":12.0,\"type\":-1,\"pos\":\"35.19183431463849,32.106897389061444,0.0\"}}]}\n";
    String anotherCheckAgents = "{\"Agents\":[{\"Agent\":{\"id\":0,\"value\":0.0,\"src\":0,\"dest\":-1,\"speed\":1.0,\"pos\":\"35.19589389346247,32.10152879327731,0.0\"}},{\"Agent\":{\"id\":1,\"value\":0.0,\"src\":0,\"dest\":-1,\"speed\":1.0,\"pos\":\"35.19589389346247,32.10152879327731,0.0\"}},{\"Agent\":{\"id\":2,\"value\":0.0,\"src\":0,\"dest\":-1,\"speed\":1.0,\"pos\":\"35.19589389346247,32.10152879327731,0.0\"}}]}\n";
    GameData gameTest = new GameData();

    @BeforeAll


    @Test
    void getAlgoGraph() {
        GraphAlgo check = gameTest.getAlgoGraph();
        assertNull(check);
    }

    @Test
    void getPokemons() {
    }

    @Test
    void getAgent() {
    }

    @Test
    void updateAgent() {
    }

    @Test
    void getAgents() {
    }

    @Test
    void setGraph() {
    }

    @Test
    void loadAgent() {
    }

    @Test
    void loadPokemons() {
    }

    @Test
    void updateAmountAgent() {
    }

    @Test
    void updatePkemons() {

    }

    @Test
    void findEdgeOfPokemon() {
    }

    @Test
    void distanceBetween2Points() {
    }

    @Test
    void whichAgent() {
    }

    @Test
    void timeToPokemon() {
    }

    @Test
    void addToAgentPath() {
    }

    @Test
    void setStop() {
    }
}