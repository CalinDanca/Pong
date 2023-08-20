import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class gameframe extends JFrame{
    gameframe(){
        Panel panel = new Panel();
        this.add(panel);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.black);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                System.out.println(key);
                panel.Player1.keyPressed(e);
                panel.Player2.keyPressed(e);
            }
            public void keyReleased(KeyEvent e) {
                panel. Player1.keyReleased(e);
                panel. Player2.keyReleased(e);
            }
        });

    }
}
