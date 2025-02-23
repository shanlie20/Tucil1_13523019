import java.util.*;

class Block {
    char symbol;
    List<char[][]> shapes = new ArrayList<>();

    Block(String shape) {
        this.symbol = shape.charAt(0);
        char[][] baseShape = convertToMatrix(shape);
        generateTransformations(baseShape);
    }

    private char[][] convertToMatrix(String shape) {
        String[] rows = shape.split(" ");
        int rowCount = rows.length;
        int colCount = 0;
    
        for (String row : rows) {
            colCount = Math.max(colCount, row.length());
        }
    
        char[][] matrix = new char[rowCount][colCount];
    
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(matrix[i], '.');
            for (int j = 0; j < rows[i].length(); j++) {
                matrix[i][j] = rows[i].charAt(j);
            }
        }
        return matrix;
    }

    private void generateTransformations(char[][] baseShape) {
        shapes.add(baseShape);
        shapes.add(rotate(baseShape));
        shapes.add(rotate(rotate(baseShape)));
        shapes.add(rotate(rotate(rotate(baseShape))));
        shapes.add(mirror(baseShape));
        shapes.add(rotate(mirror(baseShape)));
        shapes.add(rotate(rotate(mirror(baseShape))));
        shapes.add(rotate(rotate(rotate(mirror(baseShape)))));
    }

    private char[][] rotate(char[][] shape) {
        int rows = shape.length;
        int cols = 0;
    
        for (char[] row : shape) {
            cols = Math.max(cols, row.length);
        }
    
        char[][] rotated = new char[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                rotated[j][rows - 1 - i] = shape[i][j];
            }
        }
        return rotated;
    }  

    private char[][] mirror(char[][] shape) {
        int rows = shape.length;
        char[][] mirrored = new char[rows][];

        for (int i = 0; i < rows; i++) {
            mirrored[i] = shape[rows - 1 - i].clone();
        }
        return mirrored;
    }

    List<char[][]> getAllShapes() {
        return shapes;
    }
}
