import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.Arrays;

public class Panel extends JPanel implements Runnable{
    Thread gamethread;
    public static int width = 1000;
    public static int height;
    //index 0 is score for player 1, index 1 is score for player 2
    public static int[] score = {0,0};
    Paddle Player1;
    Paddle Player2;
    ball new_ball;
    Panel(){
        //16:9 screen ratio == 9/16 == 0.5625
        height = (int)(width* 0.5625);
        this.setPreferredSize(new Dimension(width, height));
        Player1 = new Paddle(1, 20, height);
        Player2 = new Paddle(2, width-40, height);
        new_ball =new ball((int)(width * 0.5), (int)(height*0.5));
        gamethread = new Thread(this);
        gamethread.start();
    }


    public void paint(Graphics g){
        Image image = createImage(getWidth(),getHeight());

        Graphics graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }
    public void draw(Graphics g) {
        Player1.draw(g);
        Player2.draw(g);
        new_ball.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("name",Font.BOLD, 36));
        g.drawLine((int)(width*0.5), 0, (int)(width*0.5), height);
        g.drawString(String.valueOf(score[0]),(int)(width *0.5 - 50), 50);
        g.drawString(String.valueOf(score[1]),(int)(width *0.5 + 30), 50);
    }
    public void run() {
        long lastTime = System.nanoTime();
        double fpsLimit =60.0;
        //nanoseconds in each frame
        //60 frames as most monitors 60hz
        double nsPerFrame = 1000000000.0 / fpsLimit;
        double FrameCounter = 0;
        while(true){
            long NewTime = System.nanoTime();
            FrameCounter += (NewTime -lastTime)/nsPerFrame;
            lastTime = NewTime;
            if(FrameCounter >=1) {
                move();
                CheckCollision();
                repaint();
                FrameCounter--;
                if (score[0] == 10 || score[1] == 10) {
                    break;
                }
            }
        }
    }
    public void CheckCollision(){
        //check ball bouncing off of walls
        if(new_ball.y<=20){
            new_ball.y_Change = new_ball.y_Change * (-1);
        }
        if(new_ball.y>=Panel.height-20){
            new_ball.y = Panel.height-20;
            new_ball.y_Change = new_ball.y_Change * (-1);
        }
        //check ball scoring point
        if(new_ball.x<=10){
            score[0] = score[0]+1;
            Player1 = new Paddle(1, 20, height);
            Player2 = new Paddle(2, width-40, height);
            new_ball =new ball((int)(width * 0.5), (int)(height*0.5));
        }
        if(new_ball.x>=width-10){
            score[1] = score[1]+1;
            Player1 = new Paddle(1, 20, height);
            Player2 = new Paddle(2, width-40, height);
            new_ball =new ball((int)(width * 0.5), (int)(height*0.5));
        }
        //check ball bouncing off of paddle
        if(   ((new_ball.x+10) >=20&&((new_ball.x+10) <= 40)) && (((new_ball.y+10)>= Player1.y) && ((new_ball.y-10)<= Player1.y+100))  ){
        new_ball.x_Change = new_ball.x_Change * (-1);
        }

        if(   ((new_ball.x+10) >=width-40 &&((new_ball.x+10) <= width-20)) && (((new_ball.y+10)>= Player2.y) && ((new_ball.y-10)<= Player2.y+100))  ){
            new_ball.x_Change = new_ball.x_Change * (-1);
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Paddle collision top and bottom of screen

        if(Player1.y <=0 ){
            Player1.y =0;
        }
        if(Player1.y >=height-100){
            Player1.y =height-100;
        }
        if(Player2.y <=0 ){
            Player2.y =0;
        }
        if(Player2.y>=height-100 ){
            Player2.y =height-100;
        }
    }

    public void move(){
        Player1.move();
        Player2.move();
        new_ball.move();
    }
}


