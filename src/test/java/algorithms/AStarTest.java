/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import domain.Maze;
import domain.Pixel;
import java.awt.Color;
import java.util.PriorityQueue;
import logic.MazeMaker;
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
public class AStarTest {

    public AStarTest() {
    }

    @Test
    public void relaxTest() {
        //TODO
    }

    @Test
    public void shortestPathEiPalautaTyhjaaPolkuaJosOnRatkaisu() {
        MazeMaker maze = new MazeMaker("maze1.gif", "solution.gif");
        Maze m = maze.imageToMaze();
        AStar a = new AStar(m);
        assertTrue(!a.algorithm().empty());
    }
}
