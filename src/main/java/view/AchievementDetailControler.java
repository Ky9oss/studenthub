package view;
import controller.*;

import java.io.IOException;
import java.net.URISyntaxException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
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
public class AchievementDetailControler {
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
    void exit(ActionEvent event) throws IOException {
        // Alert alert = new Alert(Alert.AlertType.NONE);
        // alert.setContentText("成功退出");
        // alert.show();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("achievement.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }

    @FXML
    void save(ActionEvent event) throws URISyntaxException, IOException {
        if(this.type==1){
        // subjectFielder.setText("保存成功");
        Controller.createAchievement(subjectFielder.getText(),text1.getText(),text2.getText(),text3.getText(),text4.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("添加成功");
        alert.show();
        }else if(this.type==2){
        Controller.changeAchievement(this.subjectContent,text1.getText(),text2.getText(),text3.getText(),text4.getText());
        // subjectFielder.setText("保存成功");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("修改成功");
        alert.show();
        }

    }
    @FXML
     void getData(String subjectContent,int type) throws IOException, URISyntaxException{
        this.type = type;
        //   System.out.println("++++++++++++++++++++++++");
        //   subjectFielder.setText(subjectContent);
        this.subjectContent=subjectContent;
          subjectFielder.setText(subjectContent);
          System.out.println("调用成功");
        // this.subjectContent = subjectContent;
        if(type==2){
            String detail = Controller.getAchivementByTitle(subjectContent);
            JSONObject rawObject = JSON.parseObject(detail);
          System.out.println("++++++++++++++++++++++++");
        //   System.out.println(rawObject);
            text1.setText(rawObject.getString("content"));
            text2.setText(rawObject.getString("time"));
            text3.setText(rawObject.getString("team"));
            text4.setText(rawObject.getString("responsibility"));
        }
    }

}
