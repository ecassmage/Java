public class Queue {
    private Element<?> nextInQueue = null;
    private Element<?> endOfQueue = null;
    private int len = 0;

    public static void main(String[] args){
        Queue Q = new Queue();
        Q.add("String");
        Element<?> temp = Q.nextInQueue;
        //temp.setElement("String");
    }

    public Queue(){}

    public <E> void add(E obj){
        Element<?> temp = new Element<>(obj, endOfQueue);
        if (nextInQueue == null) this.nextInQueue = temp;
        this.endOfQueue = temp;
        len++;
    }

    private static class Element<E>{
        private Element<?> next;
        private E element;

        private Element(E obj, Element<?> next){
            this.next = next;
            this.element = obj;
        }

        public void setNext(Element<?> next){
            this.next = next;
        }
        public void setElement(E element){
            this.element = element;
        }

        public E get(){
            return element;
        }
    }
}
