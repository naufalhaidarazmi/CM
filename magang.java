package casemethod2;

import java.util.Scanner;

public class magang {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] data = new String[100][6];
        int total = 0;
        while (true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    total = tambah(total, data);
                    break;
                case 2:
                    tampil(data, total);
                    break;
                case 3:
                    cari(data, total);
                    break;
                case 4:
                    hitung(data, total);
                    break;
                case 5:
                    System.out.println("Anda keluar.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static int tambah(int total, String[][] data) {
        System.out.print("Masukkan Nama: ");
        String nama = input.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = input.nextLine();
        System.out.print("Masukkan Program Studi: ");
        String prodi = input.nextLine();
        System.out.print("Masukkan Tujuan Magang: ");
        String tujuan = input.nextLine();
        String semester = "0";
        while (true) {
            System.out.print("Semester pengambilan magang (6 atau 7): ");
            if (input.hasNextLine()) {
                semester = input.nextLine();
                if (semester.equalsIgnoreCase("6") || semester.equalsIgnoreCase("7")) {
                    break;
                }
            }
            System.out.println("Semester tidak valid!");
        }
        String status = "";
        while (true) {
            System.out.print("Status Magang (Diterima/Menunggu/Ditolak): ");
            status = input.nextLine();

            if (status.equalsIgnoreCase("Diterima") ||
                    status.equalsIgnoreCase("Menunggu") ||
                    status.equalsIgnoreCase("Ditolak")) {
                break;
            }
            System.out.println("Status tidak valid!");
        }
        data[total][0] = nama;
        data[total][1] = nim;
        data[total][2] = prodi;
        data[total][3] = tujuan;
        data[total][4] = semester;
        data[total][5] = status;
        total++;
        System.out.println("Data pendaftaran berhasil ditambahkan. Total pendaftar: " + total);
        return total;
    }

    static void hitung(String[][] data, int total) {
        int ditr = 0, men = 0, ditolak = 0;

        for (int i = 0; i < total; i++) {
            switch (data[i][5].toLowerCase()) {
                case "diterima":
                    ditr++;
                    break;
                case "menunggu":
                    men++;
                    break;
                case "ditolak":
                    ditolak++;
                    break;
            }
        }

        System.out.println("Total Diterima : " + ditr);
        System.out.println("Total Menunggu : " + men);
        System.out.println("Total Ditolak  : " + ditolak);
    }

    static int menu() {
        System.out.println("\n=== Sistem Pendaftaran Magang Mahasiswa ===");
        System.out.println("1. Tambah Data Magang");
        System.out.println("2. Tampilkan Semua Pendaftar Magang");
        System.out.println("3. Cari Pendaftar Berdasarkan Program Studi");
        System.out.println("4. Hitung Jumlah Pendaftar untuk Setiap Status");
        System.out.println("5. Keluar");

        int choice = 0;
        do {
            System.out.print("Pilih menu (1-5): ");
            choice = input.nextInt();
            input.nextLine();
        } while (choice <= 0 || choice > 5);

        return choice;
    }

}