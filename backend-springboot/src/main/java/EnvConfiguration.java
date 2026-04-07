package com.fdm.SpringAssessment;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfiguration {
    @Bean
    public Dotenv dotenv() {
        // load .env if present, but don't fail if missing
        try {
            return Dotenv.configure()
                    .ignoreIfMissing()
                    .load();
        } catch (Exception e) {
            // fallback to an empty Dotenv instance to avoid failing bean creation
            return Dotenv.configure().ignoreIfMissing().load();
        }
    }
}
