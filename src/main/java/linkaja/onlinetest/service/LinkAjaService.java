package linkaja.onlinetest.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import linkaja.onlinetest.dto.AccountDto;
import linkaja.onlinetest.dto.AccountInfoDto;
import linkaja.onlinetest.dto.CustomerDto;
import linkaja.onlinetest.dto.TransferDto;
import linkaja.onlinetest.model.AccountModel;
import linkaja.onlinetest.model.CustomerModel;
import linkaja.onlinetest.repository.AccountRepo;
import linkaja.onlinetest.repository.CustomerRepo;

@Service
public class LinkAjaService {
	
	Logger log = LoggerFactory.getLogger(LinkAjaService.class);
	
	@Autowired
	AccountRepo accRepo;
	
	@Autowired
	CustomerRepo custRepo;
	
	public String addAccount(List<AccountDto> accArr) throws Exception {
		AccountModel acc;
		CustomerModel custModel;
		for(AccountDto accDto : accArr) {
			acc = new AccountModel(); 
			acc.setAccountNumber(accDto.getAccountNumber());
			acc.setCustomerNumber(accDto.getCustomerNumber());
			acc.setBalance(accDto.getBalance());

//			
//			custModel = new CustomerModel();
//			custModel.setCustomerNumber(accDto.getCustomerNumber());
//			
//			Set<CustomerModel> custSet = new HashSet<CustomerModel>();
//			custSet.add(custModel);
//			
			accRepo.save(acc);
		}
		
		return "Insert Account Sukses";
	}
	
	public String addCustomer(List<CustomerDto> custArr) throws Exception {
		CustomerModel customer;
		for(CustomerDto custDto : custArr) {
			customer = new CustomerModel();
			customer.setCustomerNumber( custDto.getCustomerNumber());
			customer.setName(custDto.getName());
			custRepo.save(customer);
		}
		
		return "Insert Customer Sukses";
	}
	
	public void updateAmount() {
		
	}
	
	public String getAccInfo(String accNo) {
		List<AccountModel> accList = accRepo.getInfoByAccNo(accNo);
		
		AccountInfoDto infoDto = new AccountInfoDto();
		
		for(AccountModel accModel : accList) {
			infoDto.setAccountNumber(String.valueOf(accModel.getAccountNumber()));
			infoDto.setBalance(accModel.getBalance());
			
			String custNo = accModel.getCustomerNumber();
			String custName = custRepo.getNameByCustNo(custNo);
			
			infoDto.setCustomerName(custName);
		}
		
		return infoDto.toString();
	}
	
	public String transferAccSeq(String fromAcc, TransferDto transferDto) {
		String retval = null;
		String account = transferDto.getToAccountNumber();
		String checkAcc = accRepo.checkAccount(account);
		
		if(checkAcc.equals("1")) {
			
		}else {
			retval = String.valueOf(HttpStatus.NO_CONTENT) + " - Account Tidak Terdaftar";
		}
		
		return retval;
	}
}
 