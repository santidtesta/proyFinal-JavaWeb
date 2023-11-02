/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.EmpleadoDAO;
import dao.EmpleadoDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empleado;
import util.DBConnection;

/**
 *
 * @author Santino
 */
@WebServlet(name = "EmpleadoController", urlPatterns = {"/EmpleadoController"})
public class EmpleadoController extends HttpServlet {

    EmpleadoDAO empleadoDao = new EmpleadoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.isEmpty()) {
            //Ir a la lista
            listarEmpleados(request, response);
        } else {
            switch (accion) {
                case "nuevo":
                    nuevoEmpleado(request, response);
                    break;
                case "edit":
                    editEmpleado(request, response);
                    break;
                case "delete":
                    deleteEmpleado(request, response);
                    break;
                case "Buscar":
                    String dato = request.getParameter("txtBuscar");
                    List<Empleado> lista = empleadoDao.buscar(dato);
                    request.setAttribute("list", lista);
                    request.getRequestDispatcher("list.jsp").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado empleado = null;
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String depto = request.getParameter("depto");
        if (id == null || id.isEmpty()) {
            //insert
            empleado = new Empleado(nombre, depto);

            System.out.println(empleado);
            empleadoDao.save(empleado);
            listarEmpleados(request, response);
        } else {
            empleado = new Empleado(Integer.parseInt(id), nombre, depto);
            empleadoDao.update(empleado);

//            empleado = new Empleado(Integer.parseInt(id), nombre, dpto);
//            empleadoDao.update(empleado);
            listarEmpleados(request, response);
        }
    }

    private void listarEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empleado> list = new ArrayList<>();
        list = empleadoDao.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request, response);

    }

    private void nuevoEmpleado(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("form-empleado.jsp");
    }

    private void editEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Empleado empleado;
        int id = Integer.parseInt(request.getParameter("id"));

        empleado = empleadoDao.getById(id);

        request.setAttribute("empleado", empleado);

        request.getRequestDispatcher("form-empleado.jsp").forward(request, response);
    }

    private void deleteEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        empleadoDao.delete(id);
        listarEmpleados(request, response);

    }

//    private void buscarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String dato = request.getParameter("txtBuscar");
//        List<Empleado> lista = empleadoDao.buscar(dato);
//        request.setAttribute("datos", lista);
//        request.getRequestDispatcher("list.jsp").forward(request, response);
//    }
}
