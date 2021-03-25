package linkaja.onlinetest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="account")
public class AccountModel {
	
	@Id
	@Column(name="account_number")
	private String accountNumber;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="cust_id")
	@Column(name="customer_number")
	private Set<CustomerModel> customerNumber = new HashSet<CustomerModel>();
	
	@NotNull
	private int balance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	public Set<CustomerModel> getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Set<CustomerModel> customerNumber) {
		this.customerNumber = customerNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"accountNumber\":");
		builder.append("\"").append(accountNumber).append("\",");
		builder.append("\"customerNumber\":");
		builder.append("\"").append(customerNumber).append("\",");
		builder.append("\"balance\":");
		builder.append(balance);
		builder.append("}");
		return builder.toString();
	}
	
	
}
