package isii.program;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import isii.other.ButtonPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

public class ResultJPanel extends JPanel {

	private static final long serialVersionUID = 8775328256550843645L;
	private JLabel gameOverLabel, continueLabel;
	
	public ResultJPanel(int x, int y, int width, int height, ButtonPanel menuPanel, String text) {
		this.setBounds(x, y, width, height);
		this.setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
		
		gameOverLabel = new JLabel(text);
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setFont(new Font("Impact", Font.ITALIC, 100));
		//gameOverLabel.setLocation((width / 2) - (gameOverLabel.getWidth() / 2), (height / 2) - (gameOverLabel.getHeight() / 2));
		this.add(gameOverLabel, BorderLayout.CENTER);
		
		continueLabel = new JLabel("Click to continue...");
		continueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		continueLabel.setFont(new Font("Buxton Sketch", Font.ITALIC, 50));
		//winLabel.setLocation((width / 2) - (winLabel.getWidth() / 2), (height / 2) - (winLabel.getHeight() / 2) + 500);
		this.add(continueLabel, BorderLayout.SOUTH);
		
		this.addMouseListener(new MouseAdapter() { //TODO Porfavor Marco del futuro quitame los actionListener del Constructor y metelos en un método, queda muy feo el codigo :) 
			@Override
			public void mouseClicked(MouseEvent e) {
				menuPanel.setVisible(true);
				setVisible(false);
			}
		});
	}

	public void setText(String text) {
		this.gameOverLabel.setText(text);
	}

}
