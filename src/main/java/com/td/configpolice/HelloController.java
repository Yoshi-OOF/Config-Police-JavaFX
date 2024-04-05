package com.td.configpolice;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class HelloController {
    @FXML
    private ListView<String> FontListView;

    @FXML
    private ListView<String> FontStyleListView;

    @FXML
    private ListView<String> FontHeightListView;

    @FXML
    private Label ResultatLabel;

    @FXML
    private TextField FontTextField;

    @FXML
    private TextField FontStyleTextField;

    @FXML
    private TextField FontHeightTextField;

    @FXML
    private ColorPicker FontColorPicker;

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
            ResultatLabel.setStyle("-fx-text-fill: " + FontColorPicker.getValue().toString().replace("0x", "#") + ";");
        });


    }

    @FXML
    protected void onChange() {
        String font = FontTextField.getText();
        String style = FontStyleTextField.getText();
        String height = FontHeightTextField.getText();
        font = font == null ? "" : font;
        style = style == null ? "" : style;
        height = height == null ? "" : height;
        ResultatLabel.setStyle("-fx-font-family: " + font + "; -fx-font-size: " + height + "; -fx-font-style: " + style + ";");
    }
}