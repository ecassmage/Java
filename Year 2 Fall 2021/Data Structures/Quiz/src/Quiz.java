public class Quiz {

    public static void main(String[] args){
        f(new int[]{1,3,6}, new int[] {2,3,4,5}, new int[1000]);
    }

    public static <K> void f(int[] S1, int[] S2, int[] S) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if ( j == S2.length || (i < S1.length && S1[i]< S2[j])) S[i+j] = S1[i++];
            else  S[i+j] = S2[j++];
        }
    }
}
