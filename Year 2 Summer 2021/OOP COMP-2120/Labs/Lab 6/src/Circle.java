public class Circle extends Shape {

    private double radius;

    public Circle(double radius){
        this.setName("Circle");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }

    public String toString(){
        return "Shape = " + getName() + ", Area = " + round(area(), 3) + ", Radius = " + round(radius, 3);
    }
}
