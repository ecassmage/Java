import java.awt.Point;

public class Robot {

    /**
     Tests the methods of the Robot class.
     @param args not used
     */
    private Point pnt;
    private int dir;
    public static void main(String[] args){
        // My Assumption (+east/-west, +south/-north) Going off of I guess coordinates of Computer.
    }

    public Robot(Point point, int dir){
        pnt = point;
        this.dir = dir;
    }

    public void turnLeft(){
        if (dir == 0) dir = 3;
        else dir--;
    }
    public void turnRight(){
        if (dir == 3) dir = 0;
        else dir++;
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
    }
    public Point getLocation(){
        return pnt;
    }
    public String getDirection(){
        String[] DIR = {"N", "E", "S", "W"};
        return DIR[dir];
    }
}
