package com.Sogutucu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        String kullaniciAdi;
        String sifre;
        String swtch;
        Scanner input=new Scanner(System.in);
        boolean kontrol;
        Arayuz a= new Arayuz();
        System.out.println("Soğutucu Başlatıldı");
        do{
            System.out.println("Kullanici Adi Girin:");
            input=new Scanner(System.in);
            kullaniciAdi=input.next();
            System.out.println("Sifre Girin:");
            input=new Scanner(System.in);
            sifre = input.next();
            kontrol=a.girisYap(kullaniciAdi,sifre);
        }while(!kontrol);
        if(kontrol){
            AgArayuzu ag=new AgArayuzu();
            SicaklikAlgilayici sic = new SicaklikAlgilayici.SicaklikAlgilayiciBuilder("Siemens").build();
            ag.setSic(sic);
            sic.attach(ag);
            sic.SicaklikOku();
            do{
                System.out.println(" Yapmak istediğiniz işlem[A/K/C]:");
                input=new Scanner(System.in);
                swtch=input.next();
                int i;
                if(swtch.equals("A"))
                    i=0;
                else if(swtch.equals("K"))
                    i=1;
                else if(swtch.equals("C"))
                    i=2;
                else if(swtch.equals("S"))
                    i=4;
                else
                    i=3;
                switch (i){
                    case 0:
                        ag.SogutucuyuAc();

                        break;

                    case 1:
                        ag.SogutucuyuKapat();

                        break;

                    case 2:
                        System.exit(0);
                        break;

                    case 3:
                        System.out.println("Hatalı Seçim");
                        break;
                    case 4:
                        sic.marka();
                        break;

                }
            }while (true);


        }
    }
}
