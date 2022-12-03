
public class NextDay_Delivery extends Abstract_Delivery{
    
    public NextDay_Delivery(int berat, int jarak, int biaya){
        super(berat, jarak, biaya);
    }
    
    @Override
    public void setbiayatotal() {
        this.biayaTotal = this.jarak*this.berat*this.getBiayaperKM();
    }
    
    @Override
    public void printInfo() {
        System.out.println("Layanan\t: NextDay");
        System.out.println("Biaya Per Km\t: " + this.getBiayaperKM());
        System.out.println("Biaya Total\t: " + this.biayaTotal);
    }
}
