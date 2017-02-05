/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import domain.Pixel;

/**
 * Implementaatio stack tietorakenteesta
 * @author Jani
 */
public class Stack {
    private Pixel[] table;
    private int size;
    
    public Stack() {
        table = new Pixel[1];
        size = 0;
    }
    
    /**
     * Lisää pinoon pikseli p, jos pino on täynnä, suurennetaan pinon kokoa
     * @param p lisättävä pikseli
     */
    public void push(Pixel p) {
        if (table.length == size) {
            increaseSize();
        }
        table[size] = p;
        size++;
    }
    
    /**
     * Suurennetaan pinon kokoa kaksinkertaiseksi.
     * Arrays.copyOf olisi tehnyt saman asian kuin allaoleva for-lauseke
     */
    public void increaseSize() {
        Pixel[] newlist = new Pixel[size*2];
        
        for (int i = 0; i < table.length; i++) {
            newlist[i] = table[i];
        }
        table = newlist;
    }
    
    public Pixel pop() {
        Pixel p = table[size-1];
        size--;
        return p;
    }
    
    public boolean empty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    
}
