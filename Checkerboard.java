/*
 * Lab activity #2 - Checkerboard
 * By Austin Ellsworth
 */
import java.awt.*;
import javax.swing.*;

public class Checkerboard extends JPanel {

    public static void main(String args[]){
        JFrame f = new JFrame("Checkerboard");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Checkerboard ());
        f.pack();
        f.setVisible(true);
    }

    public Checkerboard(){
        setPreferredSize(new Dimension(400,400));    
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Draws a black rectangle from (0,0) to (50,50)
        // Remember that (0,0) is in the upper-left of the screen.
        int position = 0;
        for (int j = 1; j <= 8; j++){	
            position++;
            for (int i = 1; i <= 8; i++) {
                position++;
                if (position %  2 != 0 ) g.setColor(Color.black);
                else g.setColor(Color.red);
                g.fillRect(((i-1)*50), ((j-1)*50), (i*50), (j*50));
            }
        }
    }
}
