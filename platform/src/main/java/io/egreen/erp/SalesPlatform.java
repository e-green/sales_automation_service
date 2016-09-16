package io.egreen.erp;

import io.egreen.apistudio.bootstrap.ApiStudio;
import io.egreen.apistudio.bootstrap.config.MSApp;
import io.egreen.apistudio.datalayer.mongodb.MongoModuleInitializer;

import javax.ws.rs.ApplicationPath;

/**
 * Created by dewmal on 8/23/16.
 */
@MSApp(
        name = "egreen_erp",
        trace = "OFF"

)
@ApplicationPath("/")
public class SalesPlatform {

    public static void main(String[] args) {
        ApiStudio.boot(SalesPlatform.class, "192.168.1.10", 6080, "/erp", MongoModuleInitializer.class);
    }
}
