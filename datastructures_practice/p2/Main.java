package datastructures_practice.p2;

public class Main {
    static int[] warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxR = -1;
        int maxC = -1;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                total += grid[r][c];
                if (grid[r][c] > maxVal) {
                    maxVal = grid[r][c];
                    maxR = r;
                    maxC = c;
                }
            }
        }
        return new int[]{total, maxR, maxC};
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 9, 2}, {7, 1, 6}, {3, 12, 5}};
        int[] res = warehouseSummary(grid);
        System.out.println("total = " + res[0] + ", maxCoordinate = (" + res[1] + ", " + res[2] + ")");
    }
}
