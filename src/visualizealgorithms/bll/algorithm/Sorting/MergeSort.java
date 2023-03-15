package visualizealgorithms.bll.algorithm.Sorting;

import visualizealgorithms.bll.algorithm.AlgorithmType;
import visualizealgorithms.bll.algorithm.GenericAlgorithm;

import java.time.Duration;
import java.time.Instant;

public class MergeSort extends GenericAlgorithm {


    public MergeSort() {
        super("Merge Sort", "Merging algorithm", AlgorithmType.SORTING);
    }

    public void sort(int[] arr, int left, int right){

        Instant start = Instant.now();

        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length -1);

        Instant finish = Instant.now();

        long elapsedTime = Duration.between(start, finish).toMillis();

        System.out.println("Finished MergeSort on " +arr.length + "items in " + elapsedTime + " ms");
    }


    public void mergeSort(int[] arr, int[] tmp, int left, int right){
        if (left < right) {
            int center = (left + right) /2; //find the center index in our array

            mergeSort(arr, tmp, left, center); // sort left part
            mergeSort(arr, tmp, center + 1, right); // sort right part
            merge(arr, tmp, left, center +1, right);
        }
    }

    private void merge(int[] arr, int[] tmp, int left, int right, int rightEnd){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left +1;

        while (left <= leftEnd && right <= rightEnd){
            if(arr[left] <= arr[right])
                tmp[k++] = arr[left++];
            else tmp[k++] = arr[right++];
        }
        while (left <= leftEnd){
            tmp[k++] = arr[left++];
        }
        while (right <= rightEnd) {
            tmp[k++] = arr[right++];
        }

        for (int i = 0; i < num; i++, rightEnd--){
            arr[rightEnd] = tmp[rightEnd];
        }
    }

    @Override
    public void doWork() {
        int[]b = (int[]) super.getData();
        sort(b,0 ,b.length -1);
    }
}
