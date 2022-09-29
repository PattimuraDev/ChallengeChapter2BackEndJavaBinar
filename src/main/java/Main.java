import helper.fileprocessor.CsvFileProcessor;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        programConsole();
    }

    /**
     * Fungsi untuk menjalankan konsol program
     */
    private static void programConsole() {
        boolean running = true;
        Scanner input = new Scanner(System.in);
        int pilihan;
        CsvFileProcessor csvFileProcessor = new CsvFileProcessor();
        final String pembatas = "---------------------------";

        while (running) {
            mainMenu();
            System.out.print("pilihan: ");
            pilihan = input.nextInt();
            if (pilihan == 0) {
                System.out.println();
                running = false;
            } else {
                final String resourceFilePath = "/home/dwisatriapatra/IdeaProjects/ChallengeChapter2BackEndJava/src/main/resources/data_sekolah.csv";
                if ((new File(resourceFilePath)).exists()) {
                    csvFileProcessor.fileReader(resourceFilePath);
                    csvFileProcessor.fileWriter(pilihan);
                } else {
                    System.out.println(pembatas +
                            "\nAplikasi Pengolah Nilai Siswa\n" +
                            pembatas +
                            "\nFile tidak ditemukan\n" +
                            "0. Exit\n" +
                            "1. Kembali ke menu utama\n"
                    );
                }
                System.out.print("pilihan: ");
                pilihan = input.nextInt();
                switch (pilihan) {
                    case 1:
                        break;
                    case 0:
                        running = false;
                        break;
                }
            }
        }
    }

    /**
     * Fungsi untuk menampilkan main menu dari program
     */
    private static void mainMenu() {
        final String pembatas = "---------------------------";
        System.out.println(pembatas +
                "\nAplikasi Pengolah Nilai Siswa\n" +
                pembatas +
                "\nLetakkan file dengan nama data_sekolah.csv di direktori berikut: /home/dwisatriapatra/IdeaProjects/ChallengeChapter2BackEndJava/src/main/resources\n" +
                "Pilih menu:\n" +
                "1. Generate txt untuk menampilkan modus\n" +
                "2. Generate txt untuk menampilkan nilai rata-rata, median\n" +
                "3. Generate kedua file\n" +
                "0. Exit\n"
        );
    }
}
