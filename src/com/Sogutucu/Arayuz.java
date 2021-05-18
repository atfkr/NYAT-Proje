package com.Sogutucu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Arayuz {
    public boolean girisYap(String kullaniciAdi,String sifre) {
        boolean giris = true;
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Sogutucu",
                    "postgres", "atif");
            if (conn != null){}
            else
                System.out.println("Bağlantı girişimi başarısız!");
            String sql = "SELECT *  FROM kullanici";
            String KA;
            String S;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                KA = rs.getString("KullaniciAdi");
                S = rs.getString("Sifre");
                if (KA.equals(kullaniciAdi) && S.equals(sifre)) {
                    conn.close();
                    return true;
                }
            }
            conn.close();
            System.out.println("Giriş başarısız!");
            return false;

        } catch (Exception e) {
            e.printStackTrace();
        }
    return false;
    }
}
