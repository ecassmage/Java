import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Map.Entry;

public class WordCountLinkedList254 {
	public static Entry<String, Integer> count_ARRAY(String[] tokens) {
		int CAPACITY = 10000;
		String[] words = new String[CAPACITY];
		int[] counts = new int[CAPACITY];
		for (int j = 0; j < tokens.length; j++) {
			String token = tokens[j];
			for (int i = 0; i < CAPACITY; i++) {
				if (words[i] == null) {
					words[i] = token;
					counts[i] = 1;
					break;
				} else if (words[i].equals(token))
					counts[i] = counts[i] + 1;
			}
		}
		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < CAPACITY & words[i] != null; i++) {
			if (counts[i] > maxCount) {
				maxWord = words[i];
				maxCount = counts[i];
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}
	public static Entry<String, Integer> countFAST2(String[] tokens, double number){
		// Wasn't sure if a nice little hashmap using linked lists was allowed so I just built a hashmap which can dramatically cut down the iterations.
		// technically it can still be considered worst case O(m) to iterate through to find a word if the hash doesn't create anything except 0 but ideally even for the last
		// key it should be only a few iterations instead of possibly up to n iterations. Would be better to use a linked list which circles around so as to make
		// Certain checks easier but meh. Also would be nice if I could use more methods then just this one...
		int capacity = (int) Math.ceil(tokens.length * number);  // 1.25 is the load factor so that we don't just have constant collisions.
		String[] words = new String[capacity];
		int[] counts = new int[capacity];
		long hashCode = 0; // Holds the hash.
		int maxCount = 0;
		String maxWord = "";
		for (String tkn: tokens){
			for (char c: tkn.toCharArray()) hashCode = Math.abs((hashCode + 1) * ((int) c));
			int start = (int) (hashCode % capacity);// This is needed in case a collision happens at the end of the array
			int gotToEnd = 0;  						// So as to prevent the second key being just not placed what so ever.
			for (int i = 0; i < capacity; i++){
				int tempIndex = i + start - gotToEnd;
				if (tempIndex == capacity)	gotToEnd = capacity;
				if (words[tempIndex] == null){
					words[tempIndex] = tkn;
					counts[tempIndex]++;
					break;
				}
				else if (words[tempIndex].equals(tkn)){
					counts[tempIndex]++;
					if (counts[tempIndex] > maxCount){
						maxCount = counts[tempIndex];
						maxWord = tkn;
					}
					break;
				}
			}
			hashCode = 0;
		}
		if (maxWord.equals("")){  // This is for if all words end up having only 1 occurrence, just choose the first one.
			maxWord = words[0];
			maxCount = counts[0];
		}
		return new AbstractMap.SimpleEntry<>(maxWord, maxCount);
	}

	public static Entry<String, Integer> countFAST_FINAL(String[] tokens){
		// This is a Hashmap which which operates by inserting at its hashed position then if full iterating down the list until an open spot opens up.
		// I would have used a linkedlist style hashMap but wasn't sure if that was aloud or not.
		int capacity = (int) Math.ceil(tokens.length * 1.25);  // 1.25 is the load factor so that we don't just have constant collisions.
		String[] words = new String[capacity];
		int[] counts = new int[capacity];
		long hashCode = 0; // Holds the hash.
		int maxCount = 0;
		String maxWord = "";
		for (String tkn: tokens){
			hashCode = Math.abs(tkn.hashCode());
			int start = (int) (hashCode % capacity);// This is needed in case a collision happens at the end of the array
			int gotToEnd = 0;  						// So as to prevent the second key after collision from being inserted anywhere.
			for (int i = 0; i < capacity; i++){
				int tempIndex = i + start - gotToEnd;
				if (tempIndex == capacity)	gotToEnd = capacity;
				if (words[tempIndex] == null){
					words[tempIndex] = tkn;
					counts[tempIndex]++;
					break;
				}
				else if (words[tempIndex].equals(tkn)){
					counts[tempIndex]++;
					if (counts[tempIndex] > maxCount){
						maxCount = counts[tempIndex];
						maxWord = tkn;
					}
					break;
				}
			}
		}
		if (maxWord.equals("")){  // This is for if all words end up having only 1 occurrence, just choose the first one.
			maxWord = words[0];
			maxCount = counts[0];
		}
		return new AbstractMap.SimpleEntry<>(maxWord, maxCount);
	}

	public static Entry<String, Integer> countFAST(String[] tokens){
		// Wasn't sure if a nice little hashmap using linked lists was allowed so I just built a hashmap which can dramatically cut down the iterations.
		// technically it can still be considered worst case O(m) to iterate through to find a word if the hash doesn't create anything except 0 but ideally even for the last
		// key it should be only a few iterations instead of possibly up to n iterations. Would be better to use a linked list which circles around so as to make
		// Certain checks easier but meh. Also would be nice if I could use more methods then just this one...
		int capacity = (int) Math.ceil(tokens.length * 1.25);  // 1.25 is the load factor so that we don't just have constant collisions.
		String[] words = new String[capacity];
		int[] counts = new int[capacity];
		long hashCode = 0; // Holds the hash.
		for (String tkn: tokens){
			for (char c: tkn.toCharArray()) hashCode = Math.abs((hashCode + 1) * ((int) c));
			int start = (int) (hashCode % capacity);// This is needed in case a collision happens at the end of the array
			int gotToEnd = 0;  						// So as to prevent the second key being just not placed what so ever.
			for (int i = 0; i < capacity; i++){
				int tempIndex = i + start - gotToEnd;
				if (tempIndex == capacity)	gotToEnd = capacity;
				if (words[tempIndex] == null){
					words[tempIndex] = tkn;
					counts[tempIndex]++;
					break;
				}
				else if (words[tempIndex].equals(tkn)){
					counts[tempIndex]++;
					break;
				}
			}
			hashCode = 0;
		}
		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < capacity; i++) {
			if (words[i] == null) continue;
			if (counts[i] > maxCount) {
				maxWord = words[i];
				maxCount = counts[i];
			}
		}
		return new AbstractMap.SimpleEntry<>(maxWord, maxCount);
	}

	public static Entry<String, Integer> better_count(String[] tokens){
		// A dictionary is about the best you can get without sorting the list outside of the timing, since a hashmap can
		// get it done in O(n) instead of O(nm) or O(nlogn) like just array counting and sorting respectively can complete the task with.
		// Also technically HashMaps are arrays with an added linked list so it is technically just sorting an array just with a hashcode instead of alphabetically.
		HashMap<String, Integer> map = new HashMap<>();
		for (String tokn : tokens){
			if (map.containsKey(tokn)) map.put(tokn, map.get(tokn) + 1);
			else map.put(tokn, 1);
		}
		int maxCount = 0;
		String maxWord = "";
		for (String tokn: map.keySet()){
			if (map.get(tokn) > maxCount) {
				maxCount = map.get(tokn);
				maxWord = tokn;
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}


	public static Entry<String, Integer> count_sort(String[] tokens){
		Arrays.sort(tokens);
		String maxWord = "";
		int maxCount = 0;
		int currentNum = 0;
		String currentWord = "";
		for (int i = 0; i < tokens.length; i++){

			if (!tokens[i].equals(currentWord)){
				if (i - currentNum > maxCount){  // the i - currentNum is to remove the time counting up with current num;
					maxCount = i - currentNum;
					maxWord = currentWord;
				}
				currentWord = tokens[i];
				currentNum = i;
			}
		}
		if (tokens.length - currentNum > maxCount){  // Pointless since of is always largest but if z was the most common it would not be counted without it.
			maxCount = tokens.length - currentNum;
			maxWord = currentWord;
		}
		return new AbstractMap.SimpleEntry<>(maxWord, maxCount);
	}

	public static Entry<String, Integer> count_LINKED_LIST(String[] tokens) {
		LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>();
		for (int j = 0; j < tokens.length; j++) {
			String word = tokens[j];
			ListIterator<Entry<String, Integer>> L = list.listIterator();
			forElseLoop: {  // A for else loop, Just to remove the booleans needed for adding new item.
				for (int i = 0; i < list.size(); i++) {
					Entry<String, Integer> e = L.next();
					if (word.equals(e.getKey())) {
						e.setValue(e.getValue() + 1);
						list.set(i, e);
						break forElseLoop;  // Breaks the loop if found
					}
				}
				list.add(new AbstractMap.SimpleEntry<String, Integer>(word, 1));
			}
		}

		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < list.size(); i++) {
			int count = list.get(i).getValue();
			if (count > maxCount) {
				maxWord = list.get(i).getKey();
				maxCount = count;
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}
	public static Entry<String, Integer> count_LINKED_LIST_Bad(String[] tokens) {
		LinkedList<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>();
		for (int j = 0; j < tokens.length; j++) {
			String word = tokens[j];
			boolean found = false;
			for (int i = 0; i < list.size(); i++) {
				Entry<String, Integer> e = list.get(i);

				if (word.equals(e.getKey())) {
					e.setValue(e.getValue() + 1);
					list.set(i, e);
					found = true;
					break;
				}
			}
			if (!found)
				list.add(new AbstractMap.SimpleEntry<String, Integer>(word, 1));
		}

		int maxCount = 0;
		String maxWord = "";
		for (int i = 0; i < list.size(); i++) {
			int count = list.get(i).getValue();
			if (count > maxCount) {
				maxWord = list.get(i).getKey();
				maxCount = count;
			}
		}
		return new AbstractMap.SimpleEntry<String, Integer>(maxWord, maxCount);
	}

	static String[] readText(String PATH) throws Exception {
		Scanner doc = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
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

	public static void main(String[] args) throws Exception {
		String[] paths = {"dblp100", "dblp200", "dblp400", "dblp800", "dblp1600", "dblp3200", "dblp6400", "dblp10k", "dblp100k", "dblp1m", "dblp3m"};
		for (String path: paths){
			String[] tokens = readText("Folder/" + path + ".txt");
			System.out.println("Total Tokens = " + tokens.length);
			long startTime = System.currentTimeMillis();
			Entry<String, Integer> entry = count_sort(tokens);
			long endTime = System.currentTimeMillis();
			String time = String.format("%12d", endTime - startTime);
			System.out.println("count_sort   -> File: " + path + ".txt\t time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

			startTime = System.currentTimeMillis();
			entry = better_count(tokens);
			endTime = System.currentTimeMillis();
			time = String.format("%12d", endTime - startTime);
			System.out.println("better_count -> File: " + path + ".txt\t time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

			startTime = System.currentTimeMillis();
			entry = countFAST(tokens);
			endTime = System.currentTimeMillis();
			time = String.format("%12d", endTime - startTime);
			System.out.println("countFast    -> File: " + path + ".txt\t time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

			startTime = System.currentTimeMillis();
			entry = countFAST2(tokens, 1.25);
			endTime = System.currentTimeMillis();
			time = String.format("%12d", endTime - startTime);
			System.out.println("countFast2   -> File: " + path + ".txt\t time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());

			startTime = System.currentTimeMillis();
			entry = countFAST_FINAL(tokens);
			endTime = System.currentTimeMillis();
			time = String.format("%12d", endTime - startTime);
			System.out.println("countFast3   -> File: " + path + ".txt\t time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue() + "\n");
		}

/*
		tokens = readText(PATH);
		startTime = System.currentTimeMillis();
		entry = count_ARRAY(tokens);
		endTime = System.currentTimeMillis();
		time = String.format("%12d", endTime - startTime);
		System.out.println("time\t" + time + "\t" + entry.getKey() + ":" + entry.getValue());*/
	}
}
