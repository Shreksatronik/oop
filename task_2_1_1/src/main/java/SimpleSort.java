public class SimpleSort {
    static boolean hasNotPrime = false;

    public static boolean hasprime(long[] array) {


        for (int i = 0; i < array.length; i++) {
            if (Validation.isNotPrime(array[i])) {
                hasNotPrime = true;
                break;
            }
        }

        return hasNotPrime;
    }

}
