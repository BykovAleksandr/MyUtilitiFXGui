package engine.guiControllers;

import engine.equalsUnequals.EqualsIsNotEqualTo;
import engine.xls.ReadXlsFileFst;
import engine.xls.ReadXlsFileSec;
import engine.xls.SaveAsExlsFile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainController {

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
    private ProgressIndicator fstIndicator;
    @FXML
    private ProgressIndicator secIndicator;
    @FXML
    private ProgressBar bar;
    @FXML
    private ProgressIndicator thirdIndicator;

    private String savePath;

    @FXML
    private void showDialogAbout(ActionEvent actionEvent) throws IOException {
        try {
            Stage stageAbout = new Stage();
            Parent rootAbout = FXMLLoader.load(getClass().getResource("../fxml/dialogAbout.fxml"));
            stageAbout.setTitle("About programm");

            stageAbout.setMinHeight(150);
            stageAbout.setMinWidth(300);
            stageAbout.setResizable(false);
            stageAbout.setScene(new Scene(rootAbout));
            stageAbout.initModality(Modality.APPLICATION_MODAL);
            stageAbout.showAndWait();

        } catch (IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    private void fstChooseBtn(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel 97-2003", "*.xls"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null){
            fstChooeseLabel.setText(file.getCanonicalPath());

            new ReadXlsFileFst(file.getCanonicalPath());

            DoWork task = new DoWork(ReadXlsFileFst.whatSerchArrayList.size());
            fstIndicator.progressProperty().bind(task.progressProperty());
            new Thread(task).start();
        }
    }
    @FXML
    private void secChooseBtn(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel 97-2003", "*.xls"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null){
            secChooeseLabel.setText(file.getCanonicalPath());

            new ReadXlsFileSec(file.getCanonicalPath());
            DoWork task =  new DoWork(ReadXlsFileSec.whearSerchArrayList.size());
            secIndicator.progressProperty().bind(task.progressProperty());
            new Thread(task).start();
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

        if (ReadXlsFileFst.whatSerchArrayList.size() == 0 && ReadXlsFileSec.whearSerchArrayList.size() == 0 && savePath == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Не выбраны файлы!");
            alert.setContentText("Выберите файл с искомыми значениями" +
                    "\n" + "Выберите файл с искомыми значениями" +
                    "\n" + "Выберите путь и сохраните файл");

            alert.showAndWait();
        }

        else if (ReadXlsFileFst.whatSerchArrayList.size() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Не выбран файл!");
            alert.setContentText("Выберите файл с искомыми значениями");

            alert.showAndWait();
        }
        else if (ReadXlsFileSec.whearSerchArrayList.size() == 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Не выбран файл!");
            alert.setContentText("Выберите файл в котором ищите");

            alert.showAndWait();
        }
        else if (savePath == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Файл не сохранен");
            alert.setContentText("Выберите путь и сохраните файл");

            alert.showAndWait();
        }
        else {
            new EqualsIsNotEqualTo(ReadXlsFileFst.whatSerchArrayList, ReadXlsFileSec.whearSerchArrayList);

            DoWork task3 = new DoWork(ReadXlsFileFst.whatSerchArrayList.size());
            thirdIndicator.progressProperty().bind(task3.progressProperty());
            bar.progressProperty().bind(task3.progressProperty());
            new Thread(task3).start();


            new SaveAsExlsFile(savePath,EqualsIsNotEqualTo.equalsValueArrayList, EqualsIsNotEqualTo.notEqualsValueArrayList);

            // Result Lable
            fstResult.setText(String.valueOf(EqualsIsNotEqualTo.equalsValueArrayList.size()));
            secResult.setText(String.valueOf(EqualsIsNotEqualTo.notEqualsValueArrayList.size()));
        }
    }


}
