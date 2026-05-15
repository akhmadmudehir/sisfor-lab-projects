import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class SistemGaji {
    static long[] gajiArray = {5000000, 6500000, 9500000};
    static int[] persenLemburArray = {30,32,34,36,38};

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean ulangi = true;
        
        while(ulangi) {
            clearScreen();
            try {
                System.out.print("Masukkan Golongan (A/B/C) : ");
                String inputGolongan = input.next().toUpperCase();

                System.out.print("Masukkan Jam Lembur       : ");
                int inputJamLembur = input.nextInt();
                
                if(!inputGolongan.matches("[ABC]")) {
                    System.out.println("\n[!] Error : Golongan tidak valid, mohon masukkan input A, B, atau C.");
                }
                SlipGaji(inputGolongan, inputJamLembur);
            } catch (Exception e) {
                System.out.println("\n[!] Error : Jam lembur harus berupa angka!.");
                input.nextLine();
            }
            System.out.println("------------------------------------------------");
            System.out.print("Hitung lagi? (y/n) : ");
            String opsi = input.next();
            if(!opsi.equalsIgnoreCase("y")){
                ulangi = false;
            }
        }
        System.out.print("\n[System] Terima kasih. Program berhenti.");
        input.close();

    }
        
    public static void SlipGaji(String gol, int jam) {
            int indexGaji = -1;
        switch(gol){
            case "A": indexGaji = 0; break;
            case "B": indexGaji = 1; break;
            case "C": indexGaji = 2; break;
        }
        
        long gajiPokok = gajiArray[indexGaji];

        int indexLembur;
        if(jam >= 5){
            indexLembur = 4;
        } else if(jam < 1) {
            indexLembur = -1;
        } else {
            indexLembur = jam - 1;
        }
        
        int persenLemburDipakai;
        persenLemburDipakai = persenLemburArray[indexLembur];

        long nominalLembur = (long) (gajiPokok * (persenLemburDipakai / 100.0));
        long totalGaji = gajiPokok + nominalLembur;

        lembarSlipGaji(gol, gajiPokok, jam, persenLemburDipakai, nominalLembur, totalGaji);

    }

    public static void lembarSlipGaji(String golongan, long gaji, int lembur, int persen, long nominal, long total){
        System.out.println("\n================================================");
        System.out.println("   SLIP GAJI KARYAWAN PT MENCARI CINTA SEJATI   ");
        System.out.println("================================================");
        System.out.printf("| %-20s : %s\n", "Golongan", golongan);
        System.out.printf("| %-20s : %s\n", "Gaji Pokok", formatRupiah(gaji));
        System.out.println("------------------------------------------------");
        System.out.printf("| %-20s : %s Jam\n", "Durasi Lembur", lembur);
        System.out.printf("| %-20s : %s (dari Gaji Pokok)\n", "Rate Lembur", persen);
        System.out.printf("| %-20s : %s\n", "Nominal Lembur", formatRupiah(nominal));
        System.out.println("================================================");
        System.out.printf("| %-20s : %s\n", "TAKE HOME PAY", formatRupiah(total));
        System.out.println("================================================");
    }

    public static String formatRupiah(long angka){
        Locale indonesia = new Locale("id","ID");
        NumberFormat formatRp = NumberFormat.getCurrencyInstance(indonesia);
        return formatRp.format(angka);
    }

    public static void clearScreen(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
