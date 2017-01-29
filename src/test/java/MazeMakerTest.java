/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Maze;
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
public class MazeMakerTest {
    
    public MazeMakerTest() {
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
    public void errorOnWrongFilePath() {
        MazeMaker maze = new MazeMaker("wrong_file_path.png", "solution.gif");
        assertEquals(maze.error, true);
    }
    
    @Test
    public void correctStartAndEndLocation1() {
        MazeMaker maze = new MazeMaker("maze1.gif", "solution.gif");
        Maze m = maze.imageToMaze();
        
        assertEquals(507, m.getStart().getX());
        assertEquals(1, m.getStart().getY());
        assertEquals(2, m.getEnd().getX());
        assertEquals(0, m.getEnd().getY());
    }
    
    @Test
    public void correctStartAndEndLocations2() {
        MazeMaker maze = new MazeMaker("maze2.gif", "solution.gif");
        Maze m = maze.imageToMaze();
        
        assertEquals(462, m.getStart().getX());
        assertEquals(138, m.getStart().getY());
        assertEquals(2, m.getEnd().getX());
        assertEquals(0, m.getEnd().getY());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
