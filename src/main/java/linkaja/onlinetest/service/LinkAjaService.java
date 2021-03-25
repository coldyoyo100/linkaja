package linkaja.onlinetest.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import linkaja.onlinetest.dto.AccountInfoDto;
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
	
	public void addAccount() {
		
	}
	
	public void addCustomer() {
		
	}
	
	public void updateAmount() {
		
	}
	
	public String getAccInfo(String accNo) {
		List<AccountModel> accList = accRepo.getInfoByAccNo(accNo);
		
		AccountInfoDto infoDto = new AccountInfoDto();
		
		for(AccountModel accModel : accList) {
			infoDto.setAccountNumber(accModel.getAccountNumber());
			infoDto.setBalance(accModel.getBalance());
			
			Set<CustomerModel> custSet = accModel.getCustomerNumber();
			for(CustomerModel custModel : custSet) {
				infoDto.setCustomerName(custModel.getName());
			}
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
 