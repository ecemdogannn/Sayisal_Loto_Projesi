import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Sayısal loto Uygulaması
        // Kullanıcıdan sayı alma
        Scanner Scanner = new Scanner(System.in);
        ArrayList<Integer> loto = new ArrayList<Integer>(); // rastgeleDegerler adında bir ArrayList nesnesi oluşturulmuş olur ve bu ArrayList sadece Integer türündeki verileri tutar.
        System.out.println("Loto için 6 hanelik değer giriniz!");
        for (int i = 0; i < 6; i++) { // Kullanıcıdan 6 tane tam sayı girmesi istenir.
            int Sayi;
            while (true) { // Döngüsü kullanarak, kullanıcının girdiği değerin 50'den küçük olup olmadığını kontrol ediyoruz.
                System.out.print("Kullanıcının girdiği " + (i + 1) + ". değer: ");
                if (Scanner.hasNextInt()){ // Kullanıcının girdiği değerin numeric olup olmadığını kontrol eder.
                    Sayi = Scanner.nextInt(); // Kullanıcıdan girdi alınır.
                    Scanner.nextLine();


                    if (Sayi >= 50) { // Eğer sayı 50'den küçükse yeni bir deger gir.
                        System.out.println("Hata: 50'den küçük bir değer giriniz!");


                    } else if (loto.contains(Sayi)) { // Kullanıcının girdiği sayının daha önce girilip girilmediğini kontrol eder. Eğer tekrarlanan sayı girilirse kullanıcıdan yeni bir sayı girmesi istenir.
                        System.out.println("Hata: Bu sayı zaten girildi, farklı bir sayı giriniz!");


                    } else {
                        loto.add(Sayi); // Geçerli bir değer girildiğinde bu değer Sayi değişkenindeki loto listesine eklenir.
                        System.out.println("İşleminize devam edebilirsiniz.");
                        break; // Eğer sayı 50'ye eşit veya büyük değilse işlemler doğru bu yüzden bu döngüden çıkar.
                    }

                }
                else // Eğer girilen değer alphanumeric ise hata yazdırır.
                {
                    System.out.println("Hata: Harf girdiniz. Lütfen bir sayı giriniz!");
                    Scanner.nextLine();
                }
            }

        }

        System.out.println("************************************************************");
        Collections.sort(loto); // Arrayliste sıralama işlemi yapar. Dizileri büyükten-küçüğe sıralar.
        System.out.println("Sıralanmış Kullanıcı Değerleri: " + loto);
        System.out.println("************************************************************");

        //  Sistemden sayı alma
        Random deger=new Random(); //random sınıfı: rastgele sayı üretmek için kullanılan bir sınıftıe.
        ArrayList <Integer> rastgeleDegerler= new ArrayList<Integer>(); // Sistemden alınan değerleri tutacak rastgeleDegerler adlı bir Arraylist nesnesi oluşturuyoruz.
        for (int i = 0; i<6; i++){ // Sistemden 6 tane sayı alır.
            int d = deger.nextInt(50); //1-49 a kadar bize random degerler üretir.

            if (!rastgeleDegerler.contains(d)) { // Eğer sistemden alınan sayı  tekrar edilmemişse...
                rastgeleDegerler.add(d);         // bunu  değeri rastgele degerler listesine ekle.
                System.out.println("Çekiliş " + (i+1) + ". değeri: " + d);
            }

        }

        System.out.println("************************************************************");
        Collections.sort(rastgeleDegerler);
        System.out.println("Sıralanmış Çekiliş Değerleri: " + rastgeleDegerler);
        System.out.println("************************************************************");

        // kullanıcının girdiği sayılar ile rastgele sayıların karşılaştırılması
        int sayac = 0;
        for (int i = 0; i < 6; i++) {
            int kullaniciDegeri = loto.get(i); // Kullanıcıdan alınan sayıları getirir.
            int rastgeleDeger = rastgeleDegerler.get(i); // Sistemden alınan sayıları getirir.

            if (rastgeleDeger == kullaniciDegeri) { // Sistemden alınan degerler ile kullanıcıdan alınan degerler eşleşip eşleşmediğine bakılır.
               System.out.println((i + 1) + ". değer: Kullanıcı değeri " + kullaniciDegeri + " ile çekiliş değeri " + rastgeleDeger + " eşleşti.");
               sayac++; // Eşleşme olduğunda sayac'ı arttırsın.
            } else {
                System.out.println((i + 1) + ". değer: Kullanıcı değeri " + kullaniciDegeri + " ile çekiliş değeri " + rastgeleDeger + " eşleşmedi.");
            }

        }

        System.out.println("************************************************************");
        System.out.println((sayac) + " Bildiniz. " );

    }
}
