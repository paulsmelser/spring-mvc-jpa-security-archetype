package it.pkg.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by psmelser on 16/06/15.
 */
@Configuration
@ComponentScan({"it.pkg.entities", "it.pkg.service"})
public class DomainConfig {
}
