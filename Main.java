package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = new VBox();
        CompoundNamer obj= new CompoundNamer();

        primaryStage.setTitle("Compound namer");
        TextField formula= new TextField("Type chemical compound here: (caps-sensitive) ");


        TextField toBeRead= new TextField("The name of the compound will be written here.");
        toBeRead.setEditable(false);
        AtomicReference<String> compound= new AtomicReference<>("");

        Button go=new Button("Name compound!");
        go.setDisable(false);
        TextField compoundInfo=new TextField("Information about the compound.");
        compoundInfo.setEditable(false);

        go.setOnAction(e-> {
            compound.set(formula.getText());
            toBeRead.clear();
            toBeRead.insertText(0,obj.giveName(compound.get()));
            compoundInfo.clear();
            compoundInfo.insertText(0,obj.giveInfo(compound.get()));
                });
        root.getChildren().addAll(formula,toBeRead,go,compoundInfo);
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
