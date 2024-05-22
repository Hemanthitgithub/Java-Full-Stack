package day13programs;

class TrieNode{
	TrieNode[] children;
	boolean isEndOfWord;
	
	public TrieNode() {
		children = new TrieNode[26];
		isEndOfWord = false;
	}
}
public class TrieForPrefixChecking{
	private TrieNode root;
	
	public TrieForPrefixChecking() {
			root = new TrieNode();
	}
	public void insert(String word) {
		TrieNode current = root;
		for(char c : word.toCharArray()) {
			int index = c -'a';
			if(current.children[index] == null) {
				current.children[index] = new TrieNode();
			}
			current = current.children[index];
		}
		current.isEndOfWord = true;
	}
	public boolean search(String word) {
		TrieNode current = root;
		for(char c:word.toCharArray()) {
			int index = c -'a';
			if(current.children[index] == null) {
				return false;
			}
			current = current.children[index];
		}
		return true;
	}
	public boolean startsWith(String prefix) {
		TrieNode current = root;
		for(char c:prefix.toCharArray()) {
			int index = c-'a';
			if(current.children[index]==null) {
				return false;
			}
			current = current.children[index];
		}
		return true;
	}
	public static void main(String[] args) {
		TrieForPrefixChecking trie = new TrieForPrefixChecking();
		trie.insert("apple");
		trie.insert("banana");
		trie.insert("app");
		
		System.out.println(trie.search("apple"));
		System.out.println(trie.search("app"));
		System.out.println(trie.search("ban"));
		
		System.out.println(trie.startsWith("app"));
		System.out.println(trie.startsWith("ban"));
		System.out.println(trie.startsWith("abc"));
	}
}


