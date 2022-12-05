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
    Scene scene_data;
    TableView<Fruit> table;
    TableView<Daftar_Data> table_data;
    ChoiceBox<String> fruitC;
    ChoiceBox<Integer> weightC; 
    TextField namaInput;
    TextField alamatInput;
    ChoiceBox<String> jarakC;
    ChoiceBox<String> delivC;
    TextField totalharga;
    Integer TotalInt = 0;
    String TotalString;
    TextField totalberat;
    Integer BeratInt = 0;
    String BeratString;
    TextField Status;
    Integer no_daftar = 1;
    
    Data_ArrayList<Account> DataAc = new Data_ArrayList();
    Data_ArrayList<Abstract_Delivery> DataDeliv = new Data_ArrayList();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        table_data = new TableView();
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
            window.setScene(setScene3());
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
        namaInput = new TextField();
        namaInput.setPromptText("nama");
        GridPane.setConstraints(namaInput, 1, 2);
        
        //alamat
        Label alamat = new Label("Adress");
        GridPane.setConstraints(alamat, 0, 3);
        alamatInput = new TextField();
        alamatInput.setPromptText("alamat");
        GridPane.setConstraints(alamatInput, 1, 3);
        
        //jarak
        Label jarak = new Label("Perkiraan jarak");
        GridPane.setConstraints(jarak, 0, 4);
        jarakC = new ChoiceBox<>();
        jarakC.getItems().addAll("1-4 km", "5-8 km", "9-12 km", "12+ km");
        jarakC.setValue("1-4 km");
        GridPane.setConstraints(jarakC, 1, 4);
        
        //delivery
        Label pengiriman = new Label("Tipe Pengirimnan");
        GridPane.setConstraints(pengiriman, 0, 6);
        delivC = new ChoiceBox<>();
        delivC.getItems().addAll("Normal", "NextDay");
        delivC.setValue("Normal");
        GridPane.setConstraints(delivC, 1, 6);
        
        //fruit
        Label fruit = new Label("fruit:");
        fruitC = new ChoiceBox<>();
        fruitC.getItems().addAll("Apple", "Banana", "Manggo", "Orange", "Melon");
        fruitC.setValue("Apple");
        
        //weight
        Label weight = new Label("weight:");
        weightC = new ChoiceBox<>();
        weightC.getItems().addAll(1, 2, 3, 4, 5);
        weightC.setValue(1);
        
        //add delete button
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> {
            try{
                deleteButtonClicked();
            }catch(Exception e){
                
            }
        });
        
        //table
        TableColumn<Fruit, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(100);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Fruit, Integer> weightColumn = new TableColumn<>("Weight");
        weightColumn.setMinWidth(100);
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        
        TableColumn<Fruit, Integer> priceColumn = new TableColumn<>("Price per Kg");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        TableColumn<Fruit, Integer> totalColumn = new TableColumn<>("Total");
        totalColumn.setMinWidth(100);
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        
        table = new TableView();
        table.getColumns().addAll(nameColumn, weightColumn, priceColumn, totalColumn);
        
        Label total = new Label("Total Harga");
        totalharga = new TextField();
        TotalInt = getTotal();
        TotalString = Integer.toString(TotalInt);
        totalharga.setText(TotalString);
        
        Label Berat = new Label("Total Berat");
        totalberat = new TextField();
        BeratInt = getTotal();
        BeratString = Integer.toString(BeratInt);
        totalberat.setText(BeratString);
        
        HBox Boxtotal = new HBox();
        Boxtotal.setAlignment(Pos.CENTER);
        Boxtotal.setSpacing(5);
        Boxtotal.getChildren().addAll(total, totalharga);
        
        HBox BoxtotalBerat = new HBox();
        BoxtotalBerat.setAlignment(Pos.CENTER);
        BoxtotalBerat.setSpacing(5);
        BoxtotalBerat.getChildren().addAll(Berat, totalberat);
        
        VBox Berat_Harga = new VBox(10);
        Berat_Harga.setAlignment(Pos.CENTER);
        Berat_Harga.getChildren().addAll(Boxtotal, BoxtotalBerat);
        
        HBox BoxPilihBuah = new HBox();
        BoxPilihBuah.setPadding(new Insets(10,10,10,10));
        BoxPilihBuah.setSpacing(10);
        BoxPilihBuah.getChildren().addAll(fruit, fruitC, weight, weightC, addButton,deleteButton);
        
        VBox v1 = new VBox();
        v1.setMinWidth(400);
        v1.getChildren().addAll(BoxPilihBuah, table);
        
        HBox BoxAllFruit = new HBox();
        BoxAllFruit.setSpacing(10);
        BoxAllFruit.getChildren().addAll(v1,Berat_Harga);
        
        //Buy Button
        Button buy = new Button("Beli");
        GridPane.setConstraints(buy, 3, 25);
        buy.setOnAction(event -> {
            if("".equals(namaInput.getText()) || "".equals(alamatInput.getText()) || "0".equals(totalharga.getText())){
                Status.setText("Ada data yang kurang");
            }else{
                setData();
                table.getItems().clear();
                totalharga.setText("0");
                totalberat.setText("0");
                Status.setText("Data Berhasil Ditambahkan");
            }
            //window.setScene(setScene1());
        });
        
        //kembali
        Button kembali = new Button("kembali");
        GridPane.setConstraints(kembali, 3, 27);
        kembali.setOnAction (a -> {
            window.setScene(setScene1());
        });
        
        Status = new TextField();
        Status.setPrefHeight(50);
        Status.setPrefWidth(170);
        
        VBox vbottom = new VBox(10);
        HBox hbottom = new HBox(20);
        
        vbottom.getChildren().addAll(buy, kembali);
        hbottom.getChildren().addAll(Status, vbottom);
        
        grid.getChildren().addAll(judul, penjelasan, nama, namaInput, alamat, alamatInput, jarak, jarakC, 
                                    pengiriman, delivC);
        
        VBox vAll = new VBox(10);
        vAll.getChildren().addAll(grid, BoxAllFruit, hbottom);
        vAll.setPadding(new Insets(10,10,10,10));
        
        Scene scene = new Scene(vAll, 700, 540);
        return scene;
    } 
    
    public Scene setScene3(){
        
        //table
        TableColumn<Daftar_Data, Integer> noColumn = new TableColumn<>("No");
        noColumn.setMinWidth(30);
        noColumn.setCellValueFactory(new PropertyValueFactory<>("no"));
        
        TableColumn<Daftar_Data, String> namaColumn = new TableColumn<>("Nama");
        namaColumn.setMinWidth(100);
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));
        
        TableColumn<Daftar_Data, String> alamatColumn = new TableColumn<>("Alamat");
        alamatColumn.setMinWidth(100);
        alamatColumn.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        
        TableColumn<Daftar_Data, String> layananColumn = new TableColumn<>("Layanan");
        layananColumn.setMinWidth(100);
        layananColumn.setCellValueFactory(new PropertyValueFactory<>("layanan"));
        
        TableColumn<Daftar_Data, Integer> biaya_buahColumn = new TableColumn<>("Biaya buah");
        biaya_buahColumn.setMinWidth(100);
        biaya_buahColumn.setCellValueFactory(new PropertyValueFactory<>("biaya_buah"));
        
        TableColumn<Daftar_Data, Integer> biaya_layananColumn = new TableColumn<>("Biaya layanan");
        biaya_layananColumn.setMinWidth(100);
        biaya_layananColumn.setCellValueFactory(new PropertyValueFactory<>("biaya_layanan"));
        
        TableColumn<Daftar_Data, Integer> biaya_totalColumn = new TableColumn<>("Biaya Total");
        biaya_totalColumn.setMinWidth(100);
        biaya_totalColumn.setCellValueFactory(new PropertyValueFactory<>("biaya_Total"));
        
        table_data.getColumns().addAll(noColumn, namaColumn, alamatColumn, layananColumn, biaya_buahColumn, biaya_layananColumn, biaya_totalColumn);
        
        //kembali
        Button kembali = new Button("kembali");
        kembali.setOnAction (a -> {
            window.setScene(setScene1());
        });
        
        VBox main = new VBox(20);
        main.setPadding(new Insets(10,10,10,10));
        main.setAlignment(Pos.CENTER);
        main.getChildren().addAll(table_data, kembali);
        scene_data = new Scene(main,700,500);
        return scene_data;
    }
    
    public void setData(){
        String nama = namaInput.getText();
        String alamat = alamatInput.getText();
        
        
        String jarak = jarakC.getValue();
        if(jarak == "1-4 km") jarak = "4";
        else if(jarak == "5-8 km") jarak = "8";
        else if(jarak == "9-12 km") jarak = "12";
        else jarak = "15";
        int jarak_int = Integer.parseInt(jarak);
        
        String deliv = delivC.getValue();
        String layanan = deliv;
        Integer biaya_layanan;
        if(deliv == "Normal") {
            deliv = "10000";
            int deliv_int = Integer.parseInt(deliv);
            biaya_layanan = deliv_int;
            DataDeliv.setArray(new Normal_Delivery(Integer.parseInt(totalberat.getText()), jarak_int, deliv_int));
        }
        else {
            deliv = "20000";
            int deliv_int = Integer.parseInt(deliv);
            biaya_layanan = deliv_int;
            DataDeliv.setArray(new NextDay_Delivery(Integer.parseInt(totalberat.getText()), jarak_int, deliv_int));
        }
        DataAc.setArray(new Account(nama, alamat, Integer.parseInt(totalharga.getText())));
        namaInput.clear();
        alamatInput.clear();
        
        Daftar_Data daftar = new Daftar_Data(no_daftar, nama, alamat, layanan, Integer.parseInt(totalharga.getText()), biaya_layanan);
        table_data.getItems().add(daftar);
        no_daftar++;
    }
    
    public Data_ArrayList<Account> getData(){
        return DataAc;
    }
    
    public void addButtonClicked(){
        Fruit Fruit = new Fruit();
        Fruit.setName(fruitC.getValue());
        Fruit.setWeight(weightC.getValue());
        if(fruitC.getValue() == "Apple"){
            Fruit.setPrice(10000);
            Fruit.setTotal(weightC.getValue()*10000);
        }else if(fruitC.getValue() == "Banana"){
            Fruit.setPrice(12000);
            Fruit.setTotal(weightC.getValue()*12000);
        }else if(fruitC.getValue() == "Manggo"){
            Fruit.setPrice(9000);
            Fruit.setTotal(weightC.getValue()*9000);
        }else if(fruitC.getValue() == "Orange"){
            Fruit.setPrice(13000);
            Fruit.setTotal(weightC.getValue()*13000);
        }else if(fruitC.getValue() == "Melon"){
            Fruit.setPrice(14000);
            Fruit.setTotal(weightC.getValue()*14000);
        }
        table.getItems().add(Fruit);
        
        TotalInt = getTotal();
        TotalString = Integer.toString(TotalInt);
        totalharga.setText(TotalString);
        
        BeratInt = getTotalBerat();
        BeratString = Integer.toString(BeratInt);
        totalberat.setText(BeratString);
    }
    
    public void deleteButtonClicked(){
        ObservableList<Fruit> FruitSelected, allFruit;
        allFruit = table.getItems();
        FruitSelected = table.getSelectionModel().getSelectedItems();
        FruitSelected.forEach(allFruit::remove);
        
        TotalInt = getTotal();
        TotalString = Integer.toString(TotalInt);
        totalharga.setText(TotalString);
        
        BeratInt = getTotalBerat();
        BeratString = Integer.toString(BeratInt);
        totalberat.setText(BeratString);
    }
    
    public int getTotal(){
        TotalInt = 0;
        for (Fruit item : table.getItems()) {
            TotalInt = TotalInt + item.getTotal();
        }
        return TotalInt;
    } 
    
    public int getTotalBerat(){
        BeratInt = 0;
        for (Fruit item : table.getItems()) {
            BeratInt = BeratInt + item.getWeight();
        }
        return BeratInt;
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