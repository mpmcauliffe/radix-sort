package algorithms;

public class Main {

    public static void main(String[] args) {

        /** RADIX **/
        int[] radixArray = { 4725, 4586, 1330, 8792, 1594, 5729 };

        // for printing purposes only
        for (int num: radixArray) { System.out.print(num + "   "); }
        System.out.print("\n");


        radixSort(radixArray, 10,4);


        // for printing purposes only
        for (int num: radixArray) { System.out.print(num + "   "); }
        System.out.print("\n");
    }

    public static void radixSort(int[] input, int radix, int width) {

        /**     { 4725, 4586, 1330, 8792, 1594, 5729 }      **/

        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        /**     { 4725, 4586, 1330, 8792, 1594, 5729 }      **/

        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }

        // adjust countArray
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray [j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }
    }

    /**
     *      METHOD()
     *          CALLED FROM radixSingleSort
     *
     *          ARGUMENTS:
     *              --int position:     position is the index value of the current number
     *              --int value:        the value of the current number
     *              --int radix:        the placement of the individual number with respect to its set
     *
     *          RETURNS:
     *              an single digit isolated from its set
     *
     *          EXAMPLE:
     *              { 4725 } --- isolate 2
     *
     *              4725 / (10^1) % 10  = 2
     **/
    public static int getDigit(int position, int value, int radix) {

        return value / (int) Math.pow(radix, position) % radix;
    }
}
