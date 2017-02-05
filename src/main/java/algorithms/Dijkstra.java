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
 * Dijkstran algoritmi lyhimmän reitin etsimiseen toteutettuna javalla
 *
 * @author Jani
 */
public class Dijkstra {

    private Maze maze;

    public Dijkstra(Maze maze) {
        this.maze = maze;
    }

    /**
     * Dijkstran algoritmi lyhimmän reitin ratkaisemiseen
     *
     * @return kutsuu shortestPath() metodia joka hakee lyhimmän polun
     */
    public Stack algorithm() {
        Pixel start = maze.getStart();
        start.setWeight(0);
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
     * Metodissa asetetaan Pixeleille painot naapureihin
     *
     * @param neighbour pikselin naapuri
     * @param pixel läpikäytävänä oleva pikseli
     * @param pq
     */
    public void relax(Pixel neighbour, Pixel pixel, PriorityQueue<Pixel> pq) {
        int weight = (neighbour.getX() != pixel.getX() && neighbour.getY() != pixel.getY()) ? 2 : 1;

        int newWeight = pixel.getWeight() + weight;
        if (neighbour.getWeight() > newWeight && !neighbour.isVisited() && !neighbour.isWall()) {
            neighbour.setWeight(newWeight);
            neighbour.setPath(pixel);
            pq.add(neighbour);
        }
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
