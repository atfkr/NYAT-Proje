package com.Sogutucu;

public class Eyleyici implements IEyleyici{
    boolean acikmi = false;
    @Override
    public void SogutucuyuKapat() {
        if(!acikmi){
            System.out.println("Sogutucu Kapandi");
            acikmi=true;
        }else{
            System.out.println("Sogutucu zaten kapalı");
        }
    }

    @Override
    public void SogutucuyuAc() {
        if(acikmi) {
            System.out.println("Sogutucu Acildi");
            acikmi=false;
        }else{
            System.out.println("Sogutucu zaten açık");
        }
    }
    public boolean Durum(){
        return acikmi;
    }
}
