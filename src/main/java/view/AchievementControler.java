package view;
import controller.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
public class AchievementControler implements Initializable{
    String subject = "";
    int year = 2023;
    int timelist = 1;
    String choose = "";
    @FXML
    private ListView<String> list;
    @FXML
    void add(ActionEvent event) throws IOException, URISyntaxException {
        //跨区域调用函数
        this.subject = "";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("achievementDetail.fxml"));
        Parent root = loader.load();
        AchievementDetailControler AchievementDetailControler = loader.getController();
        System.out.println(this.subject);
        AchievementDetailControler.getData(this.subject,1);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        // App.setRoot("courseDetail");
        this.subject = "";
    }

    @FXML
    boolean delete(ActionEvent event) throws URISyntaxException, ParseException {
        if(this.subject==""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("请选择对应内容");
            alert.show();
            return false;
        }
        Controller.deleteAchievement(this.subject);
        if(this.timelist==1){
            time1(event);
         }else if(this.timelist==2){
            time2(event);
         }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("成功删除!");
        alert.show();
        Controller.deleteAchievement(this.subject);
        return true;
    }

    @FXML
     boolean detail(ActionEvent event) throws IOException, URISyntaxException {
        if(this.subject==""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("请选择对应内容");
            alert.show();
            return false;
        }
        //跨区域调用函数
        FXMLLoader loader = new FXMLLoader(getClass().getResource("achievementDetail.fxml"));
        Parent root = loader.load();
        AchievementDetailControler AchievementDetailControler = loader.getController();
        System.out.println(this.subject);
        AchievementDetailControler.getData(this.subject,2);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        // App.setRoot("courseDetail");
        this.subject = "";
        return true;
    }
    @FXML
    private void gotoHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void gotoCourse(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("course.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void gotoGrade(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("grade.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void gotoSkill(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("skill.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void gotoAchievement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("achievement.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void gotoActivity(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("activity.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void gotoRole(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("role.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void gotoGPA(ActionEvent event) throws IOException {
        // App.setRoot("GPA");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GPA.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @FXML
    private void gotoCV(ActionEvent event) throws IOException {
        // App.setRoot("CV");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CV.fxml"));
        Parent root = loader.load();
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        try {
            Controller.createAchievement("ccccc","1","2023-8-9","1","1");
            Controller.createAchievement("bbbbb","1","2023-9-9","1","1");
            Controller.createAchievement("ssss","1","2023-10-9","1","1");
            Controller.createAchievement("aaa","1","2022-11-9","2","1");
            Controller.createAchievement("ee456456","1","2022-8-9","2","1");
            Controller.createAchievement("rr7877678","1","2021-7-9","1","1");
            Controller.createAchievement("tttt456","1","2021-8-9","1","1");
            Controller.createAchievement("tttt45678","1","2020-8-9","2","1");
            Controller.createAchievement("ttt757676t","1","2020-8-9","1","1");

        } catch (URISyntaxException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            String rawList = Controller.getAchievementsByYearForwardSort(this.year);
            System.out.print(rawList);
            // String rawList = Controller.getCoursesByYearAndByTypeForwardSort(2022,this.type);
            JSONArray rawArray = JSON.parseArray(rawList);
            String[] strs = new String[rawArray.size()];
            for(int i=0;i<rawArray.size();i++){
                JSONObject object = rawArray.getJSONObject(i);
                // System.out.print(object);
                String title = object.getString("title");
                strs[i]=title;
            }
            list.getItems().addAll(strs);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                choose = list.getSelectionModel().getSelectedItem();
                changeData(choose);
                // System.out.println(choose);
            }
            

          });
    }
    public void changeData(String subject){
        this.subject = subject;
        System.out.println( this.subject);
    }
    @FXML
    void time1(ActionEvent event) throws URISyntaxException, ParseException {
        this.timelist=1;
        transferDataList(Controller.getAchievementsByYearForwardSort(this.year));
    }

    @FXML
    void time2(ActionEvent event) throws URISyntaxException, ParseException {
        // System.out.println( "逆时间排序");
        this.timelist=2;
        transferDataList(Controller.getAchievementsByYearReverseSort(this.year));
    }

    @FXML
    void year1(ActionEvent event) throws URISyntaxException, ParseException {
        this.year = 2020;
         if(this.timelist==1){
            time1(event);
         }else if(this.timelist==2){
            time2(event);
         }else{
         }

    }

    @FXML
    void year2(ActionEvent event) throws URISyntaxException, ParseException {
        this.year = 2021;
         if(this.timelist==1){
            time1(event);
         }else if(this.timelist==2){
            time2(event);
         }else{
         }

    }

    @FXML
    void year3(ActionEvent event) throws URISyntaxException, ParseException {
        this.year = 2022;
         if(this.timelist==1){
            time1(event);
         }else if(this.timelist==2){
            time2(event);
         }else{
         }

    }

    @FXML
    void year4(ActionEvent event) throws URISyntaxException, ParseException {
        this.year = 2023;
         if(this.timelist==1){
            time1(event);
         }else if(this.timelist==2){
            time2(event);
         }else{
         }
    }
    void transferDataList(String rawList){
        System.out.println(rawList);
        list.getItems().clear();
        JSONArray rawArray = JSON.parseArray(rawList);
        String[] strs = new String[rawArray.size()];
        for(int i=0;i<rawArray.size();i++){
        JSONObject object = rawArray.getJSONObject(i);
        String title = object.getString("title");
        strs[i]=title;
        // System.out.println(strs);
          }
list.getItems().addAll(strs);
    }
}
