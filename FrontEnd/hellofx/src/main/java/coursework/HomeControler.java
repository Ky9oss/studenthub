package coursework;

import java.io.IOException;
import javafx.fxml.FXML;
public class HomeControler {
    @FXML
    private void gotoHome() throws IOException {
        App.setRoot("home");
    }
    @FXML
    private void gotoCourse() throws IOException {
        App.setRoot("course");
    }
    @FXML
    private void gotoGrade() throws IOException {
        App.setRoot("grade");
    }
    @FXML
    private void gotoSkill() throws IOException {
        App.setRoot("skill");
    }
    @FXML
    private void gotoAchievement() throws IOException {
        App.setRoot("achievement");
    }
    @FXML
    private void gotoActivity() throws IOException {
        App.setRoot("activity");
    }
    @FXML
    private void gotoRole() throws IOException {
        App.setRoot("role");
    }
    @FXML
    private void gotoGPA() throws IOException {
        App.setRoot("GPA");
    }
    @FXML
    private void gotoCV() throws IOException {
        App.setRoot("CV");
    }
}