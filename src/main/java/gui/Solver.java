/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import algorithms.AStar;
import algorithms.Dijkstra;
import domain.Maze;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import logic.MazeMaker;

/**
 * Käyttöliittymän Solve-napin toiminta
 * @author Jani
 */
public class Solver implements ActionListener {

    private JTextField input;
    private JTextField output;
    private ButtonGroup algo;

    /**
     *
     * @param input ratkaistavan Mazen tiedostonimi
     * @param output talletettavan ratkaistun Mazen tiedostonimi
     * @param algo algoritmivaihtoehdot (buttongroup)
     */
    public Solver(JTextField input, JTextField output, ButtonGroup algo) {
        this.input = input;
        this.output = output;
        this.algo = algo;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        solve();
    }

     /**
     * Ratkaistaan annettu labyrintti valitulla algoritmilla
     */
    public void solve() {
        MazeMaker mazeMaker = new MazeMaker(input.getText(), output.getText());
        Maze maze = mazeMaker.imageToMaze();
        int selected = this.algo.getSelection().toString().equals("Dijkstra") ? 1 : 2;

        if (maze == null) {
            msgbox("Kuvatiedostoa ei löytynyt");
        } else {
            if (selected == 1) {  // Piirrä uuteen tiedostoon Dijkstralla ratkottu reitti
                mazeMaker.saveSolution(new Dijkstra(maze).algorithm());

            } else if (selected == 2) { // Piirrä uuteen tiedostoon A Starilla ratkottu reitti
                mazeMaker.saveSolution(new AStar(maze).algorithm());
            }
        }

    }

    private void msgbox(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

}
