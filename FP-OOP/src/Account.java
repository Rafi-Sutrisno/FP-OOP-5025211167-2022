
public class Account implements InterfaceAccount{
    String nama;
    String alamat;
    int jarak;

    public Account(String name, String alamat, int jarak){
        this.nama = name;
        this.alamat = alamat;
        this.jarak = jarak;
    }
    
    @Override
    public void jumlahberat() {
        
    }

    @Override
    public void printInfo() {
        System.out.println("Nama\t: " + this.nama);
        System.out.println("Alamat\t: " + this.alamat);
        System.out.println("Jarak\t: " + this.jarak);
    }

}
