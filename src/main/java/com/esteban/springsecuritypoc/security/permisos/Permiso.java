package com.esteban.springsecuritypoc.security.permisos;

public enum Permiso {
    ALUMNO_READ("alumno:read"),
    ALUMNO_WRITE("alumno:write"),
    CURSO_READ("curso:read"),
    CURSO_WRITE("curso:write");

    private final String permiso;

    Permiso(String permiso){
        this.permiso = permiso;
    }

    public String getPermiso() {
        return permiso;
    }
}
