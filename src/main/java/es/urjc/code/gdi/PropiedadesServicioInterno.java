package es.urjc.code.gdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropiedadesServicioInterno {

	@Value("${ipServicioInterno}")
	private String ipServicioInterno;
	
	public PropiedadesServicioInterno () {}
	
	public PropiedadesServicioInterno (String ipServicioInterno) {
		setIpServicioInterno(ipServicioInterno);
	}
	
	public void setIpServicioInterno (String ipServicioInterno) {
		this.ipServicioInterno = ipServicioInterno;
	}
	
	public String getIpServicioInterno () {
		return this.ipServicioInterno;
	}
	
}