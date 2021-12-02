public class Invoice implements Payable{
    private int numberOfProduct;
    private double unitPrice;
    private double tax;

    public Invoice(){ this(0, 0); }
    public Invoice(int numberOfProduct, double unitPrice){ this(numberOfProduct, unitPrice, 13); }
    public Invoice(int numberOfProduct, double unitPrice, double taxPercent){
        this.numberOfProduct = numberOfProduct;
        this.unitPrice = unitPrice;
        this.tax = taxPercent;
    }

    public double getPaymentAmount(){
        return numberOfProduct * unitPrice * (1 + tax / 100);
    }


    public void setNumberOfProduct(int products){numberOfProduct = products;}
    public void setUnitPrice(double price){unitPrice = price;}
    public void setTax(double tax){this.tax = tax;}

    public int getNumberOfProduct() {return numberOfProduct;}
    public double getUnitPrice() {return unitPrice;}
    public double getTax() {return tax;}
}
