package _09_LeagueInvader;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel{
//	JPanel panel= new JPanel();
    final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    
    int currentState = MENU;

    updateMenuState() {  }
    updateGameState() {  }
    updateEndState()  {  }
	@Override
	public void paintComponent(Graphics g){
		g.fillRect(10, 10, 100, 100);
	}
}
