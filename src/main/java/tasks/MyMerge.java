package tasks;

import java.util.Arrays;

/**
 * Created by mayun8 on 11.12.2015.
 */
public class MyMerge {

    public static int[] doMergeSort(int[] arr){

        if (arr.length <2) return arr;
        int middle = arr.length/2;
        int[] left = doMergeSort(Arrays.copyOfRange(arr,0,middle));
        int[] right = doMergeSort(Arrays.copyOfRange(arr, middle, arr.length));
        return merge(left,right);
    }

    public static int[] merge(int[] left, int[] right){

        int leftSize = left.length;
        int rightSize = right.length;

        int fullSize = leftSize+rightSize;
        int[] result = new int[fullSize];
        int leftIndicator = 0;
        int rightIndicator = 0;

        for (int i = 0; i < fullSize; i++) {
            if (leftIndicator<leftSize && rightIndicator< rightSize){
                if (left[leftIndicator]>right[rightIndicator])  result[i] = right[rightIndicator++];
                else result[i] = left[leftIndicator++];
            }else if(leftIndicator<leftSize){
                result[i] = left[leftIndicator++];
            }else {
                result[i] = right[rightIndicator++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] x = {2,3,76,85,34,90,111,132};
        System.out.println(Arrays.toString(x));

        System.out.println(Arrays.toString(doMergeSort(x)));
    }
}
