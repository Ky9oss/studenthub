package view;
import controller.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;

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
import javafx.scene.control.DatePicker;
import javafx.scene.Node;
public class RoleDetailControler {
    String subjectContent = "";
    int type = 0;
    @FXML
    public TextField subjectFielder;
    @FXML
    private TextField text1;
    @FXML
    private DatePicker datepicker;
    
    @FXML
    void exit(ActionEvent event) throws IOException {
        // Alert alert = new Alert(Alert.AlertType.NONE);
        // alert.setContentText("成功退出");
        // alert.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("role.fxml"));
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
        //有bug
        int statusCode = Controller.createRole(subjectFielder.getText(),text1.getText(),getDate());
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
        //有bug
        int statusCode = Controller.changeRole(this.subjectContent,text1.getText(),getDate());
        // Controller.createRole("1","1","1");
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
            String detail = Controller.getRoleByTitle(subjectContent);
            JSONObject rawObject = JSON.parseObject(detail);
          System.out.println("++++++++++++++++++++++++");
        //   System.out.println(rawObject);
            text1.setText(rawObject.getString("content"));
           setDate(rawObject.getString("time"));
           subjectFielder.setEditable(false); 

  
          }else{
            setDate("2020-9-1");
          }
    }
    @FXML
     String getDate() {
         LocalDate date = datepicker.getValue();
         String dataString = date.toString();
         dataString = Controller.deleteZeroToDate(dataString);
        //  System.out.println(dataString);
        // this.dataString = dataString;
        return  dataString;
    }
    @FXML
    void setDate(String rawDate) {
      String stringDate = Controller.addZeroToDate(rawDate);
      LocalDate datapick = LocalDate.parse(stringDate);
      datepicker.setValue(datapick);
    }
}
