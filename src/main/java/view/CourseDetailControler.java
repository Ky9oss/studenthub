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
public class CourseDetailControler {
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
        Integer int5 = Integer.parseInt(text5.getText());
        Integer int6 = Integer.parseInt(text6.getText());
        String title = subjectFielder.getText();
        // Controller.createCourse("bbbbbbbbb","1","1","1","1",1,1);
        // System.out.println("测试");
        // System.out.println(Controller.getCourseByTitle("bbbbbbbbb"));
        Controller.createCourse(title,text1.getText(),text2.getText(),text3.getText(),text4.getText(),int5,int6);
        // System.out.println(Controller.getCourseByTitle(subjectFielder.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("添加成功");
        alert.show();
        }else if(this.type==2){
        // subjectFielder.setText("保存成功");
        Integer int5 = Integer.parseInt(text5.getText());
        Integer int6 = Integer.parseInt(text6.getText());
        Controller.changeCourse(this.subjectContent,text1.getText(),text2.getText(),text3.getText(),text4.getText(),int5,int6);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("修改成功");
        alert.show();
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
        System.out.println("++++++++++++++++++++++++");
      //   System.out.println(rawObject);
          text1.setText(rawObject.getString("content"));
          text2.setText(rawObject.getString("time"));
          text3.setText(rawObject.getString("type"));
          text4.setText(rawObject.getString("teacher"));
          text5.setText(""+rawObject.getString("grade"));
          text6.setText(""+rawObject.getString("credit"));

      }
        // this.subjectContent = subjectContent;
    }

}
