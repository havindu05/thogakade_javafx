package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.DTO.EmployeeInfoDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeInfoController implements Initializable {

    ObservableList<EmployeeInfoDTO> employeeInfoDTOS = FXCollections.observableArrayList(
            new EmployeeInfoDTO("E0001", "Nimal Perera", "1990-05-12", "2015-01-10", "Manager", "120000", "Active", "0771234567", "No 12, Main Street, Colombo", "901234567V"),
            new EmployeeInfoDTO("E0002", "Anushka Silva", "1988-11-23", "2016-03-15", "Cashier", "65000", "Active", "0712345678", "No 34, Lake Road, Kandy", "881234567V"),
            new EmployeeInfoDTO("E0003", "Kavindu Fernando", "1992-07-08", "2017-06-20", "Stock Keeper", "55000", "Active", "0768765432", "45/2, Temple Road, Galle", "921234567V")
    );

    @FXML
    private TableView<EmployeeInfoDTO> tblEmployeeInfo;

    @FXML
    private TableColumn<EmployeeInfoDTO, String> colEmployeeId, colName, colDob, colJoinedDate, colPosition, colStatus, colContactNumber, colAddress, colNic;

    @FXML
    private TableColumn<EmployeeInfoDTO, Integer> colSalary;

    @FXML
    private TextField txtEmployeeId, txtName, txtDob, txtJoinedDate, txtPosition, txtStatus, txtSalary, txtContactNumber, txtAddress, txtNic;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colJoinedDate.setCellValueFactory(new PropertyValueFactory<>("joinDate"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));

        tblEmployeeInfo.setItems(employeeInfoDTOS);

        tblEmployeeInfo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtEmployeeId.setText(newSelection.getEmployeeId());
                txtName.setText(newSelection.getName());
                txtDob.setText(newSelection.getDob());
                txtJoinedDate.setText(newSelection.getJoinDate());
                txtPosition.setText(newSelection.getPosition());
                txtSalary.setText(String.valueOf(newSelection.getSalary()));
                txtStatus.setText(newSelection.getStatus());
                txtContactNumber.setText(newSelection.getContactNumber());
                txtAddress.setText(newSelection.getAddress());
                txtNic.setText(newSelection.getNic());
            }
        });
    }

    @FXML
    void btnAdd(ActionEvent event) {
        EmployeeInfoDTO dto = new EmployeeInfoDTO(
                txtEmployeeId.getText(),
                txtName.getText(),
                txtDob.getText(),
                txtJoinedDate.getText(),
                txtPosition.getText(),
                txtSalary.getText(),
                txtStatus.getText(),
                txtContactNumber.getText(),
                txtAddress.getText(),
                txtNic.getText()
        );
        employeeInfoDTOS.add(dto);
        clearFields();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        EmployeeInfoDTO selected = tblEmployeeInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setName(txtName.getText());
            selected.setDob(txtDob.getText());
            selected.setJoinDate(txtJoinedDate.getText());
            selected.setPosition(txtPosition.getText());
            selected.setSalary(txtSalary.getText());
            selected.setStatus(txtStatus.getText());
            selected.setContactNumber(txtContactNumber.getText());
            selected.setAddress(txtAddress.getText());
            selected.setNic(txtNic.getText());
            tblEmployeeInfo.refresh();
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        EmployeeInfoDTO selected = tblEmployeeInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            employeeInfoDTOS.remove(selected);
            clearFields();
        }
    }

    @FXML
    void btnClear(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/HomePage.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Home Page");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        txtEmployeeId.clear();
        txtName.clear();
        txtDob.clear();
        txtJoinedDate.clear();
        txtPosition.clear();
        txtSalary.clear();
        txtStatus.clear();
        txtContactNumber.clear();
        txtAddress.clear();
        txtNic.clear();
    }
}
