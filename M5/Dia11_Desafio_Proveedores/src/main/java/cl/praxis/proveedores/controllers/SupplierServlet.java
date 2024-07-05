package cl.praxis.proveedores.controllers;

import cl.praxis.proveedores.models.SupplierDTO;
import cl.praxis.proveedores.services.SupplierService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

@WebServlet(name = "supplierServlet", value = "/supplier_servlet")
public class SupplierServlet extends HttpServlet {
    private SupplierService supplierService;

    public void init() {
        supplierService = new SupplierService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            int id = Integer.parseInt(request.getParameter("id"));

            if (action.equals("delete")) {
                supplierService.deleteSupplier(id);
                response.sendRedirect(request.getContextPath() + "/supplier_servlet");
                return;
            } else if (action.equals("edit")) {
                request.setAttribute("supplier", supplierService.getSupplierById(id));
            }
        }

        request.setAttribute("suppliers", supplierService.getAllSuppliers());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id").isEmpty() ? "0" : request.getParameter("id"));
        String name = request.getParameter("name");
        String rut = request.getParameter("rut");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String contact = request.getParameter("contact");
        int contactPhone = Integer.parseInt(request.getParameter("contactPhone"));

        String isActiveStr = request.getParameter("isActive");

        boolean isActive;

        if (isActiveStr == null)
            isActive = false;
        else
            isActive = isActiveStr.equals("on")? true: false;

        if (id == 0)
            supplierService.addSupplier(new SupplierDTO(id, name, rut, address, email, phone, contact, contactPhone, isActive));
        else
            supplierService.updateSupplier(new SupplierDTO(id, name, rut, address, email, phone, contact, contactPhone, isActive));

        //doGet(req, resp);
        response.sendRedirect(request.getContextPath() + "/supplier_servlet");
    }

}
