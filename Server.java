package Labs.Lab10;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Application {
    static TextArea textArea;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Scene setup
        primaryStage.setTitle("Bulletin Board Server");
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(30, 30, 30, 30));

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);

        textArea = new TextArea();
        textArea.setPrefSize(400, 400);
        grid.add(textArea, 0, 0, 1, 2);

        Button exitButton = new Button("Exit");
        grid.add(exitButton, 0, 2);
        exitButton.setOnAction(event -> {
            System.exit(0);
        });
        primaryStage.show();

        //Starts server and assigns it to thread
        ServerThread server = new ServerThread(1234);
        Thread serverThread = new Thread(server);
        serverThread.start();
    }

    public static void displayMessage(String entry){
        textArea.appendText(entry);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
