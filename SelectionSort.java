public class SelectionSort {

    public static void sort(int[] a){
        int i = 0;
        while(i < a.length - 1){
            int minIndex = i;
            int j = i + 1;
            while(j < a.length){
                if(a[minIndex] > a[j]){
                    minIndex = j;
                }
                j++;
            }
            if(minIndex != i){
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
            i++;
        }
    }

    public static  void main(String[] args){
        int[] a = {1,7,6,8,2,3,4};
        long start = System.nanoTime(); //using nanoTime() instead of currentTimeMillis() as its small dataset
        sort(a);
        long stop = System.nanoTime(); //using nanoTime() instead of currentTimeMillis() as its small dataset
        System.out.println("Here is array sorted using selection sort");
        for(int j : a){
            System.out.println(j);
        }
        System.out.println("Time taken for selection sort : " + (stop - start));
    }
}
