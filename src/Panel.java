import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Panel extends JPanel implements Runnable{
    Thread t = new Thread();
    Panel(){
        Paddle Player1 = new Paddle(1, 10);
        Paddle Player2 = new Paddle(2, 40);
    }

    public void run() {

    }
    //16:9 screen ratio
}
