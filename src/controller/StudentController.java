package controller;

import bo.BOFactory;
import bo.student.StudentBO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import util.IDGen;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author : Udara Deshan <udaradeshan.ud@gmail.com>
 * @since : 7/12/2022
 **/
public class StudentController implements Initializable {
    @FXML
    private TableView<StudentDTO> tblStudent;

    @FXML
    private TableColumn<StudentDTO, String> sid;

    @FXML
    private TableColumn<StudentDTO, String> name;

    @FXML
    private TableColumn<StudentDTO, String> email;

    @FXML
    private TableColumn<StudentDTO, String> contact;

    @FXML
    private TableColumn<StudentDTO, String> address;

    @FXML
    private TableColumn<StudentDTO, String> nic;

    @FXML
    private TextField txtSid;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtNIC;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    private ObservableList<StudentDTO> allStudentData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        makeStudentTable();
        loadStudentData();
        getNextID();
    }

    @FXML
    void OnDelete(ActionEvent event) {

    }

    @FXML
    void onSave(ActionEvent event) {
        StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOType.STUDENT);
        boolean status = false;
        try {
            status = studentBO.addStudent(setStudentDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (status) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student");
            alert.setHeaderText(null);
            alert.setContentText("Student Added successfully");
            alert.showAndWait();
            clear();
        }
    }

    @FXML
    void onUpdate(ActionEvent event) {
        StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOType.STUDENT);
        boolean status = false;
        try {
            status = studentBO.updateStudent(setStudentDTO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (status) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Student");
            alert.setHeaderText(null);
            alert.setContentText("Student Updated successfully");
            alert.showAndWait();
            clear();
        }
    }

    private StudentDTO setStudentDTO() {
        StudentDTO studentDTO=new StudentDTO();
        studentDTO.setId(txtSid.getText());
        studentDTO.setName(txtName.getText());
        studentDTO.setEmail(txtEmail.getText());
        studentDTO.setContact(txtContact.getText());
        studentDTO.setAddress(txtAddress.getText());
        studentDTO.setNic(txtNIC.getText());
        return studentDTO;
    }

    private void clear() {
        txtNIC.clear();
        txtName.clear();
        txtEmail.clear();
        txtSid.clear();
        txtContact.clear();
        txtAddress.clear();
        loadStudentData();
        getNextID();

    }

    private void makeStudentTable(){
        sid.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        name.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        contact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        nic.setCellValueFactory(new PropertyValueFactory<>("nic"));
    }

    private void loadStudentData() {
        try {
            StudentBO studentBO = (StudentBO) BOFactory.getBOFactory().getSuperBO(BOFactory.BOType.STUDENT);
            ArrayList<StudentDTO> students = studentBO.getAllStudents();
            allStudentData.clear();
            for (StudentDTO studentDTO : students) {
                if (studentDTO!= null) {
                    allStudentData.add(studentDTO);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void getNextID(){
        try {
            txtSid.setText(new IDGen(IDGen.TableName.STUDENT).getNextID());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
