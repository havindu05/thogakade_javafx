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
import model.DTO.CustomerInfoDto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfoController implements Initializable {

    ObservableList<CustomerInfoDto> customerInfoDtos = FXCollections.observableArrayList(
            new CustomerInfoDto("C0001","Mr","Havindu","2005-04-17",150000,"Patabdimulla","Ambalangoda","Southern","80301"),
            new CustomerInfoDto("C0002","Ms","Nethmi","2002-06-23",120000,"Panadura Road","Kalutara","Western","12000"),
            new CustomerInfoDto("C0003","Mr","Sithum","1999-12-15",95000,"Temple Road","Galle","Southern","80000")

    );

    @FXML
    private TableView<CustomerInfoDto> tblCustomerInfo;

    @FXML
    private TableColumn<CustomerInfoDto, String> colCustId, colTitle, colName, colDob, colAddress, colCity, colProvince, colPostalCode;

    @FXML
    private TableColumn<CustomerInfoDto, Double> colSalary;

    @FXML
    private TextField txtCustId, txtTitle, txtName, txtDob, txtSalary, txtAddress, txtCity, txtProvince, txtPostalCode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblCustomerInfo.setItems(customerInfoDtos);

        tblCustomerInfo.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtCustId.setText(newSelection.getCustId());
                txtTitle.setText(newSelection.getTitle());
                txtName.setText(newSelection.getName());
                txtDob.setText(newSelection.getDob());
                txtSalary.setText(String.valueOf(newSelection.getSalaray()));
                txtAddress.setText(newSelection.getAddress());
                txtCity.setText(newSelection.getCity());
                txtProvince.setText(newSelection.getProvince());
                txtPostalCode.setText(newSelection.getPostalCode());
            }
        });
    }

    @FXML
    void btnAdd(ActionEvent event) {
        CustomerInfoDto dto = new CustomerInfoDto(
                txtCustId.getText(),
                txtTitle.getText(),
                txtName.getText(),
                txtDob.getText(),
                Double.parseDouble(txtSalary.getText()),
                txtAddress.getText(),
                txtCity.getText(),
                txtProvince.getText(),
                txtPostalCode.getText()
        );
        customerInfoDtos.add(dto);
        clearFields();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        CustomerInfoDto selected = tblCustomerInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setTitle(txtTitle.getText());
            selected.setName(txtName.getText());
            selected.setDob(txtDob.getText());
            selected.setSalaray(Double.parseDouble(txtSalary.getText()));
            selected.setAddress(txtAddress.getText());
            selected.setCity(txtCity.getText());
            selected.setProvince(txtProvince.getText());
            selected.setPostalCode(txtPostalCode.getText());
            tblCustomerInfo.refresh();
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        CustomerInfoDto selected = tblCustomerInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            customerInfoDtos.remove(selected);
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
        txtCustId.clear();
        txtTitle.clear();
        txtName.clear();
        txtDob.clear();
        txtSalary.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
    }
}
