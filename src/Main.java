import java.io.*;
import java.util.Scanner;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String inputFileName, inputFilePath;

        System.out.println();
        System.out.println("--------------------- Selamat datang di program IQ PUZZLER PRO Solver! -------------------------------");
        System.out.println();
        System.out.println("██╗ ██████╗     ██████╗ ██╗   ██╗███████╗███████╗██╗     ███████╗██████╗     ██████╗ ██████╗  ██████╗");
        System.out.println("██║██╔═══██╗    ██╔══██╗██║   ██║╚══███╔╝╚══███╔╝██║     ██╔════╝██╔══██╗    ██╔══██╗██╔══██╗██╔═══██╗");
        System.out.println("██║██║   ██║    ██████╔╝██║   ██║  ███╔╝   ███╔╝ ██║     █████╗  ██████╔╝    ██████╔╝██████╔╝██║   ██║");
        System.out.println("██║██║▄▄ ██║    ██╔═══╝ ██║   ██║ ███╔╝   ███╔╝  ██║     ██╔══╝  ██╔══██╗    ██╔═══╝ ██╔══██╗██║   ██║");
        System.out.println("██║╚██████╔╝    ██║     ╚██████╔╝███████╗███████╗███████╗███████╗██║  ██║    ██║     ██║  ██║╚██████╔╝");
        System.out.println("╚═╝ ╚══▀▀═╝     ╚═╝      ╚═════╝ ╚══════╝╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝    ╚═╝     ╚═╝  ╚═╝ ╚═════╝ ");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println("                             Shannon Aurellius Anastasya Lie");
        System.out.println("                                    13523019 - K-01");
        System.out.println("------------------------------------------------------------------------------------------------------");
        System.out.println();
    
        while (true) {
            System.out.print("Yukk masukkan nama file inputnyaa (berformat .txt): ");
            inputFileName = sc.nextLine().trim();

            if (inputFileName.isEmpty()) {
                System.out.println("Nama file ga boleh kosong! Coba lagi yaa~");
                continue;
            }
            if (!inputFileName.toLowerCase().endsWith(".txt")) {
                System.out.println("Nama file harus diakhiri dengan '.txt' niii! Coba lagi yaa~");
                continue;
            }
            inputFilePath = "test/input/" + inputFileName;
            if (!Input.isFileExist(inputFilePath)) {
                System.out.println("File ga ditemukan nii! Coba lagi yaa~");
                continue;
            }
            break;
        }
    
        try {
            Input.readInput(inputFilePath);
            long startTime = System.currentTimeMillis();
            boolean solved = Solve.solve(0);
            long endTime = System.currentTimeMillis();
    
            if (solved) {
                System.out.println();
                System.out.println("Solusinya ketemu nii:");
                Output.printBoard();
                System.out.println();
            } else {
                System.out.println("Ga ketemu solusinya nii.");
            }
    
            System.out.println("Waktu Eksekusi: " + (endTime - startTime) + " ms");
            System.out.println();
            System.out.println("Banyak kasus yang ditinjau: " + Solve.getIterationCount());
            System.out.println();

            Output.outputToText();
            Output.outputToImage();

            System.out.println("Terima kasih udah pake program ini! See you di lain kesempatan yaa~");
        } catch (IOException e) {
            System.err.println("Gagal membaca file: " + e.getMessage());
        }
    }
}
