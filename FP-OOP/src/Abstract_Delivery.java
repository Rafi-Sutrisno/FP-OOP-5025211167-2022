
abstract class Abstract_Delivery {
    
    public int berat;
    public int jarak;
    private final int biayaperKM;
    protected int biayaTotal;
    
    public Abstract_Delivery(int berat, int jarak, int biayaperKM){
        this.berat = berat;
        this.jarak = jarak;
        this.biayaperKM = biayaperKM;
    }
    
    public int getBiayaperKM(){
        return this.biayaperKM;
    }
    
    abstract public void setbiayatotal();
    abstract public void printInfo();
}
