package com.jdc.pos.views;

import com.jdc.pos.PosApplication;
import com.jdc.pos.utils.Menu;
import com.jdc.pos.views.common.Dialog;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Objects;

public class GuestFrame {

    @FXML
    private VBox sideBar;
    @FXML
    private StackPane contentView;

    @FXML
    private void initialize() {
        loadView(Menu.HomeGuest);
    }

    @FXML
    private void clickMenu(MouseEvent event1) {

        Node node = (Node) event1.getSource();

        if(node.getId().equals("Exit")) {
            // need to confirm
            Dialog.DialogBuilder.builder()
                    .title("Выход")
                    .message("Действительно хотите выйти?")
                    .okActionListener(() -> sideBar.getScene().getWindow().hide())
                    .build().show();
        } else {
            Menu menu = Menu.valueOf(node.getId());
            loadView(menu);
        }
    }

    private void loadView(Menu menu) {
        try {

            for(Node node : sideBar.getChildren()) {

                node.getStyleClass().remove("active");

                if(node.getId().equals(menu.name())) {
                    node.getStyleClass().add("active");
                }
            }

            contentView.getChildren().clear();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(menu.getFxml()));
            loader.setControllerFactory(PosApplication.getApplicationContext()::getBean);
            Parent view = loader.load();

            AbstractController controller = loader.getController();
            controller.setTitle(menu);

            contentView.getChildren().add(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show() {

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(GuestFrame.class.getResource("GuestFrame.fxml")));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
