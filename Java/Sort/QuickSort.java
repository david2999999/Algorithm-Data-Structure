package Sort;

public class QuickSort {

    public void sort(int[] inputArr, int start , int end){
        if (start < end){
            int pp = partition(inputArr, start, end);   // index position of the correctly placed partition point
            sort(inputArr, start, pp - 1);      // sort the left half of the range
            sort(inputArr, pp + 1, end);        // sort the right half of the range
        }
    }

    private int partition(int[] inputArr, int start, int end){
        // place the pivot point at the end of the array
        int pivot = inputArr[end];

        int i = start - 1;
        for (int j = start; j <= end - 1; j++){
            // if the position at j is greater than pivot
            if (inputArr[j] <= pivot){
                i++;
                // swap the elements at ++i and j
                int ival = inputArr[i];
                int jval = inputArr[j];
                inputArr[i] = jval;
                inputArr[j] = ival;
            }
        }

        // put the pivot value in the correct slot next
        int ival = inputArr[i+1];
        inputArr[end] = ival;
        inputArr[i+1] = pivot;  // pivot value is placed in the correct slot of the array

        return i + 1;

    }
}
