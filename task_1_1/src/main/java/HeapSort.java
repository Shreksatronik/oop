public class HeapSort {
    /**
     * Если переменные и константы хранят некоторые значения,
     * то методы содержат собой набор операторов,
     * которые выполняют определенные действия.
     */
    public void sort(int[] array) {
        int N = array.length;
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(array, N, i);

        for (int i = N - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int N, int i) {
        int root = i;//root
        int l = 2 * i + 1;//left son
        int r = 2 * i + 2;//right son

        if (l < N && array[l] > array[root])
            root = l;
        if (r < N && array[r] > array[root])
            root = r;
        if (root != i) {
            int tmp = array[i];
            array[i] = array[root];
            array[root] = tmp;
            heapify(array, N, root);
        }

    }
}



