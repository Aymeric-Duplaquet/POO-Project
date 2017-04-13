package modele;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Champ;
import model.InterfaceObjet;

public class Test extends Application {

	private GridPane grid = new GridPane();
	private InterfaceObjet currentObject;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		primaryStage.setTitle("Initialiser listes !");

		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		currentObject = InterfaceObjet.test();
		
		for (int i = 0; i < currentObject.getListChamp().size(); i++) {
			discrimination(currentObject.getListChamp().get(i),i);
		}

		Scene scene = new Scene(grid, 300, 275);
		primaryStage.setScene(scene);
		primaryStage.show();
	}



	public void discrimination(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{

		if ((champ.getType() == Boolean.class ) || (champ.getType() == boolean.class)){
			//A checkbox without a caption
			CheckBox cb1 = new CheckBox("True");
			CheckBox cb2 = new CheckBox("False");
			cb1.setDisable(true);

			Label nom = new Label(champ.getNom());
			grid.add(nom, 0, ligne);

			if ((boolean) currentObject.getValeurChamp(champ)==true){
				cb1.setSelected(true);
				cb2.setSelected(false);
			}else {
				cb1.setSelected(false);
				cb2.setSelected(true);
			}

			grid.add(cb1, 1, ligne);
			grid.add(cb2, 2, ligne);
		}
		else {
			Label nom = new Label(champ.getNom());
			grid.add(nom, 0, ligne);
			Label valeur = new Label((currentObject.getValeurChamp(champ)).toString());
			grid.add(valeur, 1, ligne);
		}
	}


}




/*
GridPane grid = new GridPane();
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25, 25, 25, 25));

Text scenetitle = new Text("Welcome");
scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
grid.add(scenetitle, 0, 0, 2, 1);

Label userName = new Label("User Name:");
grid.add(userName, 0, 1);

TextField userTextField = new TextField();
grid.add(userTextField, 1, 1);

Label pw = new Label("Password:");
grid.add(pw, 0, 2);

PasswordField pwBox = new PasswordField();
grid.add(pwBox, 1, 2);

Scene scene = new Scene(grid, 300, 275);
primaryStage.setScene(scene);*/