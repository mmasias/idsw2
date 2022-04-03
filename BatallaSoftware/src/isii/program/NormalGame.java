package isii.program;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

import isii.other.ButtonPanel;

public class NormalGame extends GameController {

	private static final long serialVersionUID = -4169160719838456617L;
	private boolean action;

	public NormalGame(int x, int y, int width, int height, ResultJPanel resultPanel) {
		super(x, y, width, height, resultPanel, false);
		action = false;
		heroineDrinkPotion(panelPotion);
		heroineDefend(panelDefend);
		heroineAttack(1, panelWeapon1);
		heroineAttack(2, panelWeapon2);
		heroineAttack(3, panelWeapon3);
		
		//new AttackListenner().start();
		new StartGame().start();
	}
	
	private class StartGame extends Thread {
		
		@Override
		public void run() {
			startGame();
		}
		
		private synchronized void startGame() {
			do {
				refress(); //Necesito dormir el hilo para que me haga las comprobaciones sino empieza a ejecutarse sin comprobar.
				heroineController();
				refress();
				vampiressController();
			} while(!characterDead());
			
			// Detectar quien es el que ha muerto para mostrar si el jugador ha ganado o perdido.
			if (heroine.isDead()) winOrDead("GAME OVER");
			else winOrDead("YOU WIN");
		}

		private void winOrDead(String string) {
			setVisible(false);
			resultPanel.setText(string);
			resultPanel.setVisible(true);
		}

		/**
		 * Controlador de la heroina
		 */
		private synchronized void heroineController() {
			if (turn.getTurn() == 0 && action) {
				if (isCharacterRecovered() && isAnyAttack()) vampiressChangeTurnController();
			}
		}
		
		/**
		 * Controlador para cambiar de turno.
		 * 	- Si la vampiresa esta desmayada, recupera vida.
		 * 	- Si no esta desmayada ataca.
		 */
		private synchronized void vampiressChangeTurnController() {
			turn.changeTurn();
			if (vampiress_1.isFainting()) {
				vampiress_1.recoverEnergyFainting();
			} else {
				newAttack();
				vampiress_1.yourTurn(numAttack, heroine);
			}
		}

		/**
		 * Controlador de la vampiresa.
		 */
		private synchronized void vampiressController() {
			if(turn.getTurn() == 1) {
				if (isCharacterRecovered() && isAnyAttack()) {
					if (heroine.isDrinkPotion()) heroineDrinkPotionController();
					else heroineChangeTurnController();
				}
			}
		}
		
		/**
		 * Cuando la heroina esta tomando la pocion puede pasar lo siguiente:
		 * 	- Puede estar desmayada; recupera 2 de vida.
		 * 	- Cambio de turno. En este turno si la heroina ha llegado al turno 3 desde que se tomo la pocion recupero toda la vida y cambio "drinkPotion" a false.
		 * 	- Como he cambiado de turno esta la posibilidad de que este bebiendo todavia la pocion o ya haya recuperado la vida por la pocion:
		 * 		- Esta bebiendo la pocion "action" sigue en true para que la heroina de paso a cambiar al turno de la vampiresa y sigo ocultando los botones.
		 * 		- No esta bebiendo, significa que se ha curado al cambiar de turno. Muestro los botones y cambio "action" a false para que el controlador de la 
		 * 		heroina no cambie directamente al turno de la vampiresa sin atacar antes.
		 */
		private synchronized void heroineDrinkPotionController() {
			if (heroine.isFainting()) {
				heroine.recoverEnergyFainting(); // Recuperar vida desmayo cuando esta tomando la pocion
			}
			turn.changeTurn(); // Cambio de turno y puede que sea el turno 3 para curarse con la pocion.
			if (heroine.isDrinkPotion()) showPanels(false); //HIDE si sigue tomandose la pocion
			else showPanels(true); // SHOW si se ha tomado la pocion
		}
		
		/**
		 * Controlador de cambio de turno para la heroina.
		 * 	- Si estaba defendiendose, lo desabilito para que no pinte la animacion de defenderse.
		 * 	- Si esta desmayada, se cura y oculto los paneles.
		 * 	- Si no esta desmayada, muestro los paneles.
		 */
		private synchronized void heroineChangeTurnController() {
			turn.changeTurn();
			heroine.setDefend(false); // En el caso de estar defendiendose quitarle la animacion de defensa.
			if (heroine.isFainting()) {
				heroine.recoverEnergyFainting();
				showPanels(false); // HIDE si esta desmayada
			} else {
				showPanels(true); // SHOW si no esta desmayada
			}
		}

		/*
		 * Si no hay ningun personaje recuperando vida devuelve true, sino false
		 */
		private synchronized boolean isCharacterRecovered() {
			if (heroine.isEnergyRecovered() && vampiress_1.isEnergyRecovered()) return true; 
			else return false;
		}

		/**
		 * Si no hay ningun personaje atacando devuelve true, sino false
		 * @return boolean
		 */
		private synchronized boolean isAnyAttack() {
			if (heroine.isAttackFinish() && vampiress_1.isAttackFinish()) return true;
			else return false;
		}

		//Metodo necesario para que el bucle no se colapse
		private void refress() {
			try {Thread.sleep(1);} catch (InterruptedException e) {	e.printStackTrace();}
		}
		
	}
	
	/**
	 * Muestro o oculto los paneles del jugador.
	 * 
	 * Mostrar y ocultar va a la par con la action, asi que "action" me sirve para que:
	 * 	- Si muestro paneles hago "action" a false para que no me entre en el controlador de la heroina.
	 * 	- Si oculto los paneles hago "action" a true para que me entre en el controlador y cambie al turno de la vampiresa.
	 * @param show
	 */
	public void showPanels(boolean show) {
		if (show) {
			action = false;
			showAttackPanels(false);
		} else {
			action = true;
			hideAllPanel();
		}
	}

	/**
	 * Metodo que la heroina ataca.
	 * 	- Pongo action a true, para que entre en el if de la heroina en el controlador de su turno para que cambie al 
	 * 	turno de la vampiresa cuando termine de atacar y de hacer daño a la vampiresa.
	 * 	- "heroine.yourTurn(...) para que la heroina ataque a la vampiresa.
	 * 	- Oculto los paneles.
	 * @param nAttack
	 */
	private synchronized void heroineAttack(int nAttack) {
		action = true;
		numAttack = nAttack;
		heroine.yourTurn(numAttack, vampiress_1);
		hideAllPanel();
	}

	/**
	 * ¿Algun personaje muerto?
	 * @return
	 */
	private synchronized boolean characterDead() {
		if (heroine.isDead() || vampiress_1.isDead()) return true;
		else return false;
	}

	/**
	 * Boton de la heroina cuando ataca
	 * @param nAttack
	 * @param panelWeapon
	 */
	private synchronized void heroineAttack(int nAttack, ButtonPanel panelWeapon) {
		panelWeapon.addMouseListener(new MouseAdapter() {
			@Override
			public synchronized void mouseClicked(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) {
					heroineAttack(nAttack);
				}
			}
		});
	}

	/**
	 * Boton de la heroina cuando escoge defenderse.
	 * @param panelDefend
	 */
	private synchronized void heroineDefend(JPanel panelDefend) {
		panelDefend.addMouseListener(new MouseAdapter() {  
			@Override
			public synchronized void mouseClicked(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) {
					heroine.setDefend(true);
					action = true;
					hideAllPanel();
				}
			}
		});
	}
	
	/**
	 * Boto de la heroina cuando escoge beber la pocion.
	 * @param panelPotion
	 */
	private synchronized void heroineDrinkPotion(JPanel panelPotion) {
		panelPotion.addMouseListener(new MouseAdapter() { 
			@Override
			public synchronized void mouseClicked(MouseEvent e) {
				if (turn.getTurn() == 0  && !openSettings) {
					heroine.setDrinkPotion(true);
					action = true;
					heroine.printAnimationPotion();
					hideAllPanel();
				}
			}
		});
	}
	
	/*
	 * Asignar nuevo valor aleatorio al ataque
	 */
	private synchronized void newAttack() {
		this.numAttack = new Random().nextInt(3) + 1;
	}
}
