// Author - Bradley Tyler
// CS 3308
// 2/13/2019
// Isaac Griffith
// Class Description - Using recursion to search an array linearly
package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

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
