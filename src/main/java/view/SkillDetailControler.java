package view;
import controller.*;

import java.io.IOException;
import java.net.URISyntaxException;

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
public class SkillDetailControler {
    String subjectContent = "";
    int type = 0;
    @FXML
    public TextField subjectFielder;
    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField text3;
    @FXML
    void exit(ActionEvent event) throws IOException {
        // Alert alert = new Alert(Alert.AlertType.NONE);
        // alert.setContentText("成功退出");
        // alert.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("skill.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    void save(ActionEvent event) throws URISyntaxException {
        if(this.type==1){
        // subjectFielder.setText("保存成功");
        Controller.createSkill(this.subjectContent,text1.getText(),text2.getText(),text3.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("添加成功");
        alert.show();
        }else if(this.type==2){
        // subjectFielder.setText("保存成功");
        Controller.changeSkill(this.subjectContent,text1.getText(),text2.getText(),text3.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("修改成功");
        alert.show();
        }

    }
    @FXML
     void getData(String subjectContent,int type) throws IOException{
        this.type = type;
        //   System.out.println("++++++++++++++++++++++++");
        //   subjectFielder.setText(subjectContent);
        this.subjectContent = subjectContent;
          subjectFielder.setText(subjectContent);
          System.out.println("调用成功");
        // this.subjectContent = subjectContent;
    }

}
