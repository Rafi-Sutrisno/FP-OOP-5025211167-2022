 
public class Normal_Delivery extends Abstract_Delivery{
    
    public Normal_Delivery(int berat, int jarak, int biaya){
        super(berat, jarak, biaya);
    }
    
    @Override
    public void setbiayatotal() {
        this.biayaTotal = this.jarak*this.berat*super.getBiayaperKM();
    }
    
    @Override
    public void printInfo() {
        System.out.println("Layanan\t: Normal");
        System.out.println("Biaya Per Km\t: " + (this.getBiayaperKM()/1000) +"k");
        System.out.println("Biaya Total\t: " + (this.biayaTotal/1000) +"k");
    }

}
