package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	
	private List<Installment> installments = new ArrayList<>();
	
	public static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Contract(Integer number, LocalDate date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public LocalDate getDate() {
		return date;
	}

	public Double getTotalValue() {
		return totalValue;
	}
	
	
	public void addInstallment(Installment installment) {
		installments.add(installment);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Installment installment : installments) {
			sb.append(installment + "\n");
		}
		return sb.toString();
	}
}
