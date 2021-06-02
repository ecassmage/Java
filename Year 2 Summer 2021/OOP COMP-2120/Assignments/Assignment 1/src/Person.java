public class Person {
    private byte age;
    private double[] walkDistance;

    private boolean hungry;
    private boolean sleepy;

    private int CurrentActivity; // -1 Idle, 0 sleeping, 1 eating, 2 walking // Was going to have eating and walking work but then I read further into the assignment

    private Person friend;

    private boolean advanced;

    public Person(boolean advanced){
        age = 0;
        walkDistance = new double[]{4.0, 4.0};

        hungry = false;
        sleepy = false;

        CurrentActivity = -1;

        friend = null;
        this.advanced = advanced;
    }

    public void talk(String talkWords){
        if (age < 2) System.out.println("<Insert Baby Noises Here>");
        else System.out.println(talkWords);
        stats();
    }

    public void eat(){
        if (hungry) hungry = false;
        else System.out.println("Human is already Full");
        stats();
    }

    public void needFood(){
        hungry = true;
        stats();
    }

    public void walk(double distanceWalked){
        walkDistance[0] -= distanceWalked;
        if (walkDistance[0] < 0) sleepy = true;
        stats();
    }

    public void sleep(){
        if (CurrentActivity != 0) CurrentActivity = 0;
        else System.out.println("Human is Already Sleeping");
        stats();
    }

    public void awake(){
        if (CurrentActivity != 0) System.out.println("Human is not Sleeping");
        else {
            sleepy = false;
            CurrentActivity = -1;
        }
        stats();
    }

    public void grow(){
        age++;
        if (age > 55 && age % 5 == 0) walkDistance[1] /= 2;
        if (walkDistance[0] > walkDistance[1]) walkDistance[0] = walkDistance[1];
    }

    public void getFriend(Person newFriend){
        friend = newFriend;
    }

    public void changeFriend(Person newFriend){
        friend = newFriend;
    }

    private void stats(){
        if (!advanced) return;
        if (hungry) System.out.println("Human is Hungry");
        else System.out.println("Human is not Hungry");
        if (sleepy) System.out.println("Human is Tired");
        else System.out.println("Human is not Tired");
        System.out.println();
    }
}
