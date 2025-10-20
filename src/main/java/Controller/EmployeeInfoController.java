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
            new EmployeeInfoDTO("E0003", "Kavindu Fernando", "1992-07-08", "2017-06-20", "Stock Keeper", "55000", "Active", "0768765432", "45/2, Temple Road, Galle", "921234567V"),
            new EmployeeInfoDTO("E0004", "Samantha Jayasinghe", "1991-03-15", "2018-09-10", "Accountant", "70000", "Active", "0753456789", "78, Hill Street, Matara", "941234567V"),
            new EmployeeInfoDTO("E0005", "Ruwan Kumara", "1989-12-05", "2014-06-25", "Supervisor", "90000", "Active", "0724567890", "56, Lake Road, Jaffna", "961234567V"),
            new EmployeeInfoDTO("E0006", "Chamari Silva", "1993-07-21", "2019-11-01", "Cashier", "60000", "Active", "0715678901", "23, Garden Street, Colombo", "971234567V"),
            new EmployeeInfoDTO("E0007", "Kasun Perera", "1990-01-17", "2015-04-12", "Stock Keeper", "58000", "Active", "0766789012", "12, River Road, Kandy", "981234567V"),
            new EmployeeInfoDTO("E0008", "Dilani Fernando", "1992-09-30", "2017-08-20", "Manager", "125000", "Active", "0777890123", "34, Beach Road, Galle", "991234567V"),
            new EmployeeInfoDTO("E0009", "Tharindu Jayasuriya", "1987-05-05", "2013-12-10", "Accountant", "72000", "Active", "0758901234", "45, Flower Road, Matara", "901234568V"),
            new EmployeeInfoDTO("E0010", "Nadeesha Kumari", "1994-11-12", "2020-03-15", "Cashier", "63000", "Active", "0719012345", "67, Palm Street, Colombo", "911234567V"),
            new EmployeeInfoDTO("E0011", "Ishara Wijesinghe", "1991-09-09", "2018-02-18", "Supervisor", "88000", "Active", "0772345671", "23, Rose Street, Negombo", "921235678V"),
            new EmployeeInfoDTO("E0012", "Supun Jayawardena", "1986-02-24", "2012-05-10", "Manager", "130000", "Active", "0713456782", "89, Lake Road, Kandy", "861234567V"),
            new EmployeeInfoDTO("E0013", "Gayani Rajapaksa", "1993-06-07", "2019-09-22", "Cashier", "62000", "Active", "0764567893", "11, Temple Road, Galle", "931234567V"),
            new EmployeeInfoDTO("E0014", "Niroshan Fernando", "1988-10-29", "2015-07-30", "Accountant", "71000", "Active", "0755678904", "90, Garden Street, Matara", "881234568V"),
            new EmployeeInfoDTO("E0015", "Amali Perera", "1995-01-11", "2021-01-05", "Stock Keeper", "59000", "Active", "0716789015", "32, Beach Road, Colombo", "951234567V"),
            new EmployeeInfoDTO("E0016", "Chathura Silva", "1990-04-25", "2015-11-11", "Supervisor", "87000", "Active", "0777890126", "19, Hill Street, Galle", "901235678V"),
            new EmployeeInfoDTO("E0017", "Piumi Jayalath", "1992-08-19", "2017-04-19", "Cashier", "64000", "Active", "0768901237", "56, River Road, Kandy", "921234568V"),
            new EmployeeInfoDTO("E0018", "Rashmika Wijesooriya", "1987-07-14", "2013-09-09", "Manager", "118000", "Active", "0759012348", "87, Flower Road, Colombo", "871234568V"),
            new EmployeeInfoDTO("E0019", "Harini Jayawardena", "1993-02-22", "2019-03-25", "Accountant", "69000", "Active", "0710123459", "21, Palm Street, Matara", "931234568V"),
            new EmployeeInfoDTO("E0020", "Dasun Madushanka", "1991-06-17", "2018-07-01", "Stock Keeper", "56000", "Active", "0761234560", "44, Garden Street, Kandy", "911235678V")
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
