package com.esteban.springsecuritypoc.security.permisos;

public enum Permiso {
    VIEW_HOME("READHOME"),
    EDIT_HOME("EDITHOME");

    private final String permiso;

    Permiso(String permiso){
        this.permiso = permiso;
    }

    public String getPermiso() {
        return permiso;
    }
}
