package wedo.asim.odoroid.client.listeners;

import wedo.asim.odoroid.client.helper.OdooErrorException;

public interface OdooErrorListener {
    void onError(OdooErrorException error);
}
