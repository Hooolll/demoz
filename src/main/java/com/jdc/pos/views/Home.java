package com.jdc.pos.views;

import com.jdc.pos.model.BaseRepository;
import com.jdc.pos.model.entity.Category;
import com.jdc.pos.model.entity.Product;
import com.jdc.pos.model.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


@Controller
public class Home extends AbstractController{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton btn_buy;

    @FXML
    private JFXButton btn_buy1;

    @FXML
    private JFXButton btn_buy2;

    @FXML
    private Label title;

    @FXML
    private Label title1;
    private final BaseRepository productRepo;

    public Home(@Qualifier("productRepo") BaseRepository productRepo) {
        this.productRepo = productRepo;
    }

    @FXML
    void initialize() {
        btn_buy.setOnMouseClicked(mouseEvent -> {
            btn_buy.setText("Добавлено!");
            Product product = new Product( "Двигатель V8", 255);
            productRepo.save(product);
            System.out.println("Двигатель добавлен!");
        });
        btn_buy1.setOnMouseClicked(mouseEvent -> {
            btn_buy1.setText("Добавлено!");
            Product product = new Product("Шины гоночные V7", 155);
            productRepo.save(product);
            System.out.println("Покрышки добавлены!");
        });
        btn_buy2.setOnMouseClicked(mouseEvent -> {
            btn_buy2.setText("Добавлено");
            Product product = new Product("Трансмиссия V8", 166);
            productRepo.save(product);
            System.out.println("Трансмиссия добавлена!");
        });
    }
}
