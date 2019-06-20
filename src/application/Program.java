package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");//Precisa instanciar um SimpleDateFormat para o usuario entrar com um formato date
		SimpleDateFormat sdfIncome = new SimpleDateFormat("MM/yyyy");//Para a entradad e date do INCOME
		
		// Entrada dos dados do funcionario
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base Salary: ");
		double workerBaseSalary = sc.nextDouble();
		
		//OBJS
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName)); //como é associação o atributo department precisa ser instanciado como ali
		
		// Entrada dos contratos
		System.out.print("How many contracts to this worker? ");
		Integer nContract = sc.nextInt();
		//For para os contratos
		for (int i = 0; i < nContract; i++) {
			// Entrada dados do contrato
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double contractValuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int contractDuration = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, contractValuePerHour, contractDuration);
			//Para associar o obj contract com o obj worker¹ (¹ referencia de comment)
			worker.addContract(contract);
			
		}//Saida após atingir a quantia de contrato
		
		System.out.println();
		
		//Calculo income
		System.out.print("Enter the month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));//utilizado substring para coletar ano e mes para mandar na classe worker
		
		
		//Date incomeDate = sdfIncome.parse(sc.next());
		//System.out.printf("Income for " + sdfIncome.format(incomeDate) + ": %.2f", worker.income(incomeDate.getYear(), incomeDate.getMonth()));
		sc.close();
	}

}
