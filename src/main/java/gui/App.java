/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Luodaan graafinen käyttöliittymä
 * @author Jani
 */
public class App implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("MazeSolver");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(4, 3, 0, 2);
        
        container.setLayout(layout);

        JLabel filename = new JLabel("Filename ");
        filename.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        JTextField filenameField = new JTextField();
       
        JLabel output = new JLabel("Output ");
        output.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        JTextField outputfield = new JTextField();
           
        JLabel solvewith = new JLabel("Solve with: ");
        solvewith.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
        JRadioButton dijkstra = new JRadioButton("Dijkstra");
        JRadioButton astar = new JRadioButton("A Star");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(dijkstra);
        buttonGroup.add(astar);
        buttonGroup.setSelected(dijkstra.getModel(), true);

        
        JButton solveButton = new JButton("Solve!");
        Solver solver = new Solver(filenameField, outputfield, buttonGroup);
        solveButton.addActionListener(solver);

        container.add(filename);
        container.add(new JLabel("(ex. maze1.gif):"));
        container.add(filenameField);
        
        container.add(output);  
        container.add(new JLabel("(ex. solved.gif):"));
        container.add(outputfield);
        
        container.add(solvewith);
        container.add(dijkstra);
        container.add(astar);
        
        container.add(new JLabel(""));
        container.add(solveButton);

    }

    public JFrame getFrame() {
        return frame;
    }

}
