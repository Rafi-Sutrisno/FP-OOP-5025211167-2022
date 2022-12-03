import java.util.ArrayList;

public class Data_ArrayList<Type> {
    ArrayList<Type> array = new ArrayList<>();
    
    public void setArray(Type x){
        array.add(x);
    }

    public Type GetArray(int i){
        return array.get(i);
    }
    
    public int getSize(){
        return array.size();
    }
}
