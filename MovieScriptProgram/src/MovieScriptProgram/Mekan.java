package MovieScriptProgram;

public class Mekan extends Yer {

    String isim;
    private Kişi[] şahıslar = new Kişi[20];

    public Mekan() {
    }

    public Mekan(String isim) {
        this.isim = isim;
    }

    public Mekan(String isim, String adres) {
        super(adres);
        this.isim = isim;
    }

    public String getİsim() {
        return isim;
    }

    public Kişi[] getŞahıslar() {
        return şahıslar;
    }

    public String getAdres() {
        return super.getAdres();
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public void setİsim(String isim) {
        this.isim = isim;
    }

    public void setKişiler(Kişi[] şahıslar) {
        this.şahıslar = şahıslar;
    }

    public void kişiEkle(Kişi k) {
        if (getKişiSayısı() < şahıslar.length) {
            for (int i = 0; i < şahıslar.length; i++) {
                if (şahıslar[i] == null) {
                    şahıslar[i] = k;
                    break;
                }
            }
        } else {
            System.out.println("Eklenebilecek maksimum kişi zaten eklendi!");
        }
    }

    public void kişiÇıkar(Kişi k) {
        for (int i = 0; i < şahıslar.length; i++) {
            if (şahıslar[i] == k) {
                şahıslar[i] = null;
            }
        }
    }

    public void karakterEkle(Karakter ka) {
        boolean isVar = false;
        if (getKişiSayısı() < şahıslar.length) {
            for (int i = 0; i < şahıslar.length; i++) {
                if (şahıslar[i] != null && şahıslar[i] instanceof Karakter && ((Karakter) şahıslar[i]).ad == ka.ad && ((Karakter) şahıslar[i]).tip == ka.tip) {
                    isVar = true;
                }
            }

            if (isVar == false) {
                for (int i = 0; i < şahıslar.length; i++) {
                    if (şahıslar[i] == null) {
                        şahıslar[i] = ka;
                        break;
                    }
                }

            } else {
                System.out.println("Bu ad ve tipe sahip bir karakter bu mekana eklenemez!");
            }

        } else {
            System.out.println("Eklenebilecek kişi sayısı zaten eklendi!");
        }
    }

    public void karakterÇıkar(Karakter ka) {
        for (int i = 0; i < şahıslar.length; i++) {
            if (şahıslar[i] == ka) {
                şahıslar[i] = null;
            }
        }
    }

    public int getKişiSayısı() {
        int toplamKişi = 0;
        for (Kişi k : şahıslar) {
            if (k != null) {
                toplamKişi++;
            }
        }

        return toplamKişi;
    }

    public int getKarakterSayısı() {
        int toplamKarakter = 0;
        for (Kişi k : şahıslar) {
            if (k instanceof Karakter) {
                toplamKarakter++;
            }
        }

        return toplamKarakter;
    }

    public int getKişilerinToplamYaşı() {
        int toplamYaş = 0;
        for (int i = 0; i < şahıslar.length; i++) {
            if (şahıslar[i] != null) {
                toplamYaş += şahıslar[i].yaş;
            }
        }
        return toplamYaş;
    }

    public int getKarakterlerinToplamYaşı() {
        int toplamYaş = 0;
        for (Kişi k : şahıslar) {
            if (k != null) {
                if (k instanceof Karakter) {
                    toplamYaş += ((Karakter) k).yaş;
                }
            }
        }
        return toplamYaş;
    }

    public double getKişilerinYaşlarıOrtalaması() {
        double ortalamaYaş = 0;
        int toplamYaş = 0;
        int sayaç = 0;
        for (Kişi k : şahıslar) {
            if (k != null) {
                toplamYaş += k.yaş;
                sayaç++;
            }
        }
        ortalamaYaş = (double) toplamYaş / sayaç;
        return ortalamaYaş;
    }

    public double getKarakterlerinYaşlarıOrtalaması() {
        double ortalamaYaş = 0;
        int toplamYaş = 0;
        int sayaç = 0;
        for (Kişi k : şahıslar) {
            if (k != null) {
                if (k instanceof Karakter) {
                    toplamYaş += ((Karakter) k).yaş;
                    sayaç++;
                }
            }
        }
        ortalamaYaş = (double) toplamYaş / sayaç;
        return ortalamaYaş;
    }

    public int getKişilerinToplamKilosu() {
        int toplamKilo = 0;
        for (int i = 0; i < şahıslar.length; i++) {
            if (şahıslar[i] != null) {
                toplamKilo += şahıslar[i].kilo;
            }
        }
        return toplamKilo;
    }

    public int getKarakterlerinToplamKilosu() {
        int toplamKilosu = 0;
        for (Kişi k : şahıslar) {
            if (k != null) {
                if (k instanceof Karakter) {
                    toplamKilosu += ((Karakter) k).kilo;
                }
            }
        }
        return toplamKilosu;
    }

    public double getKişilerinKilolarıOrtalaması() {
        return (double) getKişilerinToplamKilosu() / getKişiSayısı();
    }

    public double getKarakterlerinKilolarıOrtalaması() {
        return (double) getKarakterlerinToplamKilosu() / getKarakterSayısı();
    }

    public int getKişilerinToplamBoyu() {
        int toplamBoy = 0;
        for (int i = 0; i < şahıslar.length; i++) {
            if (şahıslar[i] != null) {
                toplamBoy += şahıslar[i].boy;
            }
        }
        return toplamBoy;
    }

    public int getKarakterlerinToplamBoyu() {
        int toplamBoy = 0;
        for (Kişi k : şahıslar) {
            if (k != null) {
                if (k instanceof Karakter) {
                    toplamBoy += ((Karakter) k).boy;
                }
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
        if (getKişiSayısı() < şahıslar.length) {
            for (int i = 0; i < şahıslar.length; i++) {
                if (şahıslar[i] == null) {
                    Kişi k = new Kişi();
                    şahıslar[i] = k;
                    break;
                }
            }
        } else {
            System.out.println("Kişi oluşturulup eklenemedi!");
        }
    }

    public void kişiOluşturupEkle(int oluşturulacakKişiSayısı) {
        int boşAlan = 0;
        for (int i = 0; i < şahıslar.length; i++) {
            if (şahıslar[i] == null) {
                boşAlan++;
            }
        }

        if (boşAlan < oluşturulacakKişiSayısı) {
            System.out.println("Mekanda bu sayıda yer yoktur!");
        } else {
            for (int i = 0; i < oluşturulacakKişiSayısı; i++) {
                for (int j = 0; j < şahıslar.length; j++) {
                    if (şahıslar[j] == null) {
                        Kişi k = new Kişi();
                        şahıslar[j] = k;
                        break;
                    }
                }
            }
        }
    }

    public boolean isKişiBurda(Kişi k) {
        boolean burda = false;
        for (int i = 0; i < şahıslar.length; i++) {
            if (şahıslar[i] != null && şahıslar[i] == k) {
                burda = true;
            }
        }
        return burda;
    }

}
