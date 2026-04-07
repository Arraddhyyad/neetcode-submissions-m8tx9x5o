class Solution {
    List<String> soln = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return soln;

        backtrack(0, digits);
        return soln;
    }

    public void backtrack(int ind, String digits) {
        if (ind == digits.length()) {
            soln.add(sb.toString());
            return;
        }

        String letters = map(digits.charAt(ind));

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            backtrack(ind + 1, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public String map(char ch) {
        switch (ch) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
        }
        return "";
    }
}