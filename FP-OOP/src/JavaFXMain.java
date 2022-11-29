import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.input.MouseEvent;

public class JavaFXMain extends Application{
    
    Stage window;
    Scene scene1;
    Scene scene2;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        
        
        Label label1 = new Label("Toko Buah");
        label1.setScaleX(3);
        label1.setScaleY(3);
        Button button = new Button();
        button.setText("Mulai Beli");
        button.setOnAction (a -> {
            System.out.println("Hello World!");
            System.out.println("Noodle");
            window.setScene(scene2);
        });
        
        Label label2 = new Label("Welcome to Toko Buah");
        Button button2 = new Button();
        button2.setText("Kembali");
        button2.setOnAction (a -> {
            System.out.println("Hello World!");
            System.out.println("Meatball");
            window.setScene(scene1);
        });
        
        Button button3 = new Button("Dont click me");
        button3.setOnAction(eh -> AlertBox.make("WARNIG", "please go back this is forbidden"));
        
        Button confbutton = new Button("Buy");
        confbutton.setOnAction(eh -> {
            int result = ConfirmBox.make("MARKET", "Mau pakai keranjang ?");
            System.out.println("Berhasil Ditambahkan\nTotal : " + result);
        });
        
        VBox rooth = new VBox(30);
        rooth.getChildren().addAll(label1, button);
        rooth.setAlignment(Pos.CENTER);
        VBox rootv = new VBox(20);
        rootv.getChildren().addAll(label2, button2, confbutton, button3);
        rootv.setAlignment(Pos.CENTER);
        
        scene1 = new Scene(rooth, 400, 340, Color.AQUAMARINE);
        scene2 = new Scene(rootv, 400, 340, Color.AQUAMARINE);
        
        window.setTitle("Tutorial");
        window.setScene(scene1);
        window.show();
    }
}
