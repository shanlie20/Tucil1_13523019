import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

class Output {
    private static final String RESET = "\u001B[0m";
    private static final String[] TEXT_COLORS = {
        "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m",
        "\u001B[35m", "\u001B[36m", "\u001B[91m", "\u001B[92m", 
        "\u001B[93m", "\u001B[94m", "\u001B[95m", "\u001B[96m",
        "\u001B[97m"
    };

    private static final String[] IMAGE_COLORS = {
        "#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF", "#00FFFF",
        "#FFA500", "#800080", "#008000", "#808000", "#800000", "#008080", 
        "#000080"
    };

    private static final Map<Character, String> textColorMap = new HashMap<>();
    private static final Map<Character, Color> imageColorMap = new HashMap<>();

    private static void assignTextColors() {
        int index = 0;
        for (char[] row : Input.board) {
            for (char cell : row) {
                if (cell != '.' && !textColorMap.containsKey(cell)) {
                    textColorMap.put(cell, TEXT_COLORS[index % TEXT_COLORS.length]);
                    index++;
                }
            }
        }
    }

    private static void assignImageColors() {
        int index = 0;
        for (char[] row : Input.board) {
            for (char cell : row) {
                if (cell != '.' && !imageColorMap.containsKey(cell)) {
                    imageColorMap.put(cell, Color.decode(IMAGE_COLORS[index % IMAGE_COLORS.length]));
                    index++;
                }
            }
        }
    }

    public static void printBoard() {
        assignTextColors();
        for (char[] row : Input.board) {
            for (char cell : row) {
                if (cell == '.') {
                    System.out.print(cell);
                } else {
                    System.out.print(textColorMap.get(cell) + cell + RESET);
                }
            }
            System.out.println();
        }
    }

    public static void outputToText() throws IOException {
        String outputTextFileName, outputTextFilePath;
        System.out.print("Apakah kamu mau menyimpan solusi dalam teks?? (ya/tidak): ");
        String option = Main.sc.nextLine().trim().toLowerCase();
        if (!option.equals("ya")) return;

        while (true) {
            System.out.print("Filenya mau disimpan dengan nama apaa? (berformat .txt): ");
            outputTextFileName = Main.sc.nextLine().trim();
            if (outputTextFileName.isEmpty()) {
                System.out.println("Nama file ga boleh kosong! Coba lagi yaa~");
                continue;
            }
            if (!outputTextFileName.toLowerCase().endsWith(".txt")) {
                System.out.println("Nama file harus diakhiri dengan '.txt' niii! Coba lagi yaa~");
                continue;
            }
            outputTextFilePath = "test/output/text/" + outputTextFileName;    
            if (Input.isFileExist(outputTextFilePath)) {
                System.out.println("File yang nama itu udah ada nii. Coba masukkin nama lain yaa~");
                continue;
            }    
            break;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputTextFilePath))) {
            for (char[] row : Input.board) {
                for (char cell : row) {
                    writer.print(cell);
                }
                writer.println();
            }
            System.out.println("Solusi udah disimpan di " + outputTextFilePath);
            System.out.println();
        } catch (IOException e) {
            System.err.println("Gagal menulis ke dalam file! " + e.getMessage());
        }
    }

    public static void outputToImage() {
        String outputImageFileName, outputImageFilePath;
        System.out.print("Apakah kamu mau menyimpan solusi sebagai gambar?? (ya/tidak): ");
        String option = Main.sc.nextLine().trim().toLowerCase();
        if (!option.equals("ya")) return;
    
        while (true) {
            System.out.print("Filenya mau disimpan dengan nama apaa? (berformat .png): ");
            outputImageFileName = Main.sc.nextLine().trim();
            if (outputImageFileName.isEmpty()) {
                System.out.println("Nama file ga boleh kosong! Coba lagi yaa~");
                continue;
            }
            if (!outputImageFileName.toLowerCase().endsWith(".png")) {
                System.out.println("Nama file harus diakhiri dengan '.png'niii! Coba lagi yaa~");
                continue;
            }
            outputImageFilePath = "test/output/image/" + outputImageFileName;
            if (Input.isFileExist(outputImageFilePath)) {
                System.out.println("File yang nama itu udah ada nii. Coba masukkin nama lain yaa~");
                continue;
            }
            break;
        }
    
        try {
            int rows = Input.board.length;
            int cols = Input.board[0].length;
            int cellSize = 50;
            int width = cols * cellSize;
            int height = rows * cellSize;
    
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = image.createGraphics();
    
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
            g.setStroke(new BasicStroke(2));
    
            assignImageColors();
    
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    char cell = Input.board[i][j];
                    if (cell != '.') {
                        g.setColor(imageColorMap.get(cell));
                        g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                        g.setColor(Color.BLACK);
                        g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
                        g.drawString(String.valueOf(cell), j * cellSize + 20, i * cellSize + 30);
                    }
                }
            }
    
            g.dispose();
            File outputFile = new File(outputImageFilePath);
            ImageIO.write(image, "png", outputFile);
            System.out.println("Solusi udah disimpan di " + outputFile);
            System.out.println();
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menyimpan gambar: " + e.getMessage());
        }
    }
}    