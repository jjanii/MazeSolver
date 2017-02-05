/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 * Luokka sisältää kaksiulotteisen taulukon joka kuvastaa annettua kuvaa, sekä aloitus- ja
 * lopetuspisteet erillisinä arvoina.
 * @author Jani
 */
public class Maze {

    private Pixel start;
    private Pixel end;
    private Pixel[][] maze;

    public Pixel[][] getMaze() {
        return maze;
    }

    public void setMaze(Pixel[][] maze) {
        this.maze = maze;
    }

    public Pixel getStart() {
        return start;
    }

    public void setStart(Pixel pixel) {
        this.start = pixel;
    }

    public Pixel getEnd() {
        return end;
    }
    
    public void setEnd(Pixel pixel) {
        this.end = pixel;
    }
}
