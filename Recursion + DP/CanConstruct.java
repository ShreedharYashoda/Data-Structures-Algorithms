import java.util.*;
class CanConstruct {
	
  public static void main(String[] args) {
		Map<String, Boolean> cache = new HashMap<>();
    System.out.println(canConstruct("abcdef", Arrays.asList("abc", "cd", "def", "abcd"), cache));

		cache = new HashMap<>();
		System.out.println(canConstruct("skateboard", Arrays.asList("bo","rd","ate","t","ska","sk","boar"), cache));

		cache = new HashMap<>();
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", Arrays.asList("e","ee","eee","eeee","eeee"), cache));
		
  }

	// O(n*m^2)  O(m^2)  m - length of target, n ->no of strings in dict
	public static boolean canConstruct(String target, List<String> dict, Map<String, Boolean> cache){
			if(cache.containsKey(target)) return cache.get(target);
			if(target.equals("")) return true;
			
			for(String str:dict){
				if(target.indexOf(str) == 0){
					String sub = target.substring(str.length());
					if(canConstruct(sub, dict, cache)){
						cache.put(target, true);
						return true;
					}
				}
			}

			cache.put(target, false);
			return false;
	}
}