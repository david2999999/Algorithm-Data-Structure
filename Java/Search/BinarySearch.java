public class BinarySearch {
    public static void main(String[] args) {

        System.out.println(binarySearch(new int[] {1,2,3,4,5,6,7}, 4));
    }

    public static int binarySearch(int[] a, int x){
        int front = 0;
        int rear = a.length -1;

        while (front <= rear){
            int middle = (front + rear) / 2;

            if(x < a[middle])
                rear = middle - 1;
            else if(x > a[middle])
                front = middle + 1;
            else
                return middle;
        }

        // if x is not found
        return -1;

    }
}
