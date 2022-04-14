package Labs.Lab10;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Socket socket = new Socket("127.0.0.1", 1234); //Connects client to server
        PrintWriter out = new PrintWriter(socket.getOutputStream()); //Output to server

        stage.setTitle("Bulletin Board Client");
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 30, 30, 30));

        Scene scene = new Scene(grid, 400, 200);
        stage.setScene(scene);

        Label userLabel = new Label("Username:");
        grid.add(userLabel, 0, 0);

        TextField userTF = new TextField();
        grid.add(userTF, 0, 1);

        Label msgLabel = new Label("Message:");
        grid.add(msgLabel, 0, 2);

        TextField msgTF = new TextField();
        grid.add(msgTF, 0, 3);

        Button sendButton = new Button("Send");
        grid.add(sendButton, 0, 4);

        //Button to send data to server
        sendButton.setOnAction(event -> {
            //Gets user input
            String message = userTF.getText() + ": " + msgTF.getText();

            //Outputs to server
            out.println(message);
            out.flush();

        });

        Button exitButton = new Button("Exit");
        grid.add(exitButton, 0, 5);
        exitButton.setOnAction(event -> {
            System.exit(0);
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
