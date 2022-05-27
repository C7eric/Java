# **Algorithmn 笔记**

​																																		——CSQ





> **基于Java 与 C 写的数据结构以及基本算法笔记**





## 一、排序算法

###  1.冒泡排序-BubbleSort

```java
public static void bubbleSort(int[] arr){
        
        if(arr == null || arr.length < 2){
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if(arr[e] > arr[i]){
                    swap(arr,i,i+1);
                }
            }
        }
```



> **swap函数**

> **但是要注意使用上面方法的时候要注意 i, j 所指的不为同一个**

> ```java
> public static void swap(int[] arr,int i,int j){
>     
>     arr[i] = arr[i] ^ arr[j];
>     arr[j] = arr[i] ^ arr[j];
>     arr[i] = arr[i] ^ arr[j];
> }
> ```
>
> 
>
> 通常使用以下方法
>
> ```java
> public static void swap(int[] arr,int i,int j){
>     int tmp = arr[i];
>     arr[i] = arr[j];
>     arr[j] = tmp;
> }
> ```





### 2. 归并排序-MergeSort

> 归并排序采用 分治和递归 



```java
public class Code04_MergeSort {

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr,0,arr.length - 1);
    }

    public static void process(int[] arr,int L,int R){
        if(L == R){
            return;
        }

        int mid = L + ((R - L) >> 1);
        process(arr,L,mid);
        process(arr,mid + 1,R);
        merge(arr,L,mid,R);
    }
}
```

> *merge函数*
>
> ```java
> public static void merge(int[] arr,int L,int M,int R){
> 
>         int[] help = new int[R - L + 1];
>         int i = 0;
>         int p1 = L;
>         int p2 = M + 1;
>         while(p1 <= M && p2 <= R){
>             help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
>         }
>         while(p1 <= M){
>             help[i++] = arr[p1++];
>         }
>         while(p2 <= R){
>             help[i++] = arr[p2++];
>         }
>         for (int j = 0; j < help.length; j++) {
> 
>             arr[L + j] = help[j];
>         }
>     }
> ```

> 创建辅助数组 help . arr.length = R - L + 1
>
> > help 最后将部分/全部 排序完成的元素 一一赋给arr
>
> 双指针 p1 p2  
>
> > ```java
> > while(p1 <= M && p2 < R){
> > 	help[i++] = arr[p1] > arr[p2] ? arr[p1++] : arr[p2++]; 
> > }
> > ```
> >
> > > 指针p1 未到达M之前（包含此时达到） 且 p2 未到达 R之前（包含此时到达）
> > >
> > > 比较 arr[p1] 与 arr[p2] 的大小 如果arr[p1] 大 ,将 arr[p1] 赋给help[i],然后i ++ , 指针p1 向后移动
> >
> > 
> >
> > ```java
> > while(p1 <= M){
> >     help[i++] = arr[p1++];
> > }
> > ```
> >
> > > 当 p1 > M  或 p2 > R 时，第一个while 条件不满足，跳出循环，此时假设p2 > R ，p1 < M ，故元素仍未处理完全，即剩余部分已有序，将剩余部分依次遍历进help 





### 3. 快速排序-QuickSort



> **源码：**

```java
public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        quickSort(arr,0,arr.length - 1);
    }

    public static void quickSort(int[] arr,int L,int R){
        if(L < R){
            swap(arr,L + (int)(Math.random() * (R - L + 1)),R);
            int[] p = partition(arr,L,R);
            quickSort(arr,L,p[0] - 1); // < 区
            quickSort(arr,p[1] + 1,R);  // > 区
        }
    }
```

> ```java
> swap(arr,L+(int)*(R-L+1),R);
> ```
>
> > 将arr中随机一个数作为指定值
>
> **partition函数**
>
> > 这是一个处理arr[L...R] 的函数，默认以arr[R]做划分
> >
> > 返回等于区域（左边界，右边界），所以返回一个数组 res  res[0],res[1]
> >
> > **源码**
> >
> > ```java
> > public static int[] partition(int[] arr,int L,int R){
> >         int less = L - 1;  // 左边界
> >         int more = R;  // 右边界
> >         while(L < more){   // L 表示当前数的位置 arr[R] -> 划分值
> >             if(arr[L] < arr[R]){  // 当前数 < 划分值
> >                 swap(arr,++less,L++);
> >             } else if(arr[L] > arr[R]){  // 当前数 > 划分值
> >                 swap(arr,--more,L);
> >             } else {
> >                 L++;
> >             }
> >         }
> >         swap(arr,more,R);
> >         return new int[]{less + 1,more};
> >     }
> > ```
> >
> > 双指针 less more 
> >
> > 三个区域：
> >
> > - less 左：小于划分值 ( arr[R] )
> > - more 右 ： 大于划分值 （ arr[R] ）
> > - less ~ more : 等于 划分值 （ arr[R] ）
> >
> > ```java
> > while(L < more){   // L 表示当前数的位置 arr[R] -> 划分值
> >             if(arr[L] < arr[R]){  // 当前数 < 划分值
> >                 swap(arr,++less,L++);
> >             } else if(arr[L] > arr[R]){  // 当前数 > 划分值
> >                 swap(arr,--more,L);
> >             } else {
> >                 L++;
> >             }
> >         }
> > ```
> >
> > 当  当前值 小于 划分值的时候  :  less 后移 （++less) , 自增后的 less  与 L 交换 ， L  指向下一个位置
> >
> > ```Java
> > if(arr[L] < arr[R]){
> >     swap(arr,++less,L++);
> > }
> > ```
> >
> > 当  当前值 大于 划分值的时候   : more 前移 （--more ) , 自减后的more 与 L 交换 ， L 所指 不变 ， 再次将 交换后的值与划分值比较
> >
> > ```java
> > if(arr[L] > arr[R]){
> >     swap(arr,--more,L);
> > }
> > ```
> >
> > 当  当前值 等于  划分值的 时候   :   L 指向下一个位置 ，less 与 more 皆不动
> >
> > ```java
> > if(arr[L] == arr[R]){
> >     L++;
> > }
> > ```
>
> 
>
> > ```java
> > swap(arr,more,R);
> > ```
> >
> > 将划分值与more 交换 



###  4 .选择排序-SelectionSort

> **源码：**

````java
public static void selectionSort(int[] arr){

        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1;j< arr.length;j++){
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }
    }
````





###  5.插入排序-InsertSort



> **源码：**

````java
public static void insertionSort(int[] arr){
    if(arr == null || arr.length < 2){
        return;
    }
    
    for(int i = 0;i < arr.length;i++){
        for(int j = i - 1;j >= 0 && arr[j] > arr[j + 1];j--){
            swap(arr,j,j+1);
        }
    }
}
````



###   6.堆排序-HeapSort



> **源码：**

```java
public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for (int i = 0; i < arr.length; i++) {

            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while(heapSize > 0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapInsert(int[] arr,int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr,index,(index - 1) / 2);
        }
    }
```

>  ```java
>  for (int i = 0; i < arr.length; i++) {
>  
>              heapInsert(arr,i);
>          }
>  ```
>
> > 可以替换成以下代码
> >
> > ```java
> > for(int i = arr.length -1 ;i >= 0;i--){
> >     heapify(arr,i,arr.length);
> > }
> > ```







> **heapify 函数**
>
> ```java
> public static void heapify(int[] arr,int index,int heapSize){
>         int left = index * 2 + 1;
>         while(left < heapSize){
>             int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
>                     ? left + 1: left;
> 
>             largest = arr[largest] > arr[index] ? largest : index;
> 
>             if(largest == index){
>                 break;
>             }
>             swap(arr,largest,index);
>             index = largest;
>             left = index * 2 + 1;
>         }
>     }
> ```
>
> > ``` java
> > int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left
> > ```
> >
> > > left +  1  为 右子树  
> > >
> > > 如果 右子树大于 左子树 ，则 largest = left + 1 ; 
> > >
> > > 反之 ， largest = left ; 





























##  二、递归

### 1. arr[L...R] 范围求最大值

```java
dpublic class Code01_GetMax {

    public static int getMax(int[] arr){
        return process(arr,0,arr.length - 1);
    }

    //arr[L...R] 范围求最大值
    public static int process(int[] arr,int L,int R){

        if(L == R){  // arr[L...R] 范围内只有一个数,直接返回
            return arr[L];
        }
        int mid = L + ((R - L) >> 1); // 中点求法
        int leftMax = process(arr,0,mid);
        int rightMax = process(arr,mid + 1,R);
        return Math.max(leftMax,rightMax);
    }
}
```

>  ***中点求法：***

```JAVA
int mid = L + ((R - L) >> 1);
```

使用位运算，效率更高，且避免了数值过大造成数值错误







##  **三、位运算**







###  **1.EvenTimesOddTimes**

> **源码：**

```java
public class Code01_EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr){

        int eor = 0;
        for (int cur : arr){
            eor ^= cur;
        }
        System.out.println(eor);
    }

    public static void printOddTimesNum2(int[] arr){
        int eor = 0;
        for(int cur : arr){
            eor ^= cur;
        }
        //eor = a ^ b
        //eor != 0
        //eor 必然有一个位置为1
        int rightOne = eor & (~eor + 1); // 提取出最右边的1
        int onlyOne = 0;
        for(int cur : arr){
            if((cur & rightOne) == 0){
                onlyOne ^= cur;
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }
}

```



> ```java
> int rightOne = eor & (~eor + 1);
> ```
>
> > 提取出最右边的 1 





##  堆结构

> **源码：**

```java
PriorityQueue<Integer> heap = new Priority<>();
```

> 默认以小根堆组织
>
> 系统提供的堆结构无法高效的完成对特定位置的操作，故特殊场景下需要手写堆结构。



###  **1.SortArrayDistanceLessK**

>  **源码:**

```java
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
```

> ```java
> heap.poll();
> ```
>
> poll 出的为小根堆中的最小值(在不使用比较器重写比较方法的前提下)



### **2.比较器**

> 比较器相当于 c++ 中重载比较运算符 
>
> >  任何比较器：
> >  compare方法里，遵循一个统一的规范：
> > 返回负数的时候，认为第一个参数应该排在前面
> >  返回正数的时候，认为第二个参数应该排在前面
> >  返回0的时候，认为无所谓谁放前面
> >
> > > ```java
> > > @Override
> > > public int compare(Student o1, Student o2) {
> > >     return o1.id != o2.id ? (o1.id - o2.id) : (o2.age - o1.age);
> > > }
> > > ```

