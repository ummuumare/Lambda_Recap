package lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda02 {
    public static void main(String[] args) {
        List<String> meyve = new ArrayList<>(Arrays.asList("elma", "portakal", "cilek", "uzum", "greyfurt", "nar",
                "armut", "elma", "keciboynuzu", "elma"));
        ilkHarfEveyaC(meyve);
        System.out.println("\n**********************");
        basVeSonYildizEkle(meyve);
        System.out.println("\n**********************");
        icindeEHarfOlan(meyve);
        System.out.println(" \n  *******");
        lHarfiniSil(meyve);
        System.out.println(" \n  *******");
        karakterSayisinaGoreKucBuyLambdaEx(meyve);
        System.out.println(" \n  *******");
        karakterSayisinaGoreBuyKucLambdaEx(meyve);
        System.out.println(" \n  *******");
        karakterSayisinaGoreBuyKucMethodRef(meyve);
    }


// SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari, Method References ile aralarında bosluk bırakarak yazdıralım

    public static void ilkHarfEveyaC(List<String> meyve) {
        meyve.stream().filter(t -> t.startsWith("e") || t.startsWith("c")).forEach(Utils::yazdir);
    }

    // SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basVeSonYildizEkle(List<String> meyve) {
        meyve.stream().map(t -> "*" + t + "*").forEach(Utils::yazdir);
    }
// SORU3 : List elemanlarının icinde 'e' harfi olanları yazdırın

    public static void icindeEHarfOlan(List<String> meyve) {
        meyve.stream().filter(t -> t.contains("e")).forEach(Utils::yazdir);
    }

    // SORU4 : List elemanlarındaki 'l' harflerini silip yazdırınız
    public static void lHarfiniSil(List<String> meyve) {

        meyve.stream().map(t -> t.replace("l", "")).forEach(Utils::yazdir);
    }

    // SORU5 : List elemanlarini, Lambda Expression kullanarak
    // karakter sayisina göre kucukten buyuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreKucBuyLambdaEx(List<String> meyve) {
        meyve.stream().sorted(Comparator.comparing(t -> t.length())).forEach(Utils::yazdir);
    }

    // SORU5.1 : List elemanlarini, Lambda Expression kullanarak
    // karakter sayisina göre buyuge kucuge dogru sıralayarak yazdırınız

    public static void karakterSayisinaGoreBuyKucLambdaEx(List<String> meyve) {
        meyve.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).forEach(Utils::yazdir);
    }

    // SORU6 : List elemanlarini, Method References kullanarak
    // karakter sayisina göre buyukten kucuge dogru sıralayarak yazdırınız
    public static void karakterSayisinaGoreBuyKucMethodRef(List<String> meyve) {
        meyve.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::yazdir);

    }
}