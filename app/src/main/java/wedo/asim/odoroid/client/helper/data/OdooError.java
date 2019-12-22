package wedo.asim.odoroid.client.helper.data;

import com.google.gson.internal.LinkedTreeMap;

import java.util.HashMap;


public class OdooError extends OdooResult {


    public OdooError getErrorData() {
        if (isValidValue("data")) {
            LinkedTreeMap map = (LinkedTreeMap) get("data");
            OdooError error = new OdooError();
            new HashMap<Object, Object>(map).putAll(error);
            return error;
        }
        return null;
    }

}
