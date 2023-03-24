package com.example.webview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;

import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {
    public ImageView imageView;
    public VBox Menubar;
    public Button add;
    public TitledPane Colors;
    @FXML
    HBox canvas,canvas1, canvas3;
    @FXML TextField textField, heading;

    public Label headingText = new Label("");

    @FXML
    ColorPicker colorPicker;

    @FXML
    ComboBox<String> fonts = new ComboBox<>();

    public Label ref;

    @FXML
    public void AddHeading(){
        headingText.setText(heading.getText());
        headingText.setId("headingText");
        heading.setPromptText("Enter Text");
        heading.clear();
    }
    public void AddImage(ActionEvent event){
        FileChooser chooser = new FileChooser();
        var file = chooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());
        Image img = new Image(file.getAbsolutePath());
        imageView.setImage(img);

    }
    public void AddText(){
        Label label5 = new Label("");
        label5.setId("label");
        label5.setText(textField.getText());
        label5.setOnMouseClicked(mouseEvent -> ref = label5);
        label5.setTooltip(new Tooltip("Click To Select"));
        textField.setPromptText("Enter Text");
        textField.clear();
        canvas3.getChildren().add(label5);
    }

    public void SetColor(){
        if(ref == null)
            return;
        Label label2 = new Label("Smart Brother");
        Color myColor = colorPicker.getValue();
        label2.setBackground(new Background(new BackgroundFill(myColor,null, null)));
        StringBuilder stringBuilder = new StringBuilder(myColor.toString());
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(0);
        ref.setStyle( ref.getStyle() + "-fx-text-fill: #" + stringBuilder + ";");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        canvas.getChildren().add(headingText);

        List<String> lists = new ArrayList<>(Font.getFamilies());
        for (String list : lists) {
            fonts.getItems().add(list);
        }
    }

    public void setFont(){
        if (ref == null)
            return;
        System.out.println(fonts.getValue());
        ref.setStyle( ref.getStyle() + "-fx-font-family: " + fonts.getValue() + ";");
    }
}