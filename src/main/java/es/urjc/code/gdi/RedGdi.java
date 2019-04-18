package es.urjc.code.gdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedGdi {

	@Value("${ipredgdi}")
	private String ipredgdi;
	
	public RedGdi () {}
	
	public RedGdi (String ipredgdi) {
		setIpRedGdi(ipredgdi);
	}
	
	public void setIpRedGdi (String ipredgdi) {
		this.ipredgdi = ipredgdi;
	}
	
	public String getIpRedGdi () {
		return this.ipredgdi;
	}
}