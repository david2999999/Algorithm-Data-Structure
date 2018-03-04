package Sort;

public class MergeSortString {
    public static void sort(String inputArr[]){
        sort(inputArr, 0, inputArr.length - 1);
    }

    public static void sort(String inputArr[], int start, int end){
        if (end <= start){
            return;
        }

        int mid = (start + end) / 2;
        sort(inputArr, start, mid);     // sort the left side left
        sort(inputArr, mid + 1, end);   // sort the right side
        merge(inputArr, start, mid, end);   // merge both sides
    }

    public static void merge(String inputArr[], int start, int mid, int end){
        String tempArr[] = new String[end - start + 1];

        // first slot of the left array
        int leftSlot = start;
        // first slow of the right array
        int rightSlot = mid + 1;

        int k = 0;

        // when comparing the strings ignore the case
        while (leftSlot <= mid && rightSlot <= end){
            // if the left string is less than the right string
            if (inputArr[leftSlot].compareToIgnoreCase(inputArr[rightSlot]) < 0 ){
                tempArr[k++] = inputArr[leftSlot++];
            }else{
                tempArr[k++] = inputArr[rightSlot++];
            }
        }

        // there are cases when one of the sides are sorted already
        // there will be missing element on the other side
        // this is prevent missing elements
        if (leftSlot <= mid){
            while (leftSlot <= mid){
                tempArr[k++] = inputArr[leftSlot++];
            }
        }else if(rightSlot <= end){
            while (rightSlot <= end){
                tempArr[k++] = inputArr[rightSlot++];
            }
        }

        // copy the elements from the temp array to the actual input array 
        for (int i = 0; i < tempArr.length; i++){
            inputArr[start + i] = tempArr[i];
        }
    }
}
