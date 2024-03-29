package wedo.asim.odoroid.client.helper.data;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.TreeMap;

public class OdooResult extends TreeMap<String, Object> {

    public String getString(String key) {
        if (isValidValue(key)) {
            if (isM2O(key)) {
                return getArray(key).get(1).toString();
            }
            return get(key).toString();
        }
        return null;
    }

    public Boolean getBoolean(String key) {
        if (isValidValue(key)) {
            return Boolean.valueOf(getString(key));
        }
        return false;
    }

    public int getInt(String key) {
        if (isValidValue(key) && !get(key).toString().equals("false")) {
            if (isM2O(key)) {
                return Float.valueOf(getArray(key).get(0).toString()).intValue();
            }
            return getFloat(key).intValue();
        }
        return -1;
    }

    public Float getFloat(String key) {
        if (isValidValue(key) && !get(key).toString().equals("false")) {
            return Float.valueOf(getString(key));
        }
        return 0F;
    }

    private boolean isM2O(String key) {
        return get(key) instanceof ArrayList;
    }

    public OdooResult getData(String key) {
        if (isValidValue(key)) {
            OdooResult data = new OdooResult();
            data.putAll((LinkedTreeMap) get(key));
            return data;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> getArray(String key) {
        if (isValidValue(key)) {
            return (ArrayList<T>) get(key);
        }
        return new ArrayList<>();
    }

    public OdooRecord[] getRecords() {
        Object data = null;
        if (isValidValue("records")) {
            data = get("records");
        }
        if (isValidValue("result") && get("result") instanceof ArrayList) {
            data = get("result");
        }
        if (data != null) {
            Gson gson = new Gson();
            String recordsJSON = gson.toJson(data);
            return gson.fromJson(recordsJSON, OdooRecord[].class);
        }
        return new OdooRecord[]{};
    }

    protected boolean isValidValue(String key) {
        return get(key) != null;
    }

}
