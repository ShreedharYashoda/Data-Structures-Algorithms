import java.util.*;
class CountConstruct {
	
  public static void main(String[] args) {
		Map<String, Integer> cache = new HashMap<>();
    System.out.println(countConstruct("abcdef", Arrays.asList("abc", "cd", "def", "abcd"), cache));

		cache = new HashMap<>();
		System.out.println(countConstruct("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar"), cache));

		cache = new HashMap<>();
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e","ee","eee","eeee","eeee"), cache));
		
  }

	// O(n*m^2)  O(m^2)  m - length of target, n ->no of strings in dict
	public static int countConstruct(String target, List<String> dict, Map<String, Integer> cache){
			if(cache.containsKey(target)) return cache.get(target);
			if(target.equals("")) return 1;
			int totalCount = 0;

			for(String str:dict){
				if(target.indexOf(str) == 0){
					int count = 0;
					String sub = target.substring(str.length());
					count += countConstruct(sub, dict, cache);
					totalCount += count;
				}
			}

			cache.put(target, totalCount);
			return totalCount;
	}
}