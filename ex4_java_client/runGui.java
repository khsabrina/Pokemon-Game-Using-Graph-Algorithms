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
    JPanel TimeScore;
    JButton stop;
    int Score;


    public runGui(GameData game ,String time,String score) {
        this.gameData = game;
        this.graph = game.getAlgoGraph();
        this.pokemons = game.getPokemons();
        this.agents = game.getAgents();
        frame = new JFrame(); //creates a frame
        this.setScoreTime(time,score);
        //opening the GUI
        frame.setTitle("my GUI"); //
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit the app
        //frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());for resize
        //frame.setResizable(true);for resize

        //frame.setSize(1000,1000); //sets the size of the window
        this.The_paint = new myPanel(game);
        //this.The_paint.setSize(Toolkit.getDefaultToolkit().getScreenSize()); for resize
        frame.getContentPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                //The_paint.updateWindow(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().width);
                //The_paint.updateWindow(componentEvent.getComponent().getWidth(),componentEvent.getComponent().getHeight());
            }
        });
        frame.add(The_paint);
        frame.repaint();
        //pack is for the frame to be just on the right size
        frame.pack();

        frame.setVisible(true); //make frame visible
        // //setLayout is for the frame to be just on the right size
        frame.setLayout(new FlowLayout());//controls the size of things that we are adding(button)

        frame.getContentPane().setBackground(Color.white);//change the color of background


    }
    public void upateScreenSize(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //TimeScore.setSize(dim.width,100);
        TimeScore.setBounds(0,5,dim.width,100);
        if(frame.getWidth()>900) {
            AreaScore.setBounds(0 + frame.getWidth() / 10, 20, 350, 40);
            AreaTime.setBounds(0 + (frame.getWidth() / 10) * 4, 20, 350, 40);
            stop.setBounds(frame.getWidth() - 100, 20, 100, 50);
        }

    }
    public void setButtonStop(){
        stop = new JButton("Stop");
        stop.addActionListener(this);
        stop.setHorizontalTextPosition(JButton.CENTER);
        stop.setSize(20,20);
        stop.setFont(new Font("MV Boli",Font.PLAIN,20));
        stop.setForeground(Color.blue);
        stop.setBounds(TimeScore.getWidth()-100,20,100,50);
        TimeScore.add(stop,BorderLayout.AFTER_LINE_ENDS);
        //TimeScore.add(stop,BorderLayout.EAST);
    }
    public void setScoreTime(String time,String score){
        TimeScore = new JPanel();
        //TimeScore.setLayout(new FlowLayout(SwingConstants.RIGHT));
        TimeScore.setLayout(null);
        AreaScore = new JLabel();
        AreaTime=new JLabel();
        int Time=this.updateTime(time);
        int Score= this.updateScore(score);
        AreaTime.setText("Time to end :"+Time);
        AreaScore.setText("Score :" + Score);
        AreaTime.setForeground(Color.cyan);
        AreaScore.setForeground(Color.cyan);
        TimeScore.setPreferredSize(new Dimension(900,100));
        AreaScore.setBounds(0, 20,350,40);
        AreaTime.setBounds(350,20,350,40);
        AreaScore.setFont(new Font("MV Boli",Font.PLAIN,40));
        AreaTime.setFont(new Font("MV Boli",Font.PLAIN,40));
        TimeScore.add(AreaScore);
        TimeScore.add(AreaTime);
        TimeScore.setBackground(Color.darkGray);
        this.setButtonStop();
        frame.add(TimeScore);


    }
    public void update(GameData game,String time,String score){
        this.graph = game.getAlgoGraph();
        this.pokemons = game.getPokemons();
        this.agents = game.getAgents();
        Score= this.updateScore(score);
        int Time=this.updateTime(time);
        this.AreaScore.setText("Score :" + Score);
        this.AreaTime.setText("Time to end :"+Time);
        upateScreenSize();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        if(frame.getWidth()>900) {
            AreaScore.setBounds(0 + frame.getWidth() / 10, 20, 350, 40);
            AreaTime.setBounds(0 + (frame.getWidth() / 10) * 4, 20, 350, 40);
            stop.setBounds(frame.getWidth() - 100, 20, 100, 50);
        }
        The_paint.updateScreenSize(dim.width);
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
    public void FinishWindow(){
        JFrame frame2 = new JFrame(); //creating a new window for the input from the user
        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        label2.setText("Game Over");
        label.setText("Your score is: " + this.Score);
        label.setForeground(Color.BLUE);
        label.setFont(new Font("MV Boli",Font.PLAIN,40));
        label2.setForeground(Color.BLUE);
        label2.setFont(new Font("MV Boli",Font.PLAIN,40));
        label.setBounds(10,50,400,50);
        label2.setBounds(10,5,300,50);
        frame2.add(label2);
        frame2.add(label);
        frame2.setSize(450,150);
        frame2.setLayout(null);
        frame2.setVisible(true);
        //frame2.pack();
    }
}