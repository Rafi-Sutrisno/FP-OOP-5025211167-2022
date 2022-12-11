
public class Account implements InterfaceAccount{
    private String nama;
    private String alamat;


    public Account(String name, String alamat){
        this.nama = name;
        this.alamat = alamat;

    }

    @Override
    public void printInfo() {
        System.out.println("Nama\t\t: " + this.nama);
        System.out.println("Alamat\t\t: " + this.alamat);
    }

}
