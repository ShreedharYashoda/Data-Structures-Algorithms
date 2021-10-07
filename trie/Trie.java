import java.util.*;

class Trie {
    
    Trienode root;

    public Trie() {
        root = new Trienode('/');
    }
    
    public void insert(String word) {
        Trienode cur = root;
        for(Character ch : word.toCharArray()) {
            cur.children.putIfAbsent(ch, new Trienode(ch));
            cur = cur.children.get(ch);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        Trienode cur = root;
        for(Character ch : word.toCharArray()) {
            if(cur.children.containsKey(ch)) {
                cur = cur.children.get(ch);
            }else{
                return false;
            }
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Trienode cur = root;
        for(Character ch : prefix.toCharArray()) {
            if(cur.children.containsKey(ch)) {
                cur = cur.children.get(ch);
            }else{
                return false;
            }
        }
        return true;
    }
    
    public class Trienode {
        Character ch;
        Map<Character, Trienode> children;
        boolean isWord; 
        
        public Trienode(Character ch) {
            this.ch = ch;
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

		public static void main(String[] args){
				Trie obj = new Trie();
  			obj.insert("Shreedhar");
				obj.insert("Shreekanth");
 				boolean param_2 = obj.search("Shreedhar");
				boolean param_3 = obj.startsWith("Shreek");
				boolean param_4 = obj.startsWith("Sri");

				System.out.println(param_2);
				System.out.println(param_3);
				System.out.println(param_4);
		}
}

