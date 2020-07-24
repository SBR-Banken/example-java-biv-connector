# example-java-biv-connector

Example code (Java 8) on how to set up a connection with the BIV.

## Configation
In StatusinformatieServiceV12_Service.java and AanleverServiceV12_Service.java, change the file url to the correct
location on your file system.

Create a jks keystore and add the public part of the certificate of bta-frcportaal.nl.
Add the private part of your own certificate with alias 'client' and password 'test'.
Save the keystore with password 'test' as 'wsse.jks' in the root folder.

## Run
Execute the main method in BivConnector