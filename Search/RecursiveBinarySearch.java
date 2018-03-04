package Search;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        System.out.println(recursiveBinarySearch(new int[]{1,3,4,5,6,7,10}, 0 , 6, -1));
    }

    public static int recursiveBinarySearch(int [] a, int p , int r, int x){
        // lowest index greater than the highest index
        // return false
        if (p > r){
            return -1;
        }else{
            // find the mid point of the array
            int q = (p + r)/ 2;

            // if the element is found
            if (a[q] == x){
                return q;
            }else if (a[q] > x){        // the element is less than the mid point
                return recursiveBinarySearch(a, p, q - 1, x);   // shift the highest index to mid - 1
            }else{                      // the element is greater than the mid point
                return recursiveBinarySearch(a, q + 1, r , x);  // shift the lowest index to mid + 1
            }
        }
    }
}
