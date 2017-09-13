package ind.lw.java.algorithm.sort;

import java.awt.*;

/***
 * 堆排序:
 * 利用二叉树的存储结构
 *
 * 长度为9的数组，按照下标顺序依次摆放，可以构成如下图所示的完全二叉树
 * 叶子节点的下标一定符合: >= Array.length/2
 * a[0] a[1] a[2] a[3] a[4] a[5] a[6] a[7] a[8]
 *
 *
 *                                  a[0]
 *                                  /   \
 *                              a[1]     a[2]
 *                             /   \    /   \
 *                         a[3]  a[4] a[5]   a[6]
 *                        /   \
 *                     a[7]   a[8]
 */
public class HeapSort implements Sort{

    private int[] array;

    @Override
    public void sort(int[] unsorted) {
        if (unsorted == null || unsorted.length == 1)
            return;
        this.array = unsorted;
        buildHeap();
    }


    private void buildHeap(){

        for (int i= array.length/2-1;i>=0;i--){
            heapify(i);
        }

    }

    private void heapify(int idx){

        int small = idx;
        int r = right(idx);
        int l = left(idx);
        if ( r < array.length && array[idx] > array[r])
            small = r;

        if ( l < array.length && array[l] < array[small])
            small = l;

        if (small != idx){
            swap(array,idx,small);

            heapify(small);
        }else
            return;
    }


    private int right(int idx){
        return (idx << 1)+2;
    }
    private int left(int idx){
        return (idx << 1)+1;
    }

    public void swap(int[] arr,int a,int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

    }

    public static void main(String[] args) {

        HeapSort heapSort = new HeapSort();

        int[] arr = {8,7};
        heapSort.sort(arr);


        for (int i=0;i< arr.length;i++)
            System.out.println(arr[i]);
    }
}
