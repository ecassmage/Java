public class LineItem {
    private String leftSideDescriptor;
    private String RightSideDescriptor;
    private String Description;

    public static void main(String[] args){
        LineItem L = new LineItem("", "", "");
    }

    public LineItem(String LeftSide, Object RightSideDescriptor, String Description){
        this.leftSideDescriptor = LeftSide;
        setGoodInfo(RightSideDescriptor);
        this.Description = Description.compareTo("") == 0 ? "" : "(" + Description + ")";
    }
    public String getLeftSide()     { return leftSideDescriptor; }
    public String getRightSide()    { return RightSideDescriptor; }
    public String getDescription()  { return Description; }

    public String toString(){
        return leftSideDescriptor + "\t" + RightSideDescriptor + " " + Description;
    }

    public void setDescription(String newDescription){
        this.Description = newDescription;
    }
    public <T> void setGoodInfo(Object newVal){
        if (newVal instanceof String)          this.RightSideDescriptor = newVal.toString();
        else if (newVal instanceof Integer)    this.RightSideDescriptor = Integer.toString((int) newVal);
        else if (newVal instanceof Double)     this.RightSideDescriptor = Double.toString((double) newVal);
        else{
            System.out.println("RightSideDescriptor Does not Accept " + newVal.getClass());
            System.exit(0);
        }
    }
}
