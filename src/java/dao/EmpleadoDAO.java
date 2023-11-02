/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import model.Empleado;

/**
 *
 * @author Santino
 */
public interface EmpleadoDAO {

    // Guardar Empleado
    int save(Empleado empleado);

    // Editar empleado
    int update(Empleado empleado);

    // Borrar empleado
    int delete(int idEmpleado);

    // Obtener lista de empleados
    List<Empleado> getAll();

    // Obtener por ID
    Empleado getById(int idEmpleado);
    
    List buscar(String texto);
}
