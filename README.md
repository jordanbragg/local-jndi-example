local-jndi-example
==================

Example EAR project showing local JNDI lookups in JBoss EAP

The test EAR application shows the different kind of local EJB look-ups.

<b>In order to use this application:</b><br/>
1. Checkout project<br/>
2. Perform 'mvn clean install' on the root directory<br/>
3. Deploy the 'local-jndi-app-1.0.0-SNAPSHOT.ear' into JBoss 'deployments' directory.<br/>
4. Start JBoss (If not already started)<br/>
5. In a web browser, navigate to 'http://localhost:8080/local-jndi-web/test'<br/>
