package edu.uoc.mecm.eda.tests

import edu.uoc.mecm.eda.pac1.exercise3.Container
import edu.uoc.mecm.eda.pac1.exercise3.Service
import edu.uoc.mecm.eda.pac1.exercise3.Cluster
import edu.uoc.mecm.eda.pac1.exercise3.ContainerIPAlreadyBoundException

import spock.lang.Shared
import spock.lang.Specification

import java.text.SimpleDateFormat

/**
 * Spock Class that tests all Container, Service and Cluster methods
 *
 * BEWARE - This class is written in the Groovy language, which is slightly different from Java
 *
 * @author Carles Pairot Gavaldà
 */
class ContainerClusterTest extends Specification {

    // Define variables that will be used throughout all tests
    // It is compulsory to annotate them with @Shared

    @Shared
    Container c1 = new Container ("0", "Nexus_2.8", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20100520"), InetAddress.getByName ("172.10.0.4"))

    @Shared
    Container c2 = new Container ("1", "MySQL_3.6", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20100521"), InetAddress.getByName ("172.10.0.5"))

    @Shared
    Container c3 = new Container ("2", "Apache_Tomcat_9.1", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20221010"), InetAddress.getByName ("172.10.0.10"))

    @Shared
    Container c4 = new Container ("3", "WildFly_10.1.0", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20160314"), InetAddress.getByName ("172.10.0.6"))

    @Shared
    Container c5 = new Container ("4", "Apache_HTTPD_2.4", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20190416"), InetAddress.getByName ("172.10.0.7"))

    @Shared
    Container c6 = new Container ("5", "NGINX_1.4", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20200819"), InetAddress.getByName ("172.10.0.8"))

    @Shared
    Container c7 = new Container ("6", "Nagios_3.4", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20190314"), InetAddress.getByName ("172.10.0.8"))

    @Shared
    Container c8 = new Container ("7", "WordPress_0.9", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20060212"), InetAddress.getByName ("172.10.0.11"))

    @Shared
    Container c9 = new Container ("8", "Liferay_7.0_DXP", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20220502"), InetAddress.getByName ("172.10.0.12"))

    @Shared
    Container c10 = new Container ("9", "WildFly_10.1.0", "cpairot", new SimpleDateFormat ("yyyyMMdd" ).parse ("20160314"), InetAddress.getByName ("172.10.0.13"))

    @Shared
    Service service1 = new Service ("10", "svc_WildFly_10.1.0", [c4, c10], InetAddress.getByName ("195.76.233.141"), "apps.extra.altranet.com")

    @Shared
    Service service2 = new Service ("11", "svc_Liferay_7.0_DXP", [c9], InetAddress.getByName ("195.76.233.142"), "seu.extra.altranet.com")

    @Shared
    Service service3 = new Service ("12", "svc_FAILURE", [c6], InetAddress.getByName ("195.76.233.143"), "failure.extra.altranet.com")

    @Shared
    Service service4 = new Service ("13", "svc_Apache_Tomcat_9.1", [c3], InetAddress.getByName ("195.76.233.144"), "apps.intra.altranet.com")

    /**
     * Containers unit test
     */
    def "Container tests" () {
        when: "expect methods to work correctly"
            String c1ID = c1.getID()
            String c1Name = c1.getName()
            String c1Owner = c1.getOwner()
            InetAddress c1IPAddr = c1.getIPAddress()
            Date c1Date = c1.getInitDate()

            c2.setID ("test")
            c2.setName ("TeSt")
            c2.setOwner ("bamboo")
            c2.setIPAddress (InetAddress.getByName ("192.168.0.1"))
            c2.setInitDate (new SimpleDateFormat ("yyyyMMdd" ).parse ("20100531"))

            String testID = c2.getID()
            String testName = c2.getName()
            String testOwner = c2.getOwner()
            InetAddress testIPAddr = c2.getIPAddress()
            Date testDate = c2.getInitDate()

        then: "check properties"
            c1ID == "0"
            c1Name == "Nexus_2.8"
            c1Owner == "cpairot"
            c1IPAddr == InetAddress.getByName ("172.10.0.4")

            testID == "test"
            testName == "TeSt"
            testOwner == "bamboo"
            testIPAddr == InetAddress.getByName ("192.168.0.1")
            testDate == new SimpleDateFormat ("yyyyMMdd" ).parse ("20100531")
    }

    /**
     * Services unit test
     */
    def "Services tests" () {
        when: "expect methods to work correctly"
            String serviceID1 = service1.getID()
            String serviceName1 = service1.getName()
            def sl1 = service1.getContainers()
            InetAddress ip1 = service1.getIPAddress()
            String dns1 = service1.getDNSName()

            service4.setID ("test")
            service4.setName ("TeZZT")
            service4.setContainers ([c10, c1])
            service4.setExternalIPAddress (InetAddress.getByName ("202.123.22.14"))
            service4.setDNSName ("test.dummy.com")

            String testID = service4.getID()
            String testName = service4.getName()
            def testL = service4.getContainers()
            InetAddress testIP = service4.getIPAddress()
            String testDNS = service4.getDNSName()

        then: "check properties"
            serviceID1 == "10"
            serviceName1 == "svc_WildFly_10.1.0"
            sl1 == [c4, c10]
            ip1 == InetAddress.getByName ("195.76.233.141")
            dns1 == "apps.extra.altranet.com"

            testID == "test"
            testName == "TeZZT"
            testL == [c10, c1]
            testIP == InetAddress.getByName ("202.123.22.14")
            testDNS == "test.dummy.com"
    }

    /**
     * Service method setContainers() returns exception
     */
    def "Service method setContainers() returns exception" () {
        when: "expect method to work correctly"
            service3.setContainers ([c6, c7])

        then: "check exception is thrown"
            def e = thrown (ContainerIPAlreadyBoundException)
            e.message == "Container NGINX_1.4 cannot be added because its internal IP address is already bound by another container."
    }

    /**
     * Service constructor returns exception
     */
    def "Service constructor returns exception" () {
        when: "expect method to work correctly"
            Service serviceFail = new Service ("12", "svc_FAIL", [c7, c8, c6], InetAddress.getByName ("195.76.233.143"), "failure.extra.altranet.com")

        then: "check exception is thrown"
            def e = thrown (ContainerIPAlreadyBoundException)
            e.message == "Container Nagios_3.4 cannot be added because its internal IP address is already bound by another container."
    }

    /**
     * Cluster unit test
     */
    def "Cluster tests" () {
        when: "expect methods to work correctly"
            Cluster t1 = new Cluster()
            t1.addService (service1)
            t1.addService (service2)
            Service ts1 = t1.getService (service1.getID())
            Service ts2 = t1.getService (service2.getID())
            int tsize1 = t1.getSize()

            t1.addService (service3)
            int tsize1After = t1.getSize()

            t1.removeService (service2.getID())
            int tsize1After1 = t1.getSize()

            Cluster t2 = new Cluster()
            t2.addService (service4)
            t2.addService (service3)
            t2.addService (service1)

            int tsize2 = t2.getSize()
            Service tss1 = t2.getService (service3.getID())
            Service tss2 = t2.getService (service4.getID())
            Service tss3 = t2.getService (service1.getID())

            t2.removeService (service2.getID())
            int tsize2After = t2.getSize()

            t2.removeService (service1.getID())
            t2.removeService (service4.getID())
            t2.removeService (service3.getID())

            int tsize2After1 = t2.getSize()

        then: "check results"
            tsize1 == 2
            tsize1After == 3
            tsize1After1 == 2
            tsize2 == 3
            tss1 == service3
            tss2 == service4
            tss3 == service1
            tsize2After == 3
            tsize2After1 == 0
    }

    /**
     * Cluster methods returns exception
     */
    def "Cluster methods return exception" () {
        when: "expect methods to work correctly"
            Cluster t1 = new Cluster()
            t1.addService (service1)
            t1.addService (service2)
            t1.removeService (service1.getID())
            t1.getService (service1.getID())

        then: "check exception is thrown"
            def e = thrown (NoSuchElementException)
            e.message == "The Service with ID = 10 was not found."
    }
}