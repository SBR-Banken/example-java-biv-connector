package nl.logius.digipoort.connector;

import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;

import org.apache.wss4j.common.ext.WSPasswordCallback;

public class WSS4JPasswordCallback implements CallbackHandler
{
	private Map<String, String> passwords = new HashMap<>();

	/**
	 * It attempts to get the password from the private alias/passwords map.
	 */
	@Override
	public void handle(Callback[] callbacks)
	{
		for (Callback callback : callbacks)
		{
			if (callback instanceof WSPasswordCallback)
			{
				WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;
				String alias = passwordCallback.getIdentifier();

				if (passwords.containsKey(alias))
				{
					String password = passwords.get(alias);

					passwordCallback.setPassword(password);
				}
				else
				{
					String password = System.getProperty("javax.net.ssl.keyStorePassword");

					if (password == null)
					{
						System.err.println("unable to supply password for alias [" + alias + "], please set [javax.net.ssl.keyStorePassword] in the jvm environment");
					}
					else
					{
						System.out.println("using password [" + password + "] for alias [" + alias + "]");

						passwordCallback.setPassword(password);
					}
				}
			}
		}
	}

	/**
	 * Add an alias/password pair to the callback mechanism.
	 */
	public void setAliasPassword(String alias, String password)
	{
		passwords.put(alias, password);
	}
}
