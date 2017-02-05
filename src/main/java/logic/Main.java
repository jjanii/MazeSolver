package logic;


import algorithms.AStar;
import algorithms.Dijkstra;
import domain.Maze;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Jani
 */
public class Main {
    
    public static void main(String[] args) {

        System.out.print("Tiedoston nimi: ");
        Scanner lukija = new Scanner(System.in);
        String file = lukija.nextLine();
        System.out.print("Anna tallennustiedoston nimi (jotain.png): ");
        String output = lukija.nextLine();

        System.out.print("Ratkaise käyttämällä: 1. Dijkstraa, 2. A* ");
        int algo = Integer.parseInt(lukija.nextLine());
        
        MazeMaker mazeMaker = new MazeMaker(file, output);
        Maze maze = mazeMaker.imageToMaze();

        solve(maze, mazeMaker, algo);

    }

    /**
     * Ratkaistaan annettu labyrintti valitulla algoritmilla
     * @param maze kuvasta luotu labyrintti 
     * @param mazeMaker
     * @param algo valittu algoritmi, 1 = Dijkstra 2 = A Star
     */
    public static void solve(Maze maze, MazeMaker mazeMaker, int algo) {
        if (maze == null) {
            System.out.println("Maze = null.");
        } else {
            if (algo == 1) {  // Piirrä uuteen tiedostoon Dijkstralla ratkottu reitti
                mazeMaker.saveSolution(new Dijkstra(maze).algorithm());
            } else if (algo == 2) { // Piirrä uuteen tiedostoon A Starilla ratkottu reitti
                mazeMaker.saveSolution(new AStar(maze).algorithm());
            }
        }
    }

}
