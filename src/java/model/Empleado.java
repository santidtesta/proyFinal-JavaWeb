/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Santino
 */
public class Empleado {
    private int id;
    private String nombre;
    private String depto;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String depto) {
        this.id = id;
        this.nombre = nombre;
        this.depto = depto;
    }

    public Empleado(String nombre, String depto) {
        this.nombre = nombre;
        this.depto = depto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", depto=" + depto + '}';
    }
    
    
}
