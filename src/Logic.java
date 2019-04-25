import java.util.*;

public class Logic {

    private int rowNumber;
    private int columnNumber;
    private Node[][] nodes;

    private Node goal;
    private Node start;

    private Map<Node, Node> previousNodes;

    public Logic(int[][] matrix) {
        rowNumber = matrix.length;
        columnNumber = matrix[0].length;

        nodes = new Node[rowNumber][columnNumber];
        this.makeNodes(matrix);
    }

    // Sets up nodes from matrix grid
    private void makeNodes(int[][] matrix) {
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < columnNumber; j++) {
                nodes[i][j] = new Node(i, j, matrix[i][j], 0);
            }
        }
    }

    // Calculates straight distance between two grid points
    private int getEvaluation(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // Searches for adjacent nodes in grid
    private List<Node> getNeighbours(Node node) {
        List<Node> neighbours = new ArrayList<>();
        if (node.getRow() > 0) neighbours.add(nodes[node.getRow() - 1][node.getCol()]);
        if (node.getRow() < rowNumber - 1) neighbours.add(nodes[node.getRow() + 1][node.getCol()]);
        if (node.getCol() > 0) neighbours.add(nodes[node.getRow()][node.getCol() - 1]);
        if (node.getCol() < columnNumber - 1) neighbours.add(nodes[node.getRow()][node.getCol() + 1]);
        return neighbours;
    }

    // Main function - calculates the easiest path between two points. Based on A start algorithm
    public int findEasiestPath(int rowA, int colA, int rowB, int colB) {

        if ((rowA < 0 || rowA > rowNumber - 1) || (rowB < 0 || rowB > rowNumber - 1) ||
                (colA < 0 || colA > columnNumber - 1) || (colB < 0 || colB > columnNumber - 1)) {
            System.err.println("INDEX ERROR. PLEASE, CHECK POINTS COORDINATES (MUST BE INSIDE GRID.)");
            return -1;

        }

        // Queue for next nodes
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.getPriority() - o2.getPriority());

        // Current cost to go for each visited nodes
        Map<Node, Integer> costs = new HashMap<>();

        // Best connection (previous node - current node) for ech visited node
        previousNodes = new HashMap<>();

        start = nodes[rowA][colA];
        costs.put(start, 0);
        previousNodes.put(start, null);
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == nodes[rowB][colB]) {
                goal = nodes[rowB][colB];
                break;
            }

            for (Node next : getNeighbours(current)) {
                int cost = costs.get(current) + Math.abs(current.getData() - next.getData());
                if (!costs.containsKey(next) || (cost < costs.get(next))) {
                    costs.put(next, cost);
                    next.setPriority(cost + getEvaluation(next.getRow(), next.getCol(), rowB, colB));
                    queue.offer(next);
                    previousNodes.put(next, current);
                }
            }
        }
        return costs.get(goal);
    }

    // Returns current easiest path (additional option)
    private LinkedList<Node> returnPath() {
        LinkedList<Node> path = new LinkedList<>();
        path.add(goal);
        if (goal == start) return path;
        Node current = previousNodes.get(goal);
        while (!current.equals(start)) {
            path.add(current);
            current = previousNodes.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return (path);
    }

    // Simple console output
    public void printPath() {
        if (previousNodes == null) {
            System.err.println("NO PATH FOUND. PAY ATTENTION TO POSSIBLE ERRORS.");
            return;
        }
        LinkedList<Node> nodes = this.returnPath();
        System.out.println("BEST PATH FROM " + start.toString() + " TO " + goal.toString() + ":");
        while (!nodes.isEmpty()) {
            System.out.println(nodes.pollFirst().toString());
        }
    }
}
