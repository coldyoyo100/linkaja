package linkaja.onlinetest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

@Entity
@Table(name="account")
public class CustomerModel {
	
	@Id
	@OneToOne
	@JoinColumn(name="cust_id")
	@Column(name="customer_number")
	private String customerNumber;
	
	@NotNull
	private String name;

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"customerNumber\": \"");
		builder.append(customerNumber);
		builder.append("\", \"name\": \"");
		builder.append(name);
		builder.append("\"}");
		return builder.toString();
	}
	
}
