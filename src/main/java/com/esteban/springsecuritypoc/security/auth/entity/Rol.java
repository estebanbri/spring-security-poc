package com.esteban.springsecuritypoc.security.auth.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NOMBRE", unique = true, nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "ENABLED", columnDefinition = "number(1,0)")
    private Boolean isEnabled;

    @OneToMany(mappedBy = "rol", cascade=CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.TRUE)
    private List<Usuario> usuarios;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ROL_PERMISO",
            joinColumns =
                    { @JoinColumn(name = "id_rol", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "id_permiso", table = "permiso", referencedColumnName = "id")}
    )
    private Set<Permiso> permisos = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }
}
