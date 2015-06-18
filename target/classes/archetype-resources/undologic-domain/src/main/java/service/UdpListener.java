#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import org.springframework.stereotype.Component;

/**
 * Created by paulsmelser on 15-06-06.
 */
@Component
public interface UdpListener {
    void run();
}
