package model.services;

public class PaypalServices implements OnlinePaymentService{
	
	@Override
	public double paymentFee(double amount) {
		return amount * 1.02;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * (1 + 0.01 * months);
	}
	
}
