public class Box<E> {


    public static void main(String[] args){
        Box<String> box = new Box<>();
        box.insert("blue Box");

    }
    private E data;
    public Box() {}
    public void insert(E value) { this.data = value; }
    public E getData(){ return data; }

}
