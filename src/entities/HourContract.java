package entities;

import java.util.Date;

public class HourContract {

	//Atributos
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	//Construtores
	public HourContract() {
		
	}
	
	// ¹ aqui está a referencia que foi recebido do Program
	public HourContract(Date date, Double valuePerHour, Integer hours) {
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}
	
	//Get setters

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	//Metedos
	public Double totalValue() {
		return valuePerHour * hours;
	}
}
