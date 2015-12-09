package sort_and_search;

import java.util.Arrays;

/**
 * Created by mayun8 on 08.12.2015.
 */
public class BinarySearch {

    public static int binarySearch(int[] array, int searchValue){
        int start = array[0];
        int end = array.length-1;

        while(start<end){

            int middle = (end-start)/2;

            if (searchValue == array[middle]){
                return middle;
            }else if (array[middle]>searchValue){
                end = end -1;
            }else start = start+1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        System.out.println(Arrays.toString(arr));

        System.out.println(binarySearch(arr, 4));
    }
}
