package Program;

import Program.Products.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Program.Exceptions.ValueIncorrectException;
import Program.MoneyTypes.*;

public class VendingMachineManager {

	private static final int DIFERENCE_BETWEEN_ARRAY = 1;
	private static final Scanner SCANNER = new Scanner(System.in);
	private static List<Administrator> administrators = new ArrayList<Administrator>(); 	//Es una asociación entre VendingMachine

	// This method creates three vending machines , adding all the products and the
	// money

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
				
				operativeMachines[arrayIndex] = new VendingMachine(arrayIndex + 1, currentMachineProducts, currentMachineMoney, administrators);

			}
		}catch(ValueIncorrectException e) {
			System.out.println(e.getMessage());
		}
		return operativeMachines;
	}

	// This method prints all the information from the vending machines which are
	// brought in the parameter

	public static void ShowEnabledMachines(VendingMachine[] operativeMachines) {

		for (VendingMachine current : operativeMachines) {
			System.out.println(current.toString());
		}

	}

	public static boolean ChooseOptions(VendingMachine[] operativeMachines) {

		int machineOption;
		machineOption = VendingMachineManager.ChooseMachine() - DIFERENCE_BETWEEN_ARRAY;

		return VendingMachineManager.ChooseOptionConcretMachine(operativeMachines, machineOption);

	}

	
	public static VendingMachine getMachineBroken() {
		VendingMachine[] operativeMachines = MainProgram.getEnabledMachines();
		for(VendingMachine m : operativeMachines) {
			if(m.isBroken()) {
				return m;
			}
		}
		return null;
	}
	
	public static VendingMachine[] getAllMachinseBroken() {
		VendingMachine[] operativeMachines = MainProgram.getEnabledMachines();
		VendingMachine[] result = new VendingMachine[operativeMachines.length];
		int counter = 0;
		for(VendingMachine m : operativeMachines) {
			if(m.isBroken()) {
				result[counter] = m;
				counter++;
			}
		}
		return result;
	}
	
	public static int getNumberMachinesBroken() {
		VendingMachine[] operativeMachines = MainProgram.getEnabledMachines();
		int counter = 0;
		for(VendingMachine m : operativeMachines) {
			if(m.isBroken()) {
				counter++;
			}
		}
		return counter;
	}
	
	public static boolean isThereAMachineBroken() {
		VendingMachine[] operativeMachines = Program.GraphicInterface.ChooseMachine.OperativeMachines;
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
	
	private static int ChooseMachine() {

		int result;

		System.out.println("---------------------------------");
		System.out.println("Bienvenido");
		System.out.println("Seleccione maquina");
		System.out.println("1 - Maquina 1");
		System.out.println("2 - Maquina 2");
		System.out.println("3 - Maquina 3");
		System.out.println("Introducir opcion : ");
		result = SCANNER.nextInt();

		if (result > 3) {
			System.out.println("---------------------------------");
			System.out.println("	  OPCION INCORRECTA");
			System.out.println("---------------------------------");
			return ChooseMachine();
		} else {
			return result;
		}

	}

	private static final int CHECK_PRODUCTS_OPTION = 1;
	private static final int BUY_PRODUCTS_OPTION = 2;
	private static final int CHECK_MONEY_OPTION = 3;
	private static final int LOGIN_OPTION = 4;
	private static final int EXIT_OPTION = 5;
	private static final int REFILL_PRODUCTS_OPTION = 6;
	private static final int REFILL_MONEY_OPTION = 7;
	private static final int REPAIR_MACHINE_OPTION = 8;
	

	private static boolean ChooseOptionConcretMachine(VendingMachine[] operativeMachines, int machineOption) {

		final boolean someonelogedIn = VendingMachineManager.checkIfSomeoneLogedIn();
		
		
		System.out.println("Seleccione opcion");
		System.out.println("1 - Revisar productos");
		System.out.println("2 - Comprar producto");
		System.out.println("3 - Revisar dinero");
		if(!someonelogedIn) {
			System.out.println("4 - Logearse como Admin");
		}
		
		if(someonelogedIn) {
			System.out.println("5 - Salir y deslogearse");
			System.out.println("6 - Rellenar productos");
			System.out.println("7 - Rellenar fondos (Sin implementar)");
			System.out.println("8 - Reparar máquina");
		}else {
			System.out.println("5 - Salir");
		}
		
		System.out.println("Introducir opcion : ");

		int optionChosen;

		optionChosen = SCANNER.nextInt();
		
		//Act in every case

		if (optionChosen == CHECK_PRODUCTS_OPTION) {

			System.out.println(operativeMachines[machineOption].productString());

		} else if (optionChosen == BUY_PRODUCTS_OPTION) {

			//VendingMachineManager.BuyProduct(operativeMachines , machineOption , optionChosen);

		} else if (optionChosen == CHECK_MONEY_OPTION) {

			System.out.println(operativeMachines[machineOption].moneyString());

		} else if (optionChosen == LOGIN_OPTION) {

			System.out.println(VendingMachineManager.LogInConsole());

		} else if (optionChosen == REFILL_PRODUCTS_OPTION && someonelogedIn) {

			operativeMachines[machineOption].refillProduct();

		}  else if (optionChosen == REFILL_MONEY_OPTION && someonelogedIn) {

			//operativeMachines[machineOption].();

		}  else if (optionChosen == REPAIR_MACHINE_OPTION && someonelogedIn) {

			operativeMachines[machineOption].repairMachineString();

		}  else if (optionChosen == EXIT_OPTION) {
			if(someonelogedIn) {
				VendingMachineManager.logOutAdminLogedIn();
			}
			return false;

		} else {
			
			System.out.println("---------------------------------");
			System.out.println("		NUMERO INVALIDO");
			System.out.println("---------------------------------");
			
		}
		
		return true;

	}

/*	private static void BuyProduct(VendingMachine[] operativeMachines, int machineOption, int optionChosen) {
		
		System.out.println(operativeMachines[machineOption].productString());
		
		List<Money> list = VendingMachine.IntroduceMoney();
		
		System.out.println("Escribir producto deseado : ");
		String product = SCANNER.nextLine();
		
		if (operativeMachines[machineOption].buyProduct(product, list)) {
			System.out.println("Se ha comprado el producto");
		} else {
			System.out.println("No se ha realizado la compra");
		}
		
	}*/
	
	//LogIn methods
	
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
	
	public static String LogIn(String username, char[] password) {
		
		
		final boolean correctLogIn = checkLogIn(username, password);
		if(correctLogIn) {
			return "Bienvenido " + getAdministratorLogedIn().getName() + getAdministratorLogedIn().getSurname() + "!";
		}else{
			return "Lo sentimos, pero el usuario o contraseña que has introducido es incorrecto";
		}
	}
	
	public static String LogInConsole() {
		
		final Scanner scanner = new Scanner(System.in);
		
		String result =  "---------------------------------\n";
		result += "         Introduce tu usuario:\n";
		result += "---------------------------------\n";
		System.out.print(result);
		final String username = scanner.nextLine();
		
		String result2 =  "---------------------------------\n";
		result2 += "         Introduce tu contraseña:\n";
		result2 += "---------------------------------\n";
		System.out.print(result2);
		final String password = scanner.nextLine();
		
		scanner.close();
		System.out.println(result);	
		
		final boolean correctLogIn = checkLogIn(username, password.toCharArray());
		if(correctLogIn) {
			return "Bienvenido " + getAdministratorLogedIn().getName() + " " + getAdministratorLogedIn().getSurname() + "!";
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
	
	//Sets the list of Administrators for all the machines
	public static void setAdministrators(List<Administrator> list) {
		VendingMachineManager.administrators = list;
	}
	
	

}
