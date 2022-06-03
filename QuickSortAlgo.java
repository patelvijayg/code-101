import java.util.Arrays;

public class QuickSortAlgo {

    public static void main(String[] args) {
        int[] arr = {2,1,35,4,3,7,8,9,12,5};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int low, int high){

        if(low<high){
            int partitionIndex = partition(arr,low,high);
            quickSort(arr,low,partitionIndex-1);
            quickSort(arr,partitionIndex+1,high);
        }
    }
    public static int partition(int[] arr, int low, int high){
        int pivot=arr[high];
        //variable i is small value index
        int i=low-1;
        //vairable j is greater element index
        for (int j = low; j <high ; j++) {
            ///j should stop if it is found any smaller index than pivot and replace with i.
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        //swap the actual pivot to its correct position.
        swap(arr,i+1,high);
        return i+1;
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
}
