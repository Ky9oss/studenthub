package view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    
    @FXML
    private ImageView tx;
        
    Image tx2 = new Image(getClass().getResourceAsStream("tx2.jpg")); 
    
    Image tx1 = new Image(getClass().getResourceAsStream("tx1.jpg")); 

    @FXML
    private Button changeButton;

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
            testlabel.setText("点击修改");
            f1.setDisable(false);
            f2.setDisable(false);
            f3.setDisable(false);
            f4.setDisable(false);
            f5.setDisable(false);
            f6.setDisable(false);
            changeButton.setText("SAVE");
            this.status=1;
        }
            else{
                testlabel.setText("修改成功!");
                f1.setDisable(true);
                f2.setDisable(true);
                f3.setDisable(true);
                f4.setDisable(true);
                f5.setDisable(true);
                f6.setDisable(true);
                changeButton.setText("MODIFY");
                this.status=0;
            }     

    }

    @FXML
    private void changetx1(ActionEvent event) throws IOException{
           tx.setImage(tx1);
    }

    @FXML
    private void changetx2(ActionEvent event) throws IOException{
            tx.setImage(tx2);
    }
}