package view;
import java.io.IOException;
import java.net.URISyntaxException;

import controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
// import javafx.scene.layout.VBox;
// import java.io.IOException;
 public class GPAControler {
    
    @FXML
    private Button b1;

    @FXML
    private Button b2;

    @FXML
    private Button b3;

    @FXML
    private Label detail;

    @FXML
    private Label gpa;
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
    void sf1(ActionEvent event) throws IOException, URISyntaxException{

          detail.setText("The standard 4.0 GPA algorithm assigns a numerical value to each letter grade, ranging from 4.0 for an A to 0.0 for an F. The algorithm uses a fixed range of scores to determine the corresponding GPA value for each letter grade, as follows:"+"\n"+"A grade of 90-100 corresponds to a GPA of 4.0\nB grade of 80-89 corresponds to a GPA of 3.0\nC grade of 70-79 corresponds to a GPA of 2.0\nD grade of 60-69 corresponds to a GPA of 1.0\nF grade below 60 corresponds to a GPA of 0.0");
          gpa.setText(""+Controller.calculateGradePointAverage(1));
    }

    @FXML
    void sf2(ActionEvent event) throws IOException, URISyntaxException{
        detail.setText("The WES GPA algorithm assigns a numerical value to each letter grade, ranging from 4.0 for an A to 1.0 for a D. The algorithm uses a fixed range of scores to determine the corresponding GPA value for each letter grade, as follows:\nA grade of 85-100 corresponds to a GPA of 4.0\nB grade of 75-84 corresponds to a GPA of 3.0\nC grade of 60-74 corresponds to a GPA of 2.0\nD grade below 60 corresponds to a GPA of 1.0");
        gpa.setText(""+Controller.calculateGradePointAverage(2));
    }

    @FXML
    void sf3(ActionEvent event) throws IOException, URISyntaxException{
        detail.setText("The PKU 4.0 GPA algorithm assigns a numerical value to each letter grade, ranging from 4.0 for an A to 0.0 for an F. The algorithm uses a fixed range of scores to determine the corresponding GPA value for each letter grade, as follows:\nA grade of 90-100 corresponds to a GPA of 4.0\nA- grade of 85-89 corresponds to a GPA of 3.7\nB+ grade of 82-84 corresponds to a GPA of 3.3\nB grade of 78-81 corresponds to a GPA of 3.0\nB- grade of 75-77 corresponds to a GPA of 2.7\nC+ grade of 72-74 corresponds to a GPA of 2.3\nC grade of 68-71 corresponds to a GPA of 2.0\nC- grade of 65-67 corresponds to a GPA of 1.5\nD grade of 60-64 corresponds to a GPA of 1.0\nF grade below 60 corresponds to a GPA of 0.0.");
        gpa.setText(""+Controller.calculateGradePointAverage(3));
    }
 }
 