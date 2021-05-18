package com.Sogutucu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici,ISubject{
    Random r=new Random();
    int a=r.ints(-10,40).findFirst().getAsInt();
    String marka;
    String model;
    String uretimYili;
    private SicaklikAlgilayici(SicaklikAlgilayiciBuilder builder){
        this.marka=builder.marka;
        this.model=builder.model;
        this.uretimYili=builder.uretimYili;
    }


    private List<IObserver> subscribers = new ArrayList<>();

    @Override
    public void attach(IObserver subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void detach(IObserver subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notify(int mesaj) {
        for(IObserver subscriber: subscribers) {
            subscriber.update(mesaj);
        }
    }
    public void sicaklikDegistir(boolean acikmi){
        if (acikmi){
            if(a!=40)
            a=r.ints(a,40).findFirst().getAsInt();
        }else
        {
            if(a!=-10)
            a=r.ints(-10,a).findFirst().getAsInt();
        }

    }
    public void marka(){
        System.out.println("Marka:"+marka+"\nModel:"+model+"\nUretimYili:"+uretimYili);
    }

    @Override
    public void SicaklikOku() {
        notify(a);
    }
    public static class SicaklikAlgilayiciBuilder{
        String marka;
        String model;
        String uretimYili;
        public SicaklikAlgilayiciBuilder(String marka){
            this.marka=marka;
        }
        public SicaklikAlgilayiciBuilder model(String model){
            this.model=model;
            return this;
        }
        public SicaklikAlgilayiciBuilder uretimYili(String uretimYili){
            this.uretimYili=uretimYili;
            return this;
        }
        public SicaklikAlgilayici build(){
            return new SicaklikAlgilayici(this);
        }
    }
}
