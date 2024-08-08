package ds.service1;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//This code is adapted from https://github.com/jmdns/jmdns
public class ServiceRegistration1 {

 public static void main(String[] args) throws InterruptedException {
     try {
         // Create a JmDNS instance
         JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
         System.out.println("Registration: InetAddress.getLocalHost():" + InetAddress.getLocalHost());

         // Start a service (ensure Service1 is properly defined and started)
         Service1 service1 = new Service1();
         service1.startMe();  //NEEDED to start my service1

         // Register a service with the type _http._tcp.local.
         ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "LIBRARY_S1", 50051, "path=index.html");
         jmdns.registerService(serviceInfo);
         System.out.println("Registered: " + InetAddress.getLocalHost() + ":" + serviceInfo.getPort());

         // Keep the service registered by keeping the program running
         System.out.println("Service is now registered");
         
         // Keep the program running indefinitely so then I can run my GUI properly
         while (true) {
             Thread.sleep(10000); // Sleep for a while
         }
         
     } catch (IOException e) {
         System.out.println(e.getMessage());
     } catch (InterruptedException e) {
         System.out.println("InterruptedException: " + e.getMessage());
     }
 }
}
