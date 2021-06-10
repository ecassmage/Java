import javax.swing.*;
import java.awt.*;



public class ComboLock {
    private int[] Code;
    private boolean[] Clicks;
    private int TickCircle;
    private boolean workingLock;
    private String[] ComboLockFace;
    private Canvas canvas = new Canvas();

    public static void main(String[] args){
        ComboLock C = new ComboLock(5, 5, 5);
        C.buildComboLockFace();
    }

    public ComboLock(int secret1, int secret2, int secret3) {
        this.Code = new int[]{secret1, secret2, secret3};
        this.TickCircle = 0;
        checkIfWorkingLock();
    }
    public void reset() {
        TickCircle = 0;
        Clicks = new boolean[]{false, false, false};
    }
    public void turnLeft(int ticks) {

    }
    public void turnRight(int ticks) {

    }
    public boolean open() {
        return false;
    }
    public int showLock() {
        return 0;
    }
    private void checkIfWorkingLock(){
        for (int num: Code){
            if (!(0 <= num && num <= 39)) {
                System.out.println("This Combination Lock does not Work");
                workingLock = false;
            }
            else workingLock = true;
        }
    }

    public void fixLock(int secret1, int secret2, int secret3){
        this.Code = new int[]{secret1, secret2, secret3};
        checkIfWorkingLock();
    }

    private void buildComboLockFace(){
        // This is something I basically learned just now from the internet. Please ignore this when marking as I was just doing this for the fun of it.
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 100));
        panel.setLayout(new GridLayout());
        frame.add(panel, BorderLayout.CENTER);

        ComboLockFace = new String[]{
                "              0",
                "          35      5",
                "         30        10",
                "          25      15",
                "              20"
        };
        for (String Combo: ComboLockFace){
            System.out.println(Combo);
        }
    }
    // arg So much more difficult then python to get working.
    private class Canvas extends java.awt.Canvas {
        private int[] coordinates;
        private int[] circleDimensions = {0, 0, 300, 300};
        private final int[] CanvasDimensions = {17, 40};
        private final int padding = 50;
        private int[] importantPoints;

        public Canvas(){
            JFrame frame = new JFrame();
            frame.setLayout(new BorderLayout());
            frame.setSize(CanvasDimensions[0] + circleDimensions[2] + padding, CanvasDimensions[1] + circleDimensions[3] + padding);
            frame.setTitle("Combination Lock");
            frame.add("Center", this);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            importantPoints = new int[]{(circleDimensions[2] + circleDimensions[0]) / 2 + padding/2, (circleDimensions[2] + circleDimensions[0]) / 2 + padding/2};
            circleDimensions = new int[] {circleDimensions[0] + padding / 2, circleDimensions[1] + padding / 2, 300, 300};
            this.coordinates = new int[]{importantPoints[0], importantPoints[1], 200, 50};

            for (int i = 0; i < 40; i++){
                moveArm(i);
            }
            update();
        }

        public void update(){
            repaint();
        }

        public void moveArm(int num){
            double xx = Math.cos(Math.toRadians(90 - 9*num));
            double yy = Math.sin(Math.toRadians(90 - 9*num));
            System.out.println(num + ": " + xx + " " + yy);
            int y = (int) (Math.cos(Math.toRadians(90 - 9*num)) * (((double) circleDimensions[3] / 2) + (padding/2)));
            int x = (int) (Math.sin(Math.toRadians(90 - 9*num)) * (((double) circleDimensions[3] / 2) + (padding/2)));
            //System.out.println(x + " " + y);
            coordinates[2] = x;
            coordinates[3] = y;
        }

        public void paint(Graphics g){
            CircleObject(g);
            LineObject(g);
        }

        public void CircleObject(Graphics g){
            // 30,,, 30, 30, 340, 360 ,,, 40
            g.drawOval(circleDimensions[0], circleDimensions[1], circleDimensions[2], circleDimensions[2]);
            g.setColor(Color.black);
            g.fillOval(importantPoints[0]-5, importantPoints[1]-5, 10, 10);
            g.drawString("5", 500 - (int) (Math.cos(Math.toRadians(45)) * ((double) circleDimensions[3] / 2)), 30 + (int) (Math.sin(Math.toRadians(45)) * ((double) circleDimensions[3] / 2)));
        }

        public void LineObject(Graphics g){
            g.drawLine(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
            //g.drawLine(coordinates[0], 500, coordinates[0], 0);
            //g.drawLine(0, coordinates[1], 500, coordinates[1]);
        }
    }
}

// 10sin(deg)(x/(10cos(deg)))