
public class Account implements InterfaceAccount{
    String nama;
    String alamat;
    int jarak;

    public Account(String name, String alamat){
        this.nama = name;
        this.alamat = alamat;
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
