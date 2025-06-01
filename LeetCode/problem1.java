// 1768. Merge Strings Alternately
// https://leetcode.com/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=programming-skills
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int maxLen = Math.max(len1, len2);
        String merged = "";
        if(len1 == len2) {
            for(int i=0;i<len1;i++) {
                merged = merged.concat(String.valueOf(word1.charAt(i)));
                merged = merged.concat(String.valueOf(word2.charAt(i)));
            }
        }
        if(len1 > len2 || len2 > len1) {
            for(int i=0;i<maxLen;i++) {
                if (i < len1) {
                    merged = merged.concat(String.valueOf(word1.charAt(i)));
                }
                if (i < len2) {
                    merged = merged.concat(String.valueOf(word2.charAt(i)));
                }
            }
        }
        return merged;
    }
}