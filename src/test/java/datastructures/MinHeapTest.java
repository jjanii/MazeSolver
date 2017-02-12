/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import domain.Pixel;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jani
 */
public class MinHeapTest {

    public MinHeapTest() {
    }

    @Test
    public void afterInsertingPixelsSmallestPixelIsOnTop() {
        MinHeap heap = new MinHeap();
        Pixel p1 = new Pixel(0, 0, Color.red);
        Pixel p2 = new Pixel(0, 0, Color.red);
        Pixel p3 = new Pixel(0, 0, Color.red);
        Pixel p4 = new Pixel(0, 0, Color.red);
        p1.setWeight(1);
        p2.setWeight(50);
        p3.setWeight(25);
        p4.setWeight(9999);

        heap.insert(p4);
        heap.insert(p3);
        heap.insert(p1);
        heap.insert(p2);

        assertEquals(p1, heap.heapDelMin());
    }

    @Test
    public void afterRemovingSmallestValueTheSecondHighestValueIsOnTop() {
        MinHeap heap = new MinHeap();
        Pixel p1 = new Pixel(0, 0, Color.red);
        Pixel p2 = new Pixel(0, 0, Color.red);
        Pixel p3 = new Pixel(0, 0, Color.red);
        Pixel p4 = new Pixel(0, 0, Color.red);
        p1.setWeight(1);
        p2.setWeight(50);
        p3.setWeight(25);
        p4.setWeight(9999);

        heap.insert(p4);
        heap.insert(p3);
        heap.insert(p1);
        heap.insert(p2);

        heap.heapDelMin();
        assertEquals(p3, heap.heapDelMin());

    }

    @Test
    public void heapIsEmptyAfterDeletingAllPixels() {
        MinHeap heap = new MinHeap();
        Pixel p1 = new Pixel(0, 0, Color.red);
        Pixel p2 = new Pixel(0, 0, Color.red);
        Pixel p3 = new Pixel(0, 0, Color.red);
        Pixel p4 = new Pixel(0, 0, Color.red);
        p1.setWeight(1);
        p2.setWeight(50);
        p3.setWeight(25);
        p4.setWeight(9999);

        heap.insert(p4);
        heap.insert(p3);
        heap.insert(p1);
        heap.insert(p2);

        heap.heapDelMin();
        heap.heapDelMin();
        heap.heapDelMin();
        heap.heapDelMin();
        assertTrue(heap.isEmpty());
    }
}
