package modele;

import java.lang.reflect.InvocationTargetException;

import controleur.CharTextField;
import controleur.FloatTextField;
import controleur.IntegerTextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
	public void start(Stage primaryStage) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
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



	public void discrimination(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{

		
		
		
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
		
		else if ((champ.getType() == Integer.class ) || (champ.getType() == int.class))  {
			
			integerDiscri(champ, ligne);
		} 
		
		else if ((champ.getType() == Float.class ) || (champ.getType() == float.class))  {
			
			floatDiscri(champ, ligne);
			
		}
		
		else if ((champ.getType() == Double.class ) || (champ.getType() == double.class))  {
			
			Label nom = new Label(champ.getNom());
			grid.add(nom, 0, ligne);
			TextField valeur = new TextField(currentObject.getValeurChamp(champ).toString());
			grid.add(valeur, 1, ligne);
			
		}else if ((champ.getType() == Short.class ) || (champ.getType() == short.class))  {
			
			shortDiscri(champ, ligne);
			
		}else if ((champ.getType() == Long.class ) || (champ.getType() == long.class))  {
			
			Label nom = new Label(champ.getNom());
			grid.add(nom, 0, ligne);
			TextField valeur = new TextField(currentObject.getValeurChamp(champ).toString());
			grid.add(valeur, 1, ligne);
			
		}else if ((champ.getType() == Byte.class ) || (champ.getType() == byte.class))  {
			
			Label nom = new Label(champ.getNom());
			grid.add(nom, 0, ligne);
			TextField valeur = new TextField(currentObject.getValeurChamp(champ).toString());
			grid.add(valeur, 1, ligne);
			
		}else if ((champ.getType() == Character.class ) || (champ.getType() == char.class))  {
			
			charDiscri(champ, ligne);
			
		}
		
		else if (champ.getType() == String.class)  {
			
			stringDiscri(champ, ligne);
		}
		
	}
	
	public void integerDiscri (Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);
		
		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);
		
		IntegerTextField valeur = new IntegerTextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);
		
		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                lValue.setText(valeur.getText());
                try {
					currentObject.setValeurChamp(champ.getNom(), Integer.parseInt(valeur.getText()));
					System.out.println(currentObject.getValeurChamp(champ).toString());
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		grid.add(b, 3, ligne);
	}
	
	public void floatDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);
		
		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);
		
		FloatTextField valeur = new FloatTextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);
		
		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                lValue.setText(valeur.getText());
                try {
					currentObject.setValeurChamp(champ.getNom(), Float.parseFloat(valeur.getText()));
					System.out.println(currentObject.getValeurChamp(champ).toString());
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		grid.add(b, 3, ligne);
	}

	public void stringDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);
		
		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);
		
		TextField valeur = new TextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);
		
		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                lValue.setText(valeur.getText());
                try {
					currentObject.setValeurChamp(champ.getNom(), Float.parseFloat(valeur.getText()));
					System.out.println(currentObject.getValeurChamp(champ).toString());
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		grid.add(b, 3, ligne);
	}

	public void charDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);
		
		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);
		
		CharTextField valeur = new CharTextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);
		
		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                lValue.setText(valeur.getText());
                try {
					currentObject.setValeurChamp(champ.getNom(), valeur.getText().charAt(0));
					System.out.println(currentObject.getValeurChamp(champ).toString());
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		grid.add(b, 3, ligne);
	}

	public void shortDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);
		
		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);
		
		IntegerTextField valeur = new IntegerTextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);
		
		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {
			 
            @Override
            public void handle(ActionEvent event) {
                lValue.setText(valeur.getText());
                try {
					currentObject.setValeurChamp(champ.getNom(), Short.parseShort(valeur.getText()));
					System.out.println(currentObject.getValeurChamp(champ).toString());
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
		grid.add(b, 3, ligne);
	}
	
	public void longDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		
	}
	
	public void byteDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		
	}
	
	public void doubleDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		
	}
}
