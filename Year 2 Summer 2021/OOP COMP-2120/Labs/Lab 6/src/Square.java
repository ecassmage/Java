public class Square extends Shape {

    private double side;

    public Square(double side){
        this.setName("Square");
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }

    @Override
    public String toString(){
        return "Shape = " + getName() + ", Area = " + round(area(), 3) + ", Sides = " + round(side, 3);
    }
}
