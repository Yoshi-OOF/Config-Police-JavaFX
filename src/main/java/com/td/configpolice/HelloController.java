package com.td.configpolice;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class HelloController {
    @FXML private ListView<String> FontListView;
    @FXML private ListView<String> FontStyleListView;
    @FXML private ListView<String> FontHeightListView;
    @FXML private Label ResultatLabel;
    @FXML private TextField FontTextField;
    @FXML private TextField FontStyleTextField;
    @FXML private TextField FontHeightTextField;
    @FXML private ColorPicker FontColorPicker;

    @FXML
    protected void onCancelButtonClicked() {
        Platform.exit();
    }

    @FXML
    public void initialize() {
        FontListView.getItems().addAll("Arial", "Times New Roman", "Courier New", "Comic Sans MS");
        FontStyleListView.getItems().addAll("Normal", "Bold", "Italic", "Bold Italic");
        FontHeightListView.getItems().addAll("8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72");

        FontListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FontTextField.setText(FontListView.getSelectionModel().getSelectedItem());
                onChange();
            }
        });

        FontStyleListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FontStyleTextField.setText(FontStyleListView.getSelectionModel().getSelectedItem());
                onChange();
            }
        });

        FontHeightListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                FontHeightTextField.setText(FontHeightListView.getSelectionModel().getSelectedItem());
                onChange();
            }
        });

        FontColorPicker.setOnAction(event -> {
            ResultatLabel.setTextFill(FontColorPicker.getValue());
        });
    }

    @FXML
    protected void onChange() {
        String fontFamily = FontTextField.getText();
        String fontStyle = FontStyleTextField.getText();
        String fontHeight = FontHeightTextField.getText();

        fontFamily = fontFamily == null ? "Arial" : fontFamily;
        double fontSize = fontHeight == null || fontHeight.isEmpty() ? 12 : Double.parseDouble(fontHeight);

        FontWeight fontWeight = FontWeight.NORMAL;
        FontPosture fontPosture = FontPosture.REGULAR;

        if (fontStyle != null) {
            if (fontStyle.equals("Bold")) {
                fontWeight = FontWeight.BOLD;
            } else if (fontStyle.equals("Italic")) {
                fontPosture = FontPosture.ITALIC;
            } else if (fontStyle.equals("Bold Italic")) {
                fontWeight = FontWeight.BOLD;
                fontPosture = FontPosture.ITALIC;
            }
        }

        Font font = Font.font(fontFamily, fontWeight, fontPosture, fontSize);
        ResultatLabel.setFont(font);
    }
}
