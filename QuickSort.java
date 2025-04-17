public class QuickSort {

    public static void sort(int[] a, int low, int high){
        if(low < high){
            int pivotIndex = partition(a, low, high);

            sort(a, low,pivotIndex - 1); //recursively call the array to the left of pivot
            sort(a, pivotIndex + 1, high); //recursively call the array to the right of pivot
        }
    }

    public static int partition(int[] a, int low, int high){
        //we use this i as the index of last small element seen than pivot,
        // which is used to place app the elements less than pivot
        int i = low - 1; //as of now there is no element smaller than pivot as we have not started to traverse
        int pivot = a[high];
        for(int j = low; j < high; j++){
            if(a[j] < pivot){
                i++;
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
            }
        }
        //placing the pivot in the correct position  (all elements left < pivot, right > pivot)
        a[high] = a[++i];
        a[i] = pivot;

        //elements before the pivotIndex (i) will be smaller than opivot while to the right are greater
        return i;
    }

    public static  void main(String[] args){
        int[] a = {1,7,6,8,2,3,4};
        long start = System.nanoTime(); //using nanoTime() instead of currentTimeMillis() as its small dataset
        sort(a, 0, a.length - 1);
        long stop = System.nanoTime(); //using nanoTime() instead of currentTimeMillis() as its small dataset
        System.out.println("Here is array sorted using quick sort");
        for(int j : a){
            System.out.println(j);
        }
        System.out.println("Time taken for quick sort : " + (stop - start));
    }
}
