package com.jdc.pos.views;

import com.jdc.pos.model.entity.Account;
import com.jdc.pos.model.repo.AccountRepo;
import javafx.scene.control.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jfoenix.controls.JFXButton;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;


@Controller
public class Sales extends AbstractController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton addUser;

    @FXML
    private JFXButton cancelUser;

    @FXML
    private TextField nameAdd;

    @FXML
    private PasswordField passAdd;

    @FXML
    private Label title;
    @Autowired
    private AccountRepo accountRepo;

    @FXML
    void initialize() {
        addUser.setOnMouseClicked(mouseEvent -> {
            if (nameAdd.getText().isEmpty() || passAdd.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Не заполнены все поля");
                alert.showAndWait();
            } else {
                Account account = new Account();
                account.setLoginId(nameAdd.getText());
                account.setName(nameAdd.getText());
                account.setPassword(passAdd.getText());
                account.setRole(Account.Role.Employee);
                accountRepo.save(account);
                Alert done = new Alert(Alert.AlertType.INFORMATION);
                done.setHeaderText(null);
                done.setContentText("Пользователь успешно добавлен!");
                done.showAndWait();
            }
        });
    }
}
