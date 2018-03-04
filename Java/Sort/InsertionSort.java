package Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int myArray[] = insertionSort(new int[] {9, 12, 2, 31, 102, 22, 1, 2, 5});

        for (int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }

    public static int[] insertionSort(int[] a){
        // splits the array into sorted and unsorted section
        // in the beginning, the first element will be the sorted section
        // iterates through the array
        // the variable j will be the last index of the sorted section
        for (int i = 0; i < a.length; i++){
            // the element is the first element in the unsorted section
            int element = a[i];
            int j = i-1;

            // if the elements on the sorted side is greater than the value in the unsorted side
            // shift each element over 1 space
            while (j >= 0 && a[j] > element){
                a[j + 1] = a[j];
                j--;
            }

            // insert the element into the proper position
            a[j+1] = element;
        }
        return a;
    }
}
