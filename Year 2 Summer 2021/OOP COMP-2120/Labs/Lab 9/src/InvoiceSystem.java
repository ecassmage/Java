import java.util.ArrayList;

public class InvoiceSystem {
    public static void main(String[] args){
        InvoiceSystem IS = new InvoiceSystem();
        /*1*/ IS.addNewInvoice(new Invoice("Food", "Hello Money 123", "ShellFish", 100, 12.45, "Food To Eat"));// Not Out Of Stock
        /*2*/ IS.addNewInvoice("Carpentry", "123 Carpentry Boulevard", "Wood", 0, 55.99, "Wood to Build Stuff With");  // Out Of Stock
        /*3*/ IS.addNewInvoice("Computer Exploding", "99456 Crazy Avenue", "Computer Explosives", 1066, 14.10, "Definitely not normal explosives");  // Not Out Of Stock
        System.out.println(IS); // Only 1 and 3 appear since 2 has no quantity remaining as asked.
    }

    private ArrayList<Invoice> invoices;

    public InvoiceSystem(){ this(new Invoice[0]); }
    public InvoiceSystem(Invoice voiceOfTheMasses){ this(new Invoice[]{voiceOfTheMasses}); }
    public InvoiceSystem(ArrayList<Invoice> list){ this(list.toArray(new Invoice[list.size() + 1])); }
    public InvoiceSystem(Invoice[] list){
        this.invoices = new ArrayList<Invoice>();
        for (Invoice voice: list) invoices.add(voice);
    }

    public void addNewInvoice(Invoice voice){
        invoices.add(voice);
    }
    public void addNewInvoice(String InvoiceName, String Address, String Product, int Quantity, double Price, String Description){
        addNewInvoice(new Invoice(InvoiceName, Address, Product, Quantity, Price, Description));
    }

    public String toString(){
        String str = "";
        for (Invoice voice: invoices) {
            if (voice.inStock) {
                str = str.concat(voice.toString());
                str = str.concat("\n");
            }
        }
        return str;
    }
}
