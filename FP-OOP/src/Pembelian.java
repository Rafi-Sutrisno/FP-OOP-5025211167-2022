import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Pembelian {
    
    public static int ans = 0;
    
    public static Integer make(String title, String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(500);
        
        Label label1 = new Label(message);
        Label label2 = new Label("Pilih buah anda");
        Button yesButton = new Button("YES");
        Button noButton = new Button("NO");
        Button b1 = new Button("Apel");
        Button b2 = new Button("Pisang");
        Button b3 = new Button("Melon");
        Button b4 = new Button("Jeruk");
        yesButton.setOnAction(e -> {
            ans += 10000;
            window.close();
        });
        noButton.setOnAction(e -> {
            ans += 1000;
            window.close();
        });
        
        b1.setOnAction(e -> {
            ans += 10000;
            window.close();
        });
        b2.setOnAction(e -> {
            ans += 15000;
            window.close();
        });
        b3.setOnAction(e -> {
            ans += 20000;
            window.close();
        });
        b4.setOnAction(e -> {
            ans += 7000;
            window.close();
        });
        
        
        HBox rooth = new HBox(10);
        rooth.getChildren().addAll(yesButton, noButton);
        rooth.setAlignment(Pos.CENTER);
        
        HBox rooth2 = new HBox(10);
        rooth2.getChildren().addAll(b1, b2);
        rooth2.setAlignment(Pos.CENTER);
        
        HBox rooth3 = new HBox(10);
        rooth3.getChildren().addAll(b3, b4);
        rooth3.setAlignment(Pos.CENTER);
        
        VBox root = new VBox(10);
        root.getChildren().addAll(label1, rooth, label2, rooth2, rooth3);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();    
        
        return ans;
    }
}
