package com.github.alsaghir;

class Solution {

    public boolean isRobotBounded(String instructions) {
        int[] position = new int[]{0, 0};

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int face = 0;
        char[] ins = instructions.toCharArray();

        for (char c : ins) {
            if (c == 'L') {
                face = face == 0 ? 3 : face - 1;
            } else if (c == 'R') {
                face = face == 0 ? 3 : face + 1;
            } else {
                position[0] = position[0] + directions[face][0];
                position[1] = position[1] + directions[face][1];
            }
        }

        return (face != 0 || (position[0] == 0 && position[1] == 0));
    }

}