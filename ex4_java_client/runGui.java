package ex4_java_client;

import ex4_java_client.elements.GraphAlgo;
import ex4_java_client.elements.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class runGui implements ActionListener {
    private GraphAlgo graph;
    private List<Pokemon> pokemons;
    private List<Agent> agents;
    private GameData gameData;
    JFrame frame;
    JLabel AreaTime;
    myPanel The_paint;
    JLabel AreaScore;
    JPanel timeScore;
    JButton stop;
    int Score;


    public runGui(GameData game ,String time,String score) {
        this.gameData = game;
        this.graph = game.getAlgoGraph();
        this.pokemons = game.getPokemons();
        this.agents = game.getAgents();
        stop = new JButton("Stop");
        stop.addActionListener(this);
        stop.setHorizontalTextPosition(JButton.CENTER);
        stop.setFont(new Font("MV Boli",Font.PLAIN,10));
        stop.setForeground(Color.blue);
        frame = new JFrame(); //creates a frame
        timeScore = new JPanel();
        timeScore.setLayout(new FlowLayout(SwingConstants.RIGHT));
        AreaScore = new JLabel();
        AreaTime=new JLabel();
        //AreaScore.setBounds(200,200,50,50);
        int Time=this.updateTime(time);
        int Score= this.updateScore(score);
        AreaTime.setText("Time to end :"+Time);
        AreaScore.setText("Score :" + Score+"        ");
        AreaScore.setVerticalTextPosition(JLabel.BOTTOM);
        AreaTime.setVerticalTextPosition(JLabel.CENTER);
        AreaTime.setForeground(Color.cyan);
        AreaScore.setForeground(Color.cyan);
        AreaScore.setFont(new Font("MV Boli",Font.PLAIN,40));
        AreaTime.setFont(new Font("MV Boli",Font.PLAIN,40));
        timeScore.add(AreaScore);
        timeScore.add(AreaTime);
        timeScore.add(stop,BorderLayout.SOUTH);
        timeScore.add(stop,BorderLayout.BEFORE_LINE_BEGINS);




        //opening the GUI
        frame.setTitle("my GUI"); //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit the app
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());for resize
        //frame.setResizable(true);for resize

        //frame.setSize(1000,1000); //sets the size of the window
        this.The_paint = new myPanel(game);
        //this.The_paint.setSize(Toolkit.getDefaultToolkit().getScreenSize()); for resize
        timeScore.setBackground(Color.darkGray);
        timeScore.setPreferredSize(new Dimension(900,100));
        frame.getContentPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                //The_paint.updateWindow(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().width);
                //The_paint.updateWindow(componentEvent.getComponent().getWidth(),componentEvent.getComponent().getHeight());
            }
        });
        frame.add(timeScore);
        frame.add(The_paint);
        frame.repaint();
        //pack is for the frame to be just on the right size
        frame.pack();

        frame.setVisible(true); //make frame visible
        // //setLayout is for the frame to be just on the right size
        frame.setLayout(new FlowLayout());//controls the size of things that we are adding(button)

        frame.getContentPane().setBackground(Color.white);//change the color of background



    }
    public void update(GameData game,String time,String score){
        this.graph = game.getAlgoGraph();
        this.pokemons = game.getPokemons();
        this.agents = game.getAgents();
        Score= this.updateScore(score);
        int Time=this.updateTime(time);
        this.AreaScore.setText("Score :" + Score+"        ");
        this.AreaTime.setText("Time to end :"+Time+"          ");
        frame.repaint();
    }




    private int updateScore(String json){
        int ans =0;
        try {
            // parsing file "JSONExample.json"
            Object obj = new JSONParser().parse(json);
            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;
            // getting Nodes
            Map gameServer = ((Map)jo.get("GameServer"));
            Iterator<Map.Entry> itr1 = gameServer.entrySet().iterator();

            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                if (pair.getKey().equals("grade")) {
                    ans = (int) ((long) pair.getValue());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;

    }
    private int updateTime(String time){
        int Time= Integer.parseInt(time);
        return Time/1000;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==stop){
            this.gameData.setStop(true);
            frame.dispose();
            displayScore(Score);
        }

    }

    public void displayScore(int score) {
        JFrame frame2 = new JFrame(); //creating a new window for the input from the user
        JLabel label = new JLabel();
        label.setText("Your score is: " + score);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("MV Boli",Font.PLAIN,40));
        frame2.add(label);
        frame2.setLayout(new FlowLayout());
        frame2.setVisible(true);
        frame2.pack();
    }
}