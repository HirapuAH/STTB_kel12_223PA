/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package votings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Votings {
    
    record Peserta(String nama, String id, String status) {

    }

    record Paslon(int nomorPaslon, String namaCalon, int jumlahSuara) {

    }

    record Kategori(String namaKategori, List<Paslon> paslonList) {

    }

    record Suara(Peserta peserta, Kategori kategori, Paslon paslon) {

    }


    public static void main(String[] args) {
        
                List<Peserta> pesertaList = buatDataPeserta();
        List<Paslon> paslonList = buatDataPaslon();
        List<Kategori> kategoriList = buatDataKategori(paslonList);
        Queue<Suara> riwayatSuara = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            tampilkanMenu();
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1" ->
                    pilihPeserta(pesertaList, riwayatSuara, scanner);
                case "2" ->
                    tampilkanKategoriPaslon(kategoriList);
                case "3" ->
                    voting(pesertaList, kategoriList, riwayatSuara, scanner);
                case "4" ->
                    lihatHasilVoting(kategoriList);
                case "5" ->
                    lihatRiwayatVoting(riwayatSuara);
                case "6" ->
                    cariKategori(kategoriList, scanner);
                case "7" ->
                    cariPesertaYangMenyoblos(riwayatSuara, scanner);
                case "8" -> {
                    System.out.println("+-------------------------------------+");
                    System.out.println("|    Terima kasih, program selesai    |");
                    System.out.println("+-------------------------------------+");
                    exit = true;
                }
                default ->
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
        }
    }

    private static List<Peserta> buatDataPeserta() {
        return new ArrayList<>(List.of(
                new Peserta("Mulki", "P001", "Aktif"),
                new Peserta("Alex", "P002", "Aktif"),
                new Peserta("Julian", "P003", "Aktif")
        ));
    }

    private static List<Paslon> buatDataPaslon() {
        return new ArrayList<>(List.of(
                new Paslon(1, "Hj Ujang", 0),
                new Paslon(2, "Hj Maman Mp.d", 0),
                new Paslon(1, "Kang Gunawan", 0),
                new Paslon(2, "Hj Ubed", 0),
                new Paslon(1, "Kang Utep", 0),
                new Paslon(2, "Hj Asep.st", 0)
        ));
    }

    private static List<Kategori> buatDataKategori(List<Paslon> paslonList) {
        List<Kategori> kategoriList = new ArrayList<>();
        Kategori kategori1 = new Kategori("capress", new ArrayList<>(List.of(paslonList.get(0), paslonList.get(1))));
        Kategori kategori2 = new Kategori("dpr", new ArrayList<>(List.of(paslonList.get(2), paslonList.get(3))));
        Kategori kategori3 = new Kategori("Bumdes", new ArrayList<>(List.of(paslonList.get(4), paslonList.get(5))));

        kategoriList.add(kategori1);
        kategoriList.add(kategori2);
        kategoriList.add(kategori3);

        return kategoriList;
    }

    private static void tampilkanMenu() {
        System.out.println("=============  Menu Pilihan  ============");
        System.out.println("| 1. Pilih Peserta                      |");
        System.out.println("| 2. Tampilkan Kategori dan Paslon      |");
        System.out.println("| 3. Mulai Voting                       |");
        System.out.println("| 4. Lihat Hasil Voting                 |");
        System.out.println("| 5. Lihat Riwayat Vote                 |");
        System.out.println("| 6. Cari Kategori                      |");
        System.out.println("| 7. Cari Peserta yang Menyoblos        |");
        System.out.println("| 8. Keluar                             |");
        System.out.println("=========================================");
        System.out.print("Pilih menu -> ");
    }

    private static void pilihPeserta(List<Peserta> pesertaList, Queue<Suara> riwayatSuara, Scanner scanner) {
        if (pesertaList.isEmpty()) {
            System.out.println("Tidak ada peserta yang terdaftar.");
            return;
        }

        System.out.println("\nMenu Pilih Peserta:");
        for (int i = 0; i < pesertaList.size(); i++) {
            System.out.println((i + 1) + ". " + pesertaList.get(i).nama());
        }

        System.out.println((pesertaList.size() + 1) + ". Tambah Peserta");
        System.out.print("Pilih peserta atau tambah peserta -> ");
        int indexPeserta = scanner.nextInt();
        scanner.nextLine();

        if (indexPeserta >= 1 && indexPeserta <= pesertaList.size()) {
            Peserta peserta = pesertaList.get(indexPeserta - 1);

            System.out.println("\nAnda memilih peserta:");
            System.out.println("Nama: " + peserta.nama());
            System.out.println("Nomor Identifikasi: " + peserta.id());
            System.out.println("Status: " + peserta.status());

            riwayatSuara.add(new Suara(peserta, null, null));
        } else if (indexPeserta == pesertaList.size() + 1) {
            tambahPeserta(pesertaList, scanner);
        } else {
            System.out.println("Indeks peserta tidak valid.");
        }
    }

    private static void tambahPeserta(List<Peserta> pesertaList, Scanner scanner) {
        System.out.print("Masukkan nama peserta baru: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan nomor identifikasi peserta baru: ");
        String nomorIdentifikasi = scanner.nextLine();

        Peserta pesertaBaru = new Peserta(nama, nomorIdentifikasi, "Aktif");
        pesertaList.add(pesertaBaru);

        System.out.println("Peserta baru berhasil ditambahkan!");
    }

    private static void voting(List<Peserta> pesertaList, List<Kategori> kategoriList, Queue<Suara> riwayatSuara, Scanner scanner) {
        if (pesertaList.isEmpty() || kategoriList.isEmpty()) {
            System.out.println("Tidak dapat memulai voting. Pastikan terdapat peserta dan kategori yang terdaftar.");
            return;
        }

        System.out.println("Pilih peserta:");
        for (int i = 0; i < pesertaList.size(); i++) {
            System.out.println((i + 1) + ". " + pesertaList.get(i).nama());
        }
        int indexPeserta = scanner.nextInt() - 1;
        Peserta peserta = pesertaList.get(indexPeserta);

        if (sudahMelakukanVoting(riwayatSuara, peserta)) {
            System.out.println("Anda sudah melakukan voting. Tidak dapat memilih lagi.");
            return;
        }

        System.out.println("Pilih kategori:");
        for (int i = 0; i < kategoriList.size(); i++) {
            System.out.println((i + 1) + ". " + kategoriList.get(i).namaKategori());
        }
        int indexKategori = scanner.nextInt() - 1;
        Kategori kategori = kategoriList.get(indexKategori);

        System.out.println("Pilih paslon untuk kategori " + kategori.namaKategori() + ":");
        for (int i = 0; i < kategori.paslonList().size(); i++) {
            System.out.println((i + 1) + ". Paslon " + kategori.paslonList().get(i).nomorPaslon()
                    + ": " + kategori.paslonList().get(i).namaCalon());
        }
        int indexPaslon = scanner.nextInt() - 1;
        Paslon paslon = kategori.paslonList().get(indexPaslon);
        // Membersihkan karakter newline dari buffer
        scanner.nextLine();

        riwayatSuara.add(new Suara(peserta, kategori, paslon));

        // Tambahkan suara terlebih dahulu, lalu perbarui jumlah suara paslon
        paslon = kategori.paslonList().get(indexPaslon);
        kategori.paslonList().set(indexPaslon, new Paslon(paslon.nomorPaslon(), paslon.namaCalon(), paslon.jumlahSuara() + 1));
        System.out.println("+----------------------------------------+");
        System.out.println("|        Vote berhasil dilakukan!        |");
        System.out.println("+----------------------------------------+");
    }

    private static boolean sudahMelakukanVoting(Queue<Suara> riwayatSuara, Peserta peserta) {
        for (Suara suara : riwayatSuara) {
            if (suara.peserta().equals(peserta)) {
                return true;
            }
        }
        return false;
    }

    private static void tampilkanKategoriPaslon(List<Kategori> kategoriList) {
        if (kategoriList.isEmpty()) {
            System.out.println("Tidak ada kategori yang terdaftar.");
            return;
        }

        System.out.println("\nData Kategori dan Paslon:");
        for (Kategori k : kategoriList) {
            System.out.println("Kategori: " + k.namaKategori());
            for (Paslon p : k.paslonList()) {
                System.out.println("Paslon " + p.nomorPaslon() + ": " + p.namaCalon() + " - Jumlah Suara: " + p.jumlahSuara());
            }
            System.out.println();
        }
    }

    private static void lihatHasilVoting(List<Kategori> kategoriList) {
        if (kategoriList.isEmpty()) {
            System.out.println("Tidak ada kategori yang terdaftar.");
            return;
        }

        System.out.println("\nHasil Voting:");
        for (Kategori kategori : kategoriList) {
            System.out.println("Kategori: " + kategori.namaKategori());
            for (Paslon paslon : kategori.paslonList()) {
                System.out.println("Paslon " + paslon.nomorPaslon() + ": " + paslon.namaCalon()
                        + " - Jumlah Suara: " + paslon.jumlahSuara());
            }
            System.out.println();
        }
    }

    private static void lihatRiwayatVoting(Queue<Suara> riwayatSuara) {
        if (riwayatSuara.isEmpty()) {
            System.out.println("Tidak ada riwayat voting");
            return;
        }
        System.out.println("\nRiwayat Voting :");
        for (Suara suara : riwayatSuara) {
            System.out.println("Peserta : " + suara.peserta().nama());
            System.out.println("Kategori : " + (suara.kategori() != null ? suara.kategori().namaKategori() : "belum dipilih"));
            System.out.println("Paslon: " + (suara.paslon() != null ? "Paslon " + suara.paslon().nomorPaslon() + ": " + suara.paslon().namaCalon() : "Belum dipilih"));
            System.out.println();
        }

    }

    private static void cariKategori(List<Kategori> kategoriList, Scanner scanner) {
        System.out.print("Masukkan nama kategori yang dicari: ");
        String namaKategoriCari = scanner.nextLine();

        for (Kategori kategori : kategoriList) {
            if (kategori.namaKategori().equalsIgnoreCase(namaKategoriCari)) {
                System.out.println("Kategori ditemukan:");
                System.out.println("Nama Kategori: " + kategori.namaKategori());
                System.out.println("Daftar Paslon:");
                for (Paslon paslon : kategori.paslonList()) {
                    System.out.println("Paslon " + paslon.nomorPaslon() + ": " + paslon.namaCalon());
                }
                return;
            }
        }
        System.out.println("Kategori tidak ditemukan.");
    }

    private static void cariPesertaYangMenyoblos(Queue<Suara> riwayatSuara, Scanner scanner) {
        System.out.print("Masukkan nama peserta yang dicari: ");
        String namaPesertaCari = scanner.nextLine();

        boolean pesertaDitemukan = false;
        for (Suara suara : riwayatSuara) {
            if (suara.peserta().nama().equalsIgnoreCase(namaPesertaCari)) {
                pesertaDitemukan = true;
                System.out.println("Peserta ditemukan:");
                System.out.println("Nama: " + suara.peserta().nama());
                System.out.println("Nomor Identifikasi: " + suara.peserta().id());
                System.out.println("Status: " + suara.peserta().status());
                System.out.println("Kategori: " + (suara.kategori() != null ? suara.kategori().namaKategori() : "belum dipilih"));
                System.out.println("Paslon: " + (suara.paslon() != null ? "Paslon " + suara.paslon().nomorPaslon() + ": " + suara.paslon().namaCalon() : "Belum dipilih"));
                System.out.println();
            }
        }

        if (!pesertaDitemukan) {
            System.out.println("Peserta tidak ditemukan.");
        }       
    }
}
