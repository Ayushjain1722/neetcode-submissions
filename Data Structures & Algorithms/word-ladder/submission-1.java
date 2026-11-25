class Word {
    String word;
    int len;
    Word(String word, int len) {
        this.word = word;
        this.len = len;
    }
}
class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (int i=0;i<wordList.size();i++) {
            set.add(wordList.get(i));
        }

        int ans = 0;
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(beginWord, 1));
        while (!q.isEmpty()) {
            Word word = q.poll();
            if (word.word.equals(endWord)) {
                return word.len;
            }
            for(int i=0;i<word.word.length();i++) {
                for (int j=0;j<26;j++) {
                    String sb = word.word.substring(0, i) + (char)(j + 'a') + word.word.substring(i+1, word.word.length());
                    if(set.contains(sb)) {
                        set.remove(sb);
                        q.add(new Word(sb, word.len+1));
                    }
                }
            }
        }

        return ans;
    }
}
