/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;


import logic.MazeMaker;
import domain.Maze;
import domain.Pixel;
import java.awt.Color;
import java.util.PriorityQueue;
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
public class DijkstraTest {

    public DijkstraTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void relaxTest() {
        Maze maze = new Maze();
        
        Dijkstra d = new Dijkstra(maze);
        PriorityQueue<Pixel> pq = new PriorityQueue<>();
        
        Pixel p1 = new Pixel(0, 0, Color.BLUE);
        p1.setWeight(10);
        
        Pixel p2 = new Pixel(0, 0, Color.RED);
        p2.setWeight(20);
        
        d.relax(p2, p1, pq);
        assertEquals(p2.getPath(), p1);
    }
    
    @Test
    public void shortestPathEiPalautaTyhjaaPolkuaJosOnRatkaisu() {
        MazeMaker maze = new MazeMaker("maze1.gif", "solution.gif");
        Maze m = maze.imageToMaze();
        Dijkstra d = new Dijkstra(m);
        assertTrue(!d.algorithm().empty());
   }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
