class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(char ch : s.toCharArray())
           if(Character.isLetterOrDigit(ch))
                str+=Character.toLowerCase(ch);
               
        
        String rev = "";
        for(int i = str.length()-1;i>=0;i--)
            rev += str.charAt(i);

        return rev.equals(str);
    }
}
