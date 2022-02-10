package nl.logius.digipoort.connector;

import java.io.InputStream;
import java.security.KeyStore;
import java.util.Map;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.ws.security.SecurityConstants;
import org.apache.wss4j.common.crypto.Merlin;
import org.apache.wss4j.common.util.Loader;

public class SetupMerlin
{
	/*
	Setup Merlin, for WSS4J. A key and truststore is needed for webservices security.
	 */
	private static final String ALIAS = "client";
	private static final String PASSWD = "test";
	private static final String WSSE_JKS = "wsse.jks";

	public static void setup(BindingProvider bp) throws Exception
	{
		// initialize ws-sec crypto
		WSS4JPasswordCallback passwordCallback = new WSS4JPasswordCallback();
		passwordCallback.setAliasPassword(ALIAS, PASSWD);

		// Setup alias
		Properties merlinProperties = new Properties();
		merlinProperties.put("org.apache.ws.security.crypto.merlin.keystore.alias", ALIAS);

		// Load the keystore direct
		Merlin merlinCrypto = new Merlin(merlinProperties, SetupMerlin.class.getClassLoader(), null);

		KeyStore keyStore = KeyStore.getInstance("jks");
		InputStream input = Merlin.loadInputStream(Loader.getClassLoader(SetupMerlin.class), WSSE_JKS);
		keyStore.load(input, PASSWD.toCharArray()); // password
		merlinCrypto.setKeyStore(keyStore);
		merlinCrypto.setTrustStore(keyStore);

		// initialize request context with ws-sec config
		Map<String, Object> requestContext = bp.getRequestContext();
		requestContext.put(SecurityConstants.CALLBACK_HANDLER, passwordCallback);
		requestContext.put(SecurityConstants.SIGNATURE_CRYPTO, merlinCrypto);
		requestContext.put(SecurityConstants.SIGNATURE_USERNAME, ALIAS);
	}
}
