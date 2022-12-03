 
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
        
    }

}
