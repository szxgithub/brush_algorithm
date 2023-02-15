package middle;

import java.util.TreeMap;

public class Item208 {

    /*

    实现 Trie (前缀树)

     */

    static class Trie{

        private class Node{
            public boolean isWord;
            public TreeMap<Character,Node> next;

            public Node(boolean isWord){
                this.isWord = isWord;
                next = new TreeMap<>();
            }

            public Node(){
                this(false);
            }
        }

        private Node root;
        public Trie(){
            this.root = new Node();
        }

        public void insert(String word){
            Node cur = root;
            for (int i =0; i <word.length(); i++){
                char c = word.charAt(i);
                if (cur.next.get(c) == null){
                    cur.next.put(c,new Node());
                }
                cur = cur.next.get(c);
            }
            if (!cur.isWord){
                cur.isWord = true;
            }
        }

        public boolean search(String word){
            Node cur = root;
            for (int i =0; i<word.length(); i++){
                char c = word.charAt(i);
                if (cur.next.get(c) == null){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return cur.isWord;
        }



        public boolean startWith(String prefix){
            Node cur = root;
            for (int i =0; i <prefix.length(); i++){
                char  c = prefix.charAt(i);
                if (cur.next.get(c) == null){
                    return false;
                }
                cur = cur.next.get(c);
            }
            return true;
        }

    }

    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startWith("app");
        trie.insert("app");
        trie.search("app");

    }

}
