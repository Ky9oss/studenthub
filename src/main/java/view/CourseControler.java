package view;
import controller.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
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
public class CourseControler implements Initializable{
    String subject = "";
    int year = 1;
    String type = "";
    int timelist = 1;
    @FXML
    private ListView<String> list;
    @FXML
    void add(ActionEvent event) throws IOException {
        //跨区域调用函数
        this.subject = "";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("courseDetail.fxml"));
        Parent root = loader.load();
        CourseDetailControler CourseDetailControler = loader.getController();
        System.out.println(this.subject);
        CourseDetailControler.getData(this.subject,1);
         Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root);
         stage.setScene(scene);
         stage.show();
        // App.setRoot("courseDetail");
        this.subject = "";
    }

    @FXML
    boolean delete(ActionEvent event) throws URISyntaxException {
        if(this.subject==""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("请选择对应内容");
            alert.show();
            return false;
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("成功删除!");
        alert.show();
        // Controller.deleteCourse(this.subject);
        return true;
    }

    @FXML
    boolean detail(ActionEvent event) throws IOException {
        if(this.subject==""){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("请选择对应内容");
            alert.show();
            return false;
        }
        //跨区域调用函数
        FXMLLoader loader = new FXMLLoader(getClass().getResource("courseDetail.fxml"));
        Parent root = loader.load();
        CourseDetailControler CourseDetailControler = loader.getController();
        System.out.println(this.subject);
        CourseDetailControler.getData(this.subject,2);
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
    String[] course = {"课程2","课程3","课程5","课程7","课程9"};
    String choose;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
          list.getItems().addAll(course);
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
    void time1(ActionEvent event) {
            //   Controller.getCoursesByYearForwardSort();

    }

    @FXML
    void time2(ActionEvent event) {
        // Controller.getRolesByYearReverseSort();
    }

    @FXML
    void type1(ActionEvent event) {
        if(this.timelist==1){
            //   Controller.getCoursesByYearForwardSort();
             }else if(this.timelist==2){
            // Controller.getRolesByYearReverseSort();
             }else{
             }
             this.type="1";
    }

    @FXML
    void type2(ActionEvent event) {
        if(this.timelist==1){
            //   Controller.getCoursesByYearForwardSort();
             }else if(this.timelist==2){
            // Controller.getRolesByYearReverseSort();
             }else{
             }
             this.type="2";
    }

    @FXML
    void year1(ActionEvent event) {
         if(this.timelist==1){
        //   Controller.getCoursesByYearForwardSort();
         }else if(this.timelist==2){
        // Controller.getRolesByYearReverseSort();
         }else{
         }
         this.year=1;
    }

    @FXML
    void year2(ActionEvent event) {
        if(this.timelist==1){
            //   Controller.getCoursesByYearForwardSort();
             }else if(this.timelist==2){
            // Controller.getRolesByYearReverseSort();
             }else{
             }
             this.year=2;
    }

    @FXML
    void year3(ActionEvent event) {
        if(this.timelist==1){
            //   Controller.getCoursesByYearForwardSort();
             }else if(this.timelist==2){
            // Controller.getRolesByYearReverseSort();
             }else{
             }
             this.year=3;
    }

    @FXML
    void year4(ActionEvent event) {
        if(this.timelist==1){
            //   Controller.getCoursesByYearForwardSort();
             }else if(this.timelist==2){
            // Controller.getRolesByYearReverseSort();
             }else{
             }
             this.year=4;
    }
}
