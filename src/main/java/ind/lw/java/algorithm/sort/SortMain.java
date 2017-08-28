package ind.lw.java.algorithm.sort;

public class SortMain {


    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();

        int[] unsorted = {1,2,4,3};
        mergeSort.sort(unsorted);

        for (int i:unsorted){
            System.out.println(i);
        }

    }
}
