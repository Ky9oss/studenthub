package view;
import java.io.IOException;
import java.net.URISyntaxException;

import com.alibaba.fastjson.JSONObject;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class HomeControler {
    //状态代码，0为没修改，1为修改中
    int status = 0;
    int image ;
    @FXML
    private ImageView tx;
    Image tx3 = new Image(getClass().getResourceAsStream("head3.jpeg")); 
    
    Image tx4 = new Image(getClass().getResourceAsStream("head4.jpeg")); 
        
    Image tx2 = new Image(getClass().getResourceAsStream("head2.jpeg")); 
    
    Image tx1 = new Image(getClass().getResourceAsStream("head1.jpeg")); 
    @FXML
    private Button changeButton;
    @FXML
    private Button bt1;

    @FXML
    private Button bt2;

    @FXML
    private Button bt3;

    @FXML
    private Button bt4;
    @FXML
    private TextField f1;

    @FXML
    private TextField f2;

    @FXML
    private TextField f3;

    @FXML
    private TextField f4;

    @FXML
    private TextField f5;

    @FXML
    private TextField f6;

    @FXML
    private Label testlabel;

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
    @FXML
    private void changetest() throws IOException{   
        if(this.status==0){          
            // testlabel.setText(f1.getText()+f2.getText()+f3.getText()+f4.getText()+f5.getText()+f6.getText());
            // testlabel.setText("点击修改");
            f1.setDisable(false);
            f2.setDisable(false);
            f3.setDisable(false);
            f4.setDisable(false);
            f5.setDisable(false);
            f6.setDisable(false);
            bt1.setDisable(false);
            bt2.setDisable(false);
            bt3.setDisable(false);
            bt4.setDisable(false);
            changeButton.setText("SAVE");
            this.status=1;
        }
            else{
                try {
                    Integer int2 = Integer.parseInt(f2.getText());
                    // File file=new File("");
                    Controller.newCreateBasicInformation(f1.getText(),int2,f3.getText(),f4.getText(),f5.getText(),f6.getText(),this.image);
                    f1.setDisable(true);
                    f2.setDisable(true);
                    f3.setDisable(true);
                    f4.setDisable(true);
                    f5.setDisable(true);
                    f6.setDisable(true);
                    bt1.setDisable(true);
                    bt2.setDisable(true);
                    bt3.setDisable(true);
                    bt4.setDisable(true);
                    changeButton.setText("MODIFY");
                    this.status=0;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("Change successfully");
                    alert.show();
                    // testlabel.setText("修改成功!");                    
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("age must be integer,please change it.");
                    alert.show();
                }

            }     

    }

    @FXML
    // private void changetx1(ActionEvent event) throws IOException{
    private void changetx1() throws IOException{
        this.image = 1;
           tx.setImage(tx1);

    }

    @FXML
    private void changetx2() throws IOException{
        this.image = 2;
            tx.setImage(tx2);

    }
    @FXML
    private void changetx3() throws IOException{
        this.image = 3;
            tx.setImage(tx3);

    }
    @FXML
    private void changetx4() throws IOException{
        this.image = 4;
            tx.setImage(tx4);

    }
    public void initialize() throws URISyntaxException {
try {
    String data = Controller.getBasicInformation();
    //    System.out.print(data);
       JSONObject jsonObject = JSONObject.parseObject(data);
       System.out.print(jsonObject);
       testlabel.setWrapText(true);
    //    System.out.print(jsonObject.getString("name"));
    // testlabel.setText("This is a student data management system. The functions are as follows:  \nCreate, modify, and save personal information  \nCreate, modify, save Course, and enable selective sorting  \nCreate, modify, save skills, and allow for selective sorting  \nCreate, modify, save Achievements, and enable selective sorting  \nCreate, modify, save activities, and enable selective sorting  \nCreate, modify, save Role, and enable selective sorting  \nGenerate corresponding GPA based on different algorithms  \nGenerate CV with one click and automatically open file  \n");
testlabel.setText("This is a student data management system. The functions are as follows: \nCreate, modify, and save personal information \nCreate, modify, saveand enable selective sorting following items:\nCourse,Skill,Achievement,Activity,Role\nGenerate corresponding GPA based on different algorithms \nGenerate CV with one click and automatically open file \n");
    f1.setText(jsonObject.getString("name"));
    f2.setText(jsonObject.getString("age"));
    f3.setText(jsonObject.getString("school"));
    f4.setText(jsonObject.getString("major"));
    f5.setText(jsonObject.getString("admission_time"));
    f6.setText(jsonObject.getString("graduation_time"));
    // String[] temp = jsonObject.getString("image_path").split("/");
    String temp = jsonObject.getString("image_path");

    // String Picture = temp[1];
    String Picture = temp.substring(temp.length()-10);

    System.out.print("头像路径为"+ Picture);
    // System.out.print("------------"+(Picture=="head1.jpeg"));
    if(Picture.equals("head1.jpeg")){
    System.out.print("头像和1匹配");
       this.image = 1;
    }else if(Picture.equals("head2.jpeg")){
        this.image = 2;
    System.out.print("头像和2匹配");
    }else if(Picture.equals("head3.jpeg")){
        this.image = 3;
    System.out.print("头像和3匹配");
    }else if(Picture.equals("head4.jpeg")){
        this.image = 4;
    System.out.print("头像和4匹配");
    }else{
        // this.image = 1;
    }

    //暂时这样

    tx.setImage(new Image(getClass().getResourceAsStream(Picture)));
    // changetx1();
} catch (Exception e) {
    System.out.print("新建信息或头像没选");

}



    }
    private String getResourceAsStream(String picture) {
        return null;
    }
}