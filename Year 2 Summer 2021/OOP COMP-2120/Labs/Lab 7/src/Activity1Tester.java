public class Activity1Tester {

    public static void main(String[] args){
        Invoice I = new Invoice(100, 19.2, 13);
        Employee E = new Employee(40, 150.47);
        System.out.println("Invoices getPaymentAmount(" + I.getPaymentAmount() + ") Made From " + I.getNumberOfProduct() + " * " + I.getUnitPrice() + " * " + I.getTax() + "%");
        System.out.println("Employees getPaymentAmount(" + E.getPaymentAmount() + ") Made From " + E.getWorkingHours() + " * " + E.getHourlyRate());
    }
}
