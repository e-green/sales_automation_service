package io.egreen.apistudio.bootstrap.utill;

import org.hashids.Hashids;

/**
 * Created by Pramode Wimukthi on 9/4/2016.
 */
public class IDUtilty {

    public String getKey(long... number){
        String key="";
        Hashids hashids = new Hashids(System.currentTimeMillis() + "");
        return hashids.encode(number);
    }
}
