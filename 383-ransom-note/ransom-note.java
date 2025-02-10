class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterCount = new int[26];

        // Count occurrences of each letter in magazine
        for (char ch : magazine.toCharArray()) {
            letterCount[ch - 'a']++;
        }

        // Check if we can construct ransomNote from magazine
        for (char ch : ransomNote.toCharArray()) {
            if (letterCount[ch - 'a'] == 0) {
                return false;  // Letter not available
            }
            letterCount[ch - 'a']--;  // Use the letter
        }

        return true;
    }
}