package com.shell.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@NoArgsConstructor
public class KeyVaultAccessUsingManagedIdentity {

	SecretClient client;

	@PostConstruct
	public void init() {
		// System.out.println("Seret Name = "+createManagedIdentityCredential());
		DefaultAzureCredential defaultCredential = new DefaultAzureCredentialBuilder().build();
		// Azure SDK client builders accept the credential as a parameter
		SecretClient client = new SecretClientBuilder().vaultUrl("https://emerald-sit-vn-np-p-kv-1.vault.azure.net")
				.credential(defaultCredential).buildClient();
		KeyVaultSecret secret = client.getSecret("akv-fapp-dps-reports-appd-account-name");
		log.debug("client= " + secret.getValue());
	}

}
