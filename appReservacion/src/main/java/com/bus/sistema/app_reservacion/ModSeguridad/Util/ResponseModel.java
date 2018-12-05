package com.bus.sistema.app_reservacion.ModSeguridad.Util;

public class ResponseModel {
    public boolean response ;
    public String message ;
    public String href ;
    public String function ;

    public ResponseModel()
    {
        this.response = false;
        this.message = "Ocurrio un error inesperado";
    }

    public void SetResponse(boolean r, String m)
    {
        m="";
        this.response = r;
        this.message = m;

        if (!r && m == "") this.message = "Ocurrio un error inesperado";
    }

    public boolean isResponse() {
        return response;
    }

    public void setResponse(boolean response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
