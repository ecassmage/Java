
/**
 * A2 starter code for 2540, 2020. 
 * Author: Jianguo Lu 
 * The purpose is to understand sorting algorithms and their performances. 
 * It prints out the frequency of the 200-th most frequent word.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.Map.Entry;


public class A2 {
	public static void selectionSort(String[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (data[minIndex].compareTo(data[j]) < 0) {
					minIndex = j;
				}
			}
			if (i != minIndex)
				swap(data, minIndex, i);

		}
	}

	public static void insertionSort(String[] data) {
		int n = data.length;
		for (int k = 1; k < n; k++) {
			String cur = data[k];
			int j = k;
			while (j > 0 && data[j - 1].compareTo(cur) > 0) {
				data[j] = data[j - 1];
				j--;
			}
			data[j] = cur;
		}
	}

	public static Integer messOfStuffBetter(String[] tokens){
		class MAP{
			private NodeLine[] list;
			private int[] inUse;
			int inUsePtr = 0;
			private int size = 0;
			private int Uniques = 0;
			private final double loadFactor = 1;

			public MAP(int capacity){
				this.size = (int) Math.ceil(capacity * loadFactor);
				this.list = new NodeLine[size];
				this.inUse = new int[capacity];
				for (int i = 0; i < size; i++){
					list[i] = new NodeLine();
				}
			}
			public void add(String word){
				long hash = Math.abs(word.hashCode());
				int num = list[(int) (hash % size)].add(word);
				Uniques += num;
				if (list[(int) (hash % size)].list.size() == 1 && num == 1)	{
					inUse[inUsePtr] = ((int) (hash % size)); // This shall make sure to aid in skipping empty index positions.
					inUsePtr++;
				}
			}

			public int[] getList(){
				int[] IntList = new int[Uniques];
				int pos = 0;
				for (int index: inUse){
					if (index == 0)	break;
					pos = list[index].addToList(IntList, pos);
				}
				return IntList;
			}

			class NodeLine{
				private LinkedList<NODE> list;

				public NodeLine(){
					this.list = new LinkedList<>();
				}

				public int add(String word) {
					ListIterator<NODE> tempIterator = list.listIterator();
					while (tempIterator.hasNext()) {
						NODE temp = tempIterator.next();
						if (temp.Word.equals(word)) {
							temp.Num++;
							return 0;
						}
					}
					list.add(new NODE(word, 1));
					return 1;
				}

				public int addToList(int[] AddToList, int pos){
					ListIterator<NODE> tempIterator = list.listIterator();
					while (tempIterator.hasNext()) AddToList[pos++] = tempIterator.next().Num;
					return pos;
				}

				class NODE{
					private final String Word;
					private int Num;

					public NODE(String word, int num){
						this.Word = word;
						this.Num = num;
					}
				}
			}
		}
		MAP map = new MAP(tokens.length);

		for (String token: tokens)	map.add(token);
		int[] list = map.getList();
		Arrays.sort(list);
		int num = -1;
		if (list.length > 200) num = list[list.length - 200];  // Safety Measure or Something for if the length of list is less then 200
		return num;
	}

	public static Integer messOfStuff(String[] tokens){

		class MAP{
			private NodeLine[] list;
			int size = 0;
			int Uniques = 0;
			private final double loadFactor = 1.25;

			public MAP(int capacity){
				this.size = (int) Math.ceil(capacity * loadFactor);
				this.list = new NodeLine[size];
				for (int i = 0; i < size; i++){
					list[i] = new NodeLine();
				}
			}
			public void add(String word){
				long hash = Math.abs(word.hashCode());
				Uniques += list[(int) (hash % size)].add(word);
			}

			public int[] getList(){
				int[] IntList = new int[Uniques];
				int pos = 0;
				for (int i = 0; i < list.length; i++){
					pos = list[i].addToList(IntList, pos);
				}
				return IntList;
			}

			class NodeLine{
				private LinkedList<NODE> list;

				public NodeLine(){
					this.list = new LinkedList<>();
				}

				public int add(String word) {
					ListIterator<NODE> tempIterator = list.listIterator();
					while (tempIterator.hasNext()) {
						NODE temp = tempIterator.next();
						if (temp.Word.equals(word)) {
							temp.Num++;
							return 0;
						}
					}
					list.add(new NODE(word, 1));
					return 1;
				}

				public int addToList(int[] AddToList, int pos){
					ListIterator<NODE> tempIterator = list.listIterator();
					while (tempIterator.hasNext()) AddToList[pos++] = tempIterator.next().Num;
					return pos;
				}

				class NODE{
					private final String Word;
					private int Num;

					public NODE(String word, int num){
						this.Word = word;
						this.Num = num;
					}
				}
			}
		}
		MAP map = new MAP(tokens.length);

		for (String token: tokens)	map.add(token);
		int[] list = map.getList();
		Arrays.sort(list);
		int num = -1;
		if (list.length > 200) num = list[list.length - 200];  // Safety Measure or Something for if the length of list is less then 200
		return num;
	}

	public static Integer messOfStuffSlow(String[] tokens){
		HashMap<String, Integer> map = new HashMap<>();  // This is to cut the size needed to be sorted to size m instead of size n
		// This means nothing on its own but there is also m <= n so m is generally going to be smaller then n so a lets say that m is half of n
		// and n is 100000 using O(nlogn) for both m and n. we have (100000log(100000)) = 1660964 and (50000log(50000)) = 780482 which is more then half the iterations gone
		for (String token: tokens){
			if (map.containsKey(token)) map.put(token, map.get(token) + 1);
			else						map.put(token, 1);
		}
		System.out.println("Size of HashMap Map: " + map.size());
		String[] arr = map.keySet().toArray(new String[0]);
		Arrays.sort(arr);
		int[] arrInt = new int[arr.length];
		for(int i = 0; i < arr.length; i++)	arrInt[i] = map.get(arr[i]);
		Arrays.sort(arrInt);
		int num = -1;
		if (arrInt.length > 200) {
			num = arrInt[arrInt.length - 200];
		}
		//System.out.println("Nums Are: " + freq + " The Other is: " + num);
		return num;
	}
	/** Merge two strings. See the textbook for explanation. **/
	public static void merge(String[] S1, String[] S2, String[] S) {
		int i = 0, j = 0;
		while (i + j < S.length) {
			if (j == S2.length || (i < S1.length && S1[i].compareTo(S2[j]) < 0))
				S[i + j] = S1[i++];
			else
				S[i + j] = S2[j++];
		}
	}

	public static void mergeSort(String[] S) {
		int n = S.length;
		if (n < 2)
			return;
		int mid = n / 2;
		// partition the string into two strings
		String[] S1 = Arrays.copyOfRange(S, 0, mid);
		String[] S2 = Arrays.copyOfRange(S, mid, n);
		mergeSort(S1);
		mergeSort(S2);
		merge(S1, S2, S);
	}

	private static void swap(String[] array, int i, int j) {
		String tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	public static Integer count_ARRAY_SORT(String[] tokens, String sortMethod) {

		if (sortMethod.equals("SELECT"))
			selectionSort(tokens);
		else if (sortMethod.equals("INSERT"))
			insertionSort(tokens);
		else if (sortMethod.equals("MERGE"))
			mergeSort(tokens);
		else if (sortMethod.equals("STUFF"))
			return messOfStuff(tokens);
		else if (sortMethod.equals("STUFF2"))
			return messOfStuffSlow(tokens);
		else if (sortMethod.equals("STUFF3"))
			return messOfStuffBetter(tokens);
		else
			System.out.println(sortMethod + " sorting method does not exist.");

		int CAPACITY = 1000000;
		String[] words = new String[CAPACITY];
		int[] counts = new int[CAPACITY];
		int j = 0, k = 0;
		int len = tokens.length;
		while (j < len - 1) {
			int duplicates = 1;
			while (j < len - 2 & tokens[j].equals(tokens[j + 1])) {
				j++;
				duplicates++;
			}

			words[k] = tokens[j];
			counts[k] = duplicates;
			j++;
			k++;
		}

		String[] copyOfWords=new String[k];
		Integer[] copyOfCounts=new Integer[k];
		
		for (int i=0; i<k; i++) {
			copyOfCounts[i]=counts[i];
		}
			
		Arrays.sort(copyOfCounts);
		
		return copyOfCounts[k-200];
	}

	public static Integer read(String PATH) throws Exception {
		long startTime = System.currentTimeMillis();
		Scanner doc = new Scanner(new File(PATH));
		int size = doc.nextLine().split("[^a-zA-Z]+").length;
		HashMap<String, Integer> map = new HashMap<>();
		doc.close();
		doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		while(doc.hasNext()){
			String Word = doc.next().toLowerCase();
			if (map.containsKey(Word))	map.put(Word, map.get(Word) + 1);
			else 						map.put(Word, 1);
		}
		long done = System.currentTimeMillis();
//		System.out.println(PATH + " \tTime Before Sort: " + (done - startTime));
		ArrayList<Integer> list = new ArrayList<>(map.values());
		list.sort(null);
		doc.close();
//		System.out.println("Time After Sort: " + (System.currentTimeMillis() - startTime) + " Difference: " + (System.currentTimeMillis() - done) + '\n');
		return list.toArray(new Integer[0])[list.size() - 200];
	}

	static String[] readText(String PATH) throws Exception {
		Scanner doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		// tokenize text. any characters other than English letters(a-z and A-Z) are delimiters.
		int length = 0;
		while (doc.hasNext()) {
			doc.next();
			length++;
		}

		String[] tokens = new String[length];
		Scanner s = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		length = 0;
		while (s.hasNext()) {
			tokens[length] = s.next().toLowerCase();
			length++;
		}
		doc.close();
		return tokens;
	}

	static Integer ReadText(String PATH) throws Exception {
		long startTime = System.currentTimeMillis();
		HashMap<String, Integer> map = new HashMap<>();  // So as to significantly reduce the number of elements needed to be sorted.
		// String Builder isn't used in this since stringing everything together is O(n) more complexity then necessary, also O(n) Space Complexity more then necessary in this case
		Scanner br = new Scanner(new FileReader(PATH));
		while(br.hasNext()){
			for (String Word: br.nextLine().toLowerCase().split("[^a-z]+")) { // Regex only deals with a-z since it is set to lower case before it is called so A-Z is irrelevant.
				if (map.containsKey(Word))	map.put(Word, map.get(Word) + 1);
				else 						map.put(Word, 1);
			}
		}
		long done = System.currentTimeMillis();
		System.out.println("Time Before Sort: " + (done - startTime));
		ArrayList<Integer> list = new ArrayList<>(map.values());
		list.sort(null);
		br.close();
		System.out.println("Time After Sort: " + (System.currentTimeMillis() - startTime) + " Difference: " + (System.currentTimeMillis() - done) + '\n');
		return list.toArray(new Integer[0])[list.size() - 200];
	}


	static String [] readTextBAD(String PATH) throws Exception {
		BufferedReader br = new BufferedReader (new FileReader(PATH));
		String text = "";
		String line = "";
		while ((line = br.readLine()) != null)
			text = text + " " + line.trim();
		String tokens[] = text.trim().split("[^a-zA-Z]+");
		return tokens ;
	}

	static String[] readTextGOOD(String PATH) throws Exception {
		BufferedReader br = new BufferedReader (new FileReader(PATH));
		StringBuilder SB = new StringBuilder();
		String line = "";
		while ((line = br.readLine()) != null) SB.append(" ").append(line);  // There is a really annoying warning when these are in same append method

		StringTokenizer st = new StringTokenizer (SB.toString());  // Tokens are faster to iterate through then regex.
		String[] arr = new String[st.countTokens()];
		for (int i = 0; st.hasMoreTokens(); i++)	arr[i] = st.nextToken();
		return arr;
	}

	static String[] readText2(String PATH) throws Exception {
		ArrayList<String> list = new ArrayList<>();  // Problems like this are why Dynamic Arrays Exist.
		Scanner s = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		while (s.hasNext()) list.add(s.next().toLowerCase());
		s.close();
		return list.toArray(new String[0]);
	}

	public static void main(String[] args) throws Exception {
		String PATH = "Files/Folder/dblp";
		String[] METHODS = {"STUFF", "STUFF2", "STUFF3"};
		String[] DATASETS = { "200", "400","800","1600","3200","6400", "10000","20000","40000", "80000","160000", "320000", "640000", "1280000", "2560000"}; //, "10k","100k"}; //, "5k", "10k", "100k", "1m", "" };
		
		String[] tokens = new String[0];
		// run the experiments on different data sets
		int[] nums = new int[2];
//		for (int j = 0; j < DATASETS.length - 1; j++) {
////			long startTime = System.currentTimeMillis();
//			System.out.println("read");
//			Integer _200th_freq = read(PATH + DATASETS[j] + ".txt");
////			long endTime = System.currentTimeMillis();
////			String time = String.format("%12d", endTime - startTime);
//			System.out.println("ReadText");
//			_200th_freq = ReadText(PATH + DATASETS[j] + ".txt");
//			//System.out.println("ReadText" + " method\t time=" + time + ".\t 200th freq is " + _200th_freq + "\t For: dblp" + DATASETS[j] + ".txt");
//		}
//		System.exit(0);
		for (int t = 0; t < 2; t++){
			long startTimeComplete = System.currentTimeMillis();
			for (int j = 0; j < DATASETS.length; j++) {
				// run the experiments using different methods
				System.out.println("Data is " + DATASETS[j]);
				for (String word: METHODS) {
					long startTime = System.currentTimeMillis();
					if (t == 0) tokens = readTextGOOD(PATH + DATASETS[j] + ".txt");
					else if (j < DATASETS.length - 5) tokens = readTextBAD(PATH + DATASETS[j] + ".txt");
					else break;
					//Integer _200th_freq = count_ARRAY_SORT(tokens, word);
					long endTime = System.currentTimeMillis();
					String time = String.format("%12d", endTime - startTime);
					System.out.println(word + " method\t time=" + time /*+ ".\t 200th freq is " + _200th_freq*/);
				}
			}
			long endTimeComplete = System.currentTimeMillis();
			System.out.println(t + ": Time: " + String.format("%12d", endTimeComplete - startTimeComplete) + '\n');
			nums[t] = (int) (endTimeComplete - startTimeComplete);
		}
		System.out.println("Time: [" + nums[0] + ", " + nums[1] + "]");
	}
}
