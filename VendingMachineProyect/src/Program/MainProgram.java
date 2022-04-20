package Program;

import java.util.Scanner;

/*
 * -Cambiar las clases para adaptar a herencia
 * -A�adir a cada producto especifico una descipcion
 * -Modificar main
 * 
 * */

public class MainProgram {
	private static VendingMachine[] enabledMachines;
	
	private static void powerOn() {
		

		//Se crean y se conectan las máquinas, y también se hace la verificación para el manager de la máquina
		final Scanner scanner = new Scanner(System.in);
		
		VendingMachine OperativeMachines[] = new VendingMachine[3];
		
		OperativeMachines = VendingMachineManager.EnableMachines(OperativeMachines);
		VendingMachineManager.ShowEnabledMachines(OperativeMachines);
		
		
		boolean iDontHaveToExit;
		
		do {
			
			iDontHaveToExit = VendingMachineManager.ChooseOptions(OperativeMachines);
			
		} while (iDontHaveToExit);

		
		
		scanner.close();
	}
	
	public static VendingMachine[] getEnabledMachines() {
		VendingMachine OperativeMachines[] = new VendingMachine[3];
		
		OperativeMachines = VendingMachineManager.EnableMachines(OperativeMachines);
		return OperativeMachines;
	}
	

	public static void main(String[] args) {
		
		MainProgram.powerOn();
		
	}

}
