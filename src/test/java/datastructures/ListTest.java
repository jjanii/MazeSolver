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
public class ListTest {
    
    public ListTest() {
    }
    
    @Test
    public void listIsEmptyAtFirst() {
        List list = new List();
        assertEquals(0, list.size());
    }
   
    @Test
    public void addIncreasesListSize() {
        List list = new List();
        Pixel p = new Pixel(0,0,Color.red);
        list.add(p);
        assertEquals(1, list.size());
        for (int i = 0; i<50; i++) {
            list.add(p);
            assertEquals(list.size(), i+2);
        }
    }
    
    @Test
    public void getReturnsCorrectPixel() {
        List list = new List();
        Pixel p1 = new Pixel(0,0,Color.red);
        Pixel p2 = new Pixel(2,2,Color.blue);
        list.add(p1);
        list.add(p2);
        list.add(p1);
        list.add(p1);
        
        assertEquals(p2, list.get(1));
        assertEquals(p1, list.get(3));
    }
    
    @Test
    public void removeMovesPixels() {
        List list = new List();
        Pixel p1 = new Pixel(0,0,Color.red);
        Pixel p2 = new Pixel(1,1,Color.red);
        Pixel p3 = new Pixel(2,2,Color.red);
        Pixel p4 = new Pixel(3,3,Color.red);
        
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        
        assertEquals(p2, list.get(1));
        list.remove(1);
        assertEquals(p3, list.get(1));
    }
}
