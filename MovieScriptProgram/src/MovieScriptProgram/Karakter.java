package MovieScriptProgram;

public class Karakter extends Kişi {

    String ad, soyad;

    public Karakter() {
    }

    public Karakter(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    public Karakter(String ad, String soyad, int yaş, double boy, double kilo) {
        super(yaş, boy, kilo);
        this.ad = ad;
        this.soyad = soyad;
    }

    public Karakter(String ad, String soyad, String tip, int yaş, double boy, double kilo) {
        super(yaş, boy, kilo);
        this.ad = ad;
        this.soyad = soyad;
        this.kilo = kilo;
    }

    public String getAd() {
        return ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public void koş(Yer birYerden, Yer birYere) {
        birYerden.kişiÇıkar(this);
        birYere.kişiEkle(this);
    }

    public void koş(Yer birYerden, Yer birYere, String duygu) {
        birYerden.kişiÇıkar(this);
        birYere.kişiEkle(this);
        this.duygu = duygu;
    }

    public String getDuygu() {
        return super.getDuygu();
    }

    public double getKuvvet() {
        return super.kuvvet;
    }

    public void öldür(Kişi öldüreceğiKişi, String duygu) {
        super.öldür(öldüreceğiKişi);
        this.duygu = duygu;
    }

    public void saldır(Kişi saldıracağıKişi, String duygu) {
        super.saldır(saldıracağıKişi);
        this.duygu = duygu;
    }

    public void uyu(String duygu) {
        this.duygu = duygu;
    }

    public void mekanıYak(Yer yer, Mekan mekan) {
        if (yer.isKişiBurda(this)) {
            yer.mekanÇıkar(mekan);
        }
    }

    public void kişiyiOrtadanKaldır(Yer yer, Kişi k) {
        if (yer.isKişiBurda(k) && yer.isKişiBurda(this)) {
            if (yer instanceof Mekan) {
                ((Mekan) yer).kişiÇıkar(k);
            } else {
                yer.kişiÇıkar(k);
            }
        }
    }

}
