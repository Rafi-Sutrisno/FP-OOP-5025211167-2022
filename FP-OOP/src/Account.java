
public class Account implements InterfaceAccount{
    String nama;
    String alamat;
    int jarak;
    int biaya_buah;

    public Account(String name, String alamat, Integer biaya_buah){
        this.nama = name;
        this.alamat = alamat;
        this.biaya_buah = biaya_buah;
    }
    
    @Override
    public void jumlahberat() {
        
    }

    @Override
    public void printInfo() {
        System.out.println("Nama\t\t: " + this.nama);
        System.out.println("Alamat\t\t: " + this.alamat);
    }

}
