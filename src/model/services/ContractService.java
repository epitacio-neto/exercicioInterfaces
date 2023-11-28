package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePayment;
	
	public ContractService(OnlinePaymentService onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	public void processContract(Contract contract, int months) {
		if (months < 1) {
			throw new DomainException("Month must be equal to or greater than 1");
		}
		double installment;
		LocalDate date = contract.getDate();
		
		for (int i = 1; i <= months; i++) {
			installment = contract.getTotalValue()/months;
			installment = onlinePayment.paymentFee(installment);
			installment = onlinePayment.interest(installment, i);
			contract.addInstallment(new Installment(date.plusMonths(i), installment));
		}
	}
}
