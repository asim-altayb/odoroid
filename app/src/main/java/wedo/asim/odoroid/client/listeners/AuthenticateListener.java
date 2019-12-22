package wedo.asim.odoroid.client.listeners;

import wedo.asim.odoroid.OdooUser;
import wedo.asim.odoroid.client.AuthError;

public interface AuthenticateListener {
    void onLoginSuccess(OdooUser user);

    void onLoginFail(AuthError error);
}
