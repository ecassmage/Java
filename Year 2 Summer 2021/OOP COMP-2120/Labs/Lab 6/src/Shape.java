public abstract class Shape implements Comparable<Shape>{

    private String name;

    public Shape(){
        this.name = "General Shape";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double area();

    @Override
    public int compareTo(Shape o) {
        if (this.area() < o.area())
            return -1;
        if (this.area() > o.area())
            return 1;
        return 0;

    }

    public double round(double num, int roundNum){ // I dislike printing really long doubles as it just shoves a bunch of mostly useless information in your face making it harder to read.
        int j = 1;
        for (int i = 0; i < roundNum; i++) j *= 10;
        return ((double) Math.round(num * j)) / j;
    }

    @Override
    public String toString(){  // Pointless but meh, Only useful if new shape is added without override of its own.
        return "Shape = " + name + ", Area = " + round(area(), 3);
    }
}
