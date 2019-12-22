package wedo.asim.odoroid.client.listeners;

import wedo.asim.odoroid.client.helper.OdooErrorException;
import wedo.asim.odoroid.client.helper.data.OdooResult;

public abstract class IOdooResponse {

    public String requestingURL = null;
    public int uuid = 0;

    public abstract void onResult(OdooResult result);

    public boolean onError(OdooErrorException error) {
        return false;
    }
}
