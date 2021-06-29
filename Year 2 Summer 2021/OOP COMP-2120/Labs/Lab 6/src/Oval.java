public class Oval extends Shape {

    private double[] radius;

    public Oval(double radiusWidth, double radiusHeight){
        this.setName("Oval");
        this.radius = new double[]{radiusWidth, radiusHeight};
    }

    public double[] getRadius() { return radius; }
    public double getRadiusHeight() { return radius[0]; }
    public double getRadiusWidth() { return radius[1]; }

    @Override
    public double area() { return Math.PI * this.radius[0] * this.radius[1]; }

    public String toString(){
        return "Shape = " + getName() + ", Area = " + round(area(), 3) + ", Radius Width = " + round(radius[0], 3) + ", Radius Height = " + round(radius[1], 3);
    }

}
