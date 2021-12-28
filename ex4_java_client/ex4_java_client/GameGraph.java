package ex4_java_client.ex4_java_client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameGraph {
    List<Pokemon> Pok;
    List<Agent> Agents;
    GraphAlgo OurGraph;

    public GameGraph(GraphAlgo g){
        this.OurGraph = g;
    }

    public void LoadAgent(String file) throws IOException, ParseException {

    }
}
