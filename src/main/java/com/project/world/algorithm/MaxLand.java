package com.project.world.algorithm;

public class MaxLand {

    public static void main(String[] args) {
        final MaxLand maxLand = new MaxLand();
        maxLand.testOne();
        maxLand.testTwo();
    }

    public void testOne() {
        int[][] grid = new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        int maxArea = new MaxLand().maxAreaOfIsland(grid);
        System.out.println(maxArea);
        System.out.println(maxArea == 4);
    }

    public void testTwo() {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        int maxArea = new MaxLand().maxAreaOfIsland(grid);
        System.out.println(maxArea);
        System.out.println(maxArea == 6);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int xLimit = grid.length;
        int yLimit = grid[0].length;

        int maxArea = 0;
        for (int x = 0; x < grid.length; x++) {
            int[] gridRow = grid[x];
            for (int y = 0; y < gridRow.length; y++) {
                if (grid[x][y] == 1) {
                    Count count = new Count();
                    markAndCount(grid, x, y, xLimit, yLimit, count);
                    maxArea = Math.max(maxArea, count.count);
                }
            }
        }

        return maxArea;
    }

    public void markAndCount(int[][] grid, int x, int y, int xLimit, int yLimit, Count count) {
        count.addOne();
        grid[x][y] = 2;

        int leftX = x - 1;
        if (leftX > -1 && grid[leftX][y] == 1) {
            markAndCount(grid, leftX, y, xLimit, yLimit, count);
        }

        int upY = y - 1;
        if (upY > -1 && grid[x][upY] == 1) {
            markAndCount(grid, x, upY, xLimit, yLimit, count);
        }

        int rightX = x + 1;
        if (rightX < xLimit && grid[rightX][y] == 1) {
            markAndCount(grid, rightX, y, xLimit, yLimit, count);
        }

        int downY = y + 1;
        if (downY < yLimit && grid[x][downY] == 1) {
            markAndCount(grid, x, downY, xLimit, yLimit, count);
        }
    }

    static class Count {
        int count;

        public void addOne() {
            count++;
        }
    }
}
