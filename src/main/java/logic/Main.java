package logic;

import algorithms.AStar;
import algorithms.Dijkstra;
import domain.Maze;
import gui.App;
import java.util.Scanner;
import javax.swing.SwingUtilities;

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
        App kayttoliittyma = new App();
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
