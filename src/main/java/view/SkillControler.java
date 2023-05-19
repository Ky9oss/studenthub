package view;
import controller.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

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
public class SkillControler implements Initializable{
    String subject = "";
    String prof = "Experted";
    @FXML
    private ListView<String> list;
    @FXML
    void add(ActionEvent event) throws IOException, URISyntaxException {
        //跨区域调用函数
        this.subject = "";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("skillDetail.fxml"));

        Parent root = loader.load();
        SkillDetailControler SkillDetailControler = loader.getController();
        System.out.println(this.subject);
        SkillDetailControler.getData(this.subject,1);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
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

        Controller.deleteSkill(this.subject);
            time1();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("成功删除!");
        alert.show();
        Controller.deleteSkill(this.subject);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("skillDetail.fxml"));
        Parent root = loader.load();
        SkillDetailControler SkillDetailControler = loader.getController();
        System.out.println(this.subject);
        SkillDetailControler.getData(this.subject,2);
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
    // String[] skill = {"点击想要的排序方式"};
    String choose;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            Controller.createSkill("ccccc","1","Experted","1");
            Controller.createSkill("ccccsdfc","1","Experted","1");
            Controller.createSkill("cccsdfcc","1","Experted","1");
            Controller.createSkill("ccfdgdccc","1","Experted","1");
            Controller.createSkill("cchjghjccc","1","Experted","1");
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        String rawList;
        try {
            rawList = Controller.getSkillsByProficiency(this.prof);
                    System.out.print(rawList);

        JSONArray rawArray = JSON.parseArray(rawList);
        String[] strs = new String[rawArray.size()];
        for(int i=0;i<rawArray.size();i++){
            JSONObject object = rawArray.getJSONObject(i);
            // System.out.print(object);
            String title = object.getString("title");
            String proficiency = object.getString("proficiency");
            // strs[i]=title;
            strs[i]=title+":"+proficiency;
        }
        list.getItems().addAll(strs);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
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
        String[] temp = subject.split(":");
        String tempsubject = temp[0];
        this.subject = tempsubject;
        System.out.println( this.subject );
    }
    @FXML
    void time1() throws URISyntaxException, ParseException {
        transferDataList(Controller.getSkillsByProficiency(this.prof));
    }

    @FXML
    void prof1(ActionEvent event) throws URISyntaxException, ParseException {
        this.prof = "Experted";
            time1();
    }

    @FXML
    void prof2(ActionEvent event) throws URISyntaxException, ParseException {
        this.prof = "Advanced";
            time1();
    }
    @FXML
    void prof3(ActionEvent event) throws URISyntaxException, ParseException {
        this.prof = "Intermediate";
            time1();
    }
    @FXML
    void prof4(ActionEvent event) throws URISyntaxException, ParseException {
        this.prof = "Novice";
            time1();
    }
    void transferDataList(String rawList){
        System.out.println(rawList);
        list.getItems().clear();
        JSONArray rawArray = JSON.parseArray(rawList);
        String[] strs = new String[rawArray.size()];
        for(int i=0;i<rawArray.size();i++){
            JSONObject object = rawArray.getJSONObject(i);
            // System.out.print(object);
            String title = object.getString("title");
            String proficiency = object.getString("proficiency");
            // strs[i]=title;
            strs[i]=title+":"+proficiency;
        }
list.getItems().addAll(strs);
    }



}
