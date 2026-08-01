package _06_overloading;

import javax.swing.JOptionPane;

public class LeagueOptionPaneRunner {
	public static void main(String[] args) {
		LeagueOptionPane.showMessageDialog("hello");
		String me=JOptionPane.showInputDialog("Input a message");
		String ti=JOptionPane.showInputDialog("Enter a title");
		String fn=JOptionPane.showInputDialog("Choose a png from java, league and leagueDark");
		LeagueOptionPane.showMessageDialog(me, ti);
		LeagueOptionPane.showMessageDialog(me, ti, fn+".png");

	}
}
