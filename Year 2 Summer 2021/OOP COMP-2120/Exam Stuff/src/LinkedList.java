/**
 * Why Combine these two, Dunno, just felt like it. The Point of these Classes though is to add the ability to have Data Structures able to hold more then just their assigned generic objects.
 */
public class LinkedList {
    private Element<?> first = null;  // To Keep reference of the beginning of the linked list
    private Element<?> Current = null;  // If you want to traverse the list and keep position known without tracing the steps taken to get there.
    private Element<?> End = null;
    private int len = 0;
    private int numOfLinks;
    private boolean circularLink;
    public static void main(String[] args){
        LinkedList LL = new LinkedList(2, false);
        String obj = "String";
        List L = new List();
        LL.add("String");
        LL.add("Two");
        LL.add(3);
        LL.add(4);
        LL.add(L);
        LL.add(2.4);
        LL.add(true);
        System.out.println(LL);
        System.out.println(LL.len);
        LL.pop(L);
        System.out.println(LL);
        System.out.println(LL.len);
        LL.pop(obj);
        System.out.println(LL.len);
        System.out.println(LL);
        System.out.println("Cunt");
    }

    public LinkedList(boolean doublyLinked, boolean CircularLink){
        this((doublyLinked) ? 2 : 1, CircularLink);  // Hopefully an internal true or false changer for this().
    }
    public LinkedList(boolean doublyLinked){
        this(doublyLinked, false);  // Hopefully an internal true or false changer for this().
    }
    public LinkedList(){
        this(1, false);
    }
    public LinkedList(int NumOfLink, boolean CircularLink){
        if (NumOfLink != 1 && NumOfLink != 2) {
            System.out.println(NumOfLink + " is not a supported number of links, please choose either 1 or 2 instead");
            System.exit(0);
        }
        this.numOfLinks = NumOfLink;
        this.circularLink = CircularLink;
    }

    public <E> void add(E obj){
        add(obj, End);
    }
    public <E> void add(E obj, Element<?> after){
        if (after == null) {
            if (isEmpty()){
                first = new Element<>(obj, numOfLinks);
                Current = first;
                End = first;
            }
        } else  after.insertAfter(new Element<>(obj, numOfLinks));
        if (circularLink) {
            End.setNext(first);
            if (numOfLinks > 1) first.setPrev(End);
        }
        len++;

        if (after == End) End = End.next();
    }

    public void pop(){
        pop(Current);
    }
    public void pop(Element<?> ptr){
        Element<?> next = ptr.next();
        if (numOfLinks == 1){
            Element<?> ptrMover = first;
            // ptrMover.getNext() != first is to catch a loop
            forElseLoop:{
                if (ptr == first) break forElseLoop;
                for (int i = 0; i < len; i++){
                    if (ptrMover.getNext() == ptr) break forElseLoop;
                    if (ptrMover.getNext() == null) return;
                    ptrMover = ptrMover.getNext();
                }
                return;
            }
            if (ptr == End) End = ptrMover;
            ptrMover.links[0] = ptr.links[0];
        }
        else{
            ptr.removeExistence();
            if (ptr == End) End = ptr.prev();
        }
        len--;
        if (ptr == first) first = next;
        if (ptr == Current) Current = next;
    }

    public void pop(int index){
        switch(index){
            case -2:
                pop(End);
                break;
            case -1:
                pop(first);
                break;
            default:
                next(index);
                pop(Current);
                break;
        }
    }
    public <E> void pop(E obj){
        Element<?> ptr = first;
        boolean truth;
        while(ptr != null && ptr.get() != obj && ptr.getNext() != first) {
            truth = obj.equals(ptr.get());
            ptr = ptr.getNext();

        }
        if (ptr == null) {
            System.out.println("Value Error: " + obj + " was not located");
            System.exit(0);
        }
        pop(ptr);
    }


    public boolean isEmpty(){
        return first == null && Current == null && End == null;  // Only first really needs to be checked since if it is null everything else will be as well
    }

    public void next(){
        next(1);
    }
    public void next(int nextIterations){
        for(int i = 0; i < nextIterations; i++){
            Current = Current.getNext();
        }
    }

    public void prev(){
        prev(1);
    }
    public void prev(int prevIterations){
        for(int i = 0; i < prevIterations; i++){
            Current = Current.getPrev();
        }
    }

    public Element<?> getNextPtr(){
        return Current.getNext();
    }
    public Element<?> getPrevPtr(){
        return Current.getPrev();
    }
    public void setNextPtr(Element<?> next){
        Current.links[0] = next;
    }
    public void setPrevPtr(Element<?> prev){
        Current.links[1] = prev;
    }

    @SuppressWarnings("unchecked")
    public <E> E getNext(){
        return (E) Current.getNext().get();
    }
    @SuppressWarnings("unchecked")
    public <E> E getPrev(){
        return (E) Current.getPrev().get();
    }
    public <E> void setNext(E next){
        Element<?> Replacement = new Element<>(next, numOfLinks);
        for (int i = 0; i < numOfLinks; i++){
            Replacement.links[i] = Current.getNext().links[i];
        }
        Current.links[0] = Replacement;
    }
    public <E> void setPrev(E prev){
        Element<?> Replacement = new Element<>(prev, numOfLinks);
        for (int i = 0; i < numOfLinks; i++){
            Replacement.links[i] = Current.getPrev().links[i];
        }
        Current.links[1] = Replacement;
    }

    public String toString(){
        //return "";
        Element<?> ptr = circularLink ? Current : first;
        String str = "";
        for(int i = 0; i < len; i++){
            if (i != 0) {
                if (numOfLinks == 2)    str = str.concat(" <-> ");
                if (numOfLinks == 1)    str = str.concat(" -> ");
            }
            if (ptr == null) {
                System.out.println(str);
                System.exit(0);
            }
            str = str.concat(ptr.get().toString());
            ptr = ptr.next();
        }
        return str;
    }

    private static class Element<E>{
        private Element<?>[] links;
        private int numOfLinks;
        private E element;

        public Element(E obj, int num){
            this.links = new Element<?>[num];
            this.numOfLinks = links.length;
            this.element = obj;
        }

        public void insertNext(Element<?> next){
            next.links[0] = links[0];
            links[0] = next;
        }
        public void insertPrev(Element<?> prev){
            if (numOfLinks < 2) {
                System.out.println("This Linked List Does not Contain a pointer to the previous Element in the linked list");
                System.exit(1);
            }
            prev.links[1] = links[1];
            links[1] = prev;
        }

        public void insertAfter(Element<?> next){
            next.setNext(this.getNext());
            this.setNext(next);
            if (numOfLinks > 1) next.setPrev(this);
        }


        public Element<?> next(){
            return getNext();
        }  // Just Different Names is All
        public Element<?> prev(){
            return getPrev();
        }// Just Different Names is All
        public Element<?> getNext(){// Just Different Names is All
            return links[0];
        }
        public Element<?> getPrev(){// Just Different Names is All
            return links[1];
        }

        public E get(){
            return element;
        }

        public void setNext(Element<?> next){
            links[0] = next;
        }
        public void setPrev(Element<?> prev){
            links[1] = prev;
        }
        private void removeExistence(){
            Element<?> prev = links[1];
            links[1] = links[0];
            links[0] = prev;
        }
    }
}
