package gift.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Constants {
	
	public static String men = "Men";
	public static String women = "Women";
	public static String teens = "Teens";
	public static String kids = "Kids";
	
	public static List<String> topList = Arrays.asList(men, women, teens, kids);
	public static Map<String, List<List<String>>> map = new HashMap<String, List<List<String>>>();
	
	
	public static String[] men1 = {"one", "two", "three", "four"};
	public static String[] men2 = {"one", "two", "three", "four"};
	public static String[] men3 = {"one", "two", "three", "four"};
	public static String[] women1 = {"one", "two", "three", "four"};
	public static String[] women2 = {"one", "two", "three", "four"};
	public static String[] women3 = {"one", "two", "three", "four"};
	public static String[] kid1 = {"one", "two", "three", "four"};
	public static String[] kid2 = {"one", "two", "three", "four"};
	public static String[] kid3 = {"one", "two", "three", "four"};
	public static String[] teen1 = {"one", "two", "three", "four"};
	public static String[] teen2 = {"one", "two", "three", "four"};
	public static String[] teen3 = {"one", "two", "three", "four"};
	
	static{
		map.put(men, Arrays.asList(Arrays.asList(men1), Arrays.asList(men2), Arrays.asList(men3)));
		map.put(women, Arrays.asList(Arrays.asList(women1), Arrays.asList(women2), Arrays.asList(women3)));
		map.put(teens, Arrays.asList(Arrays.asList(teen1), Arrays.asList(teen2), Arrays.asList(teen3)));
		map.put(kids, Arrays.asList(Arrays.asList(kid1), Arrays.asList(kid2), Arrays.asList(kid3)));
	}
	
}
