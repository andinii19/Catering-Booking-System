public class Catering {
    private String namaCostumer;
    private int jumlahPesanan;
    private String jenisCatering;
    private String jenisPaket;
    private String menuCatering;
    private String tanggal;
    private int Harga=0;

    public String getNamaCostumer() {
        return namaCostumer;
    }

    public void setNamaCostumer(String namaCostumer) {
        this.namaCostumer = namaCostumer;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    public String getJenisCatering() {
        return jenisCatering;
    }

    public void setJenisCatering(String jenisCatering) {
        this.jenisCatering = jenisCatering;
    }

    public String getJenisPaket() {
        return jenisPaket;
    }

    public void setJenisPaket(String jenisPaket) {
        this.jenisPaket = jenisPaket;
        switch (jenisPaket) {
            case "Paket Eksklusif":
                if (jumlahPesanan <= 20) {
                    this.Harga += 30000;
                    break;
                } else if (jumlahPesanan <= 50) {
                    this.Harga += 32000;
                    break;
                } else if (jumlahPesanan > 50) {
                    this.Harga += 35000;
                    break;
                }

            case "Paket Menengah":
                if (jumlahPesanan <= 20) {
                    this.Harga += 20000;
                    break;
                } else if (jumlahPesanan <= 50) {
                    this.Harga += 22000;
                    break;
                } else if (jumlahPesanan > 50) {
                    this.Harga += 25000;
                    break;
                }

            case "Paket Hemat":
                if (jumlahPesanan <= 50) {
                    this.Harga += 15000;
                    break;
                } else if (jumlahPesanan > 50) {
                    this.Harga += 18000;
                    break;
                }
        }
    }

    public String getMenuCatering() {
        return menuCatering;
    }

    public void setMenuCatering(String menuCatering) {
        this.menuCatering = menuCatering;

    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public int hargaAkhir(){
        return this.Harga * getJumlahPesanan();
    }

    public void restartHarga(){
        this.Harga = 0;
    }
}
