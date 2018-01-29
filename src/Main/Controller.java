package Main;

import engine.EqualsUnequals.EqualsIsNotEqualTo;
import engine.Xls.ReadXlsFileFst;
import engine.Xls.ReadXlsFileSec;
import engine.Xls.SaveAsExlsFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    @FXML
    private Label fstResult;
    @FXML
    private Label secResult;
    @FXML
    final ProgressIndicator[] pi = new ProgressIndicator[ReadXlsFileFst.whatSerchArrayList.size()];


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
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel 97-2003", "*.xls"));
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

        new ReadXlsFileFst(fstPath);
        new ReadXlsFileSec(secPath);
        new EqualsIsNotEqualTo(ReadXlsFileFst.whatSerchArrayList, ReadXlsFileSec.whearSerchArrayList);
        new SaveAsExlsFile(savePath,EqualsIsNotEqualTo.equalsValueArrayList, EqualsIsNotEqualTo.notEqualsValueArrayList);
        fstResult.setText(String.valueOf(EqualsIsNotEqualTo.equalsValueArrayList.size()));
        secResult.setText(String.valueOf(EqualsIsNotEqualTo.notEqualsValueArrayList.size()));
    }
}
