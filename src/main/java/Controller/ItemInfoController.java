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
import model.DTO.ItemInfoDto;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemInfoController implements Initializable {

    @FXML
    private TableColumn<ItemInfoDto, String> colItemCode;

    @FXML
    private TableColumn<ItemInfoDto, String> colDescription;

    @FXML
    private TableColumn<ItemInfoDto, String> colCategory;

    @FXML
    private TableColumn<ItemInfoDto, Integer> colQtyOnHand;

    @FXML
    private TableColumn<ItemInfoDto, Double> colUnitPrice;

    @FXML
    private TableView<ItemInfoDto> tblItemInfo;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtUnitPrice;

    private ObservableList<ItemInfoDto> itemInfoDtos = FXCollections.observableArrayList(
            new ItemInfoDto("I0001", "SunCrush", "Drink", 50, 170),
            new ItemInfoDto("I0002", "ChocoDelight", "Snack", 80, 250),
            new ItemInfoDto("I0003", "MilkFresh", "Dairy", 40, 200),
            new ItemInfoDto("I0004", "RiceKing", "Grocery", 100, 120),
            new ItemInfoDto("I0005", "SoftWash", "Detergent", 30, 450),
            new ItemInfoDto("I0006", "CandyPop", "Confectionery", 200, 15),
            new ItemInfoDto("I0007", "GoldenTea", "Beverage", 60, 350),
            new ItemInfoDto("I0008", "FruitMix", "Juice", 75, 220),
            new ItemInfoDto("I0009", "ChilliBlast", "Spices", 90, 95),
            new ItemInfoDto("I0010", "CoconutOil", "Grocery", 45, 780),
            new ItemInfoDto("I0011", "EggPro", "Dairy", 120, 25),
            new ItemInfoDto("I0012", "SoapPlus", "Personal Care", 150, 90),
            new ItemInfoDto("I0013", "ToothBright", "Personal Care", 60, 120),
            new ItemInfoDto("I0014", "SnackyBite", "Snack", 180, 55),
            new ItemInfoDto("I0015", "TomatoKetchup", "Sauce", 90, 350),
            new ItemInfoDto("I0016", "PowerDrink", "Energy", 75, 500),
            new ItemInfoDto("I0017", "CoffeeMix", "Beverage", 65, 400),
            new ItemInfoDto("I0018", "YoghurtCup", "Dairy", 100, 120),
            new ItemInfoDto("I0019", "ButterCream", "Dairy", 40, 950),
            new ItemInfoDto("I0020", "SugarCube", "Grocery", 200, 25)
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colItemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQtyOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblItemInfo.setItems(itemInfoDtos);

        tblItemInfo.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtItemCode.setText(newVal.getItemCode());
                txtDescription.setText(newVal.getDescription());
                txtCategory.setText(newVal.getCategory());
                txtQtyOnHand.setText(String.valueOf(newVal.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(newVal.getUnitPrice()));
            }
        });
    }

    @FXML
    void btnAdd(ActionEvent event) {
        ItemInfoDto dto = new ItemInfoDto(
                txtItemCode.getText(),
                txtDescription.getText(),
                txtCategory.getText(),
                Integer.parseInt(txtQtyOnHand.getText()),
                Double.parseDouble(txtUnitPrice.getText())
        );
        itemInfoDtos.add(dto);
        clearFields();
    }

    @FXML
    void btnUpdate(ActionEvent event) {
        ItemInfoDto selected = tblItemInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setDescription(txtDescription.getText());
            selected.setCategory(txtCategory.getText());
            selected.setQtyOnHand(Integer.parseInt(txtQtyOnHand.getText()));
            selected.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));
            tblItemInfo.refresh();
        }
    }

    @FXML
    void btnDelete(ActionEvent event) {
        ItemInfoDto selected = tblItemInfo.getSelectionModel().getSelectedItem();
        if (selected != null) {
            itemInfoDtos.remove(selected);
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
        txtItemCode.clear();
        txtDescription.clear();
        txtCategory.clear();
        txtQtyOnHand.clear();
        txtUnitPrice.clear();
    }
}
