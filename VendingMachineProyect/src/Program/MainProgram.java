package Program;

import java.util.List;
import java.util.Scanner;

import Program.Products.*;
import Program.MoneyTypes.*;

/*
 * -Cambiar las clases para adaptar a herencia
 * -Añadir a cada producto especifico una descipcion
 * -Modificar main
 * 
 * */

public class MainProgram {

	public static void main(String[] args) {
		
		VendingMachine machines[] = new VendingMachine[3];
		Scanner sc = new Scanner(System.in);
		String aux;
		int machineOp;
		int action;
		
		
		
		
		try {
			for(int i = 0; i<=2 ; i++) {
				
				Product[] products= {new Cookie (1.50f , 10) ,
						new Chocolate (1.10f , 10),
						new Drink (1.05f , 10),
						new Snack (1.75f , 10)};
				
				Money[] money = {new Money (20 , 3) ,
						new Note (10 , 1) ,
						new Note (5 , 2) ,
						new Note (2 , 5) ,
						new Note (1 , 10) ,
						new Coin (0.5f , 20) ,
						new Coin (0.2f , 20) ,
						new Coin (0.05f , 10) };
				
				machines[i] = new VendingMachine(i+1 , products , money);
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		for (VendingMachine current : machines) {
			System.out.println(current.toString());
		}
		
		System.out.println("---------------------------------");
		System.out.println("Bienvenido");
		System.out.println("Seleccione maquina");
		System.out.println("1 - Maquina 1");
		System.out.println("2 - Maquina 2");
		System.out.println("3 - Maquina 3");
		System.out.println("Introducir opcion : ");
		machineOp = sc.nextInt();
		machineOp -= 1;
		
		
		
		do {
			System.out.println("Seleccione opcion");
			System.out.println("1 - Revisar productos");
			System.out.println("2 - Comprar producto");
			System.out.println("3 - Revisar dinero");
			System.out.println("4 - Salir");
			System.out.println("Introducir opcion : ");
			action = sc.nextInt();
			
			try {
				if(action == 1) {
					
					System.out.println(machines[machineOp].productString());
				}else if (action == 2) {
					
					System.out.println(machines[machineOp].productString());
					List<Money> list = VendingMachine.IntroduceMoney();
					System.out.println("Escribir producto deseado : ");
					String product = sc.nextLine();
					if(machines[machineOp].buyProduct(product , list)) {
						System.out.println("Se ha comprado el producto");
					}else {
						System.out.println("No se ha realizado la compra");
					}
					
				}else if (action == 3) {
					
					System.out.println(machines[machineOp].moneyString());
				}else if(action == 4) {
					break;
				}else {
					System.out.println("---------------------------------");
					System.out.println("		NUMERO INVALIDO");
					System.out.println("---------------------------------");
				}
			}catch (Exception e) {
				System.out.println(e);
			}
		}while(true);
		
		
		aux = sc.nextLine();
	}

}
