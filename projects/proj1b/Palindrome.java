public class Palindrome extends LinkedListDeque {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> lldeq = new LinkedListDeque<Character>();
        for(int i = 0;i<word.length(); i++){
            char w = word.charAt(i);
            lldeq.addLast(w);
        }
        return lldeq;
    }

    public boolean isPalindrome(String word){
        if(word.length()==1) return true;
        Boolean bool = helper(word, 0, word.length()-1);
        return bool;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word == null) return false;
        if(word.length()==0 || word.length()==1) return true;
        Boolean bool =helperTwo(word, 0, word.length()-1, cc);
        return bool;
    }
    private boolean helper(String word, int start, int end){
        if(start > end) return true;
        if(word.charAt(start) != word.charAt(end)) return false;
        Boolean bool = helper(word, start+1, end-1);
        return bool;
    }

    private boolean helperTwo(String word, int start, int end, CharacterComparator cc){
        if(start > end) return true;
        CharacterComparator offByOne = new OffByOne();
        if(!cc.equalChars(word.charAt(start), word.charAt(end))) return false;
        Boolean bool = helper(word, start+1, end-1);
        return bool;
    }
}
