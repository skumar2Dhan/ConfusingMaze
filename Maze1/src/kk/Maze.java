/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author ayayimli
 */
import java.awt.*; 
import java.util.*;
//import static GridColors.*;

public class Maze1 {
private int[][] maze1 = 
   {{0, 0, 1, 1, 1, 1}, 
    {1, 0, 1, 0, 0, 1}, 
    {1, 0, 0, 0, 1, 1},
    {1, 1, 1, 0, 1, 1},
    {1, 0, 0, 0, 1, 1},
    {1, 0, 1, 0, 0, 0}};
int nCols = 6, nRows = 6;
public static final int BACKGROUND = 0;
public static final int BARRIER = 1;
public static final int TEMPORARY = 2;
public static final int PATH = 3;

    public Maze1() {
    }

    public void toscreen(){
        System.out.println();
        for (int i = 0; i < nRows; i++){
            for (int j = 0; j < nCols; j++)
                System.out.print(maze1[i][j] + " ");
            System.out.println();
        }            
    }
    /** Attempts to find a path through point (x, y). 
        Cell colors: 
        BACKGROUND, BARRIER, TEMPORARY, PATH = 0, 1, 2, 3
        *           
     */ 
    public boolean findMazePath(int x, int y) { 
        if (x < 0 || y < 0 
            || x >= nRows || y >= nCols) 
            return false;      // Cell is out of bounds. 
        else
            if (maze1[x][y] != BACKGROUND) 
               return false;      // Cell is on barrier or dead end. 
            else if (x == nRows - 1 && y == nCols - 1) { 
               maze1[x][y] = PATH;   // Cell is on path 
               return true;                // and is maze exit. 
            } 
            else {                        // Recursive case. 
               // Attempt to find a path from each neighbor. 
               // Tentatively mark cell as on path. 
               maze1[x][y] = PATH; 
               if (findMazePath(x - 1, y) 
                   || findMazePath(x + 1, y) 
                   || findMazePath(x, y - 1) 
                   || findMazePath(x, y + 1 ) ) { 
                   return true; 
               } 
               else { 
                  maze1[x][y] = TEMPORARY; // Dead end. 
                  return false; 
               } 
        } 
    } 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Maze1 m1 = new Maze1();
        m1.toscreen();
        m1.findMazePath(0, 0);
        m1.toscreen();
    }
    
}