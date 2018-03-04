package Sort;

public class SelectionSort {
    public static void main(String[] args) {

        int[] myArray = selectionSort(new int[]{1,5,6,87,2,1,2,3});
        for (int i = 0; i < myArray.length; i++){
            System.out.print(myArray[i] + " ");
        }
    }

    public static int[] selectionSort(int a[] ){
        // loop through the whole array to find the minimum value
        for (int i = 0; i < a.length; i++){
            int min = i;

            // compare i with each of its subsequent index j
            for (int j = i+1; j < a.length; j++){
                // if there is a smaller value
                // use that element as min
                if (a[j] < a[min]){
                    min = j;
                }
            }

            // swap the two elements to sort the array
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }

        return a;
    }

}
