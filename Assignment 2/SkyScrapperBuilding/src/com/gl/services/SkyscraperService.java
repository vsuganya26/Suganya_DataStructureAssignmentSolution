package com.gl.services;

import java.util.Stack;

public class SkyscraperService {
	//Stack Declaration to store Floor Sizes available
    Stack<Integer> descFloorSizesStack;

    public void displayConstructionOrder(int noOfFloors, int[] dayWiseFloorSizes){

        //Sort the floor sizes in ascending order and populate to a stack
        populateStack(dayWiseFloorSizes);

        var tempStack = new Stack<Integer>();

        //Main implementation Start//
        for (int i = 0; i < noOfFloors; i++) {
            System.out.println("Day: " + (i + 1));
            int floorSizeOfTheDay = dayWiseFloorSizes[i];

            int largestFloorSize = descFloorSizesStack.peek();
            if (floorSizeOfTheDay != largestFloorSize) {
                tempStack.push(floorSizeOfTheDay);
            } else {
                System.out.print(descFloorSizesStack.pop() + " ");
                while (!tempStack.isEmpty() && descFloorSizesStack.peek() == tempStack.peek()) {
                    var poppedItem = descFloorSizesStack.pop();
                    tempStack.pop();
                    System.out.print(poppedItem + " ");
                }
            }
            System.out.println("");
        }
        //Main implementation End//
    }

    private void populateStack(int[] dayWiseFloorSizes){

        //Make a copy of Day wise floorSizes and sort it into ascending order
        int[] ascFloorSizesArr = dayWiseFloorSizes.clone();
        sortArray(ascFloorSizesArr, 0, ascFloorSizesArr.length - 1);

        //Store the ascending order floor sizes into stack so that pop will return the highest floor size
        descFloorSizesStack = new Stack<Integer>();
        for (int i : ascFloorSizesArr) {
            descFloorSizesStack.push(i);
        }
    }

    private void sortArray(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            //sort left part
            sortArray(array, left, mid);

            //sort right part
            sortArray(array, mid + 1, right);

            //merge both sides
            mergeArray(array, left, mid, right);
        }
    }

    private void mergeArray(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] Left = new int[n1];
        int[] Right = new int[n2];
        System.arraycopy(array, left, Left, 0, n1);
        for (int j = 0; j < n2; ++j) {
            Right[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                array[k] = Left[i];
                i++;
            } else {
                array[k] = Right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = Left[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = Right[j];
            j++;
            k++;
        }
    }
}
