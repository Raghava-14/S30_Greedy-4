/*
From any string, we can form a subsequence by deleting some number of characters (possibly no deletions).

Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. 
If the task is impossible, return -1

Examples:

Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by concatenating two subsequences of "abc": "abc" + "bc".

Input: source = "abc", target = "acdbc"
Output: -1
Explanation: It is impossible to form the target "acdbc" by concatenating subsequences of "abc".

--------------------------------------------------------------------- */

//Time =  O(S * T), where S and T are the lengths of the source and target strings
//Space = O(1)

class Solution {
    public int shortestWay(String source, String target) {
        int count = 0; // Initialize the count of subsequences used
        int index = 0; // Initialize the index into source
        
        while (index < target.length()) {
            int prevIndex = index; // Store the previous index into source
            for (int i = 0; i < source.length(); i++) {
                if (index < target.length() && source.charAt(i) == target.charAt(index)) {
                    index++; // If the current character in source matches the current character in target, move to the next character in target
                }
            }
            if (index == prevIndex) { // If no progress was made, it means the next character in target is not present in source
                return -1;
            }
            count++; // Increment the count of subsequences used
        }
        
        return count;
    }
}
