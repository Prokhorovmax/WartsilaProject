import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LogicTest {

    private final int[][] testMatrix1 = {
            {5, 5, 5, 5, 5, 5},
            {5, 3, 4, 5, 5, 5},
            {5, 3, 1, 2, 4, 5},
            {5, 3, 1, 5, 3, 5},
            {5, 3, 1, 2, 10, 2},
            {5, 3, 4, 3, 1, 10},
            {5, 5, 5, 5, 5, 5}};
    private final int[][] testMatrix2 = {
            {7, 8, 8, 8, 8, 9, 10, 11},
            {6, 9, 1, 1, 1, 9, 10, 13},
            {7, 10, 4, 5, 1, 1, 10, 9},
            {9, 11, 10, 12, 4, 1, 9, 5},
            {4, 12, 8, 4, 6, 7, 8, 10},
            {3, 7, 6, 5, 6, 8, 9, 6}};
    private final int[][] testMatrix3 = {
            {3, 1, 2, 1, 3},
            {5, 2, 15, 15, 15},
            {7, 1, 2, 1, 7},
            {7, 15, 15, 2, 15},
            {4, 10, 3, 1, 4},
            {1, 1, 1, 1, 2}};

    private Logic logic1, logic2, logic3;

    @Before
    public void setUpData() {
        logic1 = new Logic(testMatrix1);
        logic2 = new Logic(testMatrix2);
        logic3 = new Logic(testMatrix3);
    }

    @Test
    public void findEasiestPath() throws Exception {
        assertEquals(9, logic1.findEasiestPath(2, 2, 5, 5));
        assertEquals(6, logic2.findEasiestPath(1, 6, 3, 2));
        assertEquals(8, logic3.findEasiestPath(0, 3, 5, 2));
    }
}