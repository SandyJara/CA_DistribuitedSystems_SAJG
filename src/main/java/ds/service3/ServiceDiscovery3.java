package ds.service3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ServiceDiscovery3 {
    private String host;
    private int port;
    private boolean serviceDiscovered3 = false;
    private boolean logOnce = false; // this variable was creating to use to control not printing constantly when the service is discovered even when it stays until I terminate it manually

    private static final Logger logger = LoggerFactory.getLogger(ServiceDiscovery3.class);

    private static class SampleListener implements ServiceListener {
        private ServiceDiscovery3 serviceDiscovery3;

        public SampleListener(ServiceDiscovery3 serviceDiscovery) {
            this.serviceDiscovery3 = serviceDiscovery3;
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
            serviceDiscovery3.setHost(host);//then I can use it in my GUI
            serviceDiscovery3.setPort(port);//then I can use it in my GUI
            serviceDiscovery3.setServiceDiscovered(true);

            // Only to log once 
            if (!serviceDiscovery3.isLogOnce()) {
                logger.info("Service discovered at host: " + host + ", port: " + port);
                serviceDiscovery3.setLogOnce(true); // Set flag to true after first log
            }
        }
    }

    public void discoverService3() throws InterruptedException {
        JmDNS jmdns = null;
        try {
            jmdns = JmDNS.create(InetAddress.getLocalHost());
            logger.info("Service discovery started, InetAddress.getLocalHost(): " + InetAddress.getLocalHost());

            jmdns.addServiceListener("_http._tcp.local.", new SampleListener(this));

            // Keep the discovery active
            logger.info("Service discovery is active");

            while (true) {
                Thread.sleep(5000);
                if (serviceDiscovered3) {
                   
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
        return serviceDiscovered3;
    }

    public void setServiceDiscovered(boolean serviceDiscovered3) {
        this.serviceDiscovered3 = serviceDiscovered3;
    }

    public boolean isLogOnce() {
        return logOnce;
    }

    public void setLogOnce(boolean logOnce) {
        this.logOnce = logOnce;
    }

    public static void main(String[] args) {
        ServiceDiscovery3 discovery3 = new ServiceDiscovery3();
        try {
            discovery3.discoverService3();
        } catch (InterruptedException e) {
            logger.error("InterruptedException: ", e);
        }
    }
}