
package maze;


import java.awt.*; 
import java.util.Stack;
//import static GridColors.*;

public class Maze {
private int[][] maze = 
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

static void showpush(Stack st, int a) {
      st.push(new Integer(a));
      System.out.println("push(" + a + ")");
      System.out.println("stack: " + st);
   }

   static void showpop(Stack st) {
      System.out.print("pop -> ");
      Integer a = (Integer) st.pop();
      System.out.println(a);
      System.out.println("stack: " + st);
   }
    public Maze() {
    }

    public void toscreen(){
        System.out.println();
        for (int i = 0; i < nRows; i++){
            for (int j = 0; j < nCols; j++)
                System.out.print(maze[i][j] + " ");
            System.out.println();
        }            
    }
    /** Attempts to find a path through point (x, y). 
        Cell colors: 
        BACKGROUND, BARRIER, TEMPORARY, PATH = 0, 1, 2, 3
        *           
     */ 
    public boolean findMazePath(int x, int y) { 
        Stack<Integer> st= new Stack();
        maze[x][y]=PATH;
        //st.push(PATH);
        boolean path=false;
      if (x < 0 || y < 0 
            || x >= nRows || y >= nCols) 
            return false;    
      else{
         while (path==false){
          if (x < 0 || y < 0 
            || x >= nRows || y >= nCols) 
            return false;
            if(maze[x][y]==0 && maze[x+1][y]==1 &&maze[x][y+1]==0 ){
                st.push(y);
                st.push(x);
                maze[x][y]=7;
                y++;
                return false;
            }
            else if (maze[x][y]==0&& maze[x+1][y]==0 && maze[x][y+1]==1 && maze[x][y-1]==7){
                st.push(y);
                st.push(x);
                maze[x][y]=7;
                x++;
               return false;
            }
/*            else if (maze[x-1][y]==7 && maze[x][y-1]==1 && maze[x][y+1]==1 && maze[x+1][y]==0&& maze[x][y]==0){
                st.push(y);
                st.push(x);
                maze[x][y]=7;
                x++;
               return false;
            }*/
            else
                
                if (maze[x][y]==0 && maze[x][y-1]==1 && maze[x][y+1]==0 && maze[x-1][y-1]==7 && maze[x+1][y]==1){
                st.push(y);
                st.push(x);
                maze[x][y]=7;
                y++;
            
               return false;
            }
            else if(maze[x][y]==0 && maze[x][y-1]==7 && maze[x-1][y]==0 && maze[x+1][y]==0 && maze[x][y+1]==1){
                st.push(y);
                st.push(x);
                maze[x][y]=7;
                x++;
               return false;
            }
            else if(maze[x][y]==0 && maze[x-1][y]==1 && maze[x][y+1]==1 && maze[x+1][y]==1 && maze[x][y-1]==7){
                st.pop();
                st.pop();
                maze[x][y]=7;
                y--;
                return false;
            
            }
            else if (maze[x][y]==0 && maze[x][y-1]==1 && maze[x-1][y]==1 && maze[x][y+1]==0 && maze[x+1][y]==0 ){
              st.push(y);
              st.push(x);
              maze[x][y]=7;
              y++;  
              return false;
            
            }
            else if(maze[x][y]==0 && maze[x-1][y]==1 && maze[x][y+1]==1 && maze[x+1][y]==1 && maze[x][y-1]==7){
                st.pop();
                st.pop();
                st.pop();
                st.pop();
                maze[x][y]=7;
                y--;
                return false;
            
            }
            else if(maze[x][y]==0 && maze[x][y-1]==1 && maze[x-1][y]==0 && maze[x][y+1]==0 ){
                st.push(y);
                st.push(x);
                maze[x][y]=7;
                y++; 
                return false;
            
            }
            else if(maze[x][y]==0 && maze[x][y-1]==0 && maze[x-1][y]==1 && maze[x][y+1]==0 ){
                st.push(y);
                st.push(x);
                maze[x][y]=7;
                y++; 
                return false;
            
            }
            else if(maze[x][y]==0 && maze[x][y-1]==0 && maze[x-1][y]==1 ){
                System.out.println("You Win!");
               return path=true;
            
            }
            else{
                return false;
              }
        
          
        }
        return false;
        
      }   
       /*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*/
    }
   public  int [][] maze1 = 
    {{7, 7, 1, 1, 1, 1}, 
    {1, 7, 1, 2, 2, 1}, 
    {1, 7, 7, 2, 1, 1},
    {1, 1, 1, 7, 1, 1},
    {1, 2, 2, 7, 1, 1},
    {1, 2, 1, 7, 7, 7}};
   
    
    public static void main(String[] args) {
        
        /*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*//*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*/
          int [][] maze1 = 
         {{7, 7, 1, 1, 1, 1}, 
         {1, 7, 1, 2, 2, 1}, 
         {1, 7, 7, 7, 1, 1},
         {1, 1, 1, 7, 1, 1},
         {1, 2, 2, 7, 1, 1},
         {1, 2, 1, 7, 7, 7}};
        /*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*//*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*//*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*/
          
        Maze m1 = new Maze();
        m1.toscreen();
        m1.findMazePath(0, 0);
        m1.toscreen();
        /*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*//*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*//*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*/
        for (int i=0; i<6;++i){
            System.out.println();
            for (int j=0; j<6;++j){
                System.out.print(""+ maze1[i][j]);

}

}
        
        System.out.println();
    }
    /*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*//*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*//*if (x < 0 || y < 0 || x >= nRows || y >= nCols){ 
            return false;      // Cell is out of bounds. 
       }else
          while(maze[x][y]==BACKGROUND && maze[x-1][y]!=BACKGROUND &&maze[x+1][y]!=BACKGROUND &&maze[x][y-1]!=BACKGROUND 
                &&maze[x-1][y]!=BACKGROUND){ 
            maze[x][y]=PATH; 
         
    }*/
}
