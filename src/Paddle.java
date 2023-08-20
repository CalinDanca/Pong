import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Paddle{
    ArrayList<Integer> moveDirection = new ArrayList<>();
    int x;
    int y;
    int Player;
    Paddle(int Player, int x, int y){
        this.Player = Player;
        this.x = x;
        this.y = (int)((y*0.5) - 50);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(Player ==1){
            if (key == KeyEvent.VK_W) {
                System.out.println(key);
                AddOrRemoveDirection(key , 1);
            }
            if (key == KeyEvent.VK_S) {
                AddOrRemoveDirection(key , 1);
            }
        }
        else{
            if (key == KeyEvent.VK_UP) {
                AddOrRemoveDirection(key , 1);
            }
            if (key == KeyEvent.VK_DOWN) {
                AddOrRemoveDirection(key , 1);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if(Player ==1){
            if (key == KeyEvent.VK_W) {
                AddOrRemoveDirection(key , 2);
            }
            if (key == KeyEvent.VK_S) {
                AddOrRemoveDirection(key , 2);
            }
        }
        else{
            if (key == KeyEvent.VK_UP) {
                AddOrRemoveDirection(key , 2);
            }
            if (key == KeyEvent.VK_DOWN) {
                AddOrRemoveDirection(key , 2);
            }
        }
    }

    public void draw(Graphics g)
    {
        // adding specifications
        if(Player ==1){ g.setColor(Color.red);}
        else{g.setColor(Color.blue);}
        g.fillRect(x, y, 20, 100);
    }
    public void AddOrRemoveDirection(int key, int option){
        //option 1 = add
        //option 2 = remove
        boolean check = false;
        for (int i = 0; i < moveDirection.size(); i++) {
            if (moveDirection.get(i) == key) {
                //removes the key from arraylist
                if(option ==2){
                    moveDirection.remove(i);
                }
                else {
                    check = true;
                }
                break;
            }
        }
        //adds key to arraylist if not in it already
        if(option == 1 && !check){
            moveDirection.add(key);
        }
    }

    //moves the paddles up and down depending on the keys in moveDirection arraylist
    public void move(){
        for(int key:moveDirection){
            if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP){
                y = y -5;
            }
            else{
                y = y +5;
            }
        }
    }

}
