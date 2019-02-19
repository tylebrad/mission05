// Author - Bradley Tyler
// CS 3308
// 2/13/2019
// Isaac Griffith
package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

public class BinarySearch implements ArraySearch {
    @Override
    public <E extends Comparable> int search(E[] array, E item) {
        if(array == null || item == null)
            return -1;

        int index = 0;
        int low = 0;
        int high = array.length - 1;

        while(low <= high) {
            index = (low + high) / 2;
            if (item == array[index])
                return index;
            else if(item < array[index])
                    high = index - 1;

            else
                low = index + 1;

        }
        return -1;
    }
}
