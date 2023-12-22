

package GUI.Swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; // init sum = 0

    // constructor to setup the GUI components and event handlers
    public SwingAccumulator() {
    	Container cp = getContentPane();
        setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new JLabel("The accumulated Sum is: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
    	new SwingAccumulator();    
    }

    private class TFInputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	  int numberIn = Integer.parseInt(tfInput.getText());
              sum += numberIn;
              tfInput.setText("");
              tfOutput.setText((sum + ""));
        }
    }
}
