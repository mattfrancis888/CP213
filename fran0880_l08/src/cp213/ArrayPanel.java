 package cp213;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//---------------------------------------------------------------------
/**
 * @author David Brown
 * @version 2017-06-19
 * 
 *          Demonstrates catching bad number format array index exceptions.
 */
@SuppressWarnings("serial")
public class ArrayPanel extends JPanel {
    /**
     * The array to be searched.
     */
    private final int[] array = new int[4];

    /**
     * Field for user entry of the index to search for.
     */
    private final JTextField indexField = new JTextField(1);

    /**
     * Performs the search when pressed.
     */
    private final JButton showButton = new JButton("Show");

    /**
     * The label containing the result of the search.
     */
    private final JLabel valueLabel = new JLabel();

    // ---------------------------------------------------------------------
    /**
     * Constructor. Initializes the array, lays out the view and registers the
     * listeners.
     */
    public ArrayPanel() {

	   for (int i = 0; i < 4; i++) {
	      this.array[i] = i;
	   }
	   this.layoutView();
	   this.registerListeners();
    }
    // ---------------------------------------------------------------------
    /**
     * An inner class that uses an ActionListener to access
     * <code>showButton</code>. It displays the result of the array search when
     * pressed and catches any input and search errors.
     */
    private class ShowListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent evt) {
	    try {
		                                        // Find the value at the given index.
		    ArrayPanel.this.findValueAtIndex();
		
	    } catch (NumberFormatException e) {
		                                        // Catch the bad input exception.
		    JOptionPane.showMessageDialog(null,
			    "Bad Number: Use Integers Only", "Error", JOptionPane.ERROR_MESSAGE);
		
	    } catch (ArrayIndexOutOfBoundsException e) {
		                                        // Catch the array boundary exception.
		    JOptionPane.showMessageDialog(null,
				"Not a valid array index", "Error", JOptionPane.ERROR_MESSAGE);
		
	    } catch (Exception e) {
		                                        // Catch any other possible exception.
		    JOptionPane.showMessageDialog(null,
				e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		
	    } finally {
		                                        // Return focus to the index input field.
		    ArrayPanel.this.indexField.requestFocusInWindow();
		    ArrayPanel.this.indexField.selectAll();
	    }
	}}

    /**
     * Attempts to find the value in the array associated with the user-entered
     * index.
     */
    private void findValueAtIndex() {
	   String text  = this.indexField.getText();
	   int    index = Integer.parseInt(text);
	   int    value = ArrayPanel.this.array[index];
	                                          // Set the value label to the search result.
	   this.valueLabel.setText("" + value);
    }

    // ---------------------------------------------------------------------
    /**
     * Lays out the panel view. Uses default (Flow) layout.
     */
    private void layoutView() {
	   this.add               (new JLabel("Array Index: "));
	   this.indexField.setText("" + 0);
	   this.add               (this.indexField);
	   this.add               (new JLabel("Array Value: "));
	   this.valueLabel.setText("" + this.array[0]);
	   this.add               (this.valueLabel);
	   this.add               (this.showButton);
    }

    /**
     * Assigns ActionListeners to <code>showButton</code>.
     */
    private void registerListeners() {
	   this.showButton.addActionListener(new ShowListener());
    }
    // ---------------------------------------------------------------------
    /**
     * Main method for testing the class.
     * 
     * @param args
     *            Unused.
     */
    public static void main(String[] args) {
	   ArrayPanel view = new ArrayPanel();
	   JFrame     f    = new JFrame("Show Array");
	   f.setContentPane(view);
	   f.setSize(300, 150);
	   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   f.setVisible(true);
    }  
    // ---------------------------------------------------------------------
}
