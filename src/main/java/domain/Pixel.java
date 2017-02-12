/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import datastructures.List;
import java.awt.Color;
/**
 * Edustaa yhtä pikseliä annetusta labyrinttikuvasta. 
 * 
 * @author Jani
 */
public class Pixel implements Comparable<Pixel> {

    private int y;
    private int x;
    private Color color;
    private int weight;
    private boolean wall;
    private List neighbours;
    private boolean visited;
    private Pixel path;
    private int prev;

    public Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.neighbours = new List();
        this.color = color;
        this.wall = false;
        this.visited = false;
    }

    public int getY() {
        return this.y;
    }
    
    public int getX() {
        return this.x;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public Pixel getPath() {
        return this.path;
    }

    public void setPath(Pixel pixel) {
        this.path = pixel;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return this.visited;
    }

    public void addNeighbour(Pixel pixel) {
        neighbours.add(pixel);
    }

    public List getNeighbours() {
        return this.neighbours;
    }

    public Color getColor() {
        return this.color;
    }

    public void setWall(boolean b) {
        this.wall = b;
    }

    public boolean isWall() {
        return this.wall;
    }
    
    public void setPrevDist(int dist) {
        this.prev = dist;
    }
    
    public int getPrevDist() {
        return this.prev;
    }

    @Override
    public int compareTo(Pixel p) {
        return this.weight - p.getWeight();

    }
}
