package Program;

import java.util.Scanner;

public class MainProgram {

	public static void main(String[] args) {
		
		VendingMachine machines[] = new VendingMachine[3];
		Scanner sc = new Scanner(System.in);
		String aux;
		int machineOp;
		int action;
		
		
		
		
		try {
			for(int i = 0; i<=2 ; i++) {
				
				Product[] products= {new Product ("Galletas" , 1.50f , 10) ,
						new Product ("Chocolates" , 1.10f , 10),
						new Product ("Bebida" , 1.05f , 10),
						new Product ("Bocadillo" , 1.75f , 10)};
				
				Money[] money = {new Money (20 , 3) ,
						new Money (10 , 1) ,
						new Money (5 , 2) ,
						new Money (2 , 5) ,
						new Money (1 , 10) ,
						new Money (0.5f , 20) ,
						new Money (0.2f , 20) ,
						new Money (0.05f , 10) };
				
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
		
		System.out.println("Seleccione opcion");
		System.out.println("1 - Revisar productos");
		System.out.println("2 - Comprar producto");
		System.out.println("3 - Revisar dinero");
		System.out.println("Introducir opcion : ");
		action = sc.nextInt();
		
		try {
			if(action == 1) {
				System.out.println(machines[machineOp].productString());
			}else if (action == 2) {
				
			}else if (action == 3) {
				System.out.println(machines[machineOp].moneyString());
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		aux = sc.nextLine();
	}

}
