package ex4_java_client; /**
 * @author AchiyaZigi
 * A trivial example for starting the server and running all needed commands
 */


import java.io.IOException;

public class StudentCode {
    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.startConnection("127.0.0.1", 6666);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameData game = new GameData();
        String graphStr = client.getGraph();
        game.setGraph(graphStr);
        String pokemonsStr = client.getPokemons();
//        System.out.println(pokemonsStr);
        game.loadPokemons(pokemonsStr);
        int startnode = game.getAlgoGraph().center().getKey();
        int amountAgent = game.updateAmountAgent(client.getInfo());
        for (int i = 0; i < amountAgent; i++) {
            client.addAgent("{\"id\":"+startnode+"}");
        }
//        System.out.println(client.getAgents());
        runGui gameGui = new runGui(game,client.timeToEnd(),client.getInfo());
        client.start();
        int time=0;


        while (client.isRunning().equals("true")) {
            if (time == 0){
                time = Integer.parseInt(client.timeToEnd());
            }
            if (Integer.parseInt(client.timeToEnd()) < time - 100){
                time= Integer.parseInt(client.timeToEnd());
                client.move();
            }
            gameGui.update(game,client.timeToEnd(),client.getInfo());
            game.updatePkemons(client.getPokemons());
            game.updateAgent(client.getAgents());
            for (int i = 0; i < game.getPokemons().size(); i++) {
                if (!game.getPokemons().get(i).getAssign()) {
                    int agentAssign = game.whichAgent(game.getPokemons().get(i));
                    if (agentAssign != -1) {
                        game.addToAgentPath(agentAssign, game.getPokemons().get(i));
                        game.getPokemons().get(i).setAssign(true);
                    }
                }
            }
            for (int i = 0; i < game.getAgents().size(); i++) {
                if (game.getAgents().get(i).getPath().peek()!= null && game.getAgents().get(i).getSrc() == game.getAgents().get(i).getPath().peek() && game.getAgents().get(i).getDest()==-1){
                    game.getAgents().get(i).getPath().poll();
                }
                if (!game.getAgents().get(i).isEmptyPath() && game.getAgents().get(i).getDest()==-1){
                    client.chooseNextEdge("{\"agent_id\":"+i+", \"next_node_id\": " + game.getAgents().get(i).getPath().peek() + "}");
                }
            }
            if (game.stopOrNot){
                client.stop();
            }
        }
        if(!game.stopOrNot){
            gameGui.FinishWindow();
        }
    }
}
