package ex4_java_client;

import ex4_java_client.elements.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.*;

public class GameData {
    private List<Pokemon> Pokemons;
    private List<Agent> Agents;
    private GraphAlgo OurGraph;

    public GameData() {
        this.OurGraph = null;
        this.Agents = new ArrayList<>();
        this.Pokemons = new ArrayList<>();
    }

    public GraphAlgo getAlgoGraph() {
        return OurGraph;
    }

    public List<Pokemon> getPokemons() {
        return Pokemons;
    }

    public Agent getAgent(int id){
        for (int i = 0; i < this.Agents.size(); i++) {
            if(this.Agents.get(i).getId()==id){
                return this.Agents.get(i);
            }
        }
        return null;
    }

    public void updateAgent(String update){
        try {
            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(update);
            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;
            // getting Nodes
            JSONArray ja = (JSONArray) jo.get("Agents");
            Iterator AgentIterator = ja.iterator();
            while (AgentIterator.hasNext()) {
                Iterator<Map.Entry> Agent = ((Map) AgentIterator.next()).entrySet().iterator();
                while (Agent.hasNext()) {
                    obj = new JSONParser().parse((String) Agent.next().getValue().toString());
                    jo = (JSONObject) obj;
                    int id = (int) ((long) jo.get("id"));
                    double value = (double) jo.get("value");
                    int src = (int) ((long) jo.get("src"));
                    int dest = (int) ((long) jo.get("dest"));
                    double speed = (double) jo.get("speed");
                    String s = (String) jo.get("pos");
                    String[] pos = s.split(",");
                    geoLocation loc = new geoLocation(Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), Double.parseDouble(pos[2]));
                    Agent a = this.getAgent(id);
                    a.setDest(dest);
                    a.setPos(loc);
                    a.setValue(value);
                    a.setSpeed(speed);
                    a.setSrc(src);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Agent> getAgents() {
        return Agents;
    }

    public void setGraph(String graph) {
        this.OurGraph = new GraphAlgo(graph);
    }

    public void loadAgent(String json) {
        try {
            this.Agents = new ArrayList<Agent>();
            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(json);
            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;
            // getting Nodes
            JSONArray ja = (JSONArray) jo.get("Agents");
            Iterator AgentIterator = ja.iterator();
            while (AgentIterator.hasNext()) {
                Iterator<Map.Entry> Agent = ((Map) AgentIterator.next()).entrySet().iterator();
                while (Agent.hasNext()) {
                    obj = new JSONParser().parse((String) Agent.next().getValue().toString());
                    jo = (JSONObject) obj;
                    int id = (int) ((long) jo.get("id"));
                    double value = (double) jo.get("value");
                    int src = (int) ((long) jo.get("src"));
                    int dest = (int) ((long) jo.get("dest"));
                    double speed = (double) jo.get("speed");
                    String s = (String) jo.get("pos");
                    String[] pos = s.split(",");
                    geoLocation loc = new geoLocation(Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), Double.parseDouble(pos[2]));
                    Agent a = new Agent(id, value, src, dest, speed, loc);
                    this.Agents.add(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadPokemons(String json) {
        try {
            this.Pokemons = new ArrayList<Pokemon>();
            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(json);
            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;
            // getting Nodes
            JSONArray ja = (JSONArray) jo.get("Pokemons");
            Iterator AgentIterator = ja.iterator();
            while (AgentIterator.hasNext()) {
                Iterator<Map.Entry> Pokemon = ((Map) AgentIterator.next()).entrySet().iterator();
                while (Pokemon.hasNext()) {
                    obj = new JSONParser().parse((String) Pokemon.next().getValue().toString());
                    jo = (JSONObject) obj;
                    int type = (int) ((long) jo.get("type"));
                    double value = (double) jo.get("value");
                    String s = (String) jo.get("pos");
                    String[] pos = s.split(",");
                    geoLocation loc = new geoLocation(Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), Double.parseDouble(pos[2]));
                    Edge edge = this.findEdgeOfPokemon(loc, type);
                    Pokemon a = new Pokemon(value, type, loc, edge);
                    this.Pokemons.add(a);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePkemons(String json){
        List<Pokemon> sort = new ArrayList<>();
        try {
            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(json);
            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;
            // getting Nodes
            JSONArray ja = (JSONArray) jo.get("Pokemons");
            Iterator AgentIterator = ja.iterator();
            while (AgentIterator.hasNext()) {
                Iterator<Map.Entry> Pokemon = ((Map) AgentIterator.next()).entrySet().iterator();
                while (Pokemon.hasNext()) {
                    obj = new JSONParser().parse((String) Pokemon.next().getValue().toString());
                    jo = (JSONObject) obj;
                    int type = (int) ((long) jo.get("type"));
                    double value = (double) jo.get("value");
                    String s = (String) jo.get("pos");
                    String[] pos = s.split(",");
                    geoLocation loc = new geoLocation(Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), Double.parseDouble(pos[2]));
                    Edge edge = this.findEdgeOfPokemon(loc, type);
                    Pokemon a = new Pokemon(value, type, loc, edge);
                    sort.add(a);
                }
            }
            for (Pokemon old : this.Pokemons){
                boolean delete =true;
                for(Pokemon curr: sort){
                    if (old.equals(curr)){
                        delete =false;
                        break;
                    }
                }
                if (delete==true) {
                    this.Pokemons.remove(old);
                }
            }
            for (Pokemon curr : sort){
                boolean addornot = true;
                for(Pokemon old: this.Pokemons){
                    if (curr.equals(old)){
                        addornot =false;
                    }
                }
                if(addornot == true) {
                    this.Pokemons.add(curr);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Edge findEdgeOfPokemon(geoLocation pos, int type) {
        Iterator<Edge> iterator = this.OurGraph.getGraph().edgeIter();
        while (iterator.hasNext()) {
            Edge edge = iterator.next();
            double distSrcDest = distanceBetween2Points(this.OurGraph.getGraph().getNode(edge.getSrc()).getLocation(), this.OurGraph.getGraph().getNode(edge.getDest()).getLocation());
            double distSrcPok = distanceBetween2Points(this.OurGraph.getGraph().getNode(edge.getSrc()).getLocation(), pos);
            double distDestPok = distanceBetween2Points(this.OurGraph.getGraph().getNode(edge.getDest()).getLocation(), pos);
            if (Math.abs(distSrcDest - (distDestPok + distSrcPok)) < 0.000001) {
                if (type < 0 && edge.getSrc() > edge.getDest()) {
                    return edge;
                } else if (type > 0 && edge.getDest() > edge.getSrc()) {
                    return edge;
                }
            }
        }
        return null;
    }

    public Double distanceBetween2Points(geoLocation a, geoLocation b) {
        return Math.sqrt(Math.pow((a.x() - b.x()), 2) + Math.pow((a.y() - b.y()), 2));
    }

    public int whichAgent(Pokemon pokemon) {
        int bestAgent = -1;
        double minTime = Integer.MAX_VALUE;
        //double ratio = Integer.MAX_VALUE;
        for (int i = 0; i < this.Agents.size(); i++) {
            if (this.Agents.get(i).isEmptyPath()) {
                if (timeToPokemon(pokemon, this.Agents.get(i)) < minTime) {
                    minTime = timeToPokemon(pokemon, this.Agents.get(i));
                    bestAgent = i;
                }
            }
        }
        return bestAgent;
    }

    public double timeToPokemon(Pokemon pokemon, Agent agent) {
        int srcA = agent.getSrc();
        int srcP= pokemon.getEdge().getSrc();
        double speedA= agent.getSpeed();
        double weight = this.OurGraph.shortestPathDist(srcA,srcP);
        return (weight/speedA);
    }

    public void addToAgentPath(int agent, Pokemon pokemon){
        List<Node> path = this.OurGraph.shortestPath(this.Agents.get(agent).getSrc(), pokemon.getEdge().getSrc());
        for (int i = 1; i < path.size(); i++) {
            this.Agents.get(agent).getPath().add(path.get(i).getKey());
        }
        this.Agents.get(agent).getPath().add(pokemon.getEdge().getDest());
    }


}