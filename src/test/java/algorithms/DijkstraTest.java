/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import datastructures.MinHeap;
import logic.MazeMaker;
import domain.Maze;
import domain.Pixel;
import java.awt.Color;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jani
 */
public class DijkstraTest {

    public DijkstraTest() {
    }

    @Test
    public void relaxTest() {
        Maze maze = new Maze();
        
        Dijkstra d = new Dijkstra(maze);
        MinHeap heap = new MinHeap();
        
        Pixel p1 = new Pixel(0, 0, Color.BLUE);
        p1.setWeight(10);
        
        Pixel p2 = new Pixel(0, 0, Color.RED);
        p2.setWeight(20);
        
        d.relax(p2, p1, heap);
        assertEquals(p2.getPath(), p1);
    }
    
    @Test
    public void shortestPathEiPalautaTyhjaaPolkuaJosOnRatkaisu() {
        MazeMaker maze = new MazeMaker("maze1.gif", "solution.gif");
        Maze m = maze.imageToMaze();
        Dijkstra d = new Dijkstra(m);
        assertTrue(!d.algorithm().empty());
   }
}
