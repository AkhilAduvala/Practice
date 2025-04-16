public class BubbleSort {

    public static void sort(int[] a){
        boolean swap;
        int len = a.length;
        //optimization: so we can skip the end elements in inner loop as they are sorted with each outer
        int i = 0;
        do{
            swap = false;
            for(int j = 0; j < len - i - 1; j++){
               if(a[j] > a[j+1]){
                   int temp = a[j+1];
                   a[j+1] = a[j];
                   a[j] = temp;
                   //optimization: as we dont need to continue to travese the array if the array is sorted mid way
                   swap = true;
               }
            }
            i++;
        }while(swap);
    }

    public static void main(String[] args){
        int[] a = {1,7,6,8,2,3,4};
        long start = System.currentTimeMillis();
        sort(a);
        long stop = System.currentTimeMillis();
        System.out.println("Here is array sorted using bubble sort");
        for(int j : a){
            System.out.println(j);
        }
        System.out.println("Time taken for bubble sort : " + (stop - start));
    }
}
