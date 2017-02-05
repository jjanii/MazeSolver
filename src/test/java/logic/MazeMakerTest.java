package logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logic.MazeMaker;
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
    
    @Test
    public void mazeWithNoStartOrNoEndThrowsError() {
        MazeMaker maze = new MazeMaker("mazeNoMarkings.gif", "solution.gif");
        Maze m = maze.imageToMaze();
        
        assertEquals(m, null);
    }
}
