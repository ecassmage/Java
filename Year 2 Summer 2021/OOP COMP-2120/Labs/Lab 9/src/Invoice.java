import java.util.ArrayList;

public class Invoice {
    // I  have no clue What I am supposed to do here. The Activity makes no sense to me what so ever.
    private String InVoice;
    private String Address;  // I got no clue what this address is meant to hold
    private ArrayList<LineItem> lines;
    private int leftSide;   // Just a formatting quality of life thingy.
    private int Quantity;   // Holds Important Numbers
    private double Price;   // Holds Important Numbers
    public boolean inStock; // Holds Important Numbers

    public static void main(String[] args){
        Invoice I = new Invoice("This Is Censored", "324 Address I don't know the meaning of Lane");
        I.newLineItem("Money", 57, 10.13, "This is Money, It Buys you Stuff");
        System.out.println(I);
    }
    public Invoice(String InVoice, String Address, String Product, int Quantity, double Price, String Description){
        this(InVoice, Address);
        newLineItem(Product, Quantity, Price, Description);
        this.Quantity = Quantity;
        this.Price = Price;
    }
    public Invoice(String InVoice, String Address){
        // I have no Clue what I am doing so I am just going to try to emulate an example invoice format I found online.
        // So Literally All of this could be just the complete opposite of what I am actually being asked to do.
        this.InVoice = InVoice;  // I dunno, the Name of the Invoice or Something
        this.Address = Address;  // I dunno, the Name of the Invoice or Something
        this.lines = new ArrayList<>();
        this.leftSide = "Address".length() + 1;
        this.Quantity = 0;
        this.Price = 0;
    }


    public void InsertNewLineItem(int index, LineItem newItem){
        if (index == -1) lines.add(lines.size(), newItem);
        else lines.add(index, newItem);
        if (newItem.getLeftSide().length() > leftSide) this.leftSide = newItem.getLeftSide().length();
    }
    public void InsertNewLineItem(int index, String Product, int Quantity, double Price, String Description){
        InsertNewLineItem(index, new LineItem("Product", Product, Description));
        InsertNewLineItem(index, new LineItem("Quantity", Quantity, ""));
        InsertNewLineItem(index, new LineItem("Unit Price", "$" + Price, ""));
        this.Quantity = Quantity;
        this.inStock = isInStock();
        this.Price = Price;
        newLineItem("Total", "$" + amountDue());  // I don't know.
    }

    public double amountDue(){
        return ((double) Math.round(Price * Quantity * 100)) / 100;  // I have no Idea what I am doing and am very likely checking the wrong thing, I am so Confused.
    }

    public boolean isInStock(){return Quantity > 0;}
    public void newLineItem(String Product, int Quantity, double Price, String Description){ InsertNewLineItem(-1, Product, Quantity, Price, Description); }  // This is the Main One

    // These are for extra LineItems that you can add.
    public void newLineItem(LineItem newItem){ this.InsertNewLineItem(-1, newItem); }
    public void newLineItem(String LeftSide, Object RightSideDescriptor, String Description){ InsertNewLineItem(-1, new LineItem(LeftSide, RightSideDescriptor, Description)); }
    public void newLineItem(String LeftSide, Object RightSideDescriptor){ InsertNewLineItem(-1, new LineItem(LeftSide, RightSideDescriptor, "")); }

    public String toString(){
        // This is the Invoice Formatter. Formatting this specific Invoice.
        if (Quantity == 0)  return "Out Of Stock";
        String str = "";
        str = str.concat("Invoice: ");
        for (int i = 0; i < (leftSide - ((InVoice).length() / 2)) - "Invoice: ".length(); i++)   str = str.concat(" ");

        str = str.concat("<" + InVoice + ">\nAddress");  // There is no point to the space, I just like it.

        for (int i = 0; i < leftSide - "Address".length(); i++)         str = str.concat(" ");

        str = str.concat(" |   " + Address + '\n');

        for (LineItem line: lines){
            str = str.concat("" + line.getLeftSide());
            for (int i = 0; i < leftSide - line.getLeftSide().length(); i++){
                str = str.concat(" ");
            }
            str = str.concat(" |   " + line.getRightSide() + " " + line.getDescription() + "\n");
        }

        return str;
    }
}
