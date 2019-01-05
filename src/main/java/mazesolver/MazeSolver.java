package mazesolver;

public class MazeSolver {

    private int[][] map;
    private int startPositionRow;
    private int startPositionCol;
    private int solutionRow;
    private int solutionCol;

    public MazeSolver(int[][] map, int startPositionRow, int startPositionCol) {
        this.map = map;
        this.startPositionRow = startPositionRow;
        this.startPositionCol = startPositionCol;
        this.solutionRow = -1;
        this.solutionCol = -1;
    }

    private boolean canVisitCell(int row, int col) {
        if(row < 0 || col < 0) {
            return false;
        }

        if(row == map.length || col == map[row].length) {
            return false;
        }

        return map[row][col] != 1;
    }

    private void dfs(int row, int col) {
        if(!canVisitCell(row, col)) {
            return;
        }

        if(map[row][col] == 3){
            this.solutionRow = row;
            this.solutionCol = col;
            throw new RuntimeException();
        }

        map[row][col] = 1;

        dfs(row -1, col);
        dfs(row, col +1);
        dfs(row + 1, col);
        dfs(row, col - 1);
    }

    public void findWayOut() {
        try {
            dfs(startPositionRow, startPositionCol);
            System.out.println("No way out!");
        }
        catch (RuntimeException e) {
            System.out.println("Solution is found at row " + solutionRow + " col " + solutionCol);
        }

    }
}
