
public class Daftar_Data {
    private Integer no;
    private String nama;
    private String alamat;
    private String layanan;
    private Integer biaya_buah;
    private Integer biaya_layanan;
    private Integer biaya_Total;
    
    public Daftar_Data(Integer no, String nama, String alamat, String layanan, Integer biaya_buah, Integer biaya_layanan){
        this.no = no;
        this.nama = nama;
        this.alamat = alamat;
        this.layanan = layanan;
        this.biaya_buah = biaya_buah;
        this.biaya_layanan = biaya_layanan;
        this.biaya_Total = biaya_buah+biaya_layanan;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getLayanan() {
        return layanan;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    public Integer getBiaya_buah() {
        return biaya_buah;
    }

    public void setBiaya_buah(Integer biaya_buah) {
        this.biaya_buah = biaya_buah;
    }

    public Integer getBiaya_layanan() {
        return biaya_layanan;
    }

    public void setBiaya_layanan(Integer biaya_layanan) {
        this.biaya_layanan = biaya_layanan;
    }

    public Integer getBiaya_Total() {
        return biaya_Total;
    }

    public void setBiaya_Total(Integer biaya_Total) {
        this.biaya_Total = biaya_Total;
    }
    
    
}