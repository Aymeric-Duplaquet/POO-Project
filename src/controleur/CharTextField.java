package controleur;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;

public class CharTextField extends TextField {
	
	public CharTextField (String stringValue){
		super();
		setText(stringValue);
		
		this.textProperty().addListener(new ChangeListener<String>() {

		public void changed(ObservableValue<? extends String> arg0,String arg1, String newValue) {

			if(newValue.length() >= 2){
				setText(newValue.substring(0, 1));
			}
		}
	});
	}
}

