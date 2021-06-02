import java.awt.Rectangle;


public class ClassSchool {
    public static void printRectangleInfo(Rectangle r, String string){
        System.out.println(string);
        System.out.println("Position: (" + r.getX() + "," + r.getY() + ")");
        System.out.println("Width: " + r.getWidth() + ", Height " + r.getHeight());
        System.out.println("---------------");
    }

    public static void main(String[] args){
        Rectangle NewRectangle = new Rectangle();
        printRectangleInfo(NewRectangle, "Rectangle 1");
        Rectangle Rec2 = new Rectangle();
        Rectangle Rec3 = new Rectangle(Rec2);
        printRectangleInfo(Rec2, "Rectangle 2");
        NewRectangle.setLocation(100, 100);
        printRectangleInfo(NewRectangle, "Rectangle 1");
    }
}
