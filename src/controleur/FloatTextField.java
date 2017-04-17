package controleur;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FloatTextField extends TextField {
	private String numericLastKey;

	public FloatTextField(String stringValue) {
		super();
		setText(stringValue);

		this.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				char ar[] = event.getCharacter().toCharArray();
				char ch = ar[event.getCharacter().toCharArray().length - 1];
				/*populating lastkey if it is numeric*/
				if ((ch >= '0' && ch <= '9') || ch=='.') {
					numericLastKey = String.valueOf(ch);
				}

				if (isValid()) {
					/* Disable other charater than numeric character. */
					System.out.println("Consummer " + ch);
					if (!(ch >= '0' && ch <= '9') && ch!='.') {
							event.consume();
					}


				} else {
					event.consume();
				}
			}
		});

		/*Disabling 'invalid sting' past functionality if not numeric */
		this.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0,String oldValue, String newValue) {
				if(!isNumeric(newValue)){
					clear();
				} else if(!isValid()){
					clear();
				}
			}

			/**check for numeric value.
			 * @param text
			 * @return boolean
			 */
			private boolean isNumeric(String text) {
				System.out.println(text.matches("-?\\d+(.\\d+)?"));
				return text.matches("^([+-]?\\d*\\.?\\d*)$");
			}
		});
	}


	/**Check for valid text or not.
	 * @return boolean if not valid then return false else true.
	 */
	private boolean isValid() {
		if (getText().length() == 0)
			return true;
		try {
			String testText = getText();
			testText = (numericLastKey != null && numericLastKey != "") ? testText + numericLastKey : testText;
			numericLastKey = "";
			Float.parseFloat(testText);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}
