package unit7;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInAGrid {

    public static class Point {
        public int row, col;
        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point p = (Point) o;
            return row == p.row && col == p.col;
        }

        @Override
        public int hashCode() {
            return row * 31 + col;
        }
    }

    public static ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0) return null;
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> failedPoints = new HashSet<>();
        if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
            return path;
        }
        return null;
    }

    private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
        if (col < 0 || row < 0 || !maze[row][col]) return false;

        Point p = new Point(row, col);
        if (failedPoints.contains(p)) return false;

        boolean isAtOrigin = (row == 0) && (col == 0);

        if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
            path.add(p);
            return true;
        }

        failedPoints.add(p);
        return false;
    }

    public static void main(String[] args) {
        boolean[][] maze = {
            {true, true, true},
            {false, true, true},
            {true, false, true}
        };

        ArrayList<Point> path = getPath(maze);
        if (path != null) {
            System.out.println("Path found: " + path);
        } else {
            System.out.println("No path found.");
        }
    }
}
