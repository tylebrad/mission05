// Author - Bradley Tyler
// CS 3308
// 2/13/2019
// Isaac Griffith
package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;
/**
 * Searches an array linearly using recursion for a given item.
 * @param array Array to be search for the provided item
 * @param item Item to be found
 */
public class RecursiveLinearSearch implements ArraySearch {
    @Override
    public <E extends Comparable> int search(E[] array, E item) {
        if(array == null || item == null)
            return -1;
        else
            return recLinearSearch(array, item, 0);
    }
    public <E extends Comparable> int recLinearSearch(E[] array, E item, int index){
        if (index >= array.length)
            return -1;
        else if (array[index] == item)
            return index;
        else
            return recLinearSearch(array, item, index+1);

    }
}
