import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class CanvasDemo {
    private MyCanvas canvas = new MyCanvas();
    public static void main(String[] args){
        CanvasDemo fr = new CanvasDemo();
        for (int i = 0; i < 100; i++){
            fr.canvas.actionPerformer();
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception InterruptedException){}

        }
    }

    public CanvasDemo(){
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(400, 400);
        frame.setTitle("Canvas Demo");
        frame.add("Center", canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
//        canvas.actionPerformed();
    }

    private class MyCanvas extends Canvas {
        int x = 20, y = 20;
        public void paint(Graphics g){
            g.drawOval(x, y, 325, 325);
        }

        public void actionPerformer() {
            x++;
            y++;
            repaint();
        }
    }
}
