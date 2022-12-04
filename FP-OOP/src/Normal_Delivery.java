 
public class Normal_Delivery extends Abstract_Delivery{
    
    public Normal_Delivery(int berat, int jarak, int biaya){
        super(berat, jarak, biaya);
    }
    
    @Override
    public void setbiayatotal() {
        this.biayaTotal = this.jarak*this.berat*super.getBiayaperKg();
    }
    
    @Override
    public void printInfo() {
        System.out.println("Layanan\t: Normal");
        System.out.println("Biaya Per Kg\t: " + (this.getBiayaperKg()/1000) +"k");
        System.out.println("Berat Total\t: " + this.berat + " kg");
        System.out.println("Jarak\t\t: " + this.jarak + " km");
        System.out.println("Total Biaya Layanan\t: " + (this.biayaTotal/1000) +"k");
    }

}
