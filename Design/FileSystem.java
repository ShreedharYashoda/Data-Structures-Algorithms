/*Design an in-memory file system to simulate the following functions:

ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the
list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path
don't exist either, you should create them as well. This function has void return type.

addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given
content. If the file already exists, you need to append given content to original content. This function has void return type.

readContentFromFile: Given a file path, return its content in string format.*/


import java.util.*;

class FileSystem {
    
    class TrieNode{
        String name;
        String content;
        Map<String, TrieNode> children = new TreeMap<>();
    }
    
    TrieNode root;

    public FileSystem() {
        root = new TrieNode();
        root.name = "/";
    }
    
    
    public void insert(String path, String content){
        TrieNode cur = root;
        String[] p = path.split("/");
        for(int i=1; i<p.length; i++){
            cur.children.putIfAbsent(p[i], new TrieNode());
            cur = cur.children.get(p[i]);
            cur.name = p[i];
        }
        
        if(content != null){
            cur.content = cur.content == null ? content : cur.content + content;
        }
    }
    
    public TrieNode search(String path){
        TrieNode cur = root;
        String[] p = path.split("/");
        for(int i=1; i<p.length; i++){
            cur = cur.children.get(p[i]);
        }
        
        return cur;
    }
    
    public List<String> ls(String path) {
        TrieNode node = search(path);
        
        return node.content == null ? new LinkedList<>(node.children.keySet()) : Collections.singletonList(node.name);
    }
    
    public void mkdir(String path) {
        insert(path, null);
    }
    
    public void addContentToFile(String filePath, String content) {
        insert(filePath, content);
    }
    
    public String readContentFromFile(String filePath) {
        return search(filePath).content;
    }




public static void main(String[] args) {
	// ["","ls","mkdir","addContentToFile","ls","readContentFromFile"]
	// [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]

    	FileSystem fs  = new FileSystem();

    	System.out.println(fs.ls("/"));
    	fs.mkdir("/a/b/c");
    	fs.addContentToFile("/a/b/c/d","hello");
    	System.out.println(fs.ls("/"));
    	System.out.println(fs.readContentFromFile("/a/b/c/d"));
  }
}