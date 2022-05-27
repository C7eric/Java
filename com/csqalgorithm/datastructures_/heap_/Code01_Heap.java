package Java.com.csqalgorithm.datastructures_.heap_;

public class Code01_Heap {

    public static class MyMaxHeap{

        private int[] heap;
        private final int limit;
        private int heapSize;

        public  MyMaxHeap(int limit){
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        /**
         *  判断堆是否为空
         * @return 为空返回 true
         */
        public boolean isEmpty(){

            return heapSize == 0;
        }

        /**
         *  判断堆是否已满
         * @return  为满返回 true
         */
        public boolean isFull(){

            return heapSize == limit;
        }

        /**
         * 压栈
         * @param value 入栈元素的值
         */
        public void push(int value){

            if(heapSize == limit){
                return;
            }
            heap[heapSize] = value;
            heapInsert(heap,heapSize++);
        }

        /**
         * 元素出栈
         * @return heap[0] 堆顶元素(小根堆)
         */
        public int pop(){
            int ans = heap[0];
            swap(heap,0,--heapSize);
            heapify(heap,0,heapSize);
            return ans;
        }

        /**
         * 新加进来的数，现在停在了 index 位置，请依次往上移动，
         * 	移动到 0 位置，或者干不掉自己的父亲了，停！
         * @param arr 数组
         * @param index 元素下标
         */
        private void heapInsert(int[] arr,int index){

            // arr[index] < arr[(index - 1 ) / 2
            // index == 0
            while(arr[index] > arr[(index - 1) / 2]){
                swap(arr,index,(index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        /**
         *
         * 从 index 位置，往下看，不断的下沉
         * 停：较大的孩子都不再比 index 位置的数大；已经没孩子了
         * @param arr 数组
         * @param index 下标
         * @param heapSize heap长度
         */
        public void heapify(int[] arr,int index,int heapSize){

            int left = index * 2 + 1;
            while(left < heapSize){

                //把较大的孩子的下标给 largest
                int largest = arr[left] > arr[left + 1] && left + 1 < heapSize ? left : left + 1;
                largest = arr[largest] > arr[index] ? largest : index;

                if(largest == index){
                    break;
                }

                // index 和较大孩子要互换
                swap(arr,largest,index);
                index = largest;
                left = index * 2 + 1;
            }

        }

        /**
         *  交换元素
         * @param arr 数组
         * @param i 交换元素位置
         * @param j 交换元素位置
         */
        public void swap(int[] arr,int i,int j){
            int  tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

    }
}
