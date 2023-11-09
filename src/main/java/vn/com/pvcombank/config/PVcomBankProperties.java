package vn.com.pvcombank.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "pvcombank")
public class PVcomBankProperties {

    /**
     * A message to welcome users
     */
    private String greeting;
}
