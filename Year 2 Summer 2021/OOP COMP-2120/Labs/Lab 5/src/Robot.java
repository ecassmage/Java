import java.awt.Point;
import java.util.ArrayList;

public class Robot {

    /**
     Tests the methods of the Robot class.
     @param args not used
     */
    private Point pnt;
    private int dir;
    private ArrayList<String> WeHoldStuff;
    public static void main(String[] args){
        // My Assumption (+east/-west, +south/-north) Going off of I guess coordinates of Computer.
        Robot robot = new Robot(new Point(5, 5), 1);
        robot.move(); // 6, 5, 1
        robot.turnRight(); // 6, 5, 2
        robot.move(); // 6, 6, 2
        robot.move(); // 6, 7, 2
        robot.turnRight(); // 6, 7, 3
        robot.move(); // 5, 7, 3
        robot.move(); // 4, 7, 3
        robot.turnLeft(); // 4, 7, 2
        robot.move(); // 4, 8, 2
        Point location = robot.getLocation();
        System.out.println("Location: " + location.x + ", " + location.y);
        System.out.println("Expected: 4, 8");
        System.out.println("Direction: " + robot.getDirection());
        System.out.println("Expected: S");
        robot.printHistory();
    }

    public Robot(Point point, int dir){
        pnt = point;
        this.dir = dir;
        this.WeHoldStuff = new ArrayList<>();
    }

    public void turnLeft(){
        if (dir == 0) dir = 3;
        else dir--;
        update();
    }
    public void turnRight(){
        if (dir == 3) dir = 0;
        else dir++;
        update();
    }
    public void move(){
        switch(dir){
            case 0:
                pnt.setLocation(pnt.getX(), pnt.getY()-1);
                break;
            case 1:
                pnt.setLocation(pnt.getX()+1, pnt.getY());
                break;
            case 2:
                pnt.setLocation(pnt.getX(), pnt.getY()+1);
                break;
            case 3:
                pnt.setLocation(pnt.getX()-1, pnt.getY());
                break;
        }
        update();
    }

    private void update(){
        WeHoldStuff.add("(" + Math.round(pnt.getX()) + ", " + Math.round(pnt.getY()) + "), " + getDirection());
    }

    public void printHistory(){
        for (String str: WeHoldStuff){
            System.out.println(str);
        }
    }
    public Point getLocation(){
        return pnt;
    }
    public String getDirection(){
        String[] DIR = {"N", "E", "S", "W"};
        return DIR[dir];
    }
}
