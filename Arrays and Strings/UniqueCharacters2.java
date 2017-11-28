// Implement an algorithm to determine if a string has all unique characters. What if
//you can not use additional data structures?

public static boolean isUniqueChars(String str) {
    int checker = 0;
    for (int i = 0; i < str.length(); ++i) {
        int val = str.charAt(i) - ‘a’;
        if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
    }
    return true;
}