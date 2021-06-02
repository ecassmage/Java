public class Problem2 {
    private double x = -3.5;
    private double y = 1.9;
    private int n = 23;
    private int m = 14;

    public static void main(String[] args){
        Problem2 Program = new Problem2();
        Program.equationA();
        Program.equationB();
        Program.equationC();
        Program.equationD();
        Program.equationE();
        Program.equationF();
        Program.equationG();
        Program.equationH();
    }
    public static void runProgram(){
        System.out.println("\nThis is Problem2.java");
        Problem2 Program = new Problem2();
        Program.equationA();
        Program.equationB();
        Program.equationC();
        Program.equationD();
        Program.equationE();
        Program.equationF();
        Program.equationG();
        Program.equationH();
    }
    public void equationA(){System.out.println("Equation A = " + (x - n / y + x + (n * y)));}
    public void equationB(){System.out.println("Equation B = " + (n / m + n % m));}
    public void equationC(){System.out.println("Equation C = " + (n % 2 + m % 3));}
    public void equationD(){System.out.println("Equation D = " + ((m + n) / 3.0));}
    public void equationE(){System.out.println("Equation E = " + ((n - m) / 3));}
    public void equationF(){System.out.println("Equation F = " + ((n - x) / 3));}
    public void equationG(){System.out.println("Equation G = " + (1 - (1 - (1 - n))));}
    public void equationH(){System.out.println("Equation H = " + (m % 10 + (m - (n % 10))));}
}
