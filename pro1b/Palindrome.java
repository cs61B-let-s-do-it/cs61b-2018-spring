public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordInDeque = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++) {
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;
    }

    public static int count = 0;
    public boolean isPalindrome(String word) {
        if(word.length == 0 || word.length == 1) {
            return true;
        }
        else {
            Deque<Character> deque = new LinkedListDeque<>();
            deque = wordToDeque(word);
            palindromeHelper(deque);
            if(count == 0) {
                return true;
            }
            else {
                count = 0;
                return false;
            }
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }

    private boolean isPalindromeHelper(Deque d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        } else if (!cc.equalChars((char)d.removeFirst(), (char)d.removeLast())) {
            return false;
        } else {
            return isPalindromeHelper(d, cc);
        }
    }
}