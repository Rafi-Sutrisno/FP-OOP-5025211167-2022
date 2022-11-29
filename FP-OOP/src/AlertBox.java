import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
    public static void make(String title, String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        
        Label label1 = new Label(message);
        Button closebutton = new Button("Close Button");
        closebutton.setOnAction(e -> window.close());
        
        VBox root = new VBox(10);
        root.getChildren().addAll(label1, closebutton);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();    
    }
}
