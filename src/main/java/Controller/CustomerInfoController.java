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
            new CustomerInfoDto("C0003","Mr","Sithum","1999-12-15",95000,"Temple Road","Galle","Southern","80000"),
            new CustomerInfoDto("C0004","Mrs","Ishara","1988-03-11",175000,"Station Road","Colombo","Western","00100"),
            new CustomerInfoDto("C0005","Mr","Ravindu","2000-07-20",82000,"Main Street","Kandy","Central","20000"),
            new CustomerInfoDto("C0006","Ms","Tharushi","2003-09-18",134000,"Beach Road","Matara","Southern","81000"),
            new CustomerInfoDto("C0007","Mr","Pasindu","2001-05-22",99000,"Temple Junction","Negombo","Western","11500"),
            new CustomerInfoDto("C0008","Ms","Bimsara","1998-08-30",145000,"Hospital Road","Kurunegala","North Western","60000"),
            new CustomerInfoDto("C0009","Mr","Kavindu","1997-02-25",112000,"Market Road","Anuradhapura","North Central","50000"),
            new CustomerInfoDto("C0010","Mrs","Dinithi","1989-11-02",168000,"Railway Avenue","Rathnapura","Sabaragamuwa","70000"),
            new CustomerInfoDto("C0011","Mr","Supun","1996-04-10",101000,"Lake Road","Polonnaruwa","North Central","51000"),
            new CustomerInfoDto("C0012","Ms","Mishara","2004-01-28",95000,"Park Lane","Badulla","Uva","90000"),
            new CustomerInfoDto("C0013","Mr","Chathura","1995-10-06",123000,"New Town","Nuwara Eliya","Central","22200"),
            new CustomerInfoDto("C0014","Mrs","Anushka","1992-07-13",176000,"College Road","Batticaloa","Eastern","30000"),
            new CustomerInfoDto("C0015","Mr","Heshan","1998-12-03",88000,"Church Street","Trincomalee","Eastern","31000"),
            new CustomerInfoDto("C0016","Ms","Rashmi","2001-11-21",132000,"Hill View","Kegalle","Sabaragamuwa","71000"),
            new CustomerInfoDto("C0017","Mr","Dulaj","1999-05-09",97000,"River Road","Hambantota","Southern","82000"),
            new CustomerInfoDto("C0018","Ms","Sanjula","2002-09-27",115000,"Court Road","Gampaha","Western","11000"),
            new CustomerInfoDto("C0019","Mr","Tharusha","1994-01-15",142000,"Bazaar Street","Monaragala","Uva","91000"),
            new CustomerInfoDto("C0020","Mrs","Oshini","1991-08-08",162000,"Rose Lane","Jaffna","Northern","40000")
            );

    @FXML
    private TableView<CustomerInfoDto> tblCustomerInfo;

    @FXML
    private TableColumn<CustomerInfoDto, String> colCustId;

    @FXML
    private TableColumn<CustomerInfoDto, String> colTitle;

    @FXML
    private TableColumn<CustomerInfoDto, String> colName;

    @FXML
    private TableColumn<CustomerInfoDto, String> colDob;

    @FXML
    private TableColumn<CustomerInfoDto, Double> colSalary;

    @FXML
    private TableColumn<CustomerInfoDto, String> colAddress;

    @FXML
    private TableColumn<CustomerInfoDto, String> colCity;

    @FXML
    private TableColumn<CustomerInfoDto, String> colProvince;

    @FXML
    private TableColumn<CustomerInfoDto, String> colPostalCode;

    @FXML
    private TextField txtCustId;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtDob;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtPostalCode;

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

    @FXML
    void btnClear(ActionEvent event) {
        clearFields();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCustId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salaray"));
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
