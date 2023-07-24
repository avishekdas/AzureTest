package com.shell.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shell.service.KeyVaultAccessUsingManagedIdentity;

@RestController
@RequestMapping(value = "/transaction", produces = { MediaType.APPLICATION_JSON_VALUE })
public class AppServiceManagedIdentityController {

	@Autowired
	KeyVaultAccessUsingManagedIdentity keyVaultAccessUsingManagedIdentity;

	@GetMapping(value = "/keyvault")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String keyVaultConnector() throws Exception {
		String s = "Hello";
		// return
		// keyVaultAccessUsingManagedIdentity.getSecret("akv-fapp-dps-reports-appd-account-name");
		// s = keyVaultAccessUsingManagedIdentity.createManagedIdentityCredential();
		return s;
	}

}
