package ex4_java_client;

import ex4_java_client.elements.GraphAlgo;
import ex4_java_client.elements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class runGui implements ActionListener {
    private GraphAlgo graph;
    private List<Pokemon> pokemons;
    private List<Agent> agents;
    private GameData gameData;
    JFrame frame;
    myPanel The_paint;


    public runGui(GameData game) {
        this.gameData = game;
        this.graph = game.getAlgoGraph();
        this.pokemons = game.getPokemons();
        this.agents = game.getAgents();
        frame = new JFrame(); //creates a frame


        //opening the GUI
        frame.setTitle("my GUI"); //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit the app

        //frame.setSize(1000,1000); //sets the size of the window
        this.The_paint = new myPanel(game);
        frame.add(The_paint);
        frame.repaint();
        //pack is for the frame to be just on the right size
        frame.pack();
        frame.setVisible(true); //make frame visible
        // //setLayout is for the frame to be just on the right size
        frame.setLayout(new FlowLayout());//controls the size of things that we are adding(button)

        frame.getContentPane().setBackground(Color.white);//change the color of background



    }
    public void update(GameData game){
        this.graph = game.getAlgoGraph();
        this.pokemons = game.getPokemons();
        this.agents = game.getAgents();
        frame.repaint();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e==stop){
//            gameData.stopOrNot = true;
//        }
    }

}