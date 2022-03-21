package isii.program;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{
	
	private static final long serialVersionUID = 6507759407116736524L;
	private Image imagen;
    
	// Clase para hacer que el boton sea el fondo que yo quiero. 
	// Con esto consigo darle mi estilo personal.
    public ButtonPanel(ImageIcon icon) {
    	imagen = icon.getImage();
    }
    
    @Override
    public void paint(Graphics g) {
    	g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    	setOpaque(false);
    	super.paint(g);
    }
    
    public void setImage(ImageIcon image) {
    	imagen = image.getImage();
    }

}
