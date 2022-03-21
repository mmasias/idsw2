package Program;

import Program.Products.*;

import java.util.List;
import java.util.Scanner;

import Program.Exceptions.ValueIncorrectException;
import Program.MoneyTypes.*;

public class VendingMachineManager {

	private static final int DIFERENCE_BETWEEN_ARRAY = 1;
	private static final Scanner SCANNER = new Scanner(System.in);

	// This method creates three vending machines , adding all the products and the
	// money

	public static VendingMachine[] EnableMachines(VendingMachine[] operativeMachines) {

		try {
			for (int arrayIndex = 0; arrayIndex <= 2; arrayIndex++) {

				Product[] currentMachineProducts = { 
						new Cookie(1.50f, 10), 
						new Chocolate(1.10f, 10), 
						new Drink(1.05f, 10),
						new Snack(1.75f, 10) };

				Money[] currentMachineMoney = {
						new Note(20, 3), 
						new Note(10, 1), 
						new Note(5, 2), 
						new Coin(2, 5),
						new Coin(1, 10), 
						new Coin(0.5f, 20), 
						new Coin(0.2f, 20), 
						new Coin(0.05f, 10) };

				operativeMachines[arrayIndex] = new VendingMachine(arrayIndex + 1, currentMachineProducts, currentMachineMoney);

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
	private static final int EXIT_OPTION = 4;

	private static boolean ChooseOptionConcretMachine(VendingMachine[] operativeMachines, int machineOption) {

		
		
		System.out.println("Seleccione opcion");
		System.out.println("1 - Revisar productos");
		System.out.println("2 - Comprar producto");
		System.out.println("3 - Revisar dinero");
		System.out.println("4 - Salir");
		System.out.println("Introducir opcion : ");

		int optionChosen;

		optionChosen = SCANNER.nextInt();
		
		//Act in every case

		if (optionChosen == CHECK_PRODUCTS_OPTION) {

			System.out.println(operativeMachines[machineOption].productString());

		} else if (optionChosen == BUY_PRODUCTS_OPTION) {

			VendingMachineManager.BuyProduct(operativeMachines , machineOption , optionChosen);

		} else if (optionChosen == CHECK_MONEY_OPTION) {

			System.out.println(operativeMachines[machineOption].moneyString());

		} else if (optionChosen == EXIT_OPTION) {

			return false;

		} else {
			
			System.out.println("---------------------------------");
			System.out.println("		NUMERO INVALIDO");
			System.out.println("---------------------------------");
			
		}
		
		return true;

	}

	private static void BuyProduct(VendingMachine[] operativeMachines, int machineOption, int optionChosen) {
		
		System.out.println(operativeMachines[machineOption].productString());
		
		List<Money> list = VendingMachine.IntroduceMoney();
		
		System.out.println("Escribir producto deseado : ");
		String product = SCANNER.nextLine();
		
		if (operativeMachines[machineOption].buyProduct(product, list)) {
			System.out.println("Se ha comprado el producto");
		} else {
			System.out.println("No se ha realizado la compra");
		}
		
	}

}
