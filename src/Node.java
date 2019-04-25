
public class Node {

    private int row, col;
    private int data;
    private int priority;

    public Node(int row, int col, int data, int priority) {
        this.row = row;
        this.col = col;
        this.data = data;
        this.priority = priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public int getData() {
        return this.data;
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 17 * hash + row;
        hash = 17 * hash + col;
        hash = 17 * hash + data;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Node) {
            final Node other = (Node) obj;
            return ((this.getRow() == other.getRow()) && (this.getCol() == other.getCol()) && (this.getData() == other.getData()));
        } else return false;
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", row, col);
    }
}
