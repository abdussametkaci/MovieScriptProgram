package MovieScriptProgram;

import java.util.ArrayList;

public class Yer {//olayın yaşandığı yerdir

    String adres;
    private ArrayList<Kişi> kişiler = new ArrayList();
    private Mekan[] mekanlar = new Mekan[10];

    public Yer() {
    }

    public Yer(String adres) {
        this.adres = adres;
    }

    public String getAdres() {
        return adres;
    }

    public Mekan[] getMekanlar() {
        return mekanlar;
    }

    public Mekan getMekan(int konum) {
        return mekanlar[konum];
    }

    public ArrayList<Kişi> getKişiler() {
        return kişiler;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setMekanlar(Mekan[] mekanlar) {
        this.mekanlar = mekanlar;
    }

    public void setKişiler(ArrayList<Kişi> kişiler) {
        this.kişiler = kişiler;
    }

    public void kişiEkle(Kişi k) {
        kişiler.add(k);
    }

    public void kişiÇıkar(Kişi k) {
        kişiler.remove(k);
    }

    public void karakterEkle(Karakter k) {
        boolean isVar = false;
        for (Kişi ki : kişiler) {
            if (ki instanceof Karakter && ((Karakter) ki).ad == k.ad && ((Karakter) ki).tip == k.tip) {
                isVar = true;
            }

        }

        if (isVar == false) {
            kişiler.add(k);
        } else {
            System.out.println("Bu ad ve tipe sahip bir karakter bu yere eklenemez!");
        }
    }

    public void karakterÇıkar(Karakter k) {
        kişiler.remove(k);
    }

    public int getKişiSayısı() {
        int toplamKişiSayısı = 0;
        //bu yerdeki mekanlardaki toplam kişi sayısı
        for (int i = 0; i < mekanlar.length; i++) {
            if (mekanlar[i] != null) {
                toplamKişiSayısı += mekanlar[i].getKişiSayısı();
            }
        }
        //kişiler.size() belli bir mekanda bulunmayıp sadece o yerde bulunan kişi sayısını verir
        return (kişiler.size() + toplamKişiSayısı);
    }

    public int getKarakterSayısı() {
        int toplamKarakter = 0;
        for (Kişi k : kişiler) {
            if (k instanceof Karakter) {
                toplamKarakter++;
            }
        }

        for (int i = 0; i < mekanlar.length; i++) {
            if (mekanlar[i] != null) {
                toplamKarakter += mekanlar[i].getKarakterSayısı();
            }
        }

        return toplamKarakter;
    }

    public int getMekanSayısı() {
        int toplamMekan = 0;
        for (Mekan b : mekanlar) {
            if (b != null) {
                toplamMekan++;
            }
        }
        return toplamMekan;
    }

    public void mekanEkle(Mekan m) {
        boolean isVar = false;
        for (int i = 0; i < mekanlar.length; i++) {
            if (mekanlar[i] != null && mekanlar[i].adres == m.adres) {
                isVar = true;
            }
        }

        if (isVar == false) {
            if (getMekanSayısı() < mekanlar.length) {
                for (int i = 0; i < mekanlar.length; i++) {
                    if (mekanlar[i] == null) {
                        mekanlar[i] = m;
                        break;
                    }
                }
            } else {
                System.out.println("Maksimum mekan zaten eklendi!");
            }
        } else {
            System.out.println("Aynı adrese sahip bir mekan eklenemez!");
        }
    }

    public void mekanÇıkar(Mekan m) {
        for (int i = 0; i < mekanlar.length; i++) {
            if (mekanlar[i] == m) {
                mekanlar[i] = null;
            }
        }
    }

    public int getKişilerinToplamYaşı() {
        int toplamYaş = 0;
        for (Kişi k : kişiler) {
            toplamYaş += k.yaş;
        }

        for (Mekan m : mekanlar) {
            if (m != null) {
                toplamYaş += m.getKişilerinToplamYaşı();
            }

        }
        return toplamYaş;
    }

    public int getKarakterlerinToplamYaşı() {
        int toplamYaş = 0;
        for (Kişi k : kişiler) {
            if (k instanceof Karakter) {
                toplamYaş += ((Karakter) k).yaş;
            }
        }

        for (Mekan m : mekanlar) {
            if (m != null) {
                toplamYaş += m.getKarakterlerinToplamYaşı();
            }
        }
        return toplamYaş;
    }

    public double getKişilerinYaşlarıOrtalaması() {
        double ortalamaYaş = 0;
        int toplamYaş = 0;
        for (int i = 0; i < kişiler.size(); i++) {
            toplamYaş += kişiler.get(i).yaş;
        }

        for (int i = 0; i < mekanlar.length; i++) {
            if (mekanlar[i] != null) {
                toplamYaş += mekanlar[i].getKişilerinToplamYaşı();
            }
        }
        ortalamaYaş = (double) toplamYaş / kişiler.size();
        return ortalamaYaş;
    }

    public double getKarakterlerinYaşlarıOrtalaması() {
        double ortalamaYaş = 0;
        int toplamYaş = 0;
        int sayaç = 0;
        for (int i = 0; i < kişiler.size(); i++) {
            if (kişiler.get(i) instanceof Karakter) {
                toplamYaş += kişiler.get(i).yaş;
                sayaç++;
            }
        }

        for (int i = 0; i < mekanlar.length; i++) {
            if (mekanlar[i] != null) {
                toplamYaş += mekanlar[i].getKarakterlerinToplamYaşı();
            }
        }
        ortalamaYaş = (double) toplamYaş / sayaç;
        return ortalamaYaş;
    }

    public int getKişilerinToplamKilosu() {
        int toplamKilo = 0;
        for (Kişi k : kişiler) {
            toplamKilo += k.kilo;
        }

        for (Mekan m : mekanlar) {
            if (m != null) {
                toplamKilo += m.getKişilerinToplamKilosu();
            }
        }
        return toplamKilo;
    }

    public int getKarakterlerinToplamKilosu() {
        int toplamKilo = 0;
        for (Kişi k : kişiler) {
            if (k instanceof Karakter) {
                toplamKilo += ((Karakter) k).kilo;
            }
        }

        for (Mekan m : mekanlar) {
            if (m != null) {
                toplamKilo += m.getKarakterlerinToplamKilosu();
            }
        }
        return toplamKilo;
    }

    public double getKişilerinKilolarıOrtalaması() {
        return (double) getKişilerinToplamKilosu() / getKişiSayısı();
    }

    public double getKarakterlerinKilolarıOrtalaması() {
        return (double) getKarakterlerinToplamKilosu() / getKarakterSayısı();
    }

    public int getKişilerinToplamBoyu() {
        int toplamBoy = 0;
        for (Kişi k : kişiler) {
            toplamBoy += k.boy;
        }

        for (Mekan m : mekanlar) {
            if (m != null) {
                toplamBoy += m.getKişilerinToplamBoyu();
            }

        }
        return toplamBoy;
    }

    public int getKarakterlerinToplamBoyu() {
        int toplamBoy = 0;
        for (Kişi k : kişiler) {
            if (k instanceof Karakter) {
                toplamBoy += ((Karakter) k).boy;
            }
        }

        for (Mekan m : mekanlar) {
            if (m != null) {
                toplamBoy += m.getKarakterlerinToplamBoyu();
            }
        }
        return toplamBoy;
    }

    public double getKişilerinBoylarıOrtalaması() {
        return (double) getKişilerinToplamBoyu() / getKişiSayısı();
    }

    public double getKarakterlerinBoylarıOrtalaması() {
        return (double) getKarakterlerinToplamBoyu() / getKarakterSayısı();
    }

    public void kişiOluşturupEkle() {
        Kişi k = new Kişi();
        kişiler.add(k);
    }

    public void kişiOluşturupEkle(int oluşturulacakKişiSayısı) {
        for (int i = 0; i < oluşturulacakKişiSayısı; i++) {
            Kişi k = new Kişi();
            kişiler.add(k);
        }
    }

    public void mekanOluşturupEkle() {
        if (getMekanSayısı() < mekanlar.length) {
            for (int i = 0; i < mekanlar.length; i++) {
                if (mekanlar[i] == null) {
                    Mekan m = new Mekan();
                    mekanlar[i] = m;
                    break;
                }
            }
        } else {
            System.out.println("Mekan oluşturulup eklenemedi!");
        }
    }

    public void mekanOluşturupEkle(int oluşturulacakMekanSayısı) {
        int boşAlan = 0;
        for (int i = 0; i < mekanlar.length; i++) {
            if (mekanlar[i] == null) {
                boşAlan++;
            }
        }

        if (boşAlan < oluşturulacakMekanSayısı) {
            System.out.println("Bu yerde bu sayıda yer yoktur!");
        } else {
            for (int i = 0; i < oluşturulacakMekanSayısı; i++) {
                for (int j = 0; j < mekanlar.length; j++) {
                    if (mekanlar[j] == null) {
                        Mekan m = new Mekan();
                        mekanlar[j] = m;
                        break;
                    }
                }
            }
        }
    }

    public boolean isKişiBurda(Kişi k) {
        boolean burda = false;
        for (Kişi k1 : kişiler) {
            if (k1 == k) {
                burda = true;
            }
        }

        if (burda == false) {
            for (Mekan m : mekanlar) {
                if (m != null) {
                    for (Kişi k2 : m.getŞahıslar()) {
                        if (k2 != null && k2 == k) {
                            burda = true;
                        }
                    }
                }
            }
        }

        return burda;
    }

    public boolean isMekanBurda(Mekan mekan) {
        boolean burda = false;
        for (Mekan m : mekanlar) {
            if (m != null && m == mekan) {
                burda = true;
            }
        }

        return burda;

    }

}
