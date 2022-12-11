
public class NextDay_Delivery extends Abstract_Delivery{
    
    public NextDay_Delivery(int berat, int jarak, int biaya){
        super(berat, jarak, biaya);
    }
    
    @Override
    public void setbiayatotal() {
        this.biayaTotal = ((this.jarak/2)*this.berat*this.getBiayaperKg())/2;
    }
    
    @Override
    public void printInfo() {
        System.out.println("Layanan\t: NextDay");
        System.out.println("Biaya Per Kg\t: " + (this.getBiayaperKg()/1000) +"k");
        System.out.println("Berat Total\t: " + this.berat + " kg");
        System.out.println("Jarak\t\t: " + this.jarak + " km");
        System.out.println("Total Biaya Layanan\t: " + (this.biayaTotal/1000) +"k");
    }
}
