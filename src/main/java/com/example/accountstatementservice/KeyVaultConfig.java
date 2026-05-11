package com.example.accountstatementservice;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class KeyVaultConfig {

    @Bean
    public SecretClient secretClient() {
        return new SecretClientBuilder()
                .vaultUrl("https://banking-keyvault.vault.azure.net/")
                .credential(new DefaultAzureCredentialBuilder().build())
                .buildClient();
    }

    @Bean
    public DataSource dataSource(SecretClient secretClient) {

        String password = secretClient.getSecret("db-password").getValue();

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:sqlserver://bankingsqlserver.database.windows.net:1433;database=accountstatementdb");
        ds.setUsername("sqladmin");
        ds.setPassword(password);

        return ds;
    }
}
