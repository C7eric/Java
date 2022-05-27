package Java.com.csqalgorithm.solution;

import java.util.PriorityQueue;

public class Code03_SortArrayDistanceLessK {

    public void sortDistanceLessK(int[] arr,int k){

        // 默认小跟堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for(;index <= Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }

        int  i = 0;
        for(;index <= arr.length;i++,index++){
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while(heap.isEmpty()){
            arr[i++] = heap.poll();
        }
    }
}
