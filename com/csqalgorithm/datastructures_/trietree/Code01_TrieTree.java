package Java.com.csqalgorithm.datastructures_.trietree;

/**
 * @author C77eric
 * @version 1.0
 */
public class Code01_TrieTree {

    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1(){
            pass = 0;
            end = 0;

            nexts = new Node1[26];
        }
    }

    public static class Trie1 {
        private  Node1 root;
        public Trie1 (){
            root = new Node1();
        }

        public void insert(String word){
            if(word == null){
                return;
            }

            char[] str = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int path = 0;
            for(int i = 0;i < str.length;i++){
                path = str[i] - 'a';
                if(node.nexts[path] == null){
                    node.nexts[path] = new Node1();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word){
            if(search(word) != 0){
                char[] chs = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int path = 0;
                for(int i = 0;i < chs.length;i++){
                    path = chs[i] - 'a';
                    if(--node.nexts[path].pass == 0);{
                        node.nexts[path] = null;
                        return;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }
        }

        public int search(String word){
            if(word == null){
                return 0;
            }
            char str[] = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for(int  i = 0;i < str.length;++i){
                index = str[i] - 'a';
                if(node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }
    }


}
