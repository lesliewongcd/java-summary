package ind.lw.java.algorithm.sort;

public class MergeSort implements Sort{

    //排序入口
    @Override
    public void sort(int[] unsorted) {

        sort(unsorted,0,unsorted.length-1);

    }

    private void sort(int[] unsorted,int l,int r){
        if (l < r){
            int m = (r+l)/2;
            sort(unsorted,l,m);
            sort(unsorted,m+1,r);
            merge(unsorted,l,m,r);
        }
    }

    /***
     * 辅助方法：合并两个有序数组
     *
     * [Al,Al+1,...Am] [Am+1,Am+2,...Ar]
     *
     * @param array 包含两个已排序数组
     * @param l 左子数组的左边界
     * @param m 左子数组的右边界
     * @param r 右子数组的右边界
     */
    private void merge(int[] array,int l,int m,int r){



        int[] temp = new int[r-l+1];

        int i = l,j=m+1,k=0;

        while (i<=m && j<=r){
            if (array[i]<=array[j]) {
                temp[k++] = array[i++];
            }else {
                temp[k++] = array[j++];
            }
        }

        while(i <= m){
            temp[k++] = array[i++];
        }
        while(j <= r){
            temp[k++] = array[j++];
        }

        System.arraycopy(temp,0,array,l,temp.length);
    }
}
