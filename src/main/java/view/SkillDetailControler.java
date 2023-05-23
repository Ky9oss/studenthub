package view;
import controller.*;

import java.io.IOException;
import java.net.URISyntaxException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

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
        int statusCode = Controller.createSkill(subjectFielder.getText(),text1.getText(),text2.getText(),text3.getText());
        if(statusCode==-1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Empty content is not allowed. Please add corresponding content.");
            alert.show();  
          }else if(statusCode==-2){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("This title already exists,please choose another one");
            alert.show();  
          }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Add successfully!");
            alert.show();  
          }
        }else if(this.type==2){
        // subjectFielder.setText("保存成功");
        int statusCode = Controller.changeSkill(this.subjectContent,text1.getText(),text2.getText(),text3.getText());
        if(statusCode==-1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Empty content is not allowed. Please add corresponding content.");
            alert.show();  
          }else if(statusCode==-2){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("This title already exists,please choose another one");
            alert.show();  
          }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Change successfully!");
            alert.show();
          }
        }

    }
    @FXML
     void getData(String subjectContent,int type) throws IOException, URISyntaxException{
        this.type = type;
        //   System.out.println("++++++++++++++++++++++++");
        //   subjectFielder.setText(subjectContent);
        this.subjectContent = subjectContent;
          subjectFielder.setText(subjectContent);
          System.out.println("调用成功");
        // this.subjectContent = subjectContent;
        if(type==2){
            String detail = Controller.getSkillByTitle(subjectContent);
            JSONObject rawObject = JSON.parseObject(detail);
          System.out.println("++++++++++++++++++++++++");
        //   System.out.println(rawObject);
            text1.setText(rawObject.getString("content"));
            text2.setText(rawObject.getString("proficiency"));
            text3.setText(rawObject.getString("project"));
            subjectFielder.setEditable(false); 
  
        }
    }
    @FXML
    void type1(ActionEvent event) {
        text2.setText("Experted");
    }

    @FXML
    void type2(ActionEvent event) {
        text2.setText("Advanced");
    }

    @FXML
    void type3(ActionEvent event) {
        text2.setText("Intermediate");
    }

    @FXML
    void type4(ActionEvent event) {
        text2.setText("Novice");
    }
}
