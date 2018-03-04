//Write a method to decide if two strings are anagrams or not

boolean anagram(String s, String t) {
     return sort(s) == sort(t);
 }