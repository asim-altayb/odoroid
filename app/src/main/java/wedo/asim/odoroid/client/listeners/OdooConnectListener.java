package wedo.asim.odoroid.client.listeners;

import wedo.asim.odoroid.client.OdooVersion;

public interface OdooConnectListener {
    void onConnected(OdooVersion version);
}
