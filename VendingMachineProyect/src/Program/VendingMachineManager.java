package Program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Program.Exceptions.ValueIncorrectException;
import Program.MoneyTypes.Coin;
import Program.MoneyTypes.Note;
import Program.Products.Chocolate;
import Program.Products.Cookie;
import Program.Products.Drink;
import Program.Products.Snack;

public class VendingMachineManager {

	private static List<Administrator> administrators = new ArrayList<Administrator>(); 	//Es una asociación entre VendingMachine

	// This method creates three vending machines , adding all the products and the
	// money

	//-------------METODOS PARA CREAR Y OBTENER MAQUINAS , Y CREAR LISTA DE ADMINS-------------
	
	public static VendingMachine[] EnableMachines(VendingMachine[] operativeMachines) {

		try {
			for (int arrayIndex = 0; arrayIndex <= 2; arrayIndex++) {

				Product[] currentMachineProducts = { 
						new Cookie(1.50f, 10 , 1), 
						new Chocolate(1.10f, 10 , 2), 
						new Drink(1.05f, 10 , 3),
						new Snack(1.75f, 10 , 4) 
				};
				Money[] currentMachineMoney = {
						new Note(20, 3), 
						new Note(10, 1), 
						new Note(5, 2), 
						new Coin(2, 5),
						new Coin(1, 10), 
						new Coin(0.5f, 20), 
						new Coin(0.2f, 20), 
						new Coin(0.05f, 10) 
				};
				if(arrayIndex == 1) {
					
					currentMachineMoney[0].setCuantity(3);
					currentMachineMoney[1].setCuantity(2);
					currentMachineMoney[2].setCuantity(3);
					currentMachineMoney[3].setCuantity(7);
					currentMachineMoney[4].setCuantity(15);
					currentMachineMoney[5].setCuantity(25);
					currentMachineMoney[6].setCuantity(30);
					currentMachineMoney[7].setCuantity(20);
				}else if(arrayIndex == 2) {
					
					currentMachineMoney[0].setCuantity(3);
					currentMachineMoney[1].setCuantity(1);
					currentMachineMoney[2].setCuantity(3);
					currentMachineMoney[3].setCuantity(5);
					currentMachineMoney[4].setCuantity(12);
					currentMachineMoney[5].setCuantity(30);
					currentMachineMoney[6].setCuantity(10);
					currentMachineMoney[7].setCuantity(15);
				} 
				
				operativeMachines[arrayIndex] = new VendingMachine(arrayIndex + 1, currentMachineProducts, currentMachineMoney, administrators);

			}
		}catch(ValueIncorrectException e) {
			System.out.println(e.getMessage());
		}
		return operativeMachines;
	}
	
	public static VendingMachine[] getEnabledMachines() {
		VendingMachine OperativeMachines[] = new VendingMachine[3];
		
		OperativeMachines = EnableMachines(OperativeMachines);
		
		VendingMachineManager.setAdministrators(new ArrayList<Administrator>(Arrays.asList(
						new Administrator("Jesús", "Saro", "jesus.saro", "12345", false),
						new Administrator("Ruben", "Gutierrez", "ruben.gutierrez", "12345", false),
						new Administrator("Luis", "Collado", "luis.collado", "12345", false),
						new Administrator("Diego Carlitos", "Lopez", "diego.lopez", "12345", false)
						)));
		return OperativeMachines;
	}
	
	//Sets the list of Administrators for all the machines
		public static void setAdministrators(List<Administrator> list) {
			VendingMachineManager.administrators = list;
		}

	//-------------METODOS DE MAQUINAS ROTAS-------------

	public static int getNumberMachinesBroken() {
		VendingMachine[] operativeMachines = getEnabledMachines();
		int counter = 0;
		for(VendingMachine m : operativeMachines) {
			if(m.isBroken()) {
				counter++;
			}
		}
		return counter;
	}
	
	public static boolean isThereAMachineBroken() {
		VendingMachine[] operativeMachines = Program.GraphicInterface.GraphicalInterface.OperativeMachines;
		int counter = 0;
		for(VendingMachine m : operativeMachines) {
			if(m.isBroken()) {
				counter++;
			}
		}
		if(counter > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	//-------------METODOS DE MAQUINA LOGS-------------
	
	public static String LogIn(String username, char[] password) {
		
		
		final boolean correctLogIn = checkLogIn(username, password);
		if(correctLogIn) {
			return "Bienvenido " + getAdministratorLogedIn().getName() + getAdministratorLogedIn().getSurname() + "!";
		}else{
			return "Lo sentimos, pero el usuario o contraseña que has introducido es incorrecto";
		}
	}
	
	private static boolean checkLogIn(String username, char[] password) {
		
		boolean result = false;
		for(Administrator a : administrators) {
			if(username.equals(a.getUsername()) && Arrays.equals(password, a.getPassword())) {
				result = true;
				a.setLogedIn(true);
			}
		}
		return result;
	}
	
	
	public static boolean checkIfSomeoneLogedIn() {
		boolean logedIn = false;
		for(Administrator a : administrators) {
			if(a.isLogedIn()) {
				logedIn = true;
			}
		}
		return logedIn;
	}
	
	public static Administrator getAdministratorLogedIn() {
		Administrator result = null;
		for(Administrator a : administrators) {
			if(a.isLogedIn()) {
				result = a;
			}
		}
		return result;
	}
	
	public static void logOutAdminLogedIn() {
		for(Administrator a : administrators) {
			if(a.isLogedIn()) {
				a.setLogedIn(false);
			}
		}
	}

}
