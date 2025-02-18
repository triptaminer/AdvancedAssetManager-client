package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AdvancedAssetManager extends Application {

    private ConfigurableApplicationContext springContext;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        springContext = SpringApplication.run(AdvancedAssetManager.class);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Load Assets");
        btn.setOnAction(e -> System.out.println("Loading assets..."));

        VBox root = new VBox(10, btn);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Asset Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        springContext.close();
    }
}