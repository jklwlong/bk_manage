package com.gr.bk.service;

public class FsTest {
    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();//获取当前时间
        int[] arr = {5, 9, 6, 3, 8, 1, 7};
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        Thread.sleep(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");
    }
}
