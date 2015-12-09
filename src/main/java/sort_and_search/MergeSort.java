package sort_and_search;

import java.util.Arrays;

/**
 * Created by mayun8 on 07.12.2015.
 */
public class MergeSort {

    private static int[] sortMerge(int[] arr){
        if (arr.length<=1)return arr;
        int middle = (arr.length/2);
        int[] left = sortMerge(Arrays.copyOfRange(arr,0,middle));
        int[] right = sortMerge(Arrays.copyOfRange(arr,(middle),arr.length));
        return merge(left,right);
    }

    private static int[] merge(int[] left, int[] right) {
        int sizeLeft = left.length;
        int sizeRight = right.length;
        int fullSize = sizeLeft+sizeRight;
        int indicatorLeft = 0,indicatorRight = 0;
        int[] result = new int[fullSize];

        for (int i = 0; i < fullSize; i++) {
            if (indicatorRight < sizeRight && indicatorLeft < sizeLeft) {
                if (left[indicatorLeft] > right[indicatorRight]) result[i] = right[indicatorRight++];
                else result[i] = left[indicatorLeft++];
            } else if (indicatorRight < sizeRight) {
                result[i] = right[indicatorRight++];
            } else {
                result[i] = left[indicatorLeft++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] x = {1,5,3,9,6};
        System.out.println(Arrays.toString(x));
        int[] rez = sortMerge(x);
        System.out.println(Arrays.toString(rez));

    }


}
