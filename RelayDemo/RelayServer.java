import ClientAndServer.*;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.io.*;


class HelloServant extends HelloWorldPOA {
    
    public String hello_world() {
	System.out.println("hello_world called by relay.  Replying with message..");
	
	return "\nHello World!!\n";
    }
}


public class RelayServer {
    
    public static void main(String args[]) {
	try {
	    // create and initialize the ORB
	    ORB orb = ORB.init(args, null);
	    
	    // get reference to rootpoa & activate the POAManager
	    POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
	    rootpoa.the_POAManager().activate();
	    
	    // create servant and register it with the ORB
	    HelloServant helloRef = new HelloServant();
	    
	    // get the 'stringified IOR'
	    org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloRef);
	    String stringified_ior = orb.object_to_string(ref);
	    
    	    // Save IOR to file
            BufferedWriter out = new BufferedWriter(new FileWriter("server.ref"));
            out.write(stringified_ior);
	    out.close();
	    
	    // wait for invocations from clients
	    System.out.println("Server started.  Waiting for clients...");
	    orb.run();
	    
	} catch (Exception e) {
	    System.err.println("ERROR: " + e);
	    e.printStackTrace(System.out);
	}
    }
}

