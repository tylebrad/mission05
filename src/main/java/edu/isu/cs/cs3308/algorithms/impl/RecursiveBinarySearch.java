// Author - Bradley Tyler
// CS 3308
// 2/13/2019
// Isaac Griffith
package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

public class RecursiveBinarySearch implements ArraySearch {
    @Override
    public <E extends Comparable> int search(E[] array, E item) {
        if(array == null || item ==null){
            return -1;
        }
        else return recBinarySearch(array, item, 0, array.length -1);
    }

    public <E extends Comparable> int recBinarySearch(E[] array, E item, int low, int high){
        int index = (low + high) / 2;
        if(low >= high)
            return -1;
        if (item == array[index])
            return index;
        if (item.compareTo(array[index]) < 0)
            return recBinarySearch(array, item, low, index - 1);
        else
            return recBinarySearch(array, item, index + 1, high);
    }
}

