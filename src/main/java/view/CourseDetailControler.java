package view;
import controller.*;

import java.io.IOException;
import java.net.URISyntaxException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import javafx.scene.control.DatePicker;
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
import java.time.LocalDate;
public class CourseDetailControler {
    String subjectContent = "";
    int type = 0;
    String dataString;
    // String typeString;
    @FXML
    private DatePicker datepicker;
    @FXML
    public TextField subjectFielder;
    @FXML
    private TextField text1;



    @FXML
    private TextField text3;

    @FXML
    private TextField text4;

    @FXML
    private TextField text5;

    @FXML
    private TextField text6;

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
    void save(ActionEvent event) throws URISyntaxException {
        if(this.type==1){
          try {
            Integer int5 = Integer.parseInt(text5.getText());
            Integer int6 = Integer.parseInt(text6.getText());
            String title = subjectFielder.getText();
            // Controller.createCourse("bbbbbbbbb","1","1","1","1",1,1);
            // System.out.println("测试");
            // System.out.println(Controller.getCourseByTitle("bbbbbbbbb"));
            int statusCode = Controller.createCourse(title,text1.getText(),this.dataString,text3.getText(),text4.getText(),int5,int6);
            // Controller.createCourse(title,text1.getText(),this.dataString,this.typeString,text4.getText(),int5,int6);
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
          } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("grade and credit must be integer,please change");
            alert.show();
          }

        }else if(this.type==2){
        // subjectFielder.setText("保存成功");
        try {
          Integer int5 = Integer.parseInt(text5.getText());
          Integer int6 = Integer.parseInt(text6.getText());
          int statusCode = Controller.changeCourse(this.subjectContent,text1.getText(),this.dataString,text3.getText(),text4.getText(),int5,int6);
                  // Controller.changeCourse(this.subjectContent,text1.getText(),this.dataString,"111",text4.getText(),int5,int6);
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
        } catch (Exception e) {
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setContentText("grade and credit must be integer,please change");
          alert.show();
        }


        }

    }
    //跨页面传递参数
    @FXML
     void getData(String subjectContent,int type) throws IOException, URISyntaxException{
        this.type = type;
        //   System.out.println("++++++++++++++++++++++++");
        //   subjectFielder.setText(subjectContent);
        this.subjectContent = subjectContent;
          subjectFielder.setText(subjectContent);
        //   System.out.println("调用成功");
        if(type==2){
          String detail = Controller.getCourseByTitle(subjectContent);
          JSONObject rawObject = JSON.parseObject(detail);
        // System.out.println("++++++++++++++++++++++++");
      //   System.out.println(rawObject);
          text1.setText(rawObject.getString("content"));
          // text2.setText(rawObject.getString("time"));

          setDate(rawObject.getString("time"));
          text3.setText(rawObject.getString("type"));

          text4.setText(rawObject.getString("teacher"));
          text5.setText(""+rawObject.getString("grade"));
          text6.setText(""+rawObject.getString("credit"));
          subjectFielder.setEditable(false); 
        }else{
          setDate("2020-9-1");
        }

        // this.subjectContent = subjectContent;
        // LocalDate datatest = LocalDate.parse("2020-3-3");

    }
    @FXML
     String getDate(ActionEvent event) {
         LocalDate date = datepicker.getValue();
         String dataString = date.toString();
         dataString = Controller.deleteZeroToDate(dataString);
        //  System.out.println(dataString);
        this.dataString = dataString;
        return  dataString;
    }
    @FXML
    void setDate(String rawDate) {
      String stringDate = Controller.addZeroToDate(rawDate);
      LocalDate datapick = LocalDate.parse(stringDate);
      datepicker.setValue(datapick);
    }
    
    @FXML
    void type1(ActionEvent event) {
      text3.setText("compulsory");

    }

    @FXML
    void type2(ActionEvent event) {
      text3.setText("optional");

    }

    @FXML
    void type3(ActionEvent event) {
      text3.setText("other");

    }
}
