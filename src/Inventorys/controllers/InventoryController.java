package Inventorys.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class InventoryController {

    @FXML
    private TableView<?> tbViewProduct;

    @FXML
    private TextField trackID;

    @FXML
    private TextField productName;

    @FXML
    private TextField quantity;

    @FXML
    private TextField price;

    @FXML
    private TextField searchField;

    @FXML
    private Button refreshBtn;

    @FXML
    private Button delBtn;

    @FXML
    private Button addBtn;

    @FXML
    void addNew(ActionEvent event) {

    }

    @FXML
    void editPrice(ActionEvent event) {

    }

    @FXML
    void editProductName(ActionEvent event) {

    }

    @FXML
    void editQuantity(ActionEvent event) {

    }

    @FXML
    void editTrackID(ActionEvent event) {

    }

    @FXML
    void onDeleting(ActionEvent event) {

    }

    @FXML
    void onRefersh(ActionEvent event) {

    }

    @FXML
    void searching(KeyEvent event) {

    }

}
