import java.awt.geom.Line2D;
import java.awt.geom.Ellipse2D;

public class Problem3 {
    static double[] coordLine = {3, 12, 17, 31};
    static double[] coordEllipse = {4, 13, 60, 25};
    static Line2D Line;
    static Ellipse2D Ellipse;
    public static void main(String[] args){
        Problem3 newProblem = new Problem3();
        newProblem.makeLine();
        System.out.println("(3, 12) to the point (17, 31)\n" + Line.getP1() + Line.getP2());
        newProblem.changeLineEndPoint(19, 13);
        System.out.println("\n(3, 12) to the point (19, 13)\n" + Line.getP1() + Line.getP2());
        newProblem.makeEllipse();
        System.out.println("\n(25, 60) to the point (4, 13)\n" + Ellipse.getBounds2D());
    }

    public void makeLine() {
        Line = new Line2D.Double(coordLine[0], coordLine[1], coordLine[2], coordLine[3]);
        System.out.println("This is the Line Object: " + Line);
    }
    public void changeLineEndPoint(int x2, int y2){
        Line.setLine(coordLine[0], coordLine[1], x2, y2);
    }

    public void makeEllipse(){
        Ellipse = new Ellipse2D.Double();
        Ellipse = new Ellipse2D.Double(coordEllipse[0], coordEllipse[1], coordEllipse[2], coordEllipse[3]);
    }
}
