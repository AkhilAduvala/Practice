public class MergeSort {
    public static void sort(int[] arr, int left, int right){
        while(left < right){
            int middle = left + (right - left)/2;

            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
    public static void merge(int[] arr, int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, middle + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;

        while(i < k && j < k){
            arr[k++] = (leftArr[i++] < rightArr[j++] ? leftArr[i++] : rightArr[j++]);
        }

        while(i < n1){
            arr[k++] = leftArr[i++];
        }

        while(j < n2){
            arr[k++] = rightArr[j++];
        }
    }
}
