package com.example.proyecto_coches_hibernate;

import com.example.proyecto_coches_hibernate.dao.CocheDAO;
import com.example.proyecto_coches_hibernate.model.Coche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.transaction.SystemException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btAnadir;

    @FXML
    private Button btBorrar;

    @FXML
    private Button btLimpiar;

    @FXML
    private Button btModificar;

    @FXML
    private ComboBox<String> cbTipo;
    String[] tipos_de_coches={"SUB", "Monovolumen", "Hibrido", "Furgoneta"};

    @FXML
    private TableColumn<?, ?> colMarca;

    @FXML
    private TableColumn<?, ?> colMatricula;

    @FXML
    private TableColumn<?, ?> colModelo;

    @FXML
    private TableColumn<?, ?> colTipo;

    @FXML
    private TableView<Coche> tablaCoches;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtModelo;

    CocheDAO cochedao=new CocheDAO();

    @FXML
    void anadirCoche(ActionEvent event) throws SystemException {

        String matricula=txtMatricula.getText().toString();
        String marca=txtMarca.getText().toString();
        String modelo=txtModelo.getText().toString();
        String tipo=cbTipo.getValue().toString();

        Coche coche=new Coche(matricula, marca, modelo, tipo);

        cochedao.guardarCoche(coche);

    }

    @FXML
    void borrarCoche(ActionEvent event) {

        String matricula=txtMatricula.getText().toString();

        cochedao.borrarCoche(matricula);

    }

    @FXML
    void modificarCoche(ActionEvent event) {

        String matricula=txtMatricula.getText().toString();
        String marca=txtMarca.getText().toString();
        String modelo=txtModelo.getText().toString();
        String tipo=cbTipo.getValue().toString();

        Coche coche=new Coche(matricula, marca, modelo, tipo);

        cochedao.modificarCoche(coche);

    }

    @FXML
    void resetAplicacion(ActionEvent event) {

    }

    public void camposVacios(ActionEvent event) {

        txtMatricula.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        //Falta comboBox

    }
    private void actualizarTableView(){

        List<Coche> coches = cochedao.listarCoches();
        ObservableList<Coche> data = FXCollections.observableArrayList(coches);

        // Agregar datos a la TableView
        tablaCoches.setItems(data);

        this.colMatricula.setCellValueFactory(new PropertyValueFactory("matricula"));
        this.colMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        this.colModelo.setCellValueFactory(new PropertyValueFactory("modelo"));
        this.colTipo.setCellValueFactory(new PropertyValueFactory("tipo"));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        actualizarTableView();
        //sacar datos en comboBox
        cbTipo.getItems().addAll(tipos_de_coches);

    }
}





