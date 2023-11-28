package application;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalServices;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), Contract.fmt);
		
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract contrac = new Contract(number, date, totalValue);
		
		System.out.print("Entre com o numero de parcelas: ");
		int months = sc.nextInt();
		
		ContractService contractService = new ContractService( new PaypalServices());
		contractService.processContract(contrac, months);
		
		System.out.println("Parcelas: ");
		System.out.println(contrac);
		
		sc.close();
	}

}
