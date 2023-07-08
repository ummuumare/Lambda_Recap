package lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {
    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(-5, -8, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));
//        sayi.add(-5);
//        sayi.add(-8);
//        sayi.add(-12);
//        sayi.add(5);
//        sayi.add(6);
        System.out.println(sayi);
        ciftVePozitifLambdaExpression(sayi);
        System.out.println("\n*********************");
        ciftVePozitifMethodReferance(sayi);
        System.out.println("\n*********************");
        kare(sayi);
        System.out.println("\n***********************");
        kareTekrarsiz(sayi);
        System.out.println("\n***********************");
        buyuktenKucugesiralama(sayi);
        System.out.println("\n***********************");
        pozitifKupBirlerBasamagi5(sayi);
        System.out.println("\n***********************");
        toplamiMethodReferances(sayi);
        System.out.println("\n********************");
        toplamLambdaExpression(sayi);
        System.out.println("\n********************");
        System.out.println(pozitifCarpimLambdaExpression(sayi));
        System.out.println("\n********************");
        System.out.println(ciftKareKucuktenBuyuge(sayi));

    }

    //SORU1: List elemanlarının çift ve pozitif olanlarını,
// Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın
    public static void ciftVePozitifLambdaExpression(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0 && t > 0).forEach(t -> System.out.print(t + " "));//(1.best practice)
        //  sayi.stream().filter(t-> t%2==0 ).filter(t-> t>0).forEach(t-> System.out.print(t+ " "));

    }
//SORU2: List elemanlarının çift ve pozitif olanlarını,
// Method Referances kullanarak aralarında bosluk olacak sekilde yazdırın

    public static void ciftVePozitifMethodReferance(List<Integer> sayi) {
        //  sayi.stream().filter(t-> t%2==0 && t>0).forEach(Utils::yazdir);
        sayi.stream().filter(Utils::ciftPozitifBul).forEach(Utils::yazdir);
    }

    //SORU3 : List elemanlarının karelerini, aralarında bosluk olacak sekilde yazdırın
    public static void kare(List<Integer> sayi) {
        sayi.stream().map(t -> t * t).forEach(Utils::yazdir);
    }

    //SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın
    public static void kareTekrarsiz(List<Integer> sayi) {
        sayi.stream().map(t -> t * t).distinct().forEach(Utils::yazdir);

    }

    //SORU5: List elemanlarını buyukten kucuge sıralayarak yazdırın
    public static void buyuktenKucugesiralama(List<Integer> sayi) {
        sayi.stream().sorted(Comparator.reverseOrder()).forEach(Utils::yazdir);
    }

    // SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup, birler basamagı 5 olanları yazdırınız
    public static void pozitifKupBirlerBasamagi5(List<Integer> sayi) {
        sayi.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).filter(t -> t % 10 == 5).forEach(Utils::yazdir);

    }
    // SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın

    public static void toplamiMethodReferances(List<Integer> sayi) {
        Optional<Integer> sonuc = sayi.stream().reduce(Integer::sum);
        System.out.println(sonuc);
    }
    // SORU8: List elemanlarının Lambda Expression ile toplamını bulun ve yazdırın

    public static void toplamLambdaExpression(List<Integer> sayi) {
        int sonuc = sayi.stream().reduce(0,(t,u)->t + u);
        System.out.println(sonuc);
    }
 //SORU9 : Listin pozitif elemanlarının, carpımını Lambda Expression ile return ederek yazdırın
public static int pozitifCarpimLambdaExpression(List<Integer> sayi){
       int sonuc =  sayi.stream().filter(t->t>0).reduce(1,(t,u)->t*u);
   // System.out.println(sonuc);
    return sonuc;
}
//SORU10 : Listin cift elemanlarının, karelerini, kucukten buyuge sıralayıp list halinde return ederek yazdırınız


    public static List<Integer> ciftKareKucuktenBuyuge(List<Integer> sayi){
        List<Integer> liste =sayi.stream().filter(t->t%2==0).map(t->t*t).sorted().collect(Collectors.toList());
        return liste;
    }
}
