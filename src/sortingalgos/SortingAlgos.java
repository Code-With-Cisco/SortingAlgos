/*
Programmer: 5767275
Prof. Charters
COP 3804
Challenge 5
 */
package sortingalgos;

import java.util.Random;

/**
 *
 * @author mtsguest
 */
public class SortingAlgos {

    public static int[] myOriginalUnsortedArray1;
    public static int[] myCopyUnsortedArray2;
    public static long bubbleSortDuration, quickSortDuration, selectionSortDuration, insertionSortDuration, mergeSortDuration;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//Proof of Concept - that all sorting algorithms work as intended: 
        
        myOriginalUnsortedArray1 = generateRanNums(10);
        
//        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
//        quickSort(myCopyUnsortedArray2);  //Extra Credit!
//        
//        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
//        mergeSort(myCopyUnsortedArray2);  //Extra Credit!
        
        System.out.println("Selection Sort");
        myCopyUnsortedArray2 = new int[myOriginalUnsortedArray1.length];                
        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
        System.out.println("Before Selection Sort: ");
        printArray(myCopyUnsortedArray2);
        selectionSort(myCopyUnsortedArray2);
        System.out.println("After Selection Sort: ");
        printArray(myCopyUnsortedArray2);
        System.out.println("Elapsed time: " + selectionSortDuration);
        
        
        System.out.println("Insertion Sort");
        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
        System.out.println("Before Insertion Sort: ");
        printArray(myCopyUnsortedArray2);
        insertionSort(myCopyUnsortedArray2);
        System.out.println("After Insertion Sort: ");
        printArray(myCopyUnsortedArray2);
        System.out.println("Elapsed time: " + insertionSortDuration);
        
        System.out.println("Bubble Sort");
        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
        System.out.println("Before Bubble Sort: ");
        printArray(myCopyUnsortedArray2);
        bubbleSort(myCopyUnsortedArray2);
        System.out.println("After Bubble Sort: ");
        printArray(myCopyUnsortedArray2);
        System.out.println("Elapsed time: " + bubbleSortDuration);
        
        
        compareSortTimes();
        
//******Actual Challenge:
        myOriginalUnsortedArray1 = generateRanNums(20000);
        
//        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
//        quickSort(myCopyUnsortedArray2);  //Extra Credit!
//        
//        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
//        mergeSort(myCopyUnsortedArray2);  //Extra Credit!

        myCopyUnsortedArray2 = new int[myOriginalUnsortedArray1.length]; 
        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
        selectionSort(myCopyUnsortedArray2);
        
        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
        insertionSort(myCopyUnsortedArray2);
        
        copyRanNums(myOriginalUnsortedArray1, myCopyUnsortedArray2);
        bubbleSort(myCopyUnsortedArray2);
        
        compareSortTimes();
    }
    
    public static void printArray(int[] anArray)
    {
        for (int i = 0; i < anArray.length; i++) {
            System.out.print(anArray[i] + " ");
        }
        System.out.println();
    }
    
    public static int[] generateRanNums(int num)
    {
        int[] anArray;
         //1. Using Random class, generate in a for-loop 20K numbers in the range of 1 to 5000
        Random myRan = new Random();
        int aNum;
        
        if (num == 10)
        {
             anArray = new int[num];
            // create a 10-element array
            // for-loop for generating 10 numbers between 1 & 100
            for (int i = 0; i < anArray.length; i++) {
                anArray[i] = myRan.nextInt(100) + 1;
        }
        }
        else
        {
             anArray = new int[20000];
            // create a 20,000 - element array
            // for-loop for generating 20,000 numbers between 1 & 5000
            for (int i = 0; i < anArray.length; i++) {
                anArray[i] = myRan.nextInt(5000) + 1;
        }
        }    
       
            return anArray;
        
    }
    
    public static void copyRanNums(int[] fromArray, int[] toArray)
    {
        
        for (int i = 0; i < fromArray.length; i++) {
            toArray[i] = fromArray[i];
        }
        
    }
    
    public static void selectionSort(int[] anyArray)
    {
     long startSort, endSort;
            startSort = System.nanoTime();

            for (int i = 0; i < anyArray.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < anyArray.length; j++) {
                    if (anyArray[j] < anyArray[minIndex]) {
                        minIndex = j;
                    }
                }

                int temp = anyArray[minIndex];
                anyArray[minIndex] = anyArray[i];
                anyArray[i] = temp;
            }
            endSort = System.nanoTime();
            selectionSortDuration = endSort - startSort;
            //System.out.println(selectionSortDuration + " nanosec");
        
    }
    
    public static void insertionSort(int[] anyArray)
    {
        int j;
        long startSort, endSort;
        startSort = System.nanoTime();

        for (int i = 1; i < anyArray.length; ++i) {
            int key = anyArray[i];

            for (j = i - 1; j >= 0 && anyArray[j] > key; j--) {
                anyArray[j + 1] = anyArray[j];
            }
            anyArray[j + 1] = key;
        }
        endSort = System.nanoTime();
        insertionSortDuration = endSort - startSort;
        //System.out.println(insertionSortDuration + " nanosec");
    }
    
    public static void bubbleSort(int[] anyArray)
    {
       long startSort, endSort;
        startSort = System.nanoTime();

        for (int i = 0; i < anyArray.length - 1; i++) {
            for (int j = 0; j < anyArray.length - i - 1; j++) {
                if (anyArray[j] > anyArray[j + 1]) {
                    int temp = anyArray[j];
                    anyArray[j] = anyArray[j + 1];
                    anyArray[j + 1] = temp;
                }
            }
        }
        endSort = System.nanoTime();
        bubbleSortDuration = endSort - startSort;
        //System.out.println(bubbleSortDuration + " nanosec");
    }
    
    public static void compareSortTimes()
    {
        long smallest = Math.min(selectionSortDuration, Math.min(bubbleSortDuration, insertionSortDuration));
        
        
        System.out.println("Actual sort for 20,000 numbers randomly generated.");
        System.out.println("Bubble Sort - Elapsed time: " + bubbleSortDuration + " nanoseconds");
        System.out.println("Selection Sort - Elapsed time: " + selectionSortDuration + " nanoseconds");
        System.out.println("Insertion Sort - Elapsed time: " + insertionSortDuration + " nanoseconds");
        System.out.println("The most efficient sorting algorithm was " +  smallest);
        
        
    }
}
