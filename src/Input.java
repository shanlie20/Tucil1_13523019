import java.io.*;
import java.util.*;

class Input {
    public static int N, M, P;
    public static char[][] board;
    public static final List<Block> blocks = new ArrayList<>();

    public static boolean isFileExist(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.isFile();
    }

    public static void readInput(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String[] dimensions = br.readLine().split(" ");
            if (dimensions.length < 3) throw new IOException("Format file tidak valid.");
            
            N = Integer.parseInt(dimensions[0]);
            M = Integer.parseInt(dimensions[1]);
            P = Integer.parseInt(dimensions[2]);
    
            String formatCheck = br.readLine();
            if (!"DEFAULT".equals(formatCheck)) {
                throw new IOException("Format file tidak valid: Baris kedua harus berisi DEFAULT.");
            }
    
            board = new char[N][M];
            for (char[] row : board) Arrays.fill(row, '.');
    
            List<String> blockShapes = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
    
                if (blockShapes.isEmpty() || blockShapes.get(blockShapes.size() - 1).charAt(0) != line.charAt(0)) {
                    blockShapes.add(line);
                } else {
                    blockShapes.set(blockShapes.size() - 1, blockShapes.get(blockShapes.size() - 1) + " " + line);
                }
            }
    
            P = blockShapes.size();
            for (String shape : blockShapes) {
                blocks.add(new Block(shape));
            }
    
            System.out.println("File input berhasil dibaca!");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Gagal membaca file input: " + e.getMessage());
            System.exit(0);
        }
    }
}