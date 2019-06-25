package com.controladores;

import com.dao.EstudianteDaoEnMemoria;
import com.dao.EstudianteDaoHibernate;
import com.dao.EstudianteDaoJDBC;
import com.data.Data;
import com.idao.IEstudianteDao;
import com.modelos.Estudiantes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EstudianteController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    IEstudianteDao dao = null;

    public EstudianteController() {
        //SE INICIALIZA EL OBJETO DE ACCESO A DATOS
        dao = new EstudianteDaoHibernate();

       // Data.listaEstudiantes.add(new Estudiante(3, "juan", 23, "Santa Ana", "Masculino"));
        //Data.listaEstudiantes.add(new Estudiante(6, "Jose", 23, "San Salvador", "Masculino"));
    }

    //metodo de enrrutamiento
    //parametro segun accion "ruta"
    private void procesarRuta(String ruta, HttpServletRequest request, HttpServletResponse response) {

        if (ruta != null) {
            System.out.println("procesando ruta: " + ruta);
            try {
                switch (ruta) {
                    case "index": {
                        index(request, response);
                        break;
                    }
                    case "nuevo": {
                        nuevo(request, response);
                        break;
                    }
                    case "guardar": {
                        guardar(request, response);
                        break;
                    }
                    case "mostrarModificar": {
                        mostrarModificar(request, response);
                        break;
                    }
                    case "modificar": {
                        modificar(request, response);
                        break;
                    }
                    case "mostrarEliminar": {
                        mostrarEliminar(request, response);
                        break;
                    }
                    case "eliminar": {
                        eliminar(request, response);
                        break;
                    }
                    default: {

                        response.getWriter().println("Ruta No valida");
                    }
                }
            } catch (Exception e) {
                System.err.println("error: " + e.getMessage());
            }
        } else {

            try {
                index(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EstudianteController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    //ruta "index"
    private void index(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher d = request.getRequestDispatcher("/estudiante/index.jsp");

        List<Estudiantes> lista = dao.listar();
        request.setAttribute("listado", lista);

        d.forward(request, response);
    }
    //ruta "nuevo"

    private void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher d = request.getRequestDispatcher("/estudiante/nuevo.jsp");
        d.forward(request, response);
    }

    //ruta "guardar"
    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Data.contadorId++;
        //se obtienen los datos
        //del formulario que vienen en la peticion
        //y se crea un nuevo objeto de estudiante.
        Estudiantes e = new Estudiantes(Data.contadorId, request.getParameter("nombre"), Integer.parseInt(request.getParameter("edad")), request.getParameter("direccion"), request.getParameter("genero"));
        dao.guardar(e);

        //se regresa a la vista de registros
        index(request, response);
    }
    //ruta "guardar"

    private void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        //se obtienen los datos
        //del formulario que vienen en la peticion
        //y se crea un nuevo objeto de estudiante.
        Estudiantes e = new Estudiantes(Integer.parseInt(request.getParameter("id")), request.getParameter("nombre"), Integer.parseInt(request.getParameter("edad")), request.getParameter("direccion"), request.getParameter("genero"));

        dao.modificar(e);

        //se regresa a la vista de registros
        index(request, response);
    }
    //ruta "guardar"

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Data.contadorId++;
        //se obtienen los datos
        //del formulario que vienen en la peticion
        //y se crea un nuevo objeto de estudiante.
        Estudiantes e = dao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        
        dao.eliminar(e);

        //se regresa a la vista de registros
        index(request, response);
    }

    //ruta "mostrarModificar"
    private void mostrarModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher d = request.getRequestDispatcher("/estudiante/modificar.jsp");

        Estudiantes i = dao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("item", i);

        d.forward(request, response);
    }
    
    //ruta "mostrarEliminar"
    private void mostrarEliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher d = request.getRequestDispatcher("/estudiante/eliminar.jsp");

        Estudiantes i = dao.obtenerPorId(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("item", i);

        d.forward(request, response);
    }

    
    
    //PETICIONES-----------------------------------------------------------------------------------------------
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obteniendo parametro 
        //que contiene el valor de la ruta en la peticion
        String ruta = request.getParameter("action");
        procesarRuta(ruta, request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ruta = request.getParameter("action");
        procesarRuta(ruta, request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
