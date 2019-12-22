package wedo.asim.odoroid;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;

import java.util.List;

import wedo.asim.odoroid.client.builder.RequestBuilder;
import wedo.asim.odoroid.client.ConnectorClient;
import wedo.asim.odoroid.client.OdooVersion;
import wedo.asim.odoroid.client.listeners.OdooConnectListener;
import wedo.asim.odoroid.client.listeners.OdooErrorListener;

public class OdooClient extends ConnectorClient<OdooClient> {

    public static Integer REQUEST_TIMEOUT_MS = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
    public static Integer DEFAULT_MAX_RETRIES = DefaultRetryPolicy.DEFAULT_MAX_RETRIES;
    public static Boolean DEBUG_RPC = false;

    private OdooClient(Context context) {
        super(context);
    }

    public Context getContext() {
        return mContext;
    }

    public String getServerHost() {
        return serverHost;
    }

    public String getSessionId() {
        return sessionId;
    }

    public OdooVersion getVersion() {
        return odooVersion;
    }

    public List<String> getDatabases() {
        return databases;
    }

    public OdooUser getUser() {
        return odooUser;
    }

    public Boolean isConnected() {
        return isConnected;
    }

    /**
     * Builder class to initiate OdooClient Object with required host or session.
     */
    public static class Builder {
        private OdooClient client;

        public Builder(Context context) {
            client = new OdooClient(context);
        }

        public Builder setHost(String host) {
            client.serverHost = host;
            return this;
        }

        public Builder setSession(String session) {
            client.sessionId = session;
            return this;
        }

        public Builder setErrorListener(OdooErrorListener listener) {
            client.errorListener = listener;
            return this;
        }

        public Builder setConnectListener(OdooConnectListener listener) {
            client.odooConnectListener = listener;
            return this;
        }

        public Builder setSynchronizedRequests(Boolean enable) {
            client.synchronizedRequests = enable;
            return this;
        }

        public OdooClient build() {
            if (client.odooConnectListener != null || client.sessionId == null) {
                client.connect();
            }
            return client;
        }
    }

    //-----------------------------------------------
    // Request Builder API
    //-----------------------------------------------

    public RequestBuilder newRequest(String forModel) {
        return RequestBuilder.init(this, forModel);
    }
}
