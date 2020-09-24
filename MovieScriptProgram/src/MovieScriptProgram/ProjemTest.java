package MovieScriptProgram;

public class ProjemTest {
    
    public static void main(String[] args) {
        Olay o = new Olay("Bir Doktorun Psikolojik Değişimi", 7, 5, 1995, 8, 45);
        
        Yer y1 = new Yer("Yüzyıl Mahallesi");
        Mekan m1 = new Mekan("Ahmet'in Evi", "Barbaros Caddesi 23.Sokak No: 10");
        y1.mekanEkle(m1);
        Mekan m2 = new Mekan("Zengin Banka", "Kışla Caddesi 45.Sokak No: 34");
        y1.mekanEkle(m2);
        Mekan m3 = new Mekan("Nefis Market", "Yıldırım Caddesi 567.Sokak No: 123");
        y1.mekanEkle(m3);
        y1.mekanOluşturupEkle(4);
        y1.kişiOluşturupEkle(10);
        m3.kişiOluşturupEkle(5);
        System.out.println("y1'deki mekan sayısı: " + y1.getMekanSayısı());
        System.out.println("y1'deki kişi sayısı: " + y1.getKişiSayısı());
        System.out.println("m3'teki kişi sayısı: " + m3.getKişiSayısı());
        
        y1.mekanOluşturupEkle(40);//uyarı verir
        Mekan mekan = new Mekan("Aysel Apartmanı", "Barbaros Caddesi 23.Sokak No: 10");
        y1.mekanEkle(mekan);//uyarı verir

        o.yerEkle(y1);
        
        Yer yer = new Yer("Yüzyıl Mahallesi");
        o.yerEkle(yer);//uyarı verir
        
        System.out.println("y1, o'da mı: " + o.isYerBurda(y1));
        System.out.println("m2, y1'de mi: " + y1.isMekanBurda(m2));
        
        Karakter ka1 = new Karakter("Ahmet", "AK", "Doktor", 27, 180, 85);
        ka1.setKuvvet(500);
        Karakter ka2 = new Karakter("Pınar", "AK", "Ev Hanımı", 25, 160, 54);
        Karakter ka3 = new Karakter("Mustafa", "AK", "Çocuk", 6, 120, 35);
        Karakter ka4 = new Karakter("Ayşe", "AK", "Çocuk", 5, 110, 40);
        m1.karakterEkle(ka1);
        m1.karakterEkle(ka2);
        m1.karakterEkle(ka3);
        m1.karakterEkle(ka4);
        System.out.println("Ahmet'in evindeki kişi sayısı: " + m1.getKişiSayısı());
        System.out.println("Ahmet'in evindeki kişilerin yaşları toplamı: " + m1.getKarakterlerinToplamYaşı());
        System.out.println("Ahmet'in evindeki kişilerin yaşları ortalaması: " + m1.getKarakterlerinYaşlarıOrtalaması());
        System.out.println("Ahmet'in evin adrsi: " + m1.getAdres());
        
        System.out.println("y1'deki toplam kişi sayısı: " + y1.getKişiSayısı());
        
        ka1.uyu();
        ka2.söylemek("Ahmet uyan kahvaltı hazır");
        ka1.uyan();
        
        ka1.yemekYe("yumurta");
        ka2.yemekYe("menemen", "morali bozuk");
        ka3.yemekYe("menemen", 3);
        ka4.yemekYemek("mutlu");
        
        System.out.println("ka2'nin duygusu: " + ka2.getDuygu());
        ka1.öp(ka2);
        System.out.println("ka2'nin duygusu: " + ka2.getDuygu());
        ka1.öp(ka3);
        ka1.öp(ka4);
        ka1.yürü(m1, m2, "mutlu");
        System.out.println("ka1 m1 de mi: " + m1.isKişiBurda(ka1));
        System.out.println("ka1 m2 de mi: " + m2.isKişiBurda(ka1));
        System.out.println("ka1 y1'de mi: " + y1.isKişiBurda(ka1));
        
        Yer y2 = new Yer("Yüzyıl Caddesi");
        o.yerEkle(y2);
        y2.kişiOluşturupEkle(15);
        
        ka1.yürü(m2, y2);
        
        Kişi k1 = new Kişi('e', "Serseri", 30, 175, 90);
        k1.setKuvvet(100);
        y2.kişiEkle(k1);
        
        Kişi k2 = new Kişi('e', "Serseri", 32, 180, 87);
        k2.setKuvvet(120);
        y2.kişiEkle(k2);
        
        System.out.println("Caddedeki toplam kişi sayısı: " + y2.getKişiSayısı());
        System.out.println("Caddedeki toplam karakter sayısı: " + y2.getKarakterSayısı());
        System.out.println("Caddedeki kişilerin boyları ortalaması: " + y2.getKişilerinBoylarıOrtalaması());
        System.out.println("Caddedeki kişilerin kiloları ortalaması: " + y2.getKişilerinKilolarıOrtalaması());
        k1.saldır(ka1);
        k2.saldır(ka1);
        System.out.println("ka1 canlı mı: " + ka1.isCanlı() + ", ka1 yaralı mı: " + ka1.isYaralı());
        System.out.println("k1 canlı mı: " + k1.isCanlı() + ", k1 yaralı mı: " + k1.isYaralı());
        System.out.println("k2 canlı mı: " + k2.isCanlı() + ", k2 yaralı mı: " + k2.isYaralı());
        ka1.saldır(k2, "Korku");
        System.out.println("k2 canlı mı: " + k2.isCanlı());
        
        Kişi k3 = new Kişi('k', 50, 170, 100);
        y2.kişiEkle(k3);
        
        Kişi k4 = new Kişi('k', 19, 158, 55);
        y2.kişiEkle(k4);
        
        Kişi k5 = new Kişi('e', 34, 163, 71);
        y2.kişiEkle(k5);
        
        k3.setDuygu("korku");
        k4.setDuygu("hüzün");
        k5.setDuygu("korku");
        
        ka1.öldür(k3);
        ka1.öldür(k4);
        ka1.öldür(k5);
        
        Yer y3 = new Yer("Zincirli Kuyu Mezarlığı");
        o.yerEkle(y3);
        
        ka1.git(y2, y3);
        ka1.gömmek(k3, y2, y3);
        ka1.gömmek(k4, y2, y3);
        ka1.gömmek(k5, y2, y3);
        ka1.yürü(y3, m3, "durgun");
        System.out.println("ka1'in o anlık duygusu: " + ka1.getDuygu());
        
        Kişi k6 = new Kişi('k', "Kasiyer", 26, 150, 53);
        m3.kişiEkle(k6);
        k6.setKuvvet(150);
        
        k6.söylemek("borcunuz 150 TL beyfendi");
        ka1.söylemek("yanımda bu kadar yok bir kısmını sonra ödesem olur mu");
        k6.söylemek("Üzgünüm beyfendi!");
        ka1.söylemek("İnsanlık ölmüş resmen. Sonra ödesek nolcak!");
        ka1.saldır(k6, "öfke");
        System.out.println("k6 canlı mı: " + k6.isCanlı() + ", k6 yaralı mı: " + k6.isYaralı());
        ka1.koş(m3, y2);
        
        Karakter ka5 = new Karakter("Murat", "Yakalar", "Başkomiser", 29, 176, 84);
        Karakter ka6 = new Karakter("Mustafa", "Yakalatan", "Başkomiser Yardımcısı", 26, 180, 80);

        //aynı tip ve aynı ada sahip bir karakteri eklemeye çalışalım ama olmaz
        Karakter ka7 = new Karakter("Murat", "Yakalar", "Başkomiser", 36, 189, 90);
        Karakter ka8 = new Karakter("Mustafa", "Bozok", "Doktor", 32, 176, 80);
        Karakter ka9 = new Karakter("Mustafa", "Emir", "Doktor", 37, 190, 100);
        
        y2.karakterEkle(ka5);
        y2.karakterEkle(ka6);
        y2.karakterEkle(ka7);//uyarı verir
        m3.karakterEkle(ka8);//uyarı verir
        m3.karakterEkle(ka9);//uyarı verir

        ka1.koş(y2, y1, "pişman olmaksızın");
        ka1.söylemek("Yaptğımıdan hiç pişman değilim!");
        ka6.söylemek("Dur kaçma yakalayacağız seni");
        ka5.söylemek("Kaçacak yerin yok dur");
        ka5.koş(y2, y1);
        ka6.koş(y2, y1);
        
        Yer y4 = new Yer("Liman");
        o.yerEkle(y4);
        
        ka1.koş(y1, y4);
        ka1.söylemek("Oh be sonunda onları atlattım");
        ka1.söylemek("bun olanlar çok eğlenceli hahahaha");
        
        Yer y5 = new Yer("Karakol");
        o.yerEkle(y5);
        ka5.git(y1, y5);
        ka6.git(y1, y5);
        
        Yer y6 = new Yer("Büyük Ada");
        Mekan m4 = new Mekan("Ahmet'in Yazlığı", "A Caddesi 1.Sokak No: 10");
        y6.mekanEkle(m4);
        o.yerEkle(y6);
        ka1.git(y4, y6);
        ka1.setKuvvet(700);
        
        o.setYıl(2010);
        //yıl değiştiği için yaşlar da değişir
        System.out.println("ka1'in yaşı: " + ka1.getYaş());
        System.out.println("ka2'ninyaşı: " + ka2.getYaş());
        System.out.println("k6'nın yaşı: " + k6.getYaş());
        
        Yer y7 = new Yer("Bahtiyar Cafe");
        o.yerEkle(y7);
        ka6.git(y5, y7);
        ka1.git(y6, y7, "Sakin");
        ka1.öldür(ka6, "Duygusuzca");
        ka1.koş(y7, y2);
        Kişi k7 = new Kişi();
        y2.kişiEkle(k7);
        System.out.println("k7 burda mı: " + y2.isKişiBurda(k7));
        ka1.kişiyiOrtadanKaldır(y2, k7);
        System.out.println("k7 burda mı: " + y2.isKişiBurda(k7));
        ka5.git(y5, y7);
        ka5.söylemek("Hayır intikamını alacam kardeşim");
        ka5.git(y7, y2, "Büyük bir öfke");
        ka5.setKuvvet(250);
        ka5.saldır(ka1);
        System.out.println("ka5 canlı mı: " + ka5.isCanlı() + "ka5 yaralı mı: " + ka5.isYaralı());
        ka1.öldür(ka5, "soğuk kanlılıkla");
        System.out.println("ka5 canlı mı: " + ka5.isCanlı());
        ka1.git(y2, m1);
        System.out.println("Bu olaydaki mekan sayısı: " + o.getToplamMekanSayısı());
        System.out.println("Bu olaydaki toplam kii sayısı: " + o.getToplamKişiSayısı());
        System.out.println("Bu olaydaki toplam karakter sayısı: " + o.getToplamKarakterSayısı());
        System.out.println("m1 mekanı burda mı: " + y1.isMekanBurda(m1));
        ka1.mekanıYak(y1, m1);
        System.out.println("m1 mekanı var mı: " + y1.isMekanBurda(m1));
        ka1.intiharEt();
        System.out.println("y7 burda mı: " + o.isYerBurda(y7));
        o.deprem(y7);
        System.out.println("y7 burda mı: " + o.isYerBurda(y7));
        System.out.println("ka1 canlı mı: " + ka1.isCanlı());
        System.out.println("Bu olaydaki yer sayısı: " + o.getYerSayısı());
        System.out.println("Bu olaydaki mekan sayısı: " + o.getToplamMekanSayısı());
        System.out.println("Bu olaydaki toplam kişi sayısı: " + o.getToplamKişiSayısı());
        System.out.println("Bu olaydaki toplam karakter sayısı: " + o.getToplamKarakterSayısı());
        System.out.println("y1'deki kişi sayısı: " + y1.getKişiSayısı() + ", y1'deki karakter sayısı: " + y1.getKarakterSayısı());
        System.out.println("y2'deki kişi sayısı: " + y2.getKişiSayısı() + ", y2'deki karakter sayısı: " + y2.getKarakterSayısı());
        System.out.println("y3'deki kişi sayısı: " + y3.getKişiSayısı() + ", y3'deki karakter sayısı: " + y3.getKarakterSayısı());
        System.out.println("y4'deki kişi sayısı: " + y4.getKişiSayısı() + ", y4'deki karakter sayısı: " + y4.getKarakterSayısı());
        System.out.println("y5'deki kişi sayısı: " + y5.getKişiSayısı() + ", y5'deki karakter sayısı: " + y5.getKarakterSayısı());
        System.out.println("y6'deki kişi sayısı: " + y6.getKişiSayısı() + ", y6'deki karakter sayısı: " + y6.getKarakterSayısı());
        System.out.println("y7'deki kişi sayısı: " + y7.getKişiSayısı() + ", y7'deki karakter sayısı: " + y7.getKarakterSayısı());
        System.out.println("Bu olaydaki karakterlerin yaşları ortalaması: " + o.getKarakterlerinYaşlarıOrtalaması());
        System.out.println("Bu olaydaki kişilerin ortalama yaşı: " + o.getKişilerinYaşlarıOrtalaması());
        System.out.println("Bu olaydaki karakterlerin ortalama kilosu: " + o.getKarakterlerinKilolarıOrtalaması());
        System.out.println("Bu olaydaki kişilerin boyları ortalaması: " + o.getKişilerinBoylarıOrtalaması());
        System.out.println("Kötü Son!");
        
    }
}
