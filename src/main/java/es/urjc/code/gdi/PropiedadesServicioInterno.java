package es.urjc.code.gdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropiedadesServicioInterno {

	@Value("${ipserviciointerno}")
	private String ipserviciointerno;
	
	public PropiedadesServicioInterno () {}
	
	public PropiedadesServicioInterno (String ipserviciointerno) {
		setIpServicioInterno(ipserviciointerno);
	}
	
	public void setIpServicioInterno (String ipserviciointerno) {
		this.ipserviciointerno = ipserviciointerno;
	}
	
	public String getIpServicioInterno () {
		return this.ipserviciointerno;
	}
	
}