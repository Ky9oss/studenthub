package view;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.Node;
public class CourseDetailControler {
    String subjectContent = "";
    @FXML
    public TextField subjectFielder;

    @FXML
    void exit(ActionEvent event) throws IOException {
        // Alert alert = new Alert(Alert.AlertType.NONE);
        // alert.setContentText("成功退出");
        // alert.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("course.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    void save(ActionEvent event) {
        // subjectFielder.setText("保存成功");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("保存成功");
        alert.show();
    }
    @FXML
     void getData(String subjectContent) throws IOException{
        //   System.out.println("++++++++++++++++++++++++");
        //   subjectFielder.setText(subjectContent);
          subjectFielder.setText(subjectContent);
          System.out.println("调用成功");
        // this.subjectContent = subjectContent;
    }

}
