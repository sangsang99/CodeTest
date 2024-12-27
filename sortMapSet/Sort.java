import java.util.*;
public class Sort {
    public static void main(String[] args){
        int[] arrNum = {3, 1, 5, 7, 4, 8, 2, 10, 6, 9};
        int[] sortedArr = sortFactory(arrNum, "INSERT");
        for (int i : sortedArr) {
            System.out.print(i + " ");
            if (i == sortedArr.length) {System.out.println();}
        }

    }
    public static int[] sortFactory(int[] arrNum, String type){
        switch (type) {
            case "SELECT":               
                return selectSort(arrNum);
            case "BUBBLE":
                return bubbleSort(arrNum);
            case "INSERT":
                return insertSort(arrNum);
            case "QUICK":
                int start = 0;
                int end = arrNum.length - 1;
                return quickSort(arrNum, start, end);
        }
        return arrNum;
    }

    public static int[] selectSort(int[] arrNum){ 
        for (int i = 0; i < arrNum.length; i++) {
            int min = Integer.MAX_VALUE;
            int temp = -1;
            int index = -1;
            for (int j = i; j < arrNum.length; j++) {
                if(arrNum[j] < min){
                    min = arrNum[j];
                    index = j;
                }
            }
            temp = arrNum[i];
            arrNum[i] = arrNum[index];
            arrNum[index] = temp;
        }
        return arrNum;
    }
    public static int[] bubbleSort(int[] arrNum){
        for (int i = 1; i < arrNum.length; i++) {
            for (int j = 0; j < arrNum.length - i; j++) {
                int temp;
                if(arrNum[j] > arrNum[j+1]){
                    temp = arrNum[j];
                    arrNum[j] = arrNum[j+1];
                    arrNum[j+1] = temp;
                }
            }
        }
        return arrNum;
    }
    public static int[] insertSort(int[] arrNum){
        for (int i = 1; i < arrNum.length; i++) {
            for (int j = i; j > 0; j--) {
                int temp = 0;
                if(arrNum[j-1] > arrNum[j]){
                    temp = arrNum[j];
                    arrNum[j] = arrNum[j-1];
                    arrNum[j-1] = temp;
                }
            }
        }
        return arrNum;
    }
    public static int[] quickSort(int[] arrNum, int start, int end){
        if(start >= end){
            return arrNum;
        }
        int key = start;
        int i = start + 1;
        int j = end;
        int temp;
        quickSort(arrNum, start, j-1);
        quickSort(arrNum, j+1, end);
        return arrNum;
    }
}
