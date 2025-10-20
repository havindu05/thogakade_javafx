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
import model.DTO.SupplierInfoDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SupplierInfoController implements Initializable {

    @FXML
    private TableColumn<SupplierInfoDTO, String> colSupplierId;

    @FXML
    private TableColumn<SupplierInfoDTO, String> colName;

    @FXML
    private TableColumn<SupplierInfoDTO, String> colCompanyname;

    @FXML
    private TableColumn<SupplierInfoDTO, String> colEmail;

    @FXML
    private TableColumn<SupplierInfoDTO, String> colPhone;

    @FXML
    private TableColumn<SupplierInfoDTO, String> colAddress;

    @FXML
    private TableColumn<SupplierInfoDTO, String> colCity;

    @FXML
    private TableColumn<SupplierInfoDTO, String> colProvince;

    @FXML
    private TableColumn<SupplierInfoDTO, String> colPostalCode;

    @FXML
    private TableView<SupplierInfoDTO> tblSupplierInfo;

    @FXML
    private TextField txtSupplierId, txtName, txtCompanyName, txtEmail, txtPhone, txtAddress, txtCity, txtProvince, txtPostalCode;

    ObservableList<SupplierInfoDTO> supplierInfoDTOS = FXCollections.observableArrayList(
            new SupplierInfoDTO("S0001", "Heshan Perera", "FreshSupplies", "heshan@fresh.lk", "0771234567", "No 45, Galle Road", "Colombo", "Western", "00500"),
            new SupplierInfoDTO("S0002", "Anushka Silva", "FoodMart", "anushka@foodmart.lk", "0712345678", "No 12, Main Street", "Kandy", "Central", "20000"),
            new SupplierInfoDTO("S0003", "Kavindu Fernando", "TechTrade", "kavindu@techtrade.lk", "0768765432", "45/2, Temple Road", "Galle", "Southern", "80000"),
            new SupplierInfoDTO("S0004", "Dinuka Jayasuriya", "AgroGreen", "dinuka@agrogreen.lk", "0751122334", "32, Matara Road", "Matara", "Southern", "81000"),
            new SupplierInfoDTO("S0005", "Isuru Senanayake", "BuildMate", "isuru@buildmate.lk", "0789988776", "110, High Level Road", "Nugegoda", "Western", "10250"),
            new SupplierInfoDTO("S0006", "Nadeesha Rodrigo", "MediCare", "nadeesha@medicare.lk", "0723344556", "25, Temple Road", "Kurunegala", "North Western", "60000"),
            new SupplierInfoDTO("S0007", "Ravindu Dias", "SmartElectro", "ravindu@smartelectro.lk", "0764455667", "80/1, Queen’s Street", "Negombo", "Western", "11500"),
            new SupplierInfoDTO("S0008", "Sajith Abeywickrama", "OceanFoods", "sajith@oceanfoods.lk", "0702233445", "12, Harbour Road", "Trincomalee", "Eastern", "31000"),
            new SupplierInfoDTO("S0009", "Manuja Peiris", "DailyFresh", "manuja@dailyfresh.lk", "0718899776", "9, Bazaar Street", "Kalutara", "Western", "12000"),
            new SupplierInfoDTO("S0010", "Tharindu Wickramasinghe", "EcoPack", "tharindu@ecopack.lk", "0756655443", "14, Industrial Zone", "Ratnapura", "Sabaragamuwa", "70000"),
            new SupplierInfoDTO("S0011", "Sithmi Fernando", "GlowCosmetics", "sithmi@glow.lk", "0767788990", "100, Park Avenue", "Colombo", "Western", "00400"),
            new SupplierInfoDTO("S0012", "Lakshan Ranasinghe", "AutoPartsLK", "lakshan@autoparts.lk", "0771122990", "42, Main Road", "Gampaha", "Western", "11000"),
            new SupplierInfoDTO("S0013", "Chathuri Weerasinghe", "HerbalHouse", "chathuri@herbalhouse.lk", "0748899001", "15, Green Lane", "Badulla", "Uva", "90000"),
            new SupplierInfoDTO("S0014", "Roshan Alahakoon", "CeylonSpices", "roshan@ceylonspices.lk", "0715566778", "22, Market Road", "Matale", "Central", "21000"),
            new SupplierInfoDTO("S0015", "Kasun Rathnayake", "PrintWorks", "kasun@printworks.lk", "0781122334", "50, Lake View", "Anuradhapura", "North Central", "50000"),
            new SupplierInfoDTO("S0016", "Hansika Madushani", "BrightLights", "hansika@brightlights.lk", "0754455667", "88, Station Road", "Jaffna", "Northern", "40000"),
            new SupplierInfoDTO("S0017", "Chamod Hettiarachchi", "QuickFoods", "chamod@quickfoods.lk", "0763344556", "120, Temple Lane", "Hambantota", "Southern", "82000"),
            new SupplierInfoDTO("S0018", "Nirmala Rajapaksha", "EliteFabrics", "nirmala@elitefabrics.lk", "0712233445", "21, Textile Street", "Kurunegala", "North Western", "60050"),
            new SupplierInfoDTO("S0019", "Malith Jayawardena", "PaperPlus", "malith@paperplus.lk", "0778899001", "78, Hill Side", "Nuwara Eliya", "Central", "22000"),
            new SupplierInfoDTO("S0020", "Yasara Gunasekara", "CeylonTeaHouse", "yasara@ceylontea.lk", "0757788990", "32, Tea Factory Road", "Galle", "Southern", "80100")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCompanyname.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblSupplierInfo.setItems(supplierInfoDTOS);

        tblSupplierInfo.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtSupplierId.setText(newVal.getSupplierId());
                txtName.setText(newVal.getName());
                txtCompanyName.setText(newVal.getCompnayName());
                txtEmail.setText(newVal.getEmail());
                txtPhone.setText(newVal.getPhone());
                txtAddress.setText(newVal.getAddress());
                txtCity.setText(newVal.getCity());
                txtProvince.setText(newVal.getProvince());
                txtPostalCode.setText(newVal.getPostalCode());
            }
        });
    }

    @FXML
    void btnAdd(ActionEvent event) {
        SupplierInfoDTO dto = new SupplierInfoDTO(
                txtSupplierId.getText(),
                txtName.getText(),
                txtCompanyName.getText(),
                txtEmail.getText(),
                txtPhone.getText(),
                txtAddress.getText(),
                txtCity.getText(),
                txtProvince.getText(),
                txtPostalCode.getText()
        );
        supplierInfoDTOS.add(dto);
        clearFields();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        SupplierInfoDTO selected = tblSupplierInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setName(txtName.getText());
            selected.setCompnayName(txtCompanyName.getText());
            selected.setEmail(txtEmail.getText());
            selected.setPhone(txtPhone.getText());
            selected.setAddress(txtAddress.getText());
            selected.setCity(txtCity.getText());
            selected.setProvince(txtProvince.getText());
            selected.setPostalCode(txtPostalCode.getText());
            tblSupplierInfo.refresh();
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        SupplierInfoDTO selected = tblSupplierInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            supplierInfoDTOS.remove(selected);
            clearFields();
        }
    }

    @FXML
    void btnClear(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtSupplierId.clear();
        txtName.clear();
        txtCompanyName.clear();
        txtEmail.clear();
        txtPhone.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
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
}
