public class MergeSort {

    //repeatedly split the array into two halves until there is only one element in each array
    public static void sort(int[] a, int left, int right){
        //check if the array has single element or start to call recursively
        if(left < right){
            int mid = left + (right - left)/2;

            sort(a, left, mid); //move with left side of the array
            sort(a, mid + 1, right); //move with right side of the array
            merge(a, left, mid, right);
        }
    }

    //take two arrays, merge them as per the crct order(asc/desc)
    public static void merge(int[] a, int left, int mid, int right){
        int l = mid - left + 1;
        int r = right - mid;

        int[] leftArray = new int[l];
        int[] rightArray = new int[r];

        System.arraycopy(a, left, leftArray, 0, l); //taking a copy of the left side of array
        System.arraycopy(a, mid+1, rightArray, 0, r); //taking a copy of the left side of array

        int i = 0, j = 0, k = left;
        //compare both left and right arrays to place elements in crct order
        while(i < l && j < r){
            a[k++] = (leftArray[i] < rightArray[j]) ? leftArray[i++] : rightArray[j++];
        }

        //add elements from left array if any are left
        while(i < l){
            a[k++] = leftArray[i++];
        }

        //add elements from right array if any are left
        while(j < r){
            a[k++] = rightArray[j++];
        }
    }

    public static  void main(String[] args){
        int[] a = {1,7,6,8,2,3,4};
        long start = System.nanoTime(); //using nanoTime() instead of currentTimeMillis() as its small dataset
        sort(a, 0, a.length - 1);
        long stop = System.nanoTime(); //using nanoTime() instead of currentTimeMillis() as its small dataset
        System.out.println("Here is array sorted using merge sort");
        for(int j : a){
            System.out.println(j);
        }
        System.out.println("Time taken for merge sort : " + (stop - start));
    }
}
