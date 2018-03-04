package Sort;

public class MergeSort {
    public static void sort(int inputArr[]){
        sort(inputArr, 0, inputArr.length - 1);
    }

    public static void sort(int inputArr[], int start, int end){
        if (end <= start){
            return; // finish traversing the array
        }

        // use recursion to split the array in halves
        int mid = (start + end) / 2;
        sort(inputArr, start, mid);         // sort the left side
        sort(inputArr, mid + 1, end);   // sort the right side
        merge(inputArr, start, mid, end);    // merge both sides
    }

    public static void merge(int inputArr[], int start, int mid, int end){
        int tempArray[] = new int[end - start + 1];

        // index counter for the left side of the array
        int leftSlot = start;
        // index counter for the right side of the array
        int rightSlot = mid + 1;

        int k = 0;

        while (leftSlot <= mid && rightSlot <= end){
            if (inputArr[leftSlot] < inputArr[rightSlot]){
                tempArray[k] = inputArr[leftSlot];
                leftSlot++;
            }else {
                tempArray[k] = inputArr[rightSlot];
                rightSlot++;
            }
            k++;
        }


        // if it gets to here, the above loop has been completed
        // so both the left and right side of the subarray are sorted
        if (leftSlot <= mid){       // consider the right side done being sorted. Left must also be sorted
            while (leftSlot <= mid){
                tempArray[k] = inputArr[leftSlot];
                leftSlot++;
                k++;
            }
        }else if (rightSlot <= end){    
            while (rightSlot <= end){
                tempArray[k] = inputArr[rightSlot];
                rightSlot++;
                k++;
            }
        }

        // copy over the temp array into the appropriate spots in the inputArray
        for (int i = 0; i < tempArray.length; i++){
            inputArr[start + i] = tempArray[i];
        }
    }


}
