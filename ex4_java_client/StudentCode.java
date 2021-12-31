package ex4_java_client; /**
 * @author AchiyaZigi
 * A trivial example for starting the server and running all needed commands
 */

import ex4_java_client.elements.Agent;

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


        //System.out.println(client.getInfo());
        String graphStr = client.getGraph();
        game.setGraph(graphStr);

        System.out.println(graphStr);
        //client.addAgent("{\"id\":"+9+"}");
        //String agentsStr = client.getAgents();
        //game.loadAgent(client.getAgents());
        //System.out.println(client.getAgents());

        //System.out.println(agentsStr);
        String pokemonsStr = client.getPokemons();
        game.loadPokemons(pokemonsStr);

        //System.out.println(pokemonsStr);
        //String isRunningStr = client.isRunning();
        //System.out.println(isRunningStr);
        //System.out.println(client.getInfo());
        int startnode = game.getAlgoGraph().center().getKey();
        int amountAgent = game.updateAmountAgent(client.getInfo());
        for (int i = 0; i < amountAgent; i++) {
            client.addAgent("{\"id\":"+startnode+"}");
        }
        runGui gameGui = new runGui(game,client.timeToEnd(),client.getInfo());
        client.start();
        //client.login("208483008");
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
            System.out.println(client.getInfo());

            game.updatePkemons(client.getPokemons());
            game.updateAgent(client.getAgents());
            //System.out.println(client.getAgents());
            for (int i = 0; i < game.getPokemons().size(); i++) {
                //System.out.println(game.getPokemons().get(i).getAssign());
                if (!game.getPokemons().get(i).getAssign()) {
                    int agentAssign = game.whichAgent(game.getPokemons().get(i));
                    if (agentAssign != -1) {
                        game.addToAgentPath(agentAssign, game.getPokemons().get(i));
                        game.getPokemons().get(i).setAssign(true);
                    }
                }
            }

            //System.out.println(client.getAgents());

            //System.out.println(client.timeToEnd());

            //Scanner keyboard = new Scanner(System.in);
            //System.out.println("enter the next dest: ");
            //int next = keyboard.nextInt();


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
    }
}
