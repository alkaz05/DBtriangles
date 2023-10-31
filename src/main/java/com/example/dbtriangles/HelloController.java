package com.example.dbtriangles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        SQLExperiment ex = new SQLExperiment();
        ex.testConnection();
    }

    @FXML
    private TextField txtA;

    @FXML
    private TextField txtB;

    @FXML
    private TextField txtC;

    @FXML
    TableView<OTriangle> table;

    ObservableList<OTriangle> triangles = FXCollections.observableArrayList();

    public void initialize(){

        table.getColumns().clear();
        table.setItems(triangles);

        TableColumn<OTriangle, Double> col1 = new TableColumn<>("сторона a");
        col1.setCellValueFactory(new PropertyValueFactory<>("a"));
        table.getColumns().add(col1);

        TableColumn<OTriangle, Double> col2 = new TableColumn<>("сторона b");
        col2.setCellValueFactory(new PropertyValueFactory<>("b"));
        table.getColumns().add(col2);
        TableColumn<OTriangle, Double> col3 = new TableColumn<>("сторона c");
        col3.setCellValueFactory(new PropertyValueFactory<>("c"));
        table.getColumns().add(col3);
        TableColumn<OTriangle, Double> col4 = new TableColumn<>("периметр");
        col4.setCellValueFactory(new PropertyValueFactory<>("perim"));
        table.getColumns().add(col4);
        TableColumn<OTriangle, Double> col5 = new TableColumn<>("площадь");
        col5.setCellValueFactory(new PropertyValueFactory<>("area"));
        table.getColumns().add(col5);
    }

    @FXML
    void saveToDB(ActionEvent event) {
        try {
            double x = Double.parseDouble(txtA.getText());
            double y = Double.parseDouble(txtB.getText());
            double z = Double.parseDouble(txtC.getText());
            OTriangle t = new OTriangle(x, y, z);
            SQLExperiment.saveTriangle(t);

        }
        catch (Exception e){
            System.out.println("ошибка записи "+e.getMessage());
        }
    }

    @FXML
    void reloadFromBD(){
        //извлечь строки из базы и поместить в коллекцию triangles
       try {
           List<OTriangle> lst = SQLExperiment.readTriangles();
           triangles.clear();
           triangles.addAll(lst);
       }
       catch (Exception e){
           System.out.println("ошибка чтения "+e.getMessage());
       }
    }
}