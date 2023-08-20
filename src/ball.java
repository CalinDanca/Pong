import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class ball {
    int x;
    int x_Change;
    int y;
    int y_Change;
    Random rand = new Random();
    ball(int x, int y){
        this.x = x;
        this.x_Change = rand.nextInt(2);
        if(x_Change <1){ x_Change = -1;}
        this.y = y;
        this.y_Change = rand.nextInt(2);
        if(y_Change <1){ y_Change = -1;}
    }
    public void draw(Graphics g)
    {
        // adding specifications
        g.setColor(Color.WHITE);
        g.fillOval(x, y, 20, 20);
    }
    public void move(){
    x = x + 4*x_Change;
    y = y + 4*y_Change;
    }

}
