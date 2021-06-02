import java.util.Arrays;

public class NumberOfIslands {
    public static void main(String[] args) {

        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int islandCount = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    convertIslandToSea(grid, r, c);
                }
            }
        }
        return islandCount;

    }

    private static void convertIslandToSea(char[][] grid, int r, int c) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[r].length && grid[r][c] == '1') {
            grid[r][c] = '0';
            convertIslandToSea(grid, r - 1, c);
            convertIslandToSea(grid, r + 1, c);
            convertIslandToSea(grid, r, c - 1);
            convertIslandToSea(grid, r, c + 1);
        }


    }
}
