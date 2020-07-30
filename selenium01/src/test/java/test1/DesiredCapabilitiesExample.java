package test1;

import java.util.Set;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
/*NOTE:
	Desired capabilities is mainly used for Browser configurations but most of the features 
	of this class is added to Options class so going ahead this class will be deprecated
	In Options class there is a merge method which can be used to merge the capabilityTypes of a 
	DesiredCapabilities instance*/

public class DesiredCapabilitiesExample {

	public static void main(String[] args) {
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		DesiredCapabilities cap1=new DesiredCapabilities();
		cap1.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		FirefoxOptions	opt=new FirefoxOptions();
		opt.setCapability(CapabilityType.APPLICATION_NAME, "Test1");
		
		System.out.println("Caps from DesiredCapabilities instance 'cap'="+cap.getCapabilityNames());
		System.out.println("Caps from DesiredCapabilities instance 'cap1'="+cap1.getCapabilityNames());
		System.out.println("caps from FireFoxOptions instance 'opt' before merging="+opt.getCapabilityNames());
	
		opt.merge(cap1);
		System.out.println("caps from FireFoxOptions instance 'opt' after merging 'cap1'="+opt.getCapabilityNames());
		opt.merge(cap);
		System.out.println("caps from FireFoxOptions instance 'opt' after merging 'cap'="+opt.getCapabilityNames());

		//a different constructor of DesiredCapabilities class 
		//where we can pass other capabilities instaces for merging
		DesiredCapabilities cap2=new DesiredCapabilities(cap,cap1,opt); 
		System.out.println("Caps from DesiredCapabilities instance 'cap2'="+cap2.getCapabilityNames());

		
	}

}
