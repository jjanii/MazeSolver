/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import datastructures.List;
import datastructures.Stack;
import domain.Maze;
import domain.Pixel;
import java.util.PriorityQueue;

/**
 * A Star algoritmi lyhimmän reitin etsimiseen toteutettuna javalla
 * @author Jani
 */
public class AStar {

    private Maze maze;

    public AStar(Maze maze) {
        this.maze = maze;
    }

    /**
     * A Star algoritmi lyhimmän reitin löytämiseen
     * @return kutsuu shortestPath() metodia joka hakee lyhimmän polun
     */
    public Stack algorithm() {
        Pixel start = maze.getStart();
        start.setWeight(0);
        start.setPrevDist(0);
        PriorityQueue<Pixel> pq = new PriorityQueue<>();
        pq.add(start);

        while (!pq.isEmpty()) {
            Pixel p = pq.poll();

            if (p == maze.getEnd()) {
                break;
            }
            List neighbours = p.getNeighbours();

            for (int i = 0; i < neighbours.size(); i++) {
                relax(neighbours.get(i), p, pq);
            }
            p.setVisited(true);
        }
        return shortestPath();
    }

    /**
     * Metodissa valitaan paras naapuri seuraavaksi askeleeksi
     * @param neighbour pikselin naapuri
     * @param pixel läpikäytävän oleva pikseli
     * @param pq
     */
    public void relax(Pixel neighbour, Pixel pixel, PriorityQueue<Pixel> pq) {
        if (!neighbour.isVisited() && !neighbour.isWall()) {
            
            int weight = (neighbour.getX() != pixel.getX() && neighbour.getY() != pixel.getY()) ? 2 : 1;
            int currentDistance = pixel.getPrevDist() + weight;
            int distanceToEnd = estimateDistance(neighbour, maze.getEnd());
            int result = distanceToEnd + currentDistance;

            if (neighbour.getWeight() > result) {
                neighbour.setPath(pixel);
                neighbour.setWeight(result);
                neighbour.setPrevDist(currentDistance);
                pq.add(neighbour);
            }
        }
    }

    /**
     * Metodissa haetaan kahden pikselin välinen etäisyys
     * @param p1 
     * @param p2
     * @return palauttaa pikselien välisen etäisyyden
     */
    public int estimateDistance(Pixel p1, Pixel p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }

    /**
     * Lyhin reitti jonoon
     *
     * @return palauttaa jonon, päälimmäisenä alkupiste, pohjalla lopetuspiste
     */
    public Stack shortestPath() {
        Stack path = new Stack();
        Pixel p = maze.getEnd();
        while (p != null) {
            path.push(p);
            p = p.getPath();
        }

        return path;
    }
}
