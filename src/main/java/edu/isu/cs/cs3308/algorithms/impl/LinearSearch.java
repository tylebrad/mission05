// Author - Bradley Tyler
// CS 3308
// 2/13/2019
// Isaac Griffith
package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

/**
 * Searches an array linearly for a given item
 * @param array Array to be search for the provided item
 * @param item Item to be found
 */
public class LinearSearch implements ArraySearch {
    @Override
    public <E extends Comparable> int search(E[] array, E item) {
        if(array == null || item == null)
            return -1;
        int n = array.length;
        for(int i = 0; i < n; i++){
            if(array[i] == item){
                return i;
            }
        }
        return -1;
    }
}
