/**
 * 
 * 		TLS of SSL 3 met:
 * 
 * 		TLS_DHE_RSA_WITH_AES_128_CBC_SHA 
 * 		TLS_RSA_WITH_AES_128_CBC_SHA
 * 		TLS_RSA_WITH_AES_256_CBC_SHA
 * 		TLS_DHE_RSA_WITH_AES_256_CBC_SHA
 * 		TLS_RSA_WITH_3DES_EDE_CBC_SHA
 * 		SSL_RSA_WITH_AES_128_CBC_SHA
 * 
 * 		Elementen:
 *  
 * 		Het is niet toegestaan eigen header velden toe te voegen aan het bericht.
 * 
 * 		Timestamp
 * 		http://docs.oasis-open.org/wss/2004/01/oasis-200401-wsswssecurity-utility-1.0.xsd
 * 		wsu:Timestamp
 * 		wsu:Created is verplicht
 * 		wsu:Expires is optioneel
 * 
 * 		WS-Addressing: 
 * 		http://www.w3.org/2006/05/addressing/wsdl
 * 
 * 		Request:
 * 
 * 		wsa:To
 * 		gelijk aan het endpoint van de service
 * 
 * 		wsa:Action
 * 		http://logius.nl/digipoort/wus/2.0/aanleverservice/1.2/AanleverService/aanleverenRequest
 * 
 * 		wsa:MessageID
 * 		voldoen aan :
 * 		http://www.w3.org/TR/2007/REC-ws-addr-metadata-20070904/
 * 
 * 		wsa:ReplyTo
 * 		optioneel, indien gevuld moet deze de volgende waarde hebben: 
 * 		http://www.w3.org/2005/08/addressing/anonymous
 * 
 * 		Response:
 * 
 * 		wsa:To
 * 		http://www.w3.org/2005/08/addressing/anonymous
 * 
 * 		wsa:Action
 * 		http://logius.nl/digipoort/wus/2.0/aanleverservice/1.2/AanleverService/aanleverenResponse
 * 
 * 		wsa:MessageID
 * 		voldoen aan :
 * 		http://www.w3.org/TR/2007/REC-ws-addr-metadata-20070904/
 * 
 * 		wsa:RelatesTo
 * 		voldoen aan : http://www.w3.org/TR/2007/REC-ws-addr-metadata-20070904/
 * 		Moet hetzelfde ID zijn als in de request.
 * 
 * 		Overige headers mogen alleen
 * 		voorkomen met waarde:
 * 		http://www.w3.org/2005/08/addressing/anonymous
 * 		http://www.w3.org/2005/08/addressing/none
 * 
 * 		Digitale handtekening:
 * 		http://www.w3.org/2000/09/xmldsig#
 * 
 * 		Canonicalization
 * 		http://www.w3.org/2001/10/xml-exc-c14n#
 * 
 * 		Digest
 * 		http://www.w3.org/2000/09/xmldsig#sha1
 * 
 * 		Signature
 * 		http://www.w3.org/2000/09/xmldsig#rsa-sha1
 * 
 * 		- het element timestamp moet ondertekend worden.
 * 		- alle ws-addressing elementen moeten ondertekend worden.
 * 		- de body moet ondertekend worden.
 * 
 * 		Het gebruikte
 * 		x.509 certificaat moet als binary security token
 * 		meegeleverd worden.
 * 		http://docs.oasis-open.org/wss/2004/01/oasis-200401-wsswssecurity-secext-1.0.xsd
 * 
 * 		wsse:BinarySecurityToken
 * 		Encoding
 * 		http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soapmessage-security-1.0#Base64Binary
 * 		Value
 * 		http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-x509-tokenprofile-1.0#X509v3
 * 	
 * 
 */
package nl.logius.digipoort.wus._2_0.aanleverservice._1;
