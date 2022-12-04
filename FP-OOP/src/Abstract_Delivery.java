
abstract class Abstract_Delivery {
    
    public int berat;
    public int jarak;
    private final int biayaperKg;
    protected int biayaTotal;
    
    public Abstract_Delivery(int berat, int jarak, int biayaperKg){
        this.berat = berat;
        this.jarak = jarak;
        this.biayaperKg = biayaperKg;
    }
    
    public int getBiayaperKg(){
        return this.biayaperKg;
    }
    
    abstract public void setbiayatotal();
    abstract public void printInfo();
}
