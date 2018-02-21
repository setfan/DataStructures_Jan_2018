package DistanceInLabyrinth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        String[][] labyrinth = new String[size][size];
        Deque<Cell> ceilQueue = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            String[] line = reader.readLine().split("");

            for (int j = 0; j < size; j++) {
                labyrinth[i][j] = line[j];
            }
        }


        /*
        @ Return the start point coordinates in array of integers row/col.
         */
        int[] startPointCoordinates = findStartPoint(labyrinth);
        ceilQueue.add(new Cell(startPointCoordinates[0], startPointCoordinates[1]));

        labyrinth[startPointCoordinates[0]][startPointCoordinates[1]] = "0";
        while (!ceilQueue.isEmpty()) {

            Cell current = ceilQueue.poll();

            if (current.row + 1 < size && (labyrinth[current.row + 1][current.col].equals("0"))) {
                ceilQueue.add(new Cell(current.row + 1, current.col));
                labyrinth[current.row + 1][current.col] = String.format("%d", Integer.parseInt(labyrinth[current.row][current.col]) + 1);
            }
            if (current.row - 1 >= 0 && labyrinth[current.row - 1][current.col].equals("0")) {
                ceilQueue.add(new Cell(current.row - 1, current.col));
                labyrinth[current.row - 1][current.col] = String.format("%d", Integer.parseInt(labyrinth[current.row][current.col]) + 1);
            }
            if (current.col + 1 < size && (labyrinth[current.row][current.col + 1].equals("0"))) {
                ceilQueue.add(new Cell(current.row, current.col + 1));
                labyrinth[current.row][current.col + 1] = String.format("%d", Integer.parseInt(labyrinth[current.row][current.col]) + 1);
            }
            if (current.col - 1 >= 0 && labyrinth[current.row][current.col - 1].equals("0")) {
                ceilQueue.add(new Cell(current.row, current.col - 1));
                labyrinth[current.row][current.col - 1] = String.format("%d", Integer.parseInt(labyrinth[current.row][current.col]) + 1);
            }
        }

        labyrinth[startPointCoordinates[0]][startPointCoordinates[1]] = "*";


        printMatrix(labyrinth);


    }

    public static class Cell {
        private int row;
        private int col;
        private boolean visited;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
            this.visited = false;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

    private static void printMatrix(String[][] labyrinth) {
        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth.length; j++) {
                if(labyrinth[i][j].equals("0")){
                    labyrinth[i][j] = "u";
                }
                System.out.print(labyrinth[i][j]);
            }
            System.out.println();
        }
    }

    private static int[] findStartPoint(String[][] labyrinth) {
        int[] array = new int[2];
        for (int row = 0; row < labyrinth.length; row++) {
            for (int col = 0; col < labyrinth.length; col++) {
                if (labyrinth[row][col].equals("*")) {
                    array[0] = row;
                    array[1] = col;
                }
            }
        }

        return array;
    }
}
