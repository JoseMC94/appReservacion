package com.bus.sistema.app_reservacion.ModSeguridad.Util;

public class DTOPersonaSearch {

    int value ;
    String nombrePersonaMostrar;
    String referencia;

    public DTOPersonaSearch(int value, String nombrePersonaMostrar, String referencia) {
        this.value = value;
        this.nombrePersonaMostrar = nombrePersonaMostrar + "referencia: "+referencia;
    }
}
