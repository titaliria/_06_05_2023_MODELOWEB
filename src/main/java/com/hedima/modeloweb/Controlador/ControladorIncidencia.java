package com.hedima.modeloweb.controlador;

import com.hedima.modeloweb.modelo.Incidencia;
import com.hedima.modeloweb.servicio.IincidenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


public class ControladorIncidencia {
    @Controller
    @RequestMapping("/incidencia")
    public class ControladorIncidencia {
        @Autowired
        private IincidenciaServicio servicio;

        @GetMapping
        public String mostrarTodos(Model modelo) {
            List<Incidencia> incidencia = servicio.consultarTodos();
            modelo.addAttribute("incidencia", incidencia);
            return "mostrar";

        }

        @GetMapping("/formulario")
        public String mostrarFormulario(Model modelo) {
            Incidencia incidencia = new Incidencia();
            modelo.addAttribute("incidencia", incidencia);
            return "formulario";
        }

        @PostMapping("/alta")
        public String guardarIncidencia(Incidencia i, RedirectAttributes ra) {
            Incidencia i1 = servicio.crear(i);
            System.out.println(i1.toString());
            return "redirect:/incidencia";
        }

        @GetMapping("/eliminar/{id}")
        public String eliminarIncidencia(@PathVariable("id")Integer.id) {
            servicio.eliminar(id);

            return "rediret:/incidencia";
        }
        @GetMapping("/modificar/{id}")
        public String modificarMenu(@PathVariable("id") Integer id, Model modelo){
            Incidencia incidencia = servicio.consultarUno(id);
            modelo.addAttribute("incidencia",incidencia);
            return "formulario";
        }
    }


}
