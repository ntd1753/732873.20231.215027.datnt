package lab1;

import javax.swing.JOptionPane;

public class bai2_3 {
    public static void main(String[] args){
        String result;
        result = JOptionPane.showInputDialog("Please enter your name: ");
        JOptionPane.showMessageDialog(null, "Hi " + result + "!");
    }
}
