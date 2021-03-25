package linkaja.onlinetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import linkaja.onlinetest.dto.AccountDto;
import linkaja.onlinetest.dto.CustomerDto;
import linkaja.onlinetest.dto.TransferDto;
import linkaja.onlinetest.service.LinkAjaService;

@RestController
@RequestMapping("/account")
public class LinkAjaController {
	
	@Autowired
	LinkAjaService linkService;
	
	@PostMapping
	public ResponseEntity<?> addAccount(@RequestBody AccountDto accDto) throws Exception {
		
		return ResponseEntity.ok(null);
	}
	
	public ResponseEntity<?> addAccount(@RequestBody CustomerDto custDto) throws Exception {
		
		return ResponseEntity.ok(null);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/{accNo}")
	public ResponseEntity<?> getAccNoInfo(@PathVariable("accNo") String accNo) throws Exception {
		String accInfo = null;
		try {
			accInfo = linkService.getAccInfo(accNo);
			if(accInfo.isEmpty()) ResponseEntity.ok(String.valueOf(HttpStatus.NO_CONTENT) + " - Info Acc Tidak Ditemukan");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
		
		return ResponseEntity.ok(String.valueOf( HttpStatus.OK ) +" : "+accInfo.toString());
	}
	
	@PostMapping("/{accNo}/transfer")
	public String transferAction(@PathVariable("accNo") String accNo, @RequestBody TransferDto transderdto) throws Exception {
		
		return null;
	}
}
