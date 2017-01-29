/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Jani
 */
public class Pixel implements Comparable<Pixel> {

    private int y;
    private int x;
    private Color color;
    private int weight;
    private boolean wall;
    private ArrayList<Pixel> neighbours = new ArrayList<>();
    private boolean visited;
    private Pixel path;

    public Pixel(int x, int y, Color color) {
        this.x = x;
        this.y = y;
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

    public ArrayList getNeighbours() {
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

    @Override
    public int compareTo(Pixel p) {
        return this.weight - p.getWeight();

    }
}
