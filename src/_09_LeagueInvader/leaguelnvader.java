package _09_LeagueInvader;

import javax.swing.JFrame;

public class leaguelnvader {
	JFrame frame = new JFrame("atariDied");  
	public static final int WIDTH= 500;
	public static final int HEIGHT=800;
	GamePanel gamePanel;
		

	public leaguelnvader() {

        this.frame = new JFrame("League Invaders");
        this.gamePanel = new GamePanel();
	}
	public void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new leaguelnvader().setup();

	}

}
