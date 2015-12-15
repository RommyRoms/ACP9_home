package tasks;

import java.util.Arrays;

/**
 * Created by mayun8 on 11.12.2015.
 *
 */
public class MyBinary {

    public static int  search(int[] inputArr, int search){
        return binFind(inputArr,9,inputArr.length-1,search);
    }

    public static int binFind(int[] inputArr,int first, int last, int search) {

        if (first > last) {
            return -1;
        }
        int middle = (last+first)/2;
        if (inputArr[middle]<search) return  binFind(inputArr,middle+1,inputArr.length-1,search);
        else if (inputArr[middle]>search) return binFind(inputArr,inputArr[0],middle-1,search);
        else return middle;
    }


    public static void main(String[] args) {
        int[] x = {1,2,3,4,6,8,9,45,56,67,78,89,90};
        System.out.println(Arrays.toString(x));

        System.out.println(search(x,56));
    }
}
