/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import domain.Pixel;

/**
 * Minikeko
 * @author Jani
 */
public class MinHeap {
    
    
    public int parent(int i) {
        return i/2;
    }
    
    public int left(int i) {
        return 2*i;
    }
    
    public int right(int i) {
        return 2*i + 1;
    }
    
    public void heapitfy(int i) {
        //heapify
    }
    
    public void insert(Pixel p) {
        
    }
}
