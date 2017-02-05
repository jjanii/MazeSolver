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
public class StackTest {
    
    public StackTest() {
    }

    @Test
    public void stackIsEmptyAtFirst() {
        Stack s = new Stack();
        assertTrue(s.empty());
    }
    
    @Test
    public void pushIncreasesStackSize() {
        Stack s = new Stack();
        Pixel p = new Pixel(1,2,Color.red);
        s.push(p);
        assertEquals(1, s.size());
        for (int i = 0; i < 50; i++) {
            s.push(p);
        }
        assertEquals(51, s.size());
    }
    
    @Test
    public void popReturnsCorrectPixel() {
        Stack s = new Stack();
        Pixel p1 = new Pixel(0,0,Color.red);
        Pixel p2 = new Pixel(5,5,Color.blue);
        
        s.push(p2);
        s.push(p1);
        
        Pixel p3 = s.pop();
        assertEquals(p1, p3);
        Pixel p4 = s.pop();
        assertEquals(p2, p4);
    }
}
