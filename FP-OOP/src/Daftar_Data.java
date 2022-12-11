
public class Daftar_Data implements Interface_Data{
    private Integer no;
    private String nama;
    private String alamat;
    private String layanan;
    private Integer biaya_buah;
    private Integer biaya_layanan;
    private Integer berat;
    private Integer jarak;
    
    public Daftar_Data(Integer no, String nama, String alamat, String layanan, Integer biaya_buah, Integer biaya_layanan, Integer berat, Integer jarak){
        this.no = no;
        this.nama = nama;
        this.alamat = alamat;
        this.layanan = layanan;
        this.biaya_buah = biaya_buah;
        this.biaya_layanan = (biaya_layanan*berat*(jarak/2))/2;
    }

    @Override
    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    @Override
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public String getLayanan() {
        return layanan;
    }

    public void setLayanan(String layanan) {
        this.layanan = layanan;
    }

    @Override
    public Integer getBiaya_buah() {
        return biaya_buah;
    }

    public void setBiaya_buah(Integer biaya_buah) {
        this.biaya_buah = biaya_buah;
    }

    @Override
    public Integer getBiaya_layanan() {
        return biaya_layanan;
    }

    public void setBiaya_layanan(Integer biaya_layanan) {
        this.biaya_layanan = biaya_layanan;
    }

     
}
