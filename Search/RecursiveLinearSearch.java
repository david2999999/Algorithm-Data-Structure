public class RecursiveLinearSearch {
    public static void main(String[] args) {

        System.out.println( recursiveLinearSearch(new int[] {0,1,1,2,3,4,5,6}, 0 , 3));
    }

    // i is the starting position to start the search
    // x is the value to search for
    // a is the array to be passed in to be searched
    public static int recursiveLinearSearch(int[] a, int i , int x){
        // if the element is not found
        if (i > a.length - 1){
            return -1;
        // when the element is found
        }else if(a[i] == x){
            return i;
        }else{
            // continue the recursive search
            System.out.println("Index at: " + i);
            return recursiveLinearSearch(a, i+1, x);
        }
    }
}
