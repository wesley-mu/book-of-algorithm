package com.codemaster.array;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String result = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(result);
    }
    // 暴力解法
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();

        // 枚举所有长度严格大于1的子串 charArray[i..j]
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串s[left..right]是否为回文串
     *
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}