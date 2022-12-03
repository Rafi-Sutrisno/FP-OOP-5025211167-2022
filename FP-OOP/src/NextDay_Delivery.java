
public class NextDay_Delivery extends Abstract_Delivery{
    
    public NextDay_Delivery(int berat, int jarak, int biaya){
        super(berat, jarak, biaya);
    }
    
    @Override
    public void setbiayatotal() {
        this.biayaTotal = this.jarak*this.berat*super.getBiayaperKM();
    }
    
    @Override
    public void printInfo() {
        
    }
}
