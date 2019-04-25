
public class Main {

    public static void main(String[] args) {

        // Two ways to initialize the matrix: directly or from file

        /*
        int[][] grid = {
                {5, 5, 5, 5, 5, 5},
                {5, 3, 4, 5, 5, 5},
                {5, 3, 1, 2, 4, 5},
                {5, 3, 1, 5, 3, 5},
                {5, 3, 1, 2, 10, 2},
                {5, 3, 4, 3, 1, 10},
                {5, 5, 5, 5, 5, 5}};
        */

        int[][] grid = FileInput.getMatrixFromFile("files/main_example.txt");

        System.out.println("INPUT GRID:");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.printf("%5d", grid[i][j]);
            }
            System.out.println();
        }

        int rowA = 2;
        int colA = 2;
        int rowB = 5;
        int colB = 5;

        System.out.printf("\nCOST OF BEST PATH FROM [%d,%d] TO [%d,%d]: ", rowA, colA, rowB, colB);
        Logic logic = new Logic(grid);
        System.out.println(logic.findEasiestPath(rowA, colA, rowB, colB));
        logic.printPath();
    }
}