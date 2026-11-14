package datastructures_practice.p8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> out = new ArrayList<>();
        if (grid.length == 0) {
            return out;
        }
        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                out.add(grid[top][c]);
            }
            top++;
            for (int r = top; r <= bottom; r++) {
                out.add(grid[r][right]);
            }
            right--;
            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    out.add(grid[bottom][c]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    out.add(grid[r][left]);
                }
                left++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}));
    }
}
