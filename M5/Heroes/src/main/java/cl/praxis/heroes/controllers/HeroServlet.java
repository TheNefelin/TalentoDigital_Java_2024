package cl.praxis.heroes.controllers;

import cl.praxis.heroes.models.ClassDTO;
import cl.praxis.heroes.models.GenderDTO;
import cl.praxis.heroes.models.HeroDTO;
import cl.praxis.heroes.models.UserDTO;
import cl.praxis.heroes.services.imp.ClassService;
import cl.praxis.heroes.services.imp.GenderService;
import cl.praxis.heroes.services.imp.HeroService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "heroServlet", value = "/hero-servlet")
public class HeroServlet extends HttpServlet {
    ClassService classService = new ClassService();
    GenderService genderService = new GenderService();
    HeroService heroService = new HeroService();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ClassDTO> classList = classService.getAllClass();
        List<GenderDTO> genderList = genderService.getAllGender();
        List<HeroDTO> listHero = heroService.getAllHero();

        req.setAttribute("classList", classList);
        req.setAttribute("genderList", genderList);
        req.setAttribute("listHero", listHero);

        req.getRequestDispatcher("hero.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String idClassStr = req.getParameter("id_class");
        String idGenderStr = req.getParameter("id_gender");

        int id_class = 0;
        if (idClassStr != null)
            id_class = Integer.parseInt(idClassStr);

        int id_gender = 0;
        if (idGenderStr != null)
            id_gender = Integer.parseInt(idGenderStr);

        HttpSession session = req.getSession();
        UserDTO user = (UserDTO) session.getAttribute("user");

        if (user != null && name != null && id_class > 0 && id_gender > 0) {
            ClassDTO classDTO = new ClassDTO();
            classDTO.setId(id_class);

            GenderDTO genderDTO = new GenderDTO();
            genderDTO.setId(id_gender);

            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());

            HeroDTO hero = new HeroDTO();
            hero.setName(name);
            hero.setClase(classDTO);
            hero.setGender(genderDTO);
            hero.setUser(userDTO);

            heroService.addHero(hero);
        }

        doGet(req, resp);
    }
}
