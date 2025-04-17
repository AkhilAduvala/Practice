public class InsertionSort {

    public static void sort(int[] a){
        int i = 1;
        while(i < a.length){
            //we need to figure out where this key shopuld be inserted
            int key = a[i];
            int j = i - 1;
            //if any of the element to the left is greater than key,
            // then we need to move the elements till we have got to right place to insert our key
            while(j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = key;
            i++;
        }
    }

    public static void main(String[] args){
        int[] a = {1,7,6,8,2,3,4};
        long start = System.nanoTime(); //using nanoTime() instead of currentTimeMillis() as its small dataset
        sort(a);
        long stop = System.nanoTime(); //using nanoTime() instead of currentTimeMillis() as its small dataset
        System.out.println("Here is array sorted using insertion sort");
        for(int j : a){
            System.out.println(j);
        }
        System.out.println("Time taken for insertion sort : " + (stop - start));
    }
}
