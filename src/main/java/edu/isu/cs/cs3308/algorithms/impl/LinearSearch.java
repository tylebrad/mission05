// Author - Bradley Tyler
// CS 3308
// 2/13/2019
// Isaac Griffith
// Class Description - Linear Search for given item in an array
package edu.isu.cs.cs3308.algorithms.impl;

import edu.isu.cs.cs3308.algorithms.ArraySearch;

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
