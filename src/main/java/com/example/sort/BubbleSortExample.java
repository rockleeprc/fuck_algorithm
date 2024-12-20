package com.example.sort;

public class BubbleSortExample {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        bubbleSort1(arr);
//        bubbleSort2(arr);
//        bubbleSort3(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    // 选择排序

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort1(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) { // loop 0 - i
            for (int begin = 0; begin < end; begin++) { // 相邻元素两两比较
                if (arr[begin] > arr[begin + 1]) { // 前一个元素比后一个元素大，交换位置
                    int temp = arr[begin];
                    arr[begin] = arr[begin + 1];
                    arr[begin + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序优化1
     *
     * @param arr
     */
    public static void bubbleSort2(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) { // loop 0 - i
            boolean isOrder = true; // 判断数组是否有序
            for (int begin = 0; begin < end; begin++) { // 相邻元素两两比较
                if (arr[begin] > arr[begin + 1]) { // 前一个元素比后一个元素大，交换位置
                    int temp = arr[begin];
                    arr[begin] = arr[begin + 1];
                    arr[begin + 1] = temp;
                    isOrder = false; // 有交换动作，数组无序
                }
            }
            // 有序后直接退出，不再需要两两比较
            if (isOrder) break;
        }
    }

    /**
     * 冒泡排序优化2
     *
     * @param arr
     */
    public static void bubbleSort3(int[] arr) {
        for (int end = arr.length - 1; end > 0; end--) { // loop 0 - i
            int orderIndex = 1; // 数组局部有序索引位置
            for (int begin = 0; begin < end; begin++) { // 相邻元素两两比较
                if (arr[begin] > arr[begin + 1]) { // 前一个元素比后一个元素大，交换位置
                    int temp = arr[begin];
                    arr[begin] = arr[begin + 1];
                    arr[begin + 1] = temp;
                    orderIndex = begin + 1; // 记录最后一个交换的位置
                }
            }
            // 局部有序 ，调整范围
            end = orderIndex;
        }
    }
}
