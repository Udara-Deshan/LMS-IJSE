package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class DashBordController {

    @FXML
    private BorderPane boderPane;

    @FXML
    private Button btnStudent;

    @FXML
    void onStudent(ActionEvent event) {
        loadUI("Student");
    }
    private void loadUI(String ui) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/view/"+ui+".fxml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        boderPane.setCenter(root);
    }
}
