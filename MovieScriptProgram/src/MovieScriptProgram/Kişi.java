package MovieScriptProgram;

public class Kişi {

    char cinsiyet;
    int yaş;
    double boy, kilo, kuvvet;
    boolean canlı = true, yaralı = false;
    String duygu, replik;
    String tip;//oyuncuların sahip oldukları tipler.

    public Kişi() {
    }

    public Kişi(char cinsiyet, String tip, int yaş, double boy, double kilo) {
        this.cinsiyet = cinsiyet;
        this.tip = tip;
        this.yaş = yaş;
        this.boy = boy;
        this.kilo = kilo;
    }

    public Kişi(char cinsiyet, int yaş, double boy, double kilo) {
        this.cinsiyet = cinsiyet;
        this.yaş = yaş;
        this.boy = boy;
        this.kilo = kilo;

    }

    public Kişi(int yaş, double boy, double kilo) {
        this.yaş = yaş;
        this.boy = boy;
        this.kilo = kilo;

    }

    public char getCinsiyet() {
        return cinsiyet;
    }

    public int getYaş() {
        return yaş;
    }

    public double getBoy() {
        return boy;
    }

    public double getKilo() {
        return kilo;
    }

    public double getKuvvet() {
        return kuvvet;
    }

    public boolean isCanlı() {
        return canlı;
    }

    public String getDuygu() {
        return duygu;
    }

    public boolean isYaralı() {
        return yaralı;
    }

    public String getTip() {
        return tip;
    }

    public String getreplik() {
        return replik;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setCinsiyet(char cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public void setYaş(int yaş) {
        this.yaş = yaş;
    }

    public void setBoy(double boy) {
        this.boy = boy;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public void setKuvvet(double kuvvet) {
        this.kuvvet = kuvvet;
    }

    public void setCanlı(boolean canlı) {
        this.canlı = canlı;
    }

    public void setYaralı(boolean yaralı) {
        this.yaralı = yaralı;
    }

    public void setDuygu(String duygu) {
        this.duygu = duygu;
    }

    public void setReplik(String replik) {
        this.replik = replik;
    }

    public void yemekYe(String yemekAdı) {
        this.kilo += 1;
    }

    public void yemekYe(String yemekAdı, int tabakSayısı) {
        this.kilo += tabakSayısı * 0.20;
    }

    public void yemekYe(String yemekAdı, String duygu) {
        this.duygu = duygu;
        kilo += 1;
    }

    public void yemekYemek(String duygu) {
        this.duygu = duygu;
    }

    public void saldır(Kişi saldırdığıKişi) {
        if (this.kuvvet > saldırdığıKişi.kuvvet) {
            this.kuvvet -= saldırdığıKişi.kuvvet;
            saldırdığıKişi.kuvvet -= this.kuvvet / 4;
            if (saldırdığıKişi.kuvvet <= 0) {
                saldırdığıKişi.canlı = false;
            } else {
                saldırdığıKişi.yaralı = true;
            }
        } else if (this.kuvvet < saldırdığıKişi.kuvvet) {
            saldırdığıKişi.kuvvet -= this.kuvvet;
            this.kuvvet -= saldırdığıKişi.kuvvet / 4;
            if (this.kuvvet <= 0) {
                this.canlı = false;
            } else {
                this.yaralı = true;
            }
        } else {
            this.yaralı = true;
            this.kuvvet -= saldırdığıKişi.kuvvet / 2;
            saldırdığıKişi.yaralı = true;
            saldırdığıKişi.kuvvet -= this.kuvvet / 2;
        }
    }

    public void öldür(Kişi öldüreceğiKişi) {
        öldüreceğiKişi.canlı = false;
        this.duygu = "korku";
    }

    public void yürü(Yer birYerden, Yer birYere) {
        if (birYerden instanceof Mekan) {
            ((Mekan) birYerden).kişiÇıkar(this);
        } else {
            birYerden.kişiÇıkar(this);// yerden ayrılacağı için oyerden çıkarılmalı
        }
        if (birYere instanceof Mekan) {
            ((Mekan) birYere).kişiEkle(this);
        } else {
            birYere.kişiEkle(this);//o yerde bulunacağı için o yerde bulunan kişilerin listesine eklenmeli
        }

    }

    public void yürü(Yer birYerden, Yer birYere, String duygu) {
        if (birYerden instanceof Mekan) {
            ((Mekan) birYerden).kişiÇıkar(this);
        } else {
            birYerden.kişiÇıkar(this);
        }
        if (birYere instanceof Mekan) {
            ((Mekan) birYere).kişiEkle(this);
        } else {
            birYere.kişiEkle(this);
        }

        this.duygu = duygu;
    }

    public void koş(Yer birYerden, Yer birYere) {
        if (birYerden instanceof Mekan) {
            ((Mekan) birYerden).kişiÇıkar(this);
        } else {
            birYerden.kişiÇıkar(this);
        }
        if (birYere instanceof Mekan) {
            ((Mekan) birYere).kişiEkle(this);
        } else {
            birYere.kişiEkle(this);
        }
        this.duygu = "heyecanlı";
    }

    public void git(Yer birYerden, Yer birYere, String duygu) {
        birYerden.kişiÇıkar(this);
        birYere.kişiEkle(this);
        this.duygu = duygu;
    }

    public void git(Yer birYerden, Yer birYere) {
        birYerden.kişiÇıkar(this);
        birYere.kişiEkle(this);

    }

    public void dinlen() {
        this.duygu = "sakin";
    }

    public void otur(String duygu) {
        this.duygu = duygu;
    }

    public void uyu() {
        this.kilo -= 1;
        this.duygu = "huzurlu";
    }

    public void uyan() {
        this.duygu = "huzursuz";
    }

    public void sarıl(String duygu) {
        this.duygu = duygu;
    }

    public void öp(Kişi k) {
        k.duygu = "mutlu";
    }

    public void söylemek(String söz) {
        replik = söz;
        System.out.println(replik);
    }

    public void gömmek(Kişi k, Yer birYerden, Yer birYere) {
        birYerden.kişiÇıkar(k);
        birYere.kişiEkle(k);
    }

    public void intiharEt() {
        this.canlı = false;
    }

}
