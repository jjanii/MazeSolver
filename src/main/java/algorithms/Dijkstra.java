/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import domain.Maze;
import domain.Pixel;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * @author Jani
 */
public class Dijkstra {

    private Maze maze;

    public Dijkstra(Maze maze) {
        this.maze = maze;
    }

    public Stack<Pixel> algorithm() {
        Pixel start = maze.getStart();
        start.setWeight(0); 
        PriorityQueue<Pixel> pq = new PriorityQueue<>();
        pq.add(start);

        while (!pq.isEmpty()) {
            Pixel p = pq.poll(); //Ota uusi pikseli läpikäytäväksi

            if (p == maze.getEnd()) {
                break; //Lopeta läpikäynti jos nykyinen kohta on maali
            }

            ArrayList<Pixel> neighbours = p.getNeighbours(); //Hae pikselin naapurit
            for (Pixel neighbour : neighbours) { // Käy läpi kaikki naapurit
                relax(neighbour, p, pq); 
            }
            
            p.setVisited(true); //Merkitse nykyinen kohta läpikäydyksi
        }
        System.out.println("Ratkaistu");
        return shortestPath();
    }

    public void relax(Pixel neighbour, Pixel pixel, PriorityQueue<Pixel> pq) {
        int weight = 0;
        if (pixel.getX() != neighbour.getX() && pixel.getY() != neighbour.getY()) {
            weight = 2;
        } else {
            weight = 1;
        }
        
        int newWeight = pixel.getWeight() + weight;
        if (neighbour.getWeight() > newWeight && !neighbour.isVisited() && !neighbour.isWall()) {
            neighbour.setWeight(newWeight);
            neighbour.setPath(pixel);
            pq.add(neighbour);
        }
    }

    public Stack<Pixel> shortestPath() {
        Stack<Pixel> path = new Stack<>();
        Pixel p = maze.getEnd();
        while (p != null) {
            path.add(p);
            p = p.getPath();
        }

        return path;
    }
}
