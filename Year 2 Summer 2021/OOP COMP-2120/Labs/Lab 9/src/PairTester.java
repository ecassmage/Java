import java.util.ArrayList;

public class PairTester {
    public static void main(String[] args){
        Pair<String, Integer> SI = new Pair<>("String Here", 100);
        Pair<Boolean, Double> BD = new Pair<>(true, 123.0);
        Pair<String, Double> SD = new Pair<>("String Here", 110.0);
        Pair<String, Integer> SICopy = new Pair<>("This is New", 100);
        System.out.println(SI);
        SI.setObjectOne("This is New");
        System.out.println(SI);
        System.out.println(BD);
        BD.setObjectTwo(1454.1);
        System.out.println(BD);
        System.out.println(SD.getObjectOne());
        System.out.println(SD.getObjectTwo());
        System.out.println(SI.equals(SICopy));
        System.out.println(SI.equals(BD));
        System.out.println(SI.equals(BD));
        System.out.println(SICopy.toString());

        ArrayList<String> Sesquipedalian = new ArrayList<>();
        Sesquipedalian.add("Polysyllable");
        Sesquipedalian.add("Polysyllabic");
        Sesquipedalian.add("Long");
        Sesquipedalian.add("Polysyllabic word");
        Sesquipedalian.add("Sesquipedalia");
        Sesquipedalian.sort(null);
        ArrayList<String> Facetiously = new ArrayList<>();
        Facetiously.add("Amusingly");
        Facetiously.add("Ironically");
        Facetiously.add("Ludicrously");
        Facetiously.add("Playfully");
        Facetiously.add("Jokingly");
        Facetiously.add("Jocosely");
        Facetiously.add("Merrily");
        Facetiously.add("Ridiculously");
        Facetiously.add("Absurdly");
        Facetiously.add("Jovially");
        Facetiously.add("Mirthfully");
        Facetiously.add("Satirically");
        Facetiously.sort(null);
        ArrayList<Pair<String, ArrayList<String>>> P = new ArrayList<>();
        P.add(new Pair<String, ArrayList<String>>("Sesquipedalian", Sesquipedalian));
        P.add(new Pair<String, ArrayList<String>>("Facetiously", Facetiously));
        System.out.println(P);
    }
}
