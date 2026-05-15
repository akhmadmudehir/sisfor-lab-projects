package hitunggaji;

import java.util.Scanner;

public class HitungGajiKaryawan {
    public static void main(String[] args) {

        // Golongan, JamLembur, GajiPokok, PersentLembur, GajiLembur, TotalGaji
        String Golongan;
        int JamLembur;
        long GajiPokok;
        double PersentLembur = 0.00;
        double GajiLembur = 0.00;
        double TotalGaji = 0.00;

        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Golongan (A/B/C) : ");
        Golongan = input.next().toUpperCase();

        System.out.print("Masukkan Jam Lembur : ");
        JamLembur = input.nextInt();

        switch (Golongan) {
            case "A":
                GajiPokok = 5000000;
                break;
            case "B":
                GajiPokok = 6500000;
                break;
            case "C":
                GajiPokok = 9500000;
                break;
        
            default:
                System.out.print("Error: Tidak termasuk diantara golongan (A/B/C).");
                input.close();
                return;
        }

        if (JamLembur == 1) {
            PersentLembur = 0.30;
        } else if (JamLembur == 2) {
            PersentLembur = 0.32;
        } else if (JamLembur == 3) {
            PersentLembur = 0.34;
        } else if (JamLembur == 4) {
            PersentLembur = 0.36;
        } else if (JamLembur >= 5) {
            PersentLembur = 0.38;
        } else {
            PersentLembur = 0;
        }

        GajiLembur = PersentLembur * GajiPokok;
        TotalGaji = GajiPokok + GajiLembur;

        System.out.println("\n-------Perhitungan Gaji Karyawan-------");
        System.out.println("-----------------------------------------");
        System.out.println("Golongan Karyawan : " + Golongan);
        System.out.println("Jam Lembur Karyawan : " + JamLembur + " Jam");
        System.out.println("Gaji Pokok Karyawan : " + GajiPokok);
        System.out.println("Persentase Lembur Karyawan : " + PersentLembur);
        System.out.println("Gaji Lembur Karyawan : " + GajiLembur);
        System.out.println("\n---------------------------------------");
        System.out.println("Total Gaji Karyawan : " + TotalGaji);
    }
}