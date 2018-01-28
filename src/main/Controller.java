package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import java.io.File;
import java.io.IOException;

public class Controller {

    @FXML
    private Label fstChooeseLabel;
    @FXML
    private Label secChooeseLabel;
    @FXML
    private Label saveChooseLabel;

    private String fstPath;
    private String secPath;
    private String savePath;


    @FXML
    private void fstChooseBtn(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel 97-2003", "*.xls"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null){
            fstChooeseLabel.setText(file.getCanonicalPath());
            fstPath = file.getCanonicalPath();
        }
    }
    @FXML
    private void secChooseBtn(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel 97-2003", "*.xls"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null){
            secChooeseLabel.setText(file.getCanonicalPath());
            secPath= file.getCanonicalPath();
        }
    }
    @FXML
    private void saveChooseBtn(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel 97-2003", "*.xls"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null){
            saveChooseLabel.setText(file.getCanonicalPath());
            savePath = file.getCanonicalPath();
        }
    }
    @FXML
    private void startBtn(ActionEvent actionEvent) {
        //Start engine

    }
}
