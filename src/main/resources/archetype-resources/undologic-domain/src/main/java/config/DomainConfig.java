#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by psmelser on 16/06/15.
 */
@Configuration
@ComponentScan({"${package}.entities", "${package}.service"})
public class DomainConfig {
}
