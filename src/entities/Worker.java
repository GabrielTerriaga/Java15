package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	//Atributos
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//Associações
	private Department department; //Um unico departamento
	private List<HourContract> contracts = new ArrayList<>(); //Por que são varios contratos
	
	//Construtores
	public Worker() {
		
	}
	
	//Não colocar atributos que sejam listas, por que precisa ser estanciada por padrão na classe
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	//Get Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	/* Precisa remover esse set para que não seja setado uma lista dentro da outra (substituir) !CUIDADO!
	
	public void setContracts(List<HourContract> contracts) {
		this.contracts = contracts;
	}*/

	//Metodos
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public Double income(int year, int month) {
		double sum = baseSalary;
		//Calendar para extrair o mês e ano
		Calendar cal = Calendar.getInstance();
		//for each para percorrer a lista
		for (HourContract c : contracts) {
			cal.setTime(c.getDate()); //pegar data do contrato
			//criado duas variaveis para extrair o ano e mês com Calendar
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH); //+1 por que ele começa com 0
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}
