package visualizealgorithms.bll.algorithm.Sorting;

import visualizealgorithms.bll.algorithm.AlgorithmType;
import visualizealgorithms.bll.algorithm.GenericAlgorithm;

import java.time.Duration;
import java.time.Instant;

public class QuickSort extends GenericAlgorithm {

    public QuickSort() {
        super("Quick sort", "Fastest 0(N^2) sorting algorithm", AlgorithmType.SORTING);
    }

    @Override
    public void doWork() {
        int[]b = (int[]) super.getData();
        sort(b,0  ,b.length -1);
    }

    int partition(int arr[], int low, int high){
        int pivot = arr[high];
        int i = (low -1); // index of smaller element
        for(int j = low; j < high; j++){

            if(arr[j] <= pivot){
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    private void sort(int[]arr, int low, int high){
        if (low < high) {

            int pi = partition(arr, low, high);


            sort(arr, low, pi -1);
            sort(arr, pi + 1, high);
        }
    }
}
