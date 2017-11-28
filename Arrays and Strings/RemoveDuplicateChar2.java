//Design an algorithm and write code to remove the duplicate characters in a string
//without using any additional buffer. NOTE: One or two additional variables are fine.
//An extra copy of the array is not.

public static void removeDuplicatesEff(char[] str) {
     if (str == null) return;
     int len = str.length;
     if (len < 2) return;
         boolean[] hit = new boolean[256];
         for (int i = 0; i < 256; ++i) {
         hit[i] = false;
     }
     
     hit[str[0]] = true;
     int tail = 1;
     
     for (int i = 1; i < len; ++i) {
         if (!hit[str[i]]) {
             str[tail] = str[i];
             ++tail;
             hit[str[i]] = true;
        }
     }
     str[tail] = 0;
 }