/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import domain.Pixel;

/**
 * Minikeko
 *
 * @author Jani
 */
public class MinHeap {

    private Pixel[] heap;
    int size;

    public MinHeap() {
        heap = new Pixel[1];
        size = 0;
    }
    
    public int size() {
        return this.size;
    }

    /**
     * Palauttaa parametrin vanhemman
     * @param i
     * @return palauttaa solmun vanhemman
     */
    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Palauttaa parametrin vasemman lapsen indeksin
     * @param i
     * @return
     */
    public int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Palauttaa parametrin oikean lapsen indeksin
     * @param i
     * @return
     */
    public int right(int i) {
        return 2 * i + 2;
    }

    /**
     * Tiran kalvoiltakin tuttu heapify joka korjaa rikkoutuneen keon rakenteen
     * @param i mistä kohtaa kekoa aloitetaan keon korjamainen
     */
    public void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest;
        if (r < size) {
            if (heap[l].getWeight() > heap[r].getWeight()) {
                smallest = r;
            } else {
                smallest = l;
            }

            if (heap[i].getWeight() > heap[smallest].getWeight()) {
                swap(i, smallest);
                heapify(smallest);
            }
        } else if (l == size && heap[i].getWeight() > heap[l].getWeight()) {
            swap(i, l);
        }
    }

    /**
     * Vaihdetaan kahden arvon paikkaa keossa
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        Pixel p = heap[i];
        heap[i] = heap[j];
        heap[j] = p;
    }

    /**
     * Palauttaa ja poistaa keosta keon pienimmän alkion jonka jälkeen suoritetaan
     * puulle heapify operaatio jotta keon rakenne korjautuu
     * @return
     */
    public Pixel heapDelMin() {
        Pixel min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapify(0);
        return min;
    }

    /**
     * Lisätään kekoon uusi pikseli
     * Aloitetaan etsintä puun viimeisestä kohdasta ja siirretään muita arvoja
     * "alemmaksi" kunnes oikea kohta löytyy
     * @param p
     */
    public void insert(Pixel p) {
        if (size == heap.length) {
            increaseSize();
        }

        if (size == 0) {
            heap[0] = p;
        } else {
            int i = size;

            while (i > 0 && heap[parent(i)].compareTo(p) > 0) {
                heap[i] = heap[parent(i)];
                i = parent(i);
            }
            heap[i] = p;
        }
        size++;
    }

    /**
     * Suurennetaan pinon kokoa kaksinkertaiseksi.
     * Arrays.copyOf olisi tehnyt saman asian kuin allaoleva for-lauseke
     */
    public void increaseSize() {
        Pixel[] newlist = new Pixel[size * 2];

        for (int i = 0; i < heap.length; i++) {
            newlist[i] = heap[i];
        }
        heap = newlist;
    }

    /**
     * Tarkistaa onko keko tyhjä
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
