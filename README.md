local-jndi-example
==================

Example EAR project showing local JNDI lookups in JBoss EAP

The test EAR application shows the different kind of local EJB look-ups.

In order to use this application:
1. Checkout project
2. Perform 'mvn clean install' on the root directory
3. Deploy the 'local-jndi-app-<version>-SNAPSHOT.ear' into JBoss 'deployments' directory.
4. Start JBoss (If not already started)
5. In web browser, navigate to 'http://localhost:8080/local-jndi-web/test'
