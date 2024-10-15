package Lab10.Prob2;

import java.util.Objects;

public class Account {
	private int acctId;
	private double balance;
	
	public Account(int id, double startBalance) {
		if(startBalance <= 0) throw new IllegalArgumentException("Start balance must be > 0!");
		acctId = id;
		balance = startBalance;
	}
	public int getAcctId() {
		return acctId;
	}
	public double getBalance() {
		return balance;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Account)) return false;
		Account other = (Account) obj;
		return acctId == other.acctId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acctId, balance);
	}

}
