package visualizealgorithms.bll.algorithm.Sorting;

import visualizealgorithms.bll.algorithm.AlgorithmType;
import visualizealgorithms.bll.algorithm.GenericAlgorithm;

public class BubbleSort extends GenericAlgorithm {


    public BubbleSort() {
        super("BubbleSort", "slow 0(N^2) sorting algorithm", AlgorithmType.SORTING);
    }

    @Override
    public void doWork() {

        // 0(N^2)
        int[]b = (int[]) super.getData();

        for(int i = 1; i <b.length; i++){ // 0(N)
            for (int j = 0; j < b.length - i; // 0(N)
            j++)
            {
                if (b[j] > b[j + 1]){
                    int tmp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = tmp;
                }
            }
        }

    }
}
