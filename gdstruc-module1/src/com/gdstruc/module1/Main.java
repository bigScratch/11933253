package com.gdstruc.module1;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[10];

        numbers[0] = 10;
        numbers[1] = -50;
        numbers[2] = 5;
        numbers[3] = 20;
        numbers[4] = 0;
        numbers[5] = 33;
        numbers[6] = -22;
        numbers[7] = 11;
        numbers[8] = 7;
        numbers[9] = 46;

        System.out.println("Unsorted Array:");
        printArrayElements(numbers);

        System.out.println("\n\nSelection Sorted Array:");
        selectionSort(numbers);
        printArrayElements(numbers);

        System.out.println("\n\nBubble Sorted Array:");
        bubbleSort(numbers);
        printArrayElements(numbers);
    }

    private static void bubbleSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                if (arr[i] < arr[i + 1])
                {
                      int temp = arr[i];
                      arr[i] = arr[i + 1];
                      arr[i + 1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] arr)
    {
        for(int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            int smallestIndex = 0;

            // Find smallest value
            for (int i = 0; i < lastSortedIndex; i++)
            {
                if (arr[i] < arr[smallestIndex])
                {
                    smallestIndex = i;
                }
            }

            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }


    private static void printArrayElements(int[] arr)
    {
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
