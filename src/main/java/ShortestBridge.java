import javax.print.attribute.IntegerSyntax;
import java.util.*;

public class ShortestBridge {

    public static void main(String[] args) {
//9:30
//        System.out.println(shortestBridge(new int[][]{
//                {1, 1, 1, 1, 1},
//                {1, 0, 0, 0, 1},
//                {1, 0, 1, 0, 1},
//                {1, 0, 0, 0, 1},
//                {1, 1, 1, 1, 1}}));
//        System.out.println(shortestBridge(new int[][]{
//                {0, 1, 0},
//                {0, 0, 0},
//                {0, 0, 1}}));
        System.out.println(shortestBridge(new int[][]{
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 0}
        }));
    }


    public static int shortestBridge(int[][] grid) {

        Stack<List<Integer>> stackLand = new Stack();
        Queue<List<Integer>> stackSea = new LinkedList<>();
        boolean found = false;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid.length; c++) {
                if (grid[r][c] == 1) {
                    stackLand.add(Arrays.asList(r, c));
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        HashMap<List<Integer>, Integer> closed = new HashMap();
        HashMap<List<Integer>, Integer> closedSea = new HashMap();
        while (!stackLand.isEmpty()) {
            List<Integer> current = stackLand.pop();
            closed.put(current, 0);

            List<List<Integer>> neighborsLand = getNeighborsLand(current, grid);
            List<List<Integer>> neighborsSea = getNeighborsSea(current, grid);

            for (List<Integer> neighbor : neighborsLand) {
                if (!closed.containsKey(neighbor)) {
                    stackLand.add(neighbor);
                }
            }

            for (List<Integer> neighbor : neighborsSea) {
                if (!closedSea.containsKey(neighbor)) {
                    closedSea.put(neighbor, 1);
                    stackSea.add(neighbor);
                }
            }

        }
        int minBridge = Integer.MAX_VALUE;

        while (!stackSea.isEmpty()) {
            List<Integer> currentSea = stackSea.poll();

            List<List<Integer>> neighborsSea = getNeighbors(currentSea, grid);

            for (List<Integer> neighbor : neighborsSea) {
                if (!closed.containsKey(neighbor)) {
                    if (grid[neighbor.get(0)][neighbor.get(1)] == 1) {
                        minBridge = Math.min(closedSea.get(currentSea), minBridge);
                    } else if (closedSea.containsKey(neighbor)) {
                        closedSea.put(neighbor, Math.min(closedSea.get(neighbor), closedSea.get(currentSea) + 1));
                    } else {
                        closedSea.put(neighbor, closedSea.get(currentSea) + 1);
                        stackSea.add(neighbor);
                    }
                }
            }


        }


        return minBridge;
    }

    private static List<List<Integer>> getNeighborsLand(List<Integer> current, int[][] grid) {
        int r = current.get(0);
        int c = current.get(1);
        List<List<Integer>> neighbors = new ArrayList<>();
        if (r + 1 < grid.length && grid[r + 1][c] == 1) {
            neighbors.add(Arrays.asList(r + 1, c));
        }
        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
            neighbors.add(Arrays.asList(r - 1, c));
        }
        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
            neighbors.add(Arrays.asList(r, c - 1));
        }
        if (c + 1 < grid[r].length && grid[r][c + 1] == 1) {
            neighbors.add(Arrays.asList(r, c + 1));
        }
        return neighbors;

    }

    private static List<List<Integer>> getNeighborsSea(List<Integer> current, int[][] grid) {
        int r = current.get(0);
        int c = current.get(1);
        List<List<Integer>> neighbors = new ArrayList<>();
        if (r + 1 < grid.length && grid[r + 1][c] == 0) {
            neighbors.add(Arrays.asList(r + 1, c));
        }
        if (r - 1 >= 0 && grid[r - 1][c] == 0) {
            neighbors.add(Arrays.asList(r - 1, c));
        }
        if (c - 1 >= 0 && grid[r][c - 1] == 0) {
            neighbors.add(Arrays.asList(r, c - 1));
        }
        if (c + 1 < grid[r].length && grid[r][c + 1] == 0) {
            neighbors.add(Arrays.asList(r, c + 1));
        }
        return neighbors;

    }

    private static List<List<Integer>> getNeighbors(List<Integer> current, int[][] grid) {
        int r = current.get(0);
        int c = current.get(1);
        List<List<Integer>> neighbors = new ArrayList<>();
        if (r + 1 < grid.length) {
            neighbors.add(Arrays.asList(r + 1, c));
        }
        if (r - 1 >= 0) {
            neighbors.add(Arrays.asList(r - 1, c));
        }
        if (c - 1 >= 0) {
            neighbors.add(Arrays.asList(r, c - 1));
        }
        if (c + 1 < grid[r].length) {
            neighbors.add(Arrays.asList(r, c + 1));
        }
        return neighbors;

    }
}
