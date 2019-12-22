package wedo.asim.odoroid.client.helper;

import wedo.asim.odoroid.client.helper.data.OdooError;
import wedo.asim.odoroid.client.helper.data.OdooResult;

public class OdooResponse {
    public int id;
    public float jsonrpc;
    public OdooResult result;
    public OdooError error;
}
