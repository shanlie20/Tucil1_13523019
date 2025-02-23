public class Solve {
    private static int iterationCount = 0;

    public static boolean solve(int index) {
        if (index == Input.blocks.size()) return isBoardFull();
        Block block = Input.blocks.get(index);
        
        for (char[][] shape : block.getAllShapes()) {
            for (int i = 0; i < Input.N; i++) {
                for (int j = 0; j < Input.M; j++) {
                    iterationCount++;
                    if (canPlace(shape, i, j)) {
                        placeBlock(shape, i, j, block.symbol);
                        if (solve(index + 1)) return true;
                        removeBlock(shape, i, j);
                    }
                }
            }
        }
        return false;
    }

    private static boolean canPlace(char[][] shape, int x, int y) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] != '.' && (x + i >= Input.N || y + j >= Input.M || Input.board[x + i][y + j] != '.')) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void placeBlock(char[][] shape, int x, int y, char symbol) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] != '.') {
                    Input.board[x + i][y + j] = symbol;
                }
            }
        }
    }

    private static void removeBlock(char[][] shape, int x, int y) {
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[0].length; j++) {
                if (shape[i][j] != '.') {
                    Input.board[x + i][y + j] = '.';
                }
            }
        }
    }

    private static boolean isBoardFull() {
        for (char[] row : Input.board) {
            for (char cell : row) {
                if (cell == '.') return false;
            }
        }
        return true;
    }

    public static int getIterationCount() {
        return iterationCount;
    }
}