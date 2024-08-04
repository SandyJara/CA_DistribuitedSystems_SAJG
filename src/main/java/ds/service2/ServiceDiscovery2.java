package ds.service2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServiceDiscovery2 {
    private String host;
    private int port;
    private boolean serviceDiscovered2 = false;
    private boolean logOnce = false; // this variable was creating to use to control not printing constantly when the service is discovered even when it stays until I terminate it manually

    private static final Logger logger = LoggerFactory.getLogger(ServiceDiscovery2.class);

    private static class SampleListener implements ServiceListener {
        private ServiceDiscovery2 serviceDiscovery2;

        public SampleListener(ServiceDiscovery2 serviceDiscovery) {
            this.serviceDiscovery2 = serviceDiscovery2;
        }

        @Override
        public void serviceAdded(ServiceEvent event) {
            logger.info("Service added: " + event.getInfo());
        }

        @Override
        public void serviceRemoved(ServiceEvent event) {
            logger.info("Service removed: " + event.getInfo());
        }

        @Override
        public void serviceResolved(ServiceEvent event) {
            logger.info("Service resolved: " + event.getInfo());
            ServiceInfo info = event.getInfo();
            String host = info.getHostAddresses().length > 0 ? info.getHostAddresses()[0] : "unknown";
            int port = info.getPort();
            serviceDiscovery2.setHost(host);//then I can use it in my GUI
            serviceDiscovery2.setPort(port);//then I can use it in my GUI
            serviceDiscovery2.setServiceDiscovered(true);

            // Only to log once 
            if (!serviceDiscovery2.isLogOnce()) {
                logger.info("Service discovered at host: " + host + ", port: " + port);
                serviceDiscovery2.setLogOnce(true); // Set flag to true after first log
            }
        }
    }

    public void discoverService2() throws InterruptedException {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            logger.info("Service discovery started, InetAddress.getLocalHost(): " + InetAddress.getLocalHost());

            jmdns.addServiceListener("_http._tcp.local.", new SampleListener(this));

            // Keep the discovery active
            logger.info("Service discovery is active");

            while (true) {
                Thread.sleep(5000);
                if (serviceDiscovered2) {
                   
                    // break; I didnt need this because i need the discovery to stay active, so then i can execute my GUI
                }
            }

        } catch (UnknownHostException e) {
            logger.error("UnknownHostException: ", e);
        } catch (IOException e) {
            logger.error("IOException: ", e);
        } finally {
            if (jmdns != null) {
                try {
                    jmdns.close();
                } catch (IOException e) {
                    logger.error("IOException during JmDNS close: ", e);
                }
            }
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isServiceDiscovered() {
        return serviceDiscovered2;
    }

    public void setServiceDiscovered(boolean serviceDiscovered2) {
        this.serviceDiscovered2 = serviceDiscovered2;
    }

    public boolean isLogOnce() {
        return logOnce;
    }

    public void setLogOnce(boolean logOnce) {
        this.logOnce = logOnce;
    }

    public static void main(String[] args) {
        ServiceDiscovery2 discovery2 = new ServiceDiscovery2();
        try {
            discovery2.discoverService2();
        } catch (InterruptedException e) {
            logger.error("InterruptedException: ", e);
        }
    }
}