package com.project.world.algorithm;

import java.util.Arrays;

public class ColorFill {
    public static void main(String[] args) {
        int[][] image = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;

        new ColorFill().floodFill(image, sr, sc, newColor);
        int[][] result = new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        System.out.println(Arrays.deepEquals(image, result));
        System.out.println(Arrays.deepToString(image));
        System.out.println(Arrays.deepToString(result));
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startColor = image[sr][sc];
        int srUpLimit = image.length;
        int scUpLimit = image[0].length;
        if (startColor != newColor) {
            this.startFloodFill(image, sr, sc, newColor, startColor, srUpLimit, scUpLimit);
        }
        return image;
    }

    public void startFloodFill(int[][] image, int sr, int sc, int newColor, int startColor, int srUpLimit, int scUpLimit) {
        if (image[sr][sc] != newColor) {
            image[sr][sc] = newColor;
        }

        int leftSr = sr - 1;
        if (leftSr > -1 && image[leftSr][sc] == startColor) {
            image[leftSr][sc] = newColor;
            startFloodFill(image, leftSr, sc, newColor, startColor, srUpLimit, scUpLimit);
        }

        int upSc = sc - 1;
        if (upSc > -1 && image[sr][upSc] == startColor) {
            image[sr][upSc] = newColor;
            startFloodFill(image, sr, upSc, newColor, startColor, srUpLimit, scUpLimit);
        }

        int rightSr = sr + 1;
        if (rightSr < srUpLimit && image[rightSr][sc] == startColor) {
            image[rightSr][sc] = newColor;
            startFloodFill(image, rightSr, sc, newColor, startColor, srUpLimit, scUpLimit);
        }

        int downSc = sc + 1;
        if (downSc < scUpLimit && image[sr][downSc] == startColor) {
            image[sr][downSc] = newColor;
            startFloodFill(image, sr, downSc, newColor, startColor, srUpLimit, scUpLimit);
        }
    }
}
