import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.input.MouseEvent;

public class FP_JavaFXMain extends Application{
    
    Stage window;
    Scene scene1;
    TableView<Fruit> table;
    
    
    Data_ArrayList<Account> DataAc = new Data_ArrayList();
    Data_ArrayList<Abstract_Delivery> DataDeliv = new Data_ArrayList();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Buah");
        window.setScene(setScene1());
        window.show();
    }
    
    private void closeprogram(){
        boolean result2 = ConfirmBox.make("Title", "Apakah anda yakin");
            if(result2) window.close();
    }
    public Scene setScene1(){
        //scene 1
        Label label1 = new Label("Toko Buah");
        label1.setScaleX(3);
        label1.setScaleY(3);
        Button button = new Button();
        Button databutton = new Button("Data Pembeli");
        button.setText("Mulai Beli");
        
        
        button.setOnAction (a -> {
            window.setScene(setScene2());
        });
        databutton.setOnAction (event -> { 
            try{
                DataAc.GetArray(0);
                for(int i = 0; i < DataAc.getSize(); i++){
                    DataDeliv.GetArray(i).setbiayatotal();
                    System.out.println("Order " + (i+1) + " :" );
                    DataAc.GetArray(i).printInfo();
                    DataDeliv.GetArray(i).printInfo();
                    System.out.println();
                }
            }catch(Exception e){
                System.out.println("Tidak ada data");
            }
        });
        
        //tombol keluar
        /*
        window.setOnCloseRequest(event -> {
            event.consume();
            closeprogram();
        });
        */
        Button button4 = new Button("Keluar");
        button4.setOnAction(e -> closeprogram());
        
        
        //root
        //scene1
        VBox rooth = new VBox(20);
        rooth.getChildren().addAll(label1, button, databutton);
        rooth.setAlignment(Pos.CENTER);
        
        
        scene1 = new Scene(rooth, 700, 540, Color.AQUAMARINE);
        
        return scene1;
    }
    
    
    public Scene setScene2(){
        Stage window2 = new Stage();
        window2.setTitle("Toko Buah");
        
        //gridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        //judul
        Label judul = new Label("Welcome to Toko Buah");
        GridPane.setConstraints(judul, 0, 0);
        
        //penjelasan
        Label penjelasan = new Label("Masukkan data diri");
        GridPane.setConstraints(penjelasan, 0, 1);
        //nama
        Label nama = new Label("Nama");
        GridPane.setConstraints(nama, 0, 2);
        TextField namaInput = new TextField();
        namaInput.setPromptText("name");
        GridPane.setConstraints(namaInput, 1, 2);
        
        //alamat
        Label alamat = new Label("Adress");
        GridPane.setConstraints(alamat, 0, 3);
        TextField alamatInput = new TextField();
        alamatInput.setPromptText("alamat");
        GridPane.setConstraints(alamatInput, 1, 3);
        
        //jarak
        Label jarak = new Label("Perkiraan jarak");
        GridPane.setConstraints(jarak, 0, 4);
        ChoiceBox<String> jarakC = new ChoiceBox<>();
        jarakC.getItems().addAll("1-4 km", "5-8 km", "9-12 km", "12+ km");
        jarakC.setValue("1-4 km");
        GridPane.setConstraints(jarakC, 1, 4);
        
        //delivery
        Label pengiriman = new Label("Tipe Pengirimnan");
        GridPane.setConstraints(pengiriman, 0, 6);
        ChoiceBox<String> pengirimanC = new ChoiceBox<>();
        pengirimanC.getItems().addAll("Normal", "NextDay");
        pengirimanC.setValue("Normal");
        GridPane.setConstraints(pengirimanC, 1, 6);
        
        //fruit
        Label fruit = new Label("fruit:");
        ChoiceBox<String> fruitC = new ChoiceBox<>();
        fruitC.getItems().addAll("Apple", "Banana", "Manggo", "Orange", "Melon");
        fruitC.setValue("Apple");
        
        //weight
        Label weight = new Label("weight:");
        ChoiceBox<Integer> weightC = new ChoiceBox<>();
        weightC.getItems().addAll(1, 2, 3, 4, 5);
        weightC.setValue(1);
        
        //add delete button
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        
        //table
        TableColumn<Fruit, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Fruit, Integer> weightColumn = new TableColumn<>("Weight");
        weightColumn.setMinWidth(100);
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        
        TableColumn<Fruit, Integer> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        TableColumn<Fruit, Integer> totalColumn = new TableColumn<>("Total");
        totalColumn.setMinWidth(100);
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        table = new TableView();
        table.setItems(getFruit());
        table.getColumns().addAll(nameColumn, weightColumn, priceColumn, totalColumn);
        
        HBox h1 = new HBox();
        h1.setPadding(new Insets(10,10,10,10));
        h1.setSpacing(10);
        h1.getChildren().addAll(fruit, fruitC, weight, weightC, addButton,deleteButton);
        
        VBox v1 = new VBox();
        v1.getChildren().addAll(h1, table);
        
        //Buy Button
        Button buy = new Button("Beli");
        GridPane.setConstraints(buy, 3, 25);
        buy.setOnAction(event -> {
            setData(namaInput, alamatInput, jarakC, pengirimanC);
            //Data.get(0).printInfo();
            //DataAc.GetArray(0).printInfo();
            window.setScene(setScene1());
        });
        
        //kembali
        Button kembali = new Button("kembali");
        GridPane.setConstraints(kembali, 3, 27);
        kembali.setOnAction (a -> {
            window.setScene(setScene1());
        });
        
        grid.getChildren().addAll(judul, penjelasan, nama, namaInput, alamat, alamatInput, jarak, jarakC, 
                                    pengiriman, pengirimanC);
        
        VBox vAll = new VBox(10);
        vAll.getChildren().addAll(grid, v1, buy, kembali);
        vAll.setPadding(new Insets(10,10,10,10));
        
        Scene scene = new Scene(vAll, 700, 540);
        return scene;
    } 
    
    public void setData(TextField t1,TextField t2,ChoiceBox<String> c1, ChoiceBox<String> c2){
        String nama = t1.getText();
        String alamat = t2.getText();
        
        String jarak = c1.getValue();
        if(jarak == "1-4 km") jarak = "4";
        else if(jarak == "5-8 km") jarak = "8";
        else if(jarak == "9-12 km") jarak = "12";
        else jarak = "15";
        int jarak_int = Integer.parseInt(jarak);
        
        String deliv = c2.getValue();
        if(deliv == "Normal") {
            deliv = "10000";
            int deliv_int = Integer.parseInt(deliv);
            DataDeliv.setArray(new Normal_Delivery(1, jarak_int, deliv_int));
        }
        else {
            deliv = "20000";
            int deliv_int = Integer.parseInt(deliv);
            DataDeliv.setArray(new NextDay_Delivery(1, jarak_int, deliv_int));
        }
        DataAc.setArray(new Account(nama, alamat, jarak_int));
        
    }
    
    public Data_ArrayList<Account> getData(){
        return DataAc;
    }
    
    public ObservableList<Fruit> getFruit(){
        ObservableList<Fruit> Fruits = FXCollections.observableArrayList();
        Fruits.add(new Fruit("Watermelon", 10000, 3));
        Fruits.add(new Fruit("Durian", 30000, 2));
        return Fruits;
    }
    
    
}


//Catatan
/*alertbox
        Button button3 = new Button("Dont click me");
        button3.setOnAction(eh -> AlertBox.make("WARNIG", "please go back this is forbidden"));
        
        //tombol beli
        Button confbutton = new Button("Buy");
        confbutton.setOnAction(eh -> {
            int result = Pembelian.make("MARKET", "Mau pakai keranjang ?");
            System.out.println("Berhasil Ditambahkan\nTotal : " + result);
        });
        Button pilih = new Button("Pilih Buah");
            GridPane.setConstraints(pilih, 0, 5);
            pilih.setOnAction(event ->{
                int result = Pembelian.make("MARKET", "Mau pakai keranjang ?");
                System.out.println("Berhasil Ditambahkan\nTotal : " + result);
        });
*/