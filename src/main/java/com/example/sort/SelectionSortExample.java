package com.example.sort;

public class SelectionSortExample {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};

        selectionSort1(arr);
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }


    // 插入排序

    /**
     * 选择排序
     */
    public static void selectionSort1(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) {
            int maxIndex = 0;
            // 找出最大的
            for (int begin = 1; begin <= end; begin++) {
                maxIndex = arr[maxIndex] > arr[begin] ? maxIndex : begin;
            }
            //  交换位置
            int temp = arr[end];
            arr[end] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

}
