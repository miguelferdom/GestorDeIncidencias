package es.urjc.code.gdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedGdi {

	@Value("${ipRedGdi}")
	private String ipRedGdi;
	
	public RedGdi () {}
	
	public RedGdi (String ipRedGdi) {
		setIpRedGdi(ipRedGdi);
	}
	
	public void setIpRedGdi (String ipRedGdi) {
		this.ipRedGdi = ipRedGdi;
	}
	
	public String getIpRedGdi () {
		return this.ipRedGdi;
	}
}