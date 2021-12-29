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




        //System.out.println(client.getInfo());
        String graphStr = client.getGraph();
        game.setGraph(graphStr);

        System.out.println(graphStr);
        client.addAgent("{\"id\":"+9+"}");
        String agentsStr = client.getAgents();
        game.loadAgent(agentsStr);

        System.out.println(agentsStr);
        String pokemonsStr = client.getPokemons();
        game.loadPokemons(pokemonsStr);

        System.out.println(pokemonsStr);
        String isRunningStr = client.isRunning();
        System.out.println(isRunningStr);

        int startnode = game.getAlgoGraph().center().getKey();
        System.out.println(client.addAgent("{\"id\":0}"));
        runGui gameGui = new runGui(game);
        client.start();

        while (client.isRunning().equals("true")) {
            gameGui.update(game);
            client.move();
            //game.loadPokemons(client.getPokemons());
            game.updatePkemons(client.getPokemons());
            game.updateAgent(client.getAgents());
            //System.out.println(client.getAgents());
            for (int i = 0; i < game.getPokemons().size(); i++) {
                int agentAssign = game.whichAgent(game.getPokemons().get(i));
                if (agentAssign != -1) {
                    game.addToAgentPath(agentAssign, game.getPokemons().get(i));
                }
            }

            //System.out.println(client.getAgents());

            //System.out.println(client.timeToEnd());

            //Scanner keyboard = new Scanner(System.in);
            //System.out.println("enter the next dest: ");
            //int next = keyboard.nextInt();
            for (int i = 0; i < game.getAgents().size(); i++) {
                if (game.getAgents().get(i).getPath().peek()!= null && game.getAgents().get(i).getSrc() == game.getAgents().get(i).getPath().peek() && game.getAgents().get(i).getDest()!=-1){
                    game.getAgents().get(i).getPath().poll();
                }
                if (!game.getAgents().get(i).isEmptyPath() && game.getAgents().get(i).getDest()==-1){
                    client.chooseNextEdge("{\"agent_id\":"+i+", \"next_node_id\": " + game.getAgents().get(i).getPath().poll() + "}");
                }
            }
        }
    }
}
