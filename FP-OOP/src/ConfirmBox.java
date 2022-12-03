import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.geometry.*;

public class ConfirmBox {
    public static boolean ans;
    
    public static boolean make(String title, String message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);
        //window.setMinHeight(500);
        
        Label label1 = new Label(message);
        
        Button yesButton = new Button("YES");
        Button noButton = new Button("NO");
        
        yesButton.setOnAction(e -> {
            ans = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            ans = false;
            window.close();
        });
        
        
        HBox rooth = new HBox(10);
        rooth.getChildren().addAll(yesButton, noButton);
        rooth.setAlignment(Pos.CENTER);
        
        VBox root = new VBox(10);
        root.getChildren().addAll(label1, rooth);
        root.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.showAndWait();    
        
        return ans;
    }
}
