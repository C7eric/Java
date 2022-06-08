# **Algorithmn 笔记**

​																																		——CSQ





> **基于Java  写的数据结构以及基本算法笔记**





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























### **排序总结**

|      | 时间复杂度 | 空间复杂度 | 稳定性 |
| ---- | ---------- | ---------- | ------ |
| 选择 | O(N^2)     | O(1)       | X      |
| 冒泡 | O(N^2)     | O(1)       | ✓      |
| 插入 | O(N^2)     | O()        | ✓      |
| 归并 | O(N*logN)  | O(N)       | ✓      |
| 快排 | O(N*logN)  | O(logN)    | X      |
| 堆   | O(N*logN)  | O(1)       | X      |
|      |            |            |        |
|      |            |            |        |
|      |            |            |        |

> 1.基于比较的排序算法，时间复杂度在 O(N*logN)  以下的： **没有**
>
> 2.时间复杂度在  O(N*logN)  ，空间复杂度在 O(N)  以下，且有稳定性的排序算法 ： **没有**







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



### **2.二叉树遍历**

> **源码**

```java
```

> **递归序列**
>
>  
>
>  
>
>  

> **先序遍历**
>
> ```java
> ```
>
> 









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



## 四、数据结构



###  堆结构

> **源码：**

```java
PriorityQueue<Integer> heap = new Priority<>();
```

> 默认以小根堆组织
>
> 系统提供的堆结构无法高效的完成对特定位置的操作，故特殊场景下需要手写堆结构。



####  **1.SortArrayDistanceLessK**

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



#### **2.比较器**

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







### **哈希表**

> UnOrderedMap  UnSortedMap  -> C++
>
> **HashMap 在使用层面上可以理解为一种集合结构**
>
> **HsahMap 在使用过程（CRUD）中时间复杂度认为为常数级别**

#### **HashSet**

---

> >  有 key  无  value
>>
> >  hashSet 的 key 是基础类型 -> int 类型
> >
> >  ```java
> >  HashSet<String> hashSet1 = new HashSet<>();
> >  ```
> >
> >  
> >
> >  ```java
> >  hashSet1.add("csq");
> >  ```
> >
> >  > **hashSet.add();**  向 HashSet 中添加 csq
> >
> >  ```java
> >  hashSet.cantains();
> >  ```
> >
> >  > **hashSet.contains();**  确认 HashSet  中是否有 csq
> >
> >  ```java
> >  hashSet.remove():
> >  ```
> >
> >  > 移除 HashSet 中的 csq
> >
> 



#### **HashMap**

> > key 伴随 value 
>>
> > ```java
> > HashMap<Integer,String> hashMap = new HashMap<>();
> > ```
> >
> > 
> >
> > ```java
> > hashMap.put(1,"this is 1");
> > ```
> >
> > > 向 HashMap 中添加 key = 1 ,String =  "this is 1" ;
> >
> > ```java
> > hashMap1.get(1);
> > ```
> >
> > > 获取 key =  1 ，get  **@return String**
> >
> > ```java
> > System.out.println(hashMap1.containsKey(1));
> > ```
> >
> > > **hashMap1.containsKey(1**) : 确认是否有 key = 1 的键值对， **@return boolean**





### **有序表**



> ```java
> TreeSet<Integer> treeSet1 = new TreeSet<>(); 
> ```
>
> TreeSet 的 CRUD 操作 的时间复杂度为 O(logn) 
>
> > 放入有序表中的东西，如果是基础类型，内部按值传递，内存占用就是这个东西的大小
> >
> > 放入有序表中的东西，如果不是基础类型，必须提供 比较器 ，内部按引用传递，内存占用是这个东西内存地址的大小
> >
> > > ``` java
> > > treeSet = new TreeSet<>(new Comparator());
> > > ```
> > >
> > > > **提供比较器**
> > >
> > >  
> > >
> > > ```java
> > > System.out.println(treeMap.firstKey());
> > > ```
> > >
> > > > 
> > >
> > > ```java
> > > System.out.println(treeMap.lastKey());
> > > ```
> > >
> > > > 
> > >
> > > ```java
> > > System.out.println(treeMap.floorKey(4));
> > > ```
> > >
> > > > 
> > >
> > > ```java
> > > System.out.println(treeMap.ceilingKey(4));
> > > ```
> > >
> > > >  
> > > >
> > > > 









### **链表**

> **单链表和双链表结构只需要给定一个头部节点 head , 就可以找到剩下的所有节点**



#### **1.单链表的节点结构**

> ---
>
> ```java
>class Node<V>{
> 
> V value;
> Node next;
>  }
>  ```
> 
> > **由以上结构的结点依次连接起来所形成的链叫做单链表**



#### **2.双链表的节点结构**

> ---
>
> ```java
>class Node<V>{
> 
> V value;
> Node next;
>  Node last;
>  }
>  ```
> 
> > **由以上结构的节点依次连接起来所形成的链叫做双链表**
>>
> > 
> >
> > 



#### **3.链表中点求法**

> ---
>
> ```java
>public static class Node{
> 
>      public int value;
>      public Node next;
>    
>         public Node(int v){
>          value = v;
>         }
>    
>         public static Node midOrUpMidNode(Node head){
> 
>             if(head == null || head.next == null || head.next.next == null){
>              return head;
>             }
>    
>             // 链表 有三个点或以上
>          Node slow = head.next;
>             Node fast = head.next.next;
>             while(fast.next != null && fast.next.next != null){
>    
>                 slow = slow.next;
>              fast = fast.next.next;
>             }
>             return slow;
>         }
>     }
>    ```
>    
> > 快慢指针
>>
> > ---
> >
> > ```java
> > Node slow = head.next;
> > Node fast = head.next.next;
> > ```
> >
> > > 慢指针一次走一步，快指针一次走两步，当 fast.next == null or fast.next.next == null 时 **慢指针 slow 到达中点**
> 
> 
>
> > **ArrayList**
>>
> > ---
> >
> > ```java
> > public static Node right1(Node head){
> > 
> >         if(head == null){
> >             return null;
> >         }
> >         Node cur = head;
> >         ArrayList<Node> arr = new ArrayList<>();
> >         while(cur != null){
> >             arr.add(cur);
> >             cur = cur.next;
> >         }
> >         return arr.get((arr.size() - 1)/2);
> >     }
> > ```
> >
> > > 通过 **arr.get((arr.size() -1) /2**) 来获取 中点



#### **4.找到链表第一个入环节点**

> ---
>
> ```java
>/**
>      * 找到链表第一个入环节点，如果无环返回 null
>      * @param head 链表头节点
>      * @return 第一个入环节点
>      */
>     public static Node getLoopNode(Node head){
> 
>         if(head == null || head.next == null || head.next.next == null){
>             return null;
>         }
> 
>         // n1 慢  n2 快
>         Node slow = head.next;
>         Node fast = head.next.next;
>         while(slow != fast){
>             if(fast.next == null || fast.next.next == null){
>                 return null;
>             }
>             fast = fast.next.next;
>             slow = slow.next;
>         }
>         // slow fast 相遇
>         fast = head;
>         while (slow != fast){
>             slow = slow.next;
>             fast = fast.next;
>         }
>         return slow;
>     }
> ```
> 
> 



#### **5.找到两个链表第一个相交节点(无环)**

> ---
>
> ```java
>/**
>      * 如果两个链表都无环，返回第一个相交节点
>      *  如果不相交，返回 null
>      * @param head1 链表 1 头节点
>      * @param head2 链表 2 头节点
>      * @return 两个链表第一个相交节点
>      */
>     public static Node noLoop(Node head1,Node head2) {
>         if(head1 == null || head2 == null){
>             return null;
>         }
>         Node cur1 = head1;
>         Node cur2 = head2;
>         int n = 0;
>         while(cur1.next != null){
>             n++;
>             cur1 = cur1.next;
>         }
>         while(cur2.next != null){
>             n--;
>             cur2 = cur2.next;
>         }
>         if(cur1 != cur2){
>             return null;
>         }
> 
>         // n 表示 链表长度 1 减去 链表长度 2 的值
>         cur1 = n > 0 ? head1 :head2;
>         cur2 = cur1 == head1 ? head2 : head1;
>         n = Math.abs(n);
>         while(n != 0){
>             n--;
>             cur1 = cur1.next;
>         }
>         while(cur1 != cur2){
>             cur1 = cur1.next;
>             cur2 = cur2.next;
>         }
>         return cur1;
>     }
> ```
> 
> 
>
> > **n 表示链表长度 1 减去 链表长度 2 的值 **
>>
> > ```java
> > 	int n = 0;
> >     while(cur1.next != null){
> >         n++;
> >         cur1 = cur1.next;
> >     }
> >     while(cur2.next != null)
> >         n--;
> >         cur2 = cur2.next;
> >     }
> > ```
> 
> 
>
>  > ```java
>> 	cur1 = n > 0 ? head1 :head2;
> >     cur2 = cur1 == head1 ? head2 : head1;
> >     n = Math.abs(n);
> > ```
> >
> > <img src="C:\Users\CSQ-PC\AppData\Roaming\Typora\typora-user-images\image-20220603171650083.png" alt="image-20220603171650083" style="zoom: 15%;" />

 

#### **6.找到两个链表的第一个相交节点（有环）**

> ---
>
> ```java
>/**
>      *  两个有环链表，返回第一个相交节点
>      *   如果不相交，返回 null
>      * @param head1 第一个链表  头结点
>      * @param loop1  第一个链表入环节点
>      * @param head2 第二个链表 头节点
>      * @param loop2   第二个链表 入环节点
>      * @return
>      */
>     public static Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
>         Node cur1 = null;
>         Node cur2 = null;
>         if(loop1 == loop2){
>             cur1 = head1;
>             cur2 = head2;
>             int n = 0;
>             while(cur1 != loop1){
>                 n++;
>                 cur1 = cur1.next;
>             }
>             while(cur2 != loop2){
>                 n--;
>                 cur2 = cur2.next;
>             }
>             cur1 = n > 0 ? head1 : head2;
>             cur2 = cur1 == head1 ? head2 : head1;
>             n = Math.abs(n);
>             while(n != 0){
>                 n--;
>                 cur1 = cur1.next;
>             }
>             while(cur1 != cur2){
>                 cur1 = cur1.next;
>                 cur2 = cur2.next;
>             }
>             return cur1;
>         } else {
>             cur1 = loop1.next;
>             while(cur1 != loop1){
>                 if(cur1 == loop2){
>                     return loop1;
>                 }
>                 cur1 = cur1.next;
>             }
>             return null;
>         }
> 
>     }
> ```
> 
> 
>
>  ```java
>else {
>             cur1 = loop1.next;
>             while(cur1 != loop1){
>                 if(cur1 == loop2){
>                     return loop1;
>                 }
>                 cur1 = cur1.next;
>             }
>  ```
> 
> <img src="C:\Users\CSQ-PC\AppData\Roaming\Typora\typora-user-images\image-20220603172812285.png" alt="image-20220603172812285" style="zoom:15%;" />

#### 7.**反转从 left 到 right 区间内的链表**

> ---
>
> ```java
>public  class Node {
>  public int value;
>  public Node next;
>    
>     public Node(int value) {
>      this.value = value;
>     }
>    
>    public class Code03_ReverseBetween {
> 
>      public  Node reverseBetween(Node head) {
>          Node dummyNode = new Node(-1);
>             dummyNode.next = head;
>    
>             Node pre = dummyNode;
>          for (int i = 0; i < left - 1; i++) {
>                 pre = pre.next;
>             }
>    
>             Node rightNode = pre;
>          for (int i = 0; i < right -1 ; i++) {
>                 rightNode = rightNode.next;
>             }
>    
>             Node leftNode = pre.next;
>          Node curr = rightNode.next;
>    
>             pre.next = null;
>          rightNode.next = null;
>    
>             reverseLinkedList(leftNode);
> 
>             pre.next = rightNode;
>          leftNode.next = curr;
>             return dummyNode.next;
>         }
>    
>         private void reverseLinkedList(Node head){
> 
>             Node pre = null;
>          Node cur = head;
>    
>             while(cur != null){
>              Node next = cur.next;
>                 cur.next = pre;
>                 pre = cur;
>                 cur = next;
>             }
>         }
>    }
>    
> ```
> 
> 



### **二叉树**

> **二叉树（binary tree） 是指树中节点的度不大于 2 的有序树，是一种最简单且最重要的树**



#### **1.二叉树的属性**

> > ---
>>
> > - **结点**：包含一个数据元素及若干指向子树分支的信息。
>> - **结点的度**：一个结点拥有子树的数目称为结点的度。
>  > - **叶子结点**：也称为终端结点，没有子树的结点或者度为零的结点。
>> - **分支结点**：也称为非终端结点，度不为零的结点称为非终端结点。
> > - **树的度**：树中所有结点的度的最大值。
> > - **结点的层次**：从根结点开始，假设根结点为第1层，根结点的子节点为第2层，依此类推，如果某一个结点位于第L层，则其子节点位于第L+1层。
> > - **树的深度**：也称为树的高度，树中所有结点的层次最大值称为树的深度。
> > - **有序树**：如果树中各棵子树的次序是有先后次序，则称该树为有序树。
> > - **无序树**：如果树中各棵子树的次序没有先后次序，则称该树为无序树。
> 
> 
> 
> > **二叉树的节点结构**
> 
> ---
> 
> ```java
>public static class Node {
> 
>    public int value;
>     public Node left;
>    public Node right;
> 
>    public Node(int value){
>         this.value = value;
>     }
>     }
> ```
> 
> > left 与 right 为树 的左右节点（左子树，右子树
>     



#### 2.**二叉树的遍历方式**

> > ---
>
> > - 前序遍历（根左右）： 访问根结点，再访问左子树、再访问右子树。
> > - 中序遍历（左根右）： 先访问左子树，再访问根结点、再访问右子树。
>  > - 后序遍历（左右根）： 先访问左子树，再访问右子树，再访问根结点。
>



##### 1.递归序

---

> > 1 2 4 4 4 2 5 5 5 2 1 3 6 6 6 3 7 7 7 3 1



##### **2.二叉树的递归遍历**

> ---
>
> 1. **先序遍历**
> 
>    访问根结点，再访问左子树、再访问右子树
>
>    > **递归遍历**
>
>    ---
> 
>    ```java
>       /**
>         *  先序打印所有节点
>        * @param head  二叉树 head 节点
>             */
>       public static void prePrintNodes(Node head){
>            if(head == null){
>               return;
>            }
>      	System.out.println(head.value);
>        prePrintNodes(head.left);
>       prePrintNodes(head.right);
>      }
>   ```
>   ```java
>
>    > **非递归遍历**
>
>    ---
> 
>    > ```java
>    > public static void pre(Node head) {
>   >     System.out.print("pre-order: ");
>    >     if (head != null) {
>   >         Stack<Node> stack = new Stack<Node>();
>    >         stack.add(head);
>    >         while (!stack.isEmpty()) {
>    >             head = stack.pop();
>    >             System.out.print(head.value + " ");
>    >             if (head.right != null) {
>   >                 stack.push(head.right);
>    >             }
>   >             if (head.left != null) {
>    >                 stack.push(head.left);
>   >             }
>    >         }
>   >     }
>    >     System.out.println();
>   > }
>   ```
> 
> ​       **2.中序遍历**
> 
> ​           先访问左子树，再访问根结点、再访问右子树
> 
> ​			>   **递归遍历**
> 
> ```java
> 
>    /**
>     *  中序打印所有节点
>     * @param head 二叉树 head 节点
>     */
>       public static void inPrintNodes(Node head){
>        if(head == null){
>            return;
>        }
> 
>       inPrintNodes(head.left);
>       System.out.println(head.value);
>       inPrintNodes(head.right);
>   }
>```
> 
>
> 
>    > **非递归遍历**
> 
> ---
> 
>    ```java
> public static void in(Node cur) {
>     System.out.print("in-order: ");
>     if (cur != null) {
>         Stack<Node> stack = new Stack<Node>();
>         while (!stack.isEmpty() || cur != null) {
>             if (cur != null) {
>                 stack.push(cur);
>                 cur = cur.left;
>             } else {
>                 cur = stack.pop();
>                System.out.print(cur.value + " ");
>                 cur = cur.right;
>            }
>         }
>    }
>    System.out.println();
>   }
>    ```
> 
> 
> 
> 3. **后序遍历**
> 
>   先访问左子树，再访问右子树，再访问根结点
> 
>    > **递归遍历**
> 
> ---
> 
>    ```java
>    /**
>     *  后序打印所有节点
>     * @param head 二叉树 head 节点
>        */
>    public static void posPrintNodes(Node head){
>        if(head == null){
>           return;
>        }
>
>       posPrintNodes(head.left);
>       posPrintNodes(head.right);
>       System.out.println(head.value);
>   }
>    ```
>
>    > **非递归遍历**
>
> ---
> 
>    ```java
>    public static void pos1(Node head) {
>        System.out.print("pos-order: ");
>        if (head != null) {
>            Stack<Node> s1 = new Stack<Node>();
>            Stack<Node> s2 = new Stack<Node>();
>            s1.push(head);
>            while (!s1.isEmpty()) {
>                head = s1.pop(); // 头 右 左
>                s2.push(head);
>                if (head.left != null) {
>                    s1.push(head.left);
>                }
>               if (head.right != null) {
>                   s1.push(head.right);
>                   }
>           }
>           // 左 右 头
>           while (!s2.isEmpty()) {
>                System.out.print(s2.pop().value + " ");
>           }
>        }
>       System.out.println();
>    }
> 
>    public static void pos2(Node h) {
>        System.out.print("pos-order: ");
>        if (h != null) {
>            Stack<Node> stack = new Stack<Node>();
>            stack.push(h);
>            Node c = null;
>            while (!stack.isEmpty()) {
>                c = stack.peek();
>                if (c.left != null && h != c.left && h != c.right) {
>                       stack.push(c.left);
>                } else if (c.right != null && h != c.right) {
>                    stack.push(c.right);
>                } else {
>                    System.out.print(stack.pop().value + " ");
>                    h = c;
>               }
>            }
>       }
>        System.out.println();
>   }
>    ```
> 



#### **3.二叉树常见题**

---

##### 1.搜索二叉树

---

>    > > value 小于右子树 ，大于左子树
>    > >
>    > > ```java
>    > > public class Code04_IsBST {
>    > > 
>    > >  public static class Node{
>    > >      public int value;
>    > >      public Node left;
>    > >      public Node right;
>    > > 
>    > >      public Node(int value) {
>    > >          this.value = value;
>    > >      }
>    > >  }
>    > > 
>    > >  public static boolean isBST(Node head){
>    > >      if(head == null){
>    > >          return true;
>    > >      }
>    > >      ArrayList<Node> res = new ArrayList<>();
>    > >      process(head, res);
>    > >      for (int i = 0; i < res.size(); i++) {
>    > >          if(res.get(i).value <= res.get(i - 1).value){
>    > >              return false;
>    > >          }
>    > >      }
>    > >      return true;
>    > >  }
>    > > 
>    > >  public static void process(Node head, ArrayList<Node> res){
>    > >      if(head == null){
>    > >          return;
>    > >      }
>    > >      process(head.left,res);
>    > >      res.add(head);
>    > >      process(head.right,res);
>    > >  }
>    > > 
>    > > 
>    > >  public static boolean isBST2(Node head){
>    > >      if(head == null){
>    > >          return true;
>    > >      }
>    > >      return process(head).isBST;
>    > >  }
>    > > 
>    > >  public static class Info{
>    > > 
>    > >      public boolean isBST;
>    > >      public int max;
>    > >      public int min;
>    > > 
>    > >      public Info(boolean isBST, int max, int min) {
>    > >          this.isBST = isBST;
>    > >          this.max = max;
>    > >          this.min = min;
>    > >      }
>    > >  }
>    > > 
>    > >  public static Info process(Node x){
>    > >      if(x == null) {
>    > >          return null;
>    > >      }
>    > >          Info leftInfo = process(x.left);
>    > >          Info rightInfo = process(x.right);
>    > > 
>    > >          int  max = x.value;
>    > >          if(leftInfo != null){
>    > >              max = Math.max(max, leftInfo.max);
>    > >          }
>    > >          if(rightInfo != null){
>    > >              max = Math.max(max, rightInfo.max);
>    > >          }
>    > >          int min = x.value;
>    > >          if(leftInfo != null){
>    > >              min = Math.min(min, leftInfo.min);
>    > >          }
>    > >          if(rightInfo != null){
>    > >              min = Math.min(min, rightInfo.min);
>    > >          }
>    > > 
>    > >          boolean isBST = true;
>    > >          if(leftInfo != null && !leftInfo.isBST){
>    > >              isBST = false;
>    > >          }
>    > >          if(rightInfo != null && !rightInfo.isBST){
>    > >              isBST = false;
>    > >          }
>    > >          if(leftInfo != null && leftInfo.max < x.value){
>    > >              isBST = false;
>    > >          }
>    > >          if(rightInfo != null && rightInfo.min > x.value){
>    > >              isBST = false;
>    > >          }
>    > >          return new Info(isBST,max,min);
>    > >      }
>    > > }
>    > > ```



##### 2.完全二叉树

---

>    > ```java
>    > public static boolean isCBT(Node head){
>    >     if(head == null){
>    >         return true;
>    >     }
>    >     LinkedList<Node> queue = new LinkedList<>();
>    >     boolean leaf = false;
>    >     Node left = null;
>    >     Node right = null;
>    >     queue.add(head);
>    >     while(!queue.isEmpty()){
>    >         head = queue.poll();
>    >         left = head.left;
>    >         right = head.right; 
>    >         if(
>    >         (leaf && (left == null || right == null))
>    >             ||
>    >         (left == null && right != null)    
>    >         ){
>    >             return false;
>    >         }
>    >         if(left != null){
>    >             queue.add(left);
>    >         }
>    >         if(right != null){
>    >             queue.add(right);
>    >         }
>    >         if(left == null || right == null){
>    >             leaf = true;
>    >         }
>    >         return true;
>    >     }
>    > ```
>    >
>    > ---
>    >
>    > > ```java
>    > > if(
>    > >      (leaf && (left == null || right == null))
>    > >          ||
>    > >      (left == null && right != null)    
>    > >      ){
>    > >          return false;
>    > >      }
>    > > ```
>    > >
>    > > > **如果遇到不双全的节点之后，又发现当前节点不是叶节点**
>    >
>    > ---
>    >
>    > > **方法二**
>    >
>    > ---
>    >
>    > ```java
>    > public static boolean isCBT2(Node head){
>    >     if(head == null){
>    >         return true;
>    >     }
>    > 
>    >     return process(head).isCBT;
>    > }
>    > 
>    > public static class Info{
>    >     public boolean isFull;
>    >     public boolean isCBT;
>    >     public int height;
>    > 
>    >     public Info(boolean full,boolean cbt,int h){
>    >         isFull = fuu;
>    >         isCBT = cbt;
>    >         height = h;
>    >     }
>    > }
>    > 
>    > public static Info process(Node x){
>    >     if(x == null){
>    >         return new Info(true,true,0);
>    >     }
>    > 
>    >     Info leftInfo = process(x.left);
>    >     Info rightInfo = process(x.right);
>    > 
>    >     int height = Math.max(leftInfo.height,rightInfo) + 1;
>    > 
>    >     if(isFull){
>    >         isCBT = true;
>    >     } else {
>    >         if(leftInfo.isCBT && rightInfo.isCBT){
>    >             if(leftInfo.isCBT
>    >               && rightInfo.isFull
>    >               && leftInfo.height == rightInfo.height + 1){
>    >                 isCBT = true;
>    >             }
>    >         	if(leftInfo.isFull
>    >           	  && rightInfo.isFull
>    >               && leftInfo.height == rightInfo.height + 1){
>    >                 isCBT = true;
>    >             }
>    >             if(leftInfo.isFull
>    >               && rightInfo.isCBT
>    >               && leftInfo.height == rightInfo.height){
>    >                 isCBT =true;
>    >             }
>    >         }
>    >     }
>    >     	return new Info(isFull,isCBT,height);
>    > }
>    > ```
>    >
>    > ---
>    >
>    > > ```java
>    > > if(isFull){
>    > >      isCBT = true;
>    > >  } else {
>    > >      if(leftInfo.isCBT && rightInfo.isCBT){
>    > >          if(leftInfo.isCBT
>    > >            && rightInfo.isFull
>    > >            && leftInfo.height == rightInfo.height + 1){
>    > >              isCBT = true;
>    > >          }
>    > >      	if(leftInfo.isFull
>    > >        	  && rightInfo.isFull
>    > >            && leftInfo.height == rightInfo.height + 1){
>    > >              isCBT = true;
>    > >          }
>    > >          if(leftInfo.isFull
>    > >            && rightInfo.isCBT
>    > >            && leftInfo.height == rightInfo.height){
>    > >              isCBT =true;
>    > >          }
>    > >      }
>    > >  }
>    > > ```
>    > >
>    >



##### **3.满二叉树**

---

>    > > ```java
>    > > public class Code06_IsFull {
>    > >  public static class Node {
>    > >      public int value;
>    > >      public Node left;
>    > >      public Node right;
>    > > 
>    > >      public Node(int value) {
>    > >          this.value = value;
>    > >      }
>    > >  }
>    > > 
>    > >  public static boolean isFull(Node head) {
>    > >      if (head == null) {
>    > >          return false;
>    > >      }
>    > >      Info1 all = process1(head);
>    > >      return (1 << all.height) - 1 == all.nodes;
>    > >  }
>    > > 
>    > >  public static class Info1 {
>    > >      public int height;
>    > >      public int nodes;
>    > > 
>    > >      public Info1(int height, int nodes) {
>    > >          this.height = height;
>    > >          this.nodes = nodes;
>    > >      }
>    > >  }
>    > > 
>    > >  public static Info1 process1(Node head) {
>    > >      if (head == null) {
>    > >          return new Info1(0, 0);
>    > >      }
>    > >      Info1 leftInfo = process1(head.left);
>    > >      Info1 rightInfo = process1(head.right);
>    > > 
>    > >      int height = Math.max(leftInfo.height, rightInfo.height);
>    > >      int nodes = leftInfo.nodes + rightInfo.nodes + 1;
>    > >      return new Info1(height, nodes);
>    > >  }
>    > > 
>    > >  public static boolean isFull2(Node head) {
>    > >      if (head == null) {
>    > >          return false;
>    > >      }
>    > >      return process2(head).isFull;
>    > >  }
>    > > 
>    > >  public static class Info2 {
>    > >      public int height;
>    > >      public boolean isFull;
>    > > 
>    > >      public Info2(int height, boolean isFull) {
>    > >          this.height = height;
>    > >          this.isFull = isFull;
>    > >      }
>    > >  }
>    > > 
>    > >  public static Info2 process2(Node x) {
>    > >      if (x == null) {
>    > >          return new Info2(0, true);
>    > >      }
>    > >      Info2 leftInfo = process2(x.left);
>    > >      Info2 rightInfo = process2(x.right);
>    > > 
>    > >      int height = Math.max(leftInfo.height, rightInfo.height);
>    > >      boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
>    > >      return new Info2(height, isFull);
>    > >  }
>    > > }
>    > > 
>    > > ```



##### **4.平衡二叉树**

---

>    > ```java
>    > 
>    > public class Code05_IsBalanced {
>    >     public static class Node{
>    >         public int value;
>    >         public Node left;
>    >         public Node right;
>    > 
>    >         public Node(int value) {
>    >             this.value = value;
>    >         }
>    >     }
>    > 
>    >     public static boolean isBalanced1(Node head) {
>    >         boolean[] ans = new boolean[1];
>    >         ans[0] = true;
>    >         process(head,ans);
>    >         return ans[0];
>    >     }
>    > 
>    >     public static int process(Node head,boolean[] ans) {
>    >         if(!ans[0] || head == null){
>    >             return -1;
>    >         }
>    >         int leftHeight = process(head.left, ans);
>    >         int rightHeight = process(head.right, ans);
>    > 
>    >         if(Math.abs(leftHeight - rightHeight) > 1){
>    >             ans[0] = false;
>    >         }
>    >         return Math.max(leftHeight, rightHeight) + 1;
>    >     }
>    > 
>    >     public static boolean isBalanced2(Node head){
>    >         return process(head).isBalance;
>    >     }
>    > 
>    >     public static class Info{
>    >         public int height;
>    >         public boolean isBalance;
>    > 
>    >         public Info(int height, boolean isBalance) {
>    >             this.height = height;
>    >             this.isBalance = isBalance;
>    >         }
>    >     }
>    > 
>    >     public static Info process(Node head){
>    >         if(head == null){
>    >             return new Info(0,true);
>    >         }
>    > 
>    >         Info leftInfo = process(head.left);
>    >         Info rightInfo = process(head.right);
>    >         int height = Math.max(leftInfo.height, rightInfo.height) + 1;
>    >         boolean isBalance = true;
>    >         if(!leftInfo.isBalance){
>    >             isBalance = false;
>    >         }
>    >         if(!rightInfo.isBalance){
>    >             isBalance = false;
>    >         }
>    >         if(Math.abs(leftInfo.height - rightInfo.height) > 1){
>    >             isBalance = false;
>    >         }
>    >         return new Info(height,isBalance);
>    >     }
>    > }
>    > 
>    > ```
>    >



##### 5.二叉树的层序遍历

---

> ```java
> public class Code10_TreeMaxWidth {
>     public static class Node{
>         public int value;
>         public Node left;
>         public Node right;
> 
>         public Node(int value) {
>             this.value = value;
>         }
>     }
>     public static int maxWidthUseMap(Node head) {
>         if(head == null){
>             return 0;
>         }
>         Queue<Node> queue = new LinkedList<>();
>         queue.add(head);
>         HashMap<Node,Integer> levelMap = new HashMap<>();
>         levelMap.put(head,1);
>         int curLevel = 1;
>         int curLevelNodes = 0;
>         int max = 0;
>         while (!queue.isEmpty()) {
> 
>             Node cur = queue.poll();
>             int curNodeLevel = levelMap.get(cur);
>             if(cur.left != null){
>                 levelMap.put(cur.left,curNodeLevel + 1);
>                 queue.add(cur.left);
>             }
>             if (cur.right != null) {
>                 levelMap.put(cur.right,curNodeLevel + 1);
>                 queue.add(cur.right);
>             }
>             if(curNodeLevel == curLevel){
>                 curLevelNodes++;
>             } else {
>                 max = Math.max(max,curLevelNodes);
>                 curLevel++;
>                 curLevelNodes = 1;
>             }
>         }
>         max = Math.max(max,curLevelNodes);
>         return max;
>     }
> 
>     public static int maxWidthNoMap(Node head){
>         if(head == null){
>             return 0;
>         }
>         Queue<Node> queue = new LinkedList<>();
>         queue.add(head);
>         Node curEnd = head;
>         Node nextEnd = null;
>         int max = 0;
>         int curLevelNodes = 0;
>         while (!queue.isEmpty()) {
>             Node cur = queue.poll();
>             if(cur.left != null){
>                 queue.add(cur.left);
>                 nextEnd = cur.left;
>             }
>             if(cur.right != null){
>                 queue.add(cur.right);
>                 nextEnd = cur.right;
>             }
>             curLevelNodes++;
>             if (cur == curEnd) {
>                 max = Math.max(max,curLevelNodes);
>                 curLevelNodes = 0;
>                 curEnd = nextEnd;
>             }
>         }
>         return max;
>     }
> 
>     public static class levelOrder {
>         public List<List<Integer>> levelOrder(Node head) {
>             List<List<Integer>> res = new ArrayList<List<Integer>>();
>             if(head == null){
>                 return res;
>             }
>             Queue<Node> queue = new LinkedList<>();
>             queue.add(head);
>             while(!queue.isEmpty()){
> 
>                 List<Integer> help = new ArrayList<>();
>                 int curLevelSizes = queue.size();
>                 for(int  i = 1;i <= curLevelSizes;++i){
>                     Node cur = queue.poll();
>                     help.add(cur.value);
>                     if(cur.left != null){
>                         queue.add(cur.left);
>                     }
>                     if(cur.right != null){
>                         queue.add(cur.right);
>                     }
>                 }
>                 res.add(help);
>             }
>             return res;
>         }
>     }
> }
> ```



##### 6.后继节点

---

> ```java
> public class Code09_SuccessorNode {
>     public static class Node{
> 
>         public int value;
>         public Node left;
>         public Node right;
>         public Node parent;
> 
>         public Node(int value) {
>             this.value = value;
>         }
>     }
> 
>     public static Node getSuccessorNode(Node node){
>         if(node == null){
>             return node;
>         }
>         if(node.right != null){
>             return getLeftMost(node.right);
>         } else {
>             Node parent = node.parent;
>             while (parent != null && parent.right == node) {
>                 node = parent;
>                 parent = node.parent;
>             }
>             return node;
>         }
>     }
> 
>     public static Node getLeftMost(Node node){
>         if (node == null) {
>             return node;
>         }
>         while(node.left != null){
>             node = node.left;
>         }
>         return node;
>     }
> }
> ```



##### 7.二叉树的最近公共祖先

---

> ```java
> public class Code07_LowestAncestor {
>     public static class Node {
>         public int value;
>         public Node left;
>         public Node right;
> 
>         public Node(int value) {
>             this.value = value;
>         }
>     }
>     public static Node lowestAncestor1(Node head,Node o1,Node o2){
>         if(head == null || head == o1 || head == o2){
>             return head;
>         }
> 
>         Node left = lowestAncestor1(head.left, o1, o2);
>         Node right = lowestAncestor1(head.right, o1, o2);
> 
>         if(left != null && right != null){
>             return head;
>         }
>         return left != null  ? left : right;
>     }
> 
>     public static Node lowestAncestor2(Node head,Node a,Node b){
>         return process(head,a,b).ans;
>     }
> 
>     public static class Info{
>         public boolean findA;
>         public boolean findB;
>         public Node ans;
> 
>         public Info(boolean findA, boolean findB, Node ans) {
>             this.findA = findA;
>             this.findB = findB;
>             this.ans = ans;
>         }
>     }
> 
>     public static Info process(Node x,Node a,Node b){
>         if(x == null){
>             return new Info(false,false,null);
>         }
> 
>         Info leftInfo = process(x.left,a,b);
>         Info rightInfo = process(x.right,a,b);
> 
>         boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
>         boolean findB = (x == b) || leftInfo.findB || rightInfo.findB;
>         Node ans = null;
>         if(leftInfo.ans != null){
>             ans = leftInfo.ans;
>         } else if(rightInfo.ans != null){
>             ans = rightInfo.ans;
>         } else {
>             if (findA && findB) {
>                 ans = x;
>                 }
>             }
>         return new Info(findA,findB,ans);
>     }
> }
> ```





### 图

#### 1.图的结构描述

---

>```java
>public static class Graph{
>    public HashMap<Node,Integer> nodes;
>    public HashSet<Edge> edges;
>    
>    public Graph(){
>        nodes = new HashMap<Node,Integer>();
>        edges = new HashSet<Edge>();
>    }
>}
>```
>
> 
>
>```java
>public static class Node{
>    
>    public int value;
>    public int in;
>    public int out;
>    public ArrayList<Node> nexts;
>    public ArrayList<Edge> edges;
>    
>    public Node(int value){
>        this.value = value;
>        in = 0;
>        out = 0;
>        nexts = new ArrayList<Node>();
>        edges = new ArrayList<Edge>();
>    }
>}
>```
>
> 
>
>```java
>public static class Edge{
>    public int weight;
>    public Node from;
>    public Node to;
>    
>    public Edge(int weight,Node from,Node to){
>        this.weight = weight;
>        this.from = from;
>        this.to = to;
>    }
>}
>```



#### 2.示例 - 创建图

---

>```java
>public class Code01_GraphGenerator {
>    // matrix 所有的边
>    // N*3 的矩阵
>    // [weight, from节点上面的值，to节点上面的值]
>    //
>    // [ 5 , 0 , 7]
>    // [ 3 , 0,  1]
>
>    public static Graph createGraph(int[][] matrix){
>        Graph graph = new Graph();
>        for(int i = 0;i < matrix.length;++i){
>
>            //拿到每一条边
>            int weight = matrix[i][0];
>            int from = matrix[i][1];
>            int to = matrix[i][2];
>            if(!graph.nodes.containsKey(from)){
>                graph.nodes.put(from,new Node(from));
>            }
>            if(!graph.nodes.containsKey(to)){
>                graph.nodes.put(to,new Node(to));
>            }
>            Node fromNode = graph.nodes.get(from);
>            Node toNode = graph.nodes.get(to);
>            Edge newEdge = new Edge(weight,fromNode,toNode);
>            fromNode.nexts.add(toNode);
>            fromNode.out++;
>            toNode.in++;
>            fromNode.edges.add(newEdge);
>            graph.edges.add(newEdge);
>        }
>        return graph;
>    }
>}
>```



#### 3.BFS

---

> ```java
> public class Code02_BFS {
> 
>     /**
>      *  从 node 开始 ，进行 广度 / 宽度 优先遍历
>      */
>     public static void bfs(Node start) {
>         if (start == null) {
>             return;
>         }
>         Queue<Node> queue = new LinkedList<>();
>         HashSet<Node> set = new HashSet<>();
>         queue.add(start);
>         set.add(start);
>         while(!queue.isEmpty()) {
>             Node cur = queue.poll();
>             System.out.println(cur.value);
>             for(Node next : cur.nexts){
>                 if(!set.contains(next)){
>                     set.add(next);
>                     queue.add(next);
>                 }
>             }
>         }
>     }
> }
> ```



#### 4.DFS

---

> ```java
> public class Code03_DFS {
>     public static void dfs(Node start){
>         if (start == null) {
>             return;
>         }
>         Stack<Node> stack = new Stack<Node>();
>         HashSet<Node> set = new HashSet<>();
>         stack.add(start);
>         set.add(start);
>         System.out.println(start.value);
>         while(!stack.isEmpty()){
>             Node cur = stack.pop();
>             for(Node next : cur.nexts){
>                 if(!set.contains(next)) {
>                     stack.push(cur);
>                     stack.push(next);
>                     set.add(next);
>                     System.out.println(next.value);
>                     break;
>                 }
>             }
>         }
>     }
> }
> ```



#### 5.拓扑排序

---

> ```java
> public class Code04_TopologySort {
> 
>     // direct graph no loop
>     public static List<Node> sortedTopology(Graph graph) {
> 
>         HashMap<Node, Integer> inMap = new HashMap<>();
>         Queue<Node> zeroInQueue = new LinkedList<>();
> 
>         /**
>          * public Collection<V> values() {
>          *         Collection<V> vs = values;
>          *         if (vs == null) {
>          *             vs = new Values();
>          *             values = vs;
>          *         }
>          *         return vs;
>          *     }
>          */
> 
>         for(Node node : graph.nodes.values()){
>             inMap.put(node, node.in);
>             if(node.in == 0){
>                 zeroInQueue.add(node);
>             }
>         }
>         List<Node> result = new ArrayList<>();
>         while (!zeroInQueue.isEmpty()) {
>             Node cur = zeroInQueue.poll();
>             result.add(cur);
>             for(Node next : cur.nexts){
> 
>                 /**
>                  *  HashMap.get(e);  @return  e.value / null
>                  * public V get(Object key) {
>                  *         Node<K,V> e;
>                  *         return (e = getNode(key)) == null ? null : e.value;
>                  *     }
>                  */
>                 inMap.put(next,inMap.get(next) - 1);
>                 if(inMap.get(next) == 0){
>                     zeroInQueue.add(next);
>                 }
>             }
>         }
>         return result;
>     }
> }
> ```
