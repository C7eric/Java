package Java.com.csqalgorithm.datastructures_.trietree;

/**
 * @author C77eric
 * @version 1.0
 */
public class Code02_WordDictionary {
    /*
    Tire+DFS:
    Tire(前缀树)用于前缀匹配,dfs用于'.'匹配的26种字母情况查找
        */
    // Tire节点类
    class Node{
        boolean end;
        Node[] children;
        public Node() {
            end = false;
            children = new Node[26];
        }
    }
    Node root;
    // 初始化词典对象
    public Code02_WordDictionary() {
        root = new Node();
    }

    // 将 word 添加到数据结构中，之后可以对它进行匹配
    public void addWord(String word) {
        Node p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.children[u] == null) p.children[u] = new Node();
            p = p.children[u];
        }
        p.end = true;
    }

    // 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。
    // word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    // 判断以root为根节点是否存在单词word[idx,n-1]
    private boolean dfs(Node p, String word, int idx) {
        int n = word.length();
        if (idx == n) return p.end;  // 递归至word结尾并且该节点恰好end==true说明是存储单词的结尾
        if (word.charAt(idx) == '.') {
            // 1.遇到word[idx]为'.'的情况->可以匹配26个字母中任意一个
            for (int i = 0; i < 26; i++) {
                if (p.children[i] != null && dfs(p.children[i], word, idx + 1)) {
                    return true;    // 一旦有一个匹配到就说明匹配到
                }
            }
            return false;   // 全部匹配失败
        } else {
            // 2.遇到word[idx]为普通字母的情况
            int u = word.charAt(idx) - 'a';
            if (p.children[u] == null) return false;    // 没有该节点说明匹配不到
            return dfs(p.children[u], word, idx + 1);   // 有该节点,是否匹配到取决于后面段是否匹配到
        }
    }
}
