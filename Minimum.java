//Time = O(n), where n is the length of the input arrays
//Space = O(1)

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        
        // Initialize count arrays for A, B, and numbers that appear in the same position in both arrays
        int[] countA = new int[7], countB = new int[7], same = new int[7];
        
        // Calculate the count of each number in A and B, as well as the count of numbers that appear in the same position in both arrays
        for (int i = 0; i < n; i++) {
            countA[A[i]]++; // Increment the count of the current number in A
            countB[B[i]]++; // Increment the count of the current number in B
            
            if (A[i] == B[i]) {
                same[A[i]]++; // Increment the count of the current number if it appears in the same position in both A and B
            }
        }
        
        // Find the number that appears in all dominos
        for (int i = 1; i <= 6; i++) {
            if (countA[i] + countB[i] - same[i] == n) { // Check if the current number appears in all the dominos
                return n - Math.max(countA[i], countB[i]); // Return the minimum number of rotations required to make all the dominos have the same number on either side
            }
        }
        
        return -1; // Return -1 if it is impossible to make all the dominos have the same number on either side
    }
}
