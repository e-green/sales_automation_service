package io.egreen.apistudio.bootstrap.status;

import java.lang.reflect.Type;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
public class StatusMessage {

    private Type type;

    public StatusMessage(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }


    public enum Type {

        PENDDING("pendding"),
        FINISHED("finished");
        private String type;

        Type(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

}
