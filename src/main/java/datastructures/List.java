/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import domain.Pixel;

/**
 * Lista joka korvaa ArrayListin 
 * @author Jani
 */
public class List {

    private Pixel[] items;
    private int size;

    public List() {
        items = new Pixel[1];
        size = 0;
    }

    /**
     * Lisää pixelin taulukkoon
     * @param p
     */
    public void add(Pixel p) {
        if (items.length == size) {
            increaseSize();
        }

        items[size] = p;
        size++;
    }

    /**
     * Suurennetaan listan kokoa kaksinkertaiseksi.
     * Arrays.copyOf olisi tehnyt saman asian kuin allaoleva for-lauseke
     */
    public void increaseSize() {
        Pixel[] newlist = new Pixel[size * 2];

        for (int i = 0; i < items.length; i++) {
            newlist[i] = items[i];
        }
        items = newlist;
    }

    /**
     * Palauttaa taulukosta halutulla kohdalla olevan arvon
     * @param i kohta minkä arvon käyttäjä haluaa
     * @return palautettava arvo
     */
    public Pixel get(int i) {
        return items[i];
    }

    /**
     * Poistaa taulukosta halutulla kohdalla olevan arvon
     * @param i kohta minkä arvon käyttäjä haluaa poistettavan
     */
    public void remove(int i) {
        for (int j = i; j < items.length - 1; j++) {
            items[j] = items[j + 1];
        }
        size--;
    }
    
    /**
     * Palauttaa listan koon
     * @return listan koko
     */
    public int size() {
        return size;
    }
}
