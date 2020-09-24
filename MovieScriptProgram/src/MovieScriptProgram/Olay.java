package MovieScriptProgram;

import java.util.ArrayList;

public class Olay {

    String olayAdı;
    int gün, ay, yıl, saat, dakika;
    ArrayList<Yer> yerler = new ArrayList();

    public Olay() {
    }

    public Olay(String olayAdı) {
        this.olayAdı = olayAdı;
    }

    public Olay(String olayAdı, int gün, int ay, int yıl, int saat, int dakika) {
        this.olayAdı = olayAdı;
        this.gün = gün;
        this.ay = ay;
        this.yıl = yıl;
        this.saat = saat;
        this.dakika = dakika;
    }

    public Olay(int gün, int ay, int yıl, int saat, int dakika) {
        this.gün = gün;
        this.ay = ay;
        this.yıl = yıl;
        this.saat = saat;
        this.dakika = dakika;
    }

    public void setYerler(ArrayList<Yer> yerler) {
        this.yerler = yerler;
    }

    public String getOlayAdı() {
        return olayAdı;
    }

    public ArrayList<Yer> getYerler() {
        return yerler;
    }

    public void setZaman(int gün, int ay, int yıl, int saat, int dakika) {
        this.gün = gün;
        this.ay = ay;
        this.saat = saat;
        this.dakika = dakika;
        setYıl(yıl);
    }

    public void setOlayAdı(String olayAdı) {
        this.olayAdı = olayAdı;
    }

    public int getYerSayısı() {
        return yerler.size();
    }

    public int getToplamKişiSayısı() {
        int toplamKişiSayısı = 0;
        for (Yer y : yerler) {
            toplamKişiSayısı += y.getKişiSayısı();
        }

        return toplamKişiSayısı;
    }

    public int getToplamKarakterSayısı() {
        int toplamKarakterSayısı = 0;
        for (Yer y : yerler) {
            toplamKarakterSayısı += y.getKarakterSayısı();
        }
        return toplamKarakterSayısı;
    }

    public int getKişilerinToplamYaşı() {
        int toplamYaş = 0;
        for (int i = 0; i < yerler.size(); i++) {
            toplamYaş += yerler.get(i).getKişilerinToplamYaşı();
        }

        return toplamYaş;
    }

    public int getKarakterlerinToplamYaşı() {
        int toplamYaş = 0;
        for (Yer y : yerler) {
            toplamYaş += y.getKarakterlerinToplamYaşı();
        }

        return toplamYaş;
    }

    public double getKişilerinYaşlarıOrtalaması() {
        return (double) getKişilerinToplamYaşı() / getToplamKişiSayısı();
    }

    public double getKarakterlerinYaşlarıOrtalaması() {
        return (double) getKarakterlerinToplamYaşı() / getToplamKarakterSayısı();
    }

    public int getKişilerinToplamBoyu() {
        int toplamBoy = 0;
        for (Yer y : yerler) {
            toplamBoy += y.getKişilerinToplamBoyu();
        }
        return toplamBoy;
    }

    public int getKarakterlerinToplamBoyu() {
        int toplamBoy = 0;
        for (Yer y : yerler) {
            toplamBoy += y.getKarakterlerinToplamBoyu();
        }
        return toplamBoy;
    }

    public double getKişilerinBoylarıOrtalaması() {
        return (double) getKişilerinToplamBoyu() / getToplamKişiSayısı();
    }

    public double getKarakterlerinBoylarıOrtalaması() {
        return (double) getKarakterlerinToplamBoyu() / getToplamKarakterSayısı();
    }

    public int getKişilerinToplamKilosu() {
        int toplamKilo = 0;
        for (Yer y : yerler) {
            toplamKilo += y.getKişilerinToplamKilosu();
        }
        return toplamKilo;
    }

    public int getKarakterlerinToplamKilosu() {
        int toplamKilo = 0;
        for (Yer y : yerler) {
            toplamKilo += y.getKarakterlerinToplamKilosu();
        }
        return toplamKilo;
    }

    public double getKişilerinKilolarıOrtalaması() {
        return (double) getKişilerinToplamKilosu() / getToplamKişiSayısı();
    }

    public double getKarakterlerinKilolarıOrtalaması() {
        return (double) getKarakterlerinToplamKilosu() / getToplamKarakterSayısı();
    }

    public void yerEkle(Yer yer) {
        boolean isVar = false;
        for (Yer y : yerler) {
            if (y.adres == yer.adres) {
                isVar = true;
            }
        }

        if (isVar == false) {
            yerler.add(yer);
        } else {
            System.out.println("Aynı adrese sahip bir yer eklenemez!");
        }
    }

    public void yerÇıkar(Yer yer) {
        yerler.remove(yer);
    }

    public int getGün() {
        return gün;
    }

    public void setGün(int gün) {
        this.gün = gün;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getYıl() {
        return yıl;
    }

    public void setYıl(int yıl) {
        for (Yer y : yerler) {
            for (Kişi k : y.getKişiler()) {
                k.yaş += yıl - this.yıl;
            }

            for (int i = 0; i < y.getMekanlar().length; i++) {
                if (y.getMekanlar()[i] != null) {
                    for (int j = 0; j < y.getMekanlar()[i].getŞahıslar().length; j++) {
                        if (y.getMekanlar()[i].getŞahıslar()[j] != null) {
                            y.getMekanlar()[i].getŞahıslar()[j].yaş += yıl - this.yıl;
                        }
                    }
                }
            }
        }
        this.yıl = yıl;
    }

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public int getDakika() {
        return dakika;
    }

    public void setDakika(int dakika) {
        this.dakika = dakika;
    }

    public int getToplamMekanSayısı() {
        int toplamMekan = 0;
        for (Yer y : yerler) {
            toplamMekan += y.getMekanSayısı();
        }

        return toplamMekan;
    }

    public void deprem(Yer yer) {
        yerÇıkar(yer);
    }

    public boolean isYerBurda(Yer yer) {
        boolean burda = false;
        for (Yer y : yerler) {
            if (y == yer) {
                burda = true;
            }
        }
        return burda;
    }

}
