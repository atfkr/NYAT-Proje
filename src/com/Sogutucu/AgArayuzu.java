package com.Sogutucu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AgArayuzu implements IAgArayüzü,IObserver{
    IEyleyici eyleyici;
    ISicaklikAlgilayici sicaklikAlgilayici;
    int sicaklik;
    public AgArayuzu(){
        eyleyici=new Eyleyici();
    }
    public void setSic(ISicaklikAlgilayici sic){
        sicaklikAlgilayici = sic;
        sicaklikAlgilayici.SicaklikOku();
    }
    @Override
    public void update(int sicaklik) {
        System.out.println("Sıcaklık: "+ sicaklik);
    }

    @Override
    public void SogutucuyuAc() {
        eyleyici.SogutucuyuAc();
        sicaklikAlgilayici.sicaklikDegistir(eyleyici.Durum());
        SicaklikGonder();
    }

    @Override
    public void SogutucuyuKapat() {
        eyleyici.SogutucuyuKapat();
        sicaklikAlgilayici.sicaklikDegistir(eyleyici.Durum());
        SicaklikGonder();
    }

    @Override
    public void SicaklikGonder() {
        sicaklikAlgilayici.SicaklikOku();
    }
}
