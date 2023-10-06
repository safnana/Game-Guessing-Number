
package gamejudi;

import java.util.*;
import java.lang.Math;
import java.util.Arrays;

public class Gamehoki {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String start;
        int uang;
        System.out.println("================================================================");
        System.out.println("TEBAK HOKI");
        System.out.println("\n"+"START (YES / NO)");
        System.out.print("= ");
        start = input.nextLine();
        start = kapital(start);
        if (start.equals("YES")) {
            uang = 50000;
            game(uang);
        } if (start.equals ("NO")){
            System.exit(0); }
    }
    
    public static int bonus(int x) {
        int h, i, temp, n, a, y;
        
        n = 3;
        int[] bonusTime = new int[n];
        int[] bonusTimetemp = new int[n];
        
        for (i = 0; i <= n - 1; i++) {
            bonusTime[i] = random.nextInt(50);
        }
        for (i = 0; i <= n - 1; i++) {
            bonusTimetemp[i] = bonusTime[i];
        }
        for (i = 0; i <= n - 1; i++) {
            for (h = n - 1; h >= i + 1; h--) {
                if (bonusTime[h] < bonusTime[h - 1]) {
                    temp = bonusTime[h];
                    bonusTime[h] = bonusTime[h - 1];
                    bonusTime[h - 1] = temp;
                }
            }
        }
        System.out.println("================================================================");
        System.out.println("SESI BONUS");
        System.out.println("Terdapat 3 Pilihan. Tebak pilihan nomor yang memuat nilai terbesar (1 / 2 / 3)");
        System.out.print("= ");
        a = input.nextInt();
        if (bonusTimetemp[a - 1] == bonusTime[2]) {
            System.out.println("Selamat! Anda mendapatkan bonus Rp20.000");
            y = 20000;
            x = x + y;
        } else {
            System.out.println("Anda tidak mendapatkan bonus");
        }
        
        return x;
    }
    
    public static boolean cek(int[] pilihan, int n, int tebak) {
        boolean ada;
        int i;
        
        i = 0;
        ada = false;
        while (i < n && !ada) {
            if (pilihan[i] == tebak) {
                ada = true;
            } else {
                i = i + 1;
            }
        }
        
        return ada;
    }
    
    public static void game(int uang) {
        boolean hasil;
        int n, i, tebak, ronde;
        
        n = 10;
        i = 0;
        ronde = 0;
        int[] pilihan = new int[n];
        System.out.println("================================================================");
        System.out.println("Uang awal anda Rp" + uang);
        System.out.println("Setiap pasang membayar Rp10000, jika benar mendapatkan hadiah Rp15000");
        System.out.println("Tebak salah satu dari 10 angka benar. Rentang angka 0-20");
        String play, next;
        
        System.out.println("\n"+"PLAY (YES)");
        System.out.print("= ");
        play = input.nextLine();
        play = kapital(play);
        boolean running;
        running = true;
        while (running == true) {
             ronde = ronde + 1;
            System.out.println("================================================================");
            System.out.println("Ronde ke-" + ronde);
            uang = uang - 10000;
            for (i = 0; i <= n - 1; i++) {
                pilihan[i] = random.nextInt(20);
            }
            System.out.print("Tebak angka = ");
            tebak = input.nextInt();
            hasil = cek(pilihan, n, tebak);
            if (hasil == true) {
                System.out.println("\n"+"Selamat! anda mendapatkan hadiah Rp15000");
                uang = uang + 15000;
            } else {
                System.out.println("\n"+"Ayo coba lagi keberuntunganmu semakin mendekat!");
            }
            System.out.println("Sisa uang Anda Rp" + uang);
            if (ronde % 3 == 0) {
               uang = bonus(uang);
            } 
            System.out.println ("\n"+"Next(YES / NO) : ");
            System.out.print("= ");
            next = input.next();
            next = kapital(next);
            if (next.equalsIgnoreCase ("YES") && uang >= 10000){
                running = true;}
            else {
                System.out.println("\n"+"Game berakhir. Sisa uang Anda Rp" + uang);
                        System.exit(0);
            }}
       
    }
    
    public static String kapital(String uppercase) {
        
        String hasil = uppercase.toUpperCase();
        return hasil;
    }}
    
   
