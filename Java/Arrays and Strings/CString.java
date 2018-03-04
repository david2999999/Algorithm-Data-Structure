//Write code to reverse a C-Style String. (C-String means that “abcd” is represented as
//five characters, including the null character.)

void reverse(char *str) {
     char * end = str;
     char tmp;
     if (str) {
         while (*end) {
         ++end;
        }
         --end;
         while (str < end) {
             tmp = *str;
             *str++ = *end;
             *end-- = tmp;
         }
     }
 }