
import domain.Maze;
import domain.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Stack;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jani
 */
public class MazeMaker {

    private BufferedImage BImage;
    private String savename;
    protected int height;
    protected int width;
    public boolean error = false; //for testing purposes
    /**
     * Konstruktorissa luetaan annettu tiedosto ja muutetaan se buffered imageksi
     *
     * @param file on kuvan nimi
     * @param output on tallennettavan ratkaisun nimi
     *
     */
    public MazeMaker(String file, String output) {
        this.savename = output;
        try {
            File image = new File(file);
            BImage = ImageIO.read(image);
            this.height = BImage.getHeight();
            this.width = BImage.getWidth();
        } catch (IOException ex) {
            System.out.println("Kuvan lukeminen epäonnistui");
            error = true;
        }
    }

    /**
     * Metodi muuntaa aiemmin konstruktorissa annetun tiedoston
     * kaksiulotteiseksi taulukoksi, ja kutsuu setNeighbours metodia
     * naapureiden asettamiseksi.
     *
     * @return palauttaa mazen joka sisältää 2 ulotteisen taulukon,
     * aloituspisteen, sekä maalipisteen.
     */
    public Maze imageToMaze() {
        Maze maze = new Maze();
        Pixel[][] mazeArray = new Pixel[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                createPixel(x, y, maze, mazeArray);
            }
        }
        if (maze.getStart() == null || maze.getEnd() == null) {
            System.out.println("Aloitus- tai lopetuspistettä ei ole merkattu kuvaan");
            error = true;
            return null;
        }
        setNeighbours(mazeArray);
        maze.setMaze(mazeArray);

        return maze;
    }

    /**
     * Luodaan Pixel luokka annetusta kuvan pikselistä, ja lisätään ne Mazeen. 
     * Jos pikseli on punainen, merkataan se aloituspisteeksi, jos sininen niin maaliksi.
     * 
     * @param y pikselin Y-kordinaatti
     * @param x pikselin X-kordinaatti
     * @param maze maze jota käsitellään
     * @param mazeArray mazeen talletettava mazeArray
     */
    
    protected void createPixel(int x, int y, Maze maze, Pixel[][] mazeArray) {
        int color = BImage.getRGB(x, y);
        
        Pixel pixel = new Pixel(x, y, new Color(color));
        if (pixel.getColor().equals(Color.RED)) {
            maze.setStart(pixel);
        } else if (pixel.getColor().equals(Color.BLUE)) {
            maze.setEnd(pixel);
        } else if (pixel.getColor().getRGB() < -100000) {
            pixel.setWall(true);
        }
        pixel.setWeight(Integer.MAX_VALUE); 
        mazeArray[x][y] = pixel;
    }

    /**
     * Metodi laskee kaksiulotteisen taulukon jokaiselle pikselille sen naapurit ja asettaa ne
     * kyseisen pikselin naapurit -listaan.
     *
     */
    private void setNeighbours(Pixel[][] maze) {
        for (Pixel[] maze1 : maze) {
            for (int y = 0; y < maze[0].length; y++) {
                Pixel p = maze1[y];
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        if (!bordercheck(p.getX() + l, p.getY() + k) && !(k == 0 && y == 0)) {
                            p.addNeighbour(maze[p.getX() + l][p.getY() + k]);
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodi tarkastaa meneekö pikselin kordinaatit labyrintin rajojen yli
     *
     * @param x Pikselin x koordinaatti
     * @param y Pikselin y koordinaati
     * @return palauttaa true/false riippuen ylittääkö pikseli annetun labyrintin rajoja
     */
    public boolean bordercheck(int x, int y) {
        return !(x >= 0 && x < width && y < height && y >= 0);
    }

    /**
     * Metodi käy annetun pinon läpi, hakee pikselin X ja Y koordinaatit ja värjää
     * annetussa kuvassa oikeilla paikoilla olevan pikselin pisteen punaiseksi. 
     * 
     * @param path reitti
     */
    public void saveSolution(Stack<Pixel> path) {
        try {
            int color = Color.BLUE.getRGB();
            while (!path.isEmpty()) {
                Pixel p = path.pop(); 
                BImage.setRGB(p.getX(), p.getY(), color);
            }
            File output = new File(savename);
            ImageIO.write(BImage, "png", output);
        } catch (IOException ex) {
            error = true;
            //error
        }

    }

}
