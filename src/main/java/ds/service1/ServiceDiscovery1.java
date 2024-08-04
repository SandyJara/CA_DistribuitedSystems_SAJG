package ds.service1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServiceDiscovery1 {
    private String host;
    private int port;
    private boolean serviceDiscovered = false;
    private boolean logOnce = false; // this variable was creating to use to control not printing constantly when the service is discovered even when it stays until I terminate it manually

    private static final Logger logger = LoggerFactory.getLogger(ServiceDiscovery1.class);

    private static class SampleListener implements ServiceListener {
        private ServiceDiscovery1 serviceDiscovery;

        public SampleListener(ServiceDiscovery1 serviceDiscovery) {
            this.serviceDiscovery = serviceDiscovery;
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
            serviceDiscovery.setHost(host);//then I can use it in my GUI
            serviceDiscovery.setPort(port);//then I can use it in my GUI
            serviceDiscovery.setServiceDiscovered(true);

            // Only to log once 
            if (!serviceDiscovery.isLogOnce()) {
                logger.info("Service discovered at host: " + host + ", port: " + port);
                serviceDiscovery.setLogOnce(true); // Set flag to true after first log
            }
        }
    }

    public void discoverService1() throws InterruptedException {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            logger.info("Service discovery started, InetAddress.getLocalHost(): " + InetAddress.getLocalHost());

            jmdns.addServiceListener("_http._tcp.local.", new SampleListener(this));

            // Keep the discovery active
            logger.info("Service discovery is active");

            while (true) {
                Thread.sleep(5000);
                if (serviceDiscovered) {
                   
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
        return serviceDiscovered;
    }

    public void setServiceDiscovered(boolean serviceDiscovered) {
        this.serviceDiscovered = serviceDiscovered;
    }

    public boolean isLogOnce() {
        return logOnce;
    }

    public void setLogOnce(boolean logOnce) {
        this.logOnce = logOnce;
    }

    public static void main(String[] args) {
        ServiceDiscovery1 discovery = new ServiceDiscovery1();
        try {
            discovery.discoverService1();
        } catch (InterruptedException e) {
            logger.error("InterruptedException: ", e);
        }
    }
}