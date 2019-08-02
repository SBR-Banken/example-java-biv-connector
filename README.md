# example-java-biv-connector

Voorbeeld code (Java 8) hoe je een verbinding tot stand kan brengen met de banken infrastructurele voorzieningen (BIV).

Configuration steps:
- Create a java keystore tls.jks, password 'pass' that serves as truststore and add the certificate of bta-frcportaal.nl to this keystore
- Create a java keystore wsse.jks, that serves as keystore and add your PKI-O certificate to this keystore. The alias of the certificate and the password for this certificate and keystore can be set in SetupMerlin.java
- Update AanleverServiceV12_Service and StatusinformatieServiceV12_Service with the correct url's. (replace 'your/location' with the actual location on your file system)