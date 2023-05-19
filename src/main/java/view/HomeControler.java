package view;
import controller.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
// import com.alibaba.fastjson.JSON;
import org.checkerframework.checker.initialization.qual.Initialized;
import org.checkerframework.common.initializedfields.qual.InitializedFields;
// import org.json.JSONArray;
import org.json.JSONArray;

import com.google.gson.JsonObject;
// import org.json.JSONException;
// import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.Node;
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
                alert.setContentText("修改成功");
                alert.show();
                // testlabel.setText("修改成功!");
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
    //    System.out.print(jsonObject.getString("name"));


    f1.setText(jsonObject.getString("name"));
    f2.setText(jsonObject.getString("age"));
    f3.setText(jsonObject.getString("school"));
    f4.setText(jsonObject.getString("major"));
    f5.setText(jsonObject.getString("admission_time"));
    f6.setText(jsonObject.getString("graduation_time"));
    String[] temp = jsonObject.getString("image_path").split("/");
    String Picture = temp[1];
    System.out.print("头像路径为"+ Picture);
    //暂时这样
    tx.setImage(new Image(getClass().getResourceAsStream(Picture)));
    // changetx1();
} catch (Exception e) {
    System.out.print("新建信息");

}



    }
}