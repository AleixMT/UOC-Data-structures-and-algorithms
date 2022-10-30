package edu.uoc.mecm.eda.tests

import edu.uoc.mecm.eda.pac1.exercise4.CapacityException
import edu.uoc.mecm.eda.pac1.exercise4.Log
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Spock Class that tests all Calamari methods
 *
 * BEWARE - This class is written in the Groovy language, which is slightly different from Java
 *
 * @author Carles Pairot Gavaldà
 */
class LogTest extends Specification {

    @Shared
    String[] logEntries = ["2014-02-17 15:01:25,100 INFO [org.jboss.weld.deployer] (MSC service thread 1-8) JBAS016005: Starting Services for CDI deployment: rest-javaee7.war\n",
                           "2014-02-17 15:01:25,292 INFO [org.jboss.weld.Version] (MSC service thread 1-8) WELD-000900: 2.1.2 (Final)\n",
                           "2014-02-17 15:01:25,523 INFO [org.jboss.weld.deployer] (MSC service thread 1-6) JBAS016008: Starting weld service for deployment rest-javaee7.war\n",
                           "2014-02-17 15:01:29,366 INFO [org.jboss.resteasy.spi.ResteasyDeployment] (MSC service thread 1-7) Deploying javax.ws.rs.core.Application: class com.sample.JaxRsActivator\n",
                           "2014-02-17 15:01:29,541 INFO [org.wildfly.extension.undertow] (MSC service thread 1-7) JBAS017534: Registered web context: /rest-javaee7\n",
                           "2014-02-17 15:01:29,583 INFO [org.jboss.as.server] (Controller Boot Thread) JBAS018559: Deployed \\\"rest-javaee7.war\\\" (runtime-name : \\\"rest-javaee7.war\\\")\n",
                           "2014-02-17 15:01:29,726 INFO [org.jboss.as] (Controller Boot Thread) JBAS015961: Http management interface listening on http://127.0.0.1:9990/management,\n",
                           "2014-02-17 15:01:29,729 INFO [org.jboss.as] (Controller Boot Thread) JBAS015951: Admin console listening on http://127.0.0.1:9990,\n",
                           "2014-02-17 15:01:29,730 INFO [org.jboss.as] (Controller Boot Thread) JBAS015874: WildFly 8.0.0.Final \\\"WildFly\\\" started in 45032ms - Started 305 of 3\n",
                           "61 services (93 services are lazy, passive or on-demand)"]

    /**
     * Log unit tests
     */
   @Unroll
    def "Log unit tests" () {
        when: "expect methods to work correctly"
            Log l1 = new Log (5)
            for (int i = 0; i < 4; i++) {
                l1.add (logEntries[i])
            }

            int size1 = l1.size()
            String l1Head = l1.get()
            String l1NextHead = l1.peek()

            Log l2 = new Log (8)

            int l2Full = 0;
            // Keep on adding until log is full
            for (int i = 0; i < logEntries.size(); i++) {
                try {
                    l2.add (logEntries[i])
                } catch (CapacityException ce) {
                    // Log is now full. Now we could, for example, persist it to disk, and then clear it to continue using it
                    // l2.persistToDisk()
                    l2Full = l2.size()
                    l2.clear()
                    l2.add(logEntries[i]);
                }
            }

            int l2NoFull = l2.size()
            String l2Head = l2.get()

        then: "check results"
            size1 == 4
            l1Head == "2014-02-17 15:01:25,100 INFO [org.jboss.weld.deployer] (MSC service thread 1-8) JBAS016005: Starting Services for CDI deployment: rest-javaee7.war\n"
            l1NextHead == "2014-02-17 15:01:25,292 INFO [org.jboss.weld.Version] (MSC service thread 1-8) WELD-000900: 2.1.2 (Final)\n"
            l2Full == 8
            l2NoFull == 2
            l2Head == "2014-02-17 15:01:29,730 INFO [org.jboss.as] (Controller Boot Thread) JBAS015874: WildFly 8.0.0.Final \\\"WildFly\\\" started in 45032ms - Started 305 of 3\n"
    }

    /**
     * Test log overflow
     */
    def "Test log overflow" () {
        when: "expect methods to work correctly"
            Log l1 = new Log(5)
            for (int i = 0; i < logEntries.size(); i++) {
                l1.add (logEntries[i])
            }

        then: "check exception is thrown"
            def e = thrown (CapacityException)
            e.message == "Buffer Overflow"
    }

    /**
     * Test log underflow
     */
    def "Test log underflow" () {
        when: "expect methods to work correctly"
            Log l1 = new Log(5)
            for (int i = 0; i < 2; i++) {
                l1.add (logEntries[i])
            }

            l1.get()
            l1.get()
            l1.get()

        then: "check exception is thrown"
            def e = thrown (CapacityException)
            e.message == "Empty Buffer"
    }
}