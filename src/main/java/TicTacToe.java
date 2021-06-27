import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        String[][] grid ={{"#","#","#"},{"#","#","#"},{"#","#","#"}};

        tictactoe(grid);

    }

    private static void tictactoe(String[][] grid){


        while(true){

            botInput(grid);
            printGrid(grid);
            if(hasWon(grid)){
                break;
            }
            askForInput(grid);
            printGrid(grid);
            if(hasWon(grid)){
                break;
            }


        }


    }

    private static void botInput(String[][] grid) {

        int randomColumn = getRandomNumberInRange(0,2);
        int randomRow = getRandomNumberInRange(0,2);
        if(grid[randomRow][randomColumn].equals("#")){
            grid[randomRow][randomColumn] = "O";
        }else{
            botInput(grid);
        }

    }

    private static void askForInput(String[][] grid) {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        System.out.print("Enter a row: ");
        int row= sc.nextInt();
        System.out.print("Enter a column: ");
        int column= sc.nextInt();
        grid[row][column]="X";
    }

    private static boolean hasWon(String[][] grid) {

        for(int row = 0;row<3;row++){
            if(grid[row][0].equals(grid[row][1]) && grid[row][1].equals(grid[row][2]) && !grid[row][1].equals("#")){
                System.out.println(grid[row][0] +" has won");
                return true;
            }
        }

        for(int column = 0;column<3;column++){
            if(grid[0][column].equals(grid[1][column]) && grid[1][column].equals(grid[2][column]) &&!grid[2][column].equals("#")){
                System.out.println(grid[0][column] +" has won");
                return true;
            }
        }


       if(grid[0][0]==grid[1][1] && grid[1][1]==grid[2][2] && !grid[2][2].equals("#")){
           System.out.println(grid[0][0] +" has won");
           return true;
       }

        if(grid[0][2]==grid[1][1] && grid[1][1]==grid[2][0] &&!grid[2][0].equals("#")) {
            System.out.println(grid[2][0] +" has won");
            return true;
        }


        return false;
    }

    private static void printGrid(String[][] grid) {

        for(int row=0;row<grid.length;row++){
            String[] currentRow = grid[row];

            System.out.println(currentRow[0]+currentRow[1]+currentRow[2]);


        }

    }

    private static int getRandomNumberInRange(int min, int max) {

        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();

    }


}
