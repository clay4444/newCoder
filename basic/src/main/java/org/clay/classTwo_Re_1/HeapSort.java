package org.clay.classTwo_Re_1;

import java.util.Arrays;

public class HeapSort {

    public static void heapSort(int[] arr){

        if (arr == null || arr.length < 2) {
            return;
        }

        for(int i = 0; i < arr.length; i++){
            heapInsert(arr,i);
        }

        swap(arr,0,arr.length-1);

        int heapSize = arr.length-1;

        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    /**
     * index位置索引下沉的过程
     * @param arr
     * @param index
     * @param heapSize  理解为索引
     */
    public static void heapify(int[] arr, int index,int heapSize){
        int left = (2 * index) + 1;

        while(left < heapSize){
            int largest = left + 1 < heapSize && arr[left+1] > arr[left] ? left+1 : left;

            largest = arr[largest] > arr[index] ? largest : index;

            if(largest == index){
                return;
            }
            swap(arr,index,largest);
            index = largest;
            left = (2 * index) + 1;
        }
    }

    /**
     * 构建大顶堆的过程
     */
    public static void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index-1)/2]){   //父节点的索引都是 (index-1)/2
            swap(arr,index,(index-1)/2);
            index = (index-1) / 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
    }
}
