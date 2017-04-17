package vue;

import java.lang.reflect.InvocationTargetException;

import controleur.ByteTextField;
import controleur.CharTextField;
import controleur.DoubleTextField;
import controleur.FloatTextField;
import controleur.IntegerTextField;
import controleur.LongTextField;
import controleur.ShortTextField;
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
			System.out.println(currentObject.getListChamp().get(i).getNom());
			discrimination(currentObject.getListChamp().get(i),i);
		}

		Scene scene = new Scene(grid, 2000, 2000);
		primaryStage.setScene(scene);
		primaryStage.show();
	}



	public void discrimination(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{


		if ((champ.getType() == Boolean.class ) || (champ.getType() == boolean.class))
			booleanDiscri(champ, ligne);

		else if ((champ.getType() == Integer.class ) || (champ.getType() == int.class))
			integerDiscri(champ, ligne);

		else if ((champ.getType() == Float.class ) || (champ.getType() == float.class))
			floatDiscri(champ, ligne);

		else if ((champ.getType() == Double.class ) || (champ.getType() == double.class)) 
			doubleDiscri(champ, ligne);

		else if ((champ.getType() == Short.class ) || (champ.getType() == short.class))
			shortDiscri(champ, ligne);

		else if ((champ.getType() == Long.class ) || (champ.getType() == long.class))
			longDiscri(champ, ligne);

		else if ((champ.getType() == Byte.class ) || (champ.getType() == byte.class))
			byteDiscri(champ, ligne);

		else if ((champ.getType() == Character.class ) || (champ.getType() == char.class))
			charDiscri(champ, ligne);	

		else if (champ.getType() == String.class) 
			stringDiscri(champ, ligne);

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
		
		if(!champ.getModifiable()){
			b.setDisable(true);
			valeur.setDisable(true);
		}
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
		
		if(!champ.getModifiable()){
			b.setDisable(true);
			valeur.setDisable(true);
		}
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
		
		if(!champ.getModifiable()){
			b.setDisable(true);
			valeur.setDisable(true);
		}
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
		
		if(!champ.getModifiable()){
			b.setDisable(true);
			valeur.setDisable(true);
		}
	}

	public void shortDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);

		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);

		ShortTextField valeur = new ShortTextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);

		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) throws NumberFormatException {
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
		
		if(!champ.getModifiable()){
			b.setDisable(true);
			valeur.setDisable(true);
		}
	}

	public void longDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{

		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);

		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);

		LongTextField valeur = new LongTextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);

		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) throws NumberFormatException {
				lValue.setText(valeur.getText());
				try {
					currentObject.setValeurChamp(champ.getNom(), Long.parseLong(valeur.getText()));
					System.out.println(currentObject.getValeurChamp(champ).toString());
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		grid.add(b, 3, ligne);
		
		if(!champ.getModifiable()){
			b.setDisable(true);
			valeur.setDisable(true);
		}
	}

	public void byteDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);

		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);

		ByteTextField valeur = new ByteTextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);

		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) throws NumberFormatException {
				lValue.setText(valeur.getText());
				try {
					currentObject.setValeurChamp(champ.getNom(), Byte.parseByte(valeur.getText()));
					System.out.println(currentObject.getValeurChamp(champ).toString());
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		grid.add(b, 3, ligne);
		
		if(!champ.getModifiable()){
			b.setDisable(true);
			valeur.setDisable(true);
		}
	}

	public void doubleDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);

		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);

		DoubleTextField valeur = new DoubleTextField(currentObject.getValeurChamp(champ).toString());
		grid.add(valeur, 2, ligne);

		Button b = new Button("Modifier");
		b.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) throws NumberFormatException {
				lValue.setText(valeur.getText());
				try {
					currentObject.setValeurChamp(champ.getNom(), Double.parseDouble(valeur.getText()));
					System.out.println(currentObject.getValeurChamp(champ).toString());
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		grid.add(b, 3, ligne);
		
		if(!champ.getModifiable()){
			b.setDisable(true);
			valeur.setDisable(true);
		}
	}

	public void booleanDiscri(Champ champ, int ligne) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException{
		CheckBox cb1 = new CheckBox("True");
		grid.add(cb1, 2, ligne);
		CheckBox cb2 = new CheckBox("False");
		grid.add(cb2, 3, ligne);

		Label nom = new Label(champ.getNom());
		grid.add(nom, 0, ligne);

		Label lValue = new Label(currentObject.getValeurChamp(champ).toString());
		grid.add(lValue, 1, ligne);

		if ((boolean) currentObject.getValeurChamp(champ)==true){
			cb1.setSelected(true);
			cb2.setSelected(false);
		}else {
			cb1.setSelected(false);
			cb2.setSelected(true);
		}

		cb1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				lValue.setText("true");
				try {
					currentObject.setValeurChamp(champ.getNom(),true);
					System.out.println(currentObject.getValeurChamp(champ).toString());
					cb2.setSelected(false);
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		cb2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				lValue.setText("false");
				try {
					currentObject.setValeurChamp(champ.getNom(),false);
					System.out.println(currentObject.getValeurChamp(champ).toString());
					cb1.setSelected(false);
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException
						| IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		if(!champ.getModifiable()){
			cb1.setDisable(true);
			cb2.setDisable(true);
		}

	}
}