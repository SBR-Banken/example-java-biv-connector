package nl.logius.digipoort.connector;

import java.util.Map;
import java.util.Properties;

import javax.xml.ws.BindingProvider;

import org.apache.cxf.ws.security.SecurityConstants;
import org.apache.ws.security.components.crypto.Merlin;

public class SetupMerlin
{
	/*
	Setup Merlin, for WSS4J. A key and truststore is needed for webservices security.
	 */
	private static final String ALIAS = "biv";
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
		merlinProperties.put("org.apache.ws.security.crypto.merlin.keystore.file", WSSE_JKS);
		merlinProperties.put("org.apache.ws.security.crypto.merlin.keystore.password", PASSWD);
		merlinProperties.put("org.apache.ws.security.crypto.merlin.truststore.file", WSSE_JKS);
		merlinProperties.put("org.apache.ws.security.crypto.merlin.truststore.password", PASSWD);

		// initialize request context with ws-sec config
		Map<String, Object> requestContext = bp.getRequestContext();
		requestContext.put(SecurityConstants.CALLBACK_HANDLER, passwordCallback);
		requestContext.put(SecurityConstants.SIGNATURE_CRYPTO, new Merlin(merlinProperties));
		requestContext.put(SecurityConstants.SIGNATURE_USERNAME, ALIAS);
	}
}
