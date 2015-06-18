#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config;

/**
 * Created by psmelser on 03/06/15.
 */
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(value = 2)
public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
}