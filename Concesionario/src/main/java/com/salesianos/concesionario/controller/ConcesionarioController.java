package com.salesianos.concesionario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianos.concesionario.model.Vendedor;
import com.salesianos.concesionario.model.Marca;
import com.salesianos.concesionario.model.Coche;
import com.salesianos.concesionario.repository.MarcasRepository;
import com.salesianos.concesionario.repository.VendedoresRepository;
import com.salesianos.concesionario.repository.CochesRepository;

//Falta ser refactorizado
@Controller
public class ConcesionarioController {
 
    @Autowired
    private CochesRepository cr;

    @Autowired
    private MarcasRepository mr;
 
    @Autowired
    private VendedoresRepository vr;
 
    @GetMapping("/")
    public String listaUsuarios(Model model){
    	model.addAttribute("coches", cr.findAll());
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/asc")
    public String listaUsuariosAsc(Model model){
    	model.addAttribute("coches", cr.findByOrderByFullnameAsc());
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        model.addAttribute("type", "asc");
        return "index";
    }
    
    @GetMapping("/desc")
    public String listaUsuariosDesc(Model model){
    	model.addAttribute("users", cr.findByOrderByFullnameDesc());
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        model.addAttribute("type", "desc");
        return "index";
    }
    
    @GetMapping("/marcas")
    public String listaMarcas(Model model){
    	model.addAttribute("marcas", mr.findAll());
        return "marcas";
    }
    
    @GetMapping("/verMarca/{id}")
    public String verMarca(@PathVariable long id, Model model){
    	Optional<Marca> m = mr.findById(id);
    	model.addAttribute("marca", m.get());
        return "verMarca";
    }
    
    @GetMapping("/vendedores")
    public String listaVendedores(Model model){
    	model.addAttribute("vendedores", vr.findAll());
        return "vendedores";
    }
    
    @GetMapping("/verVendedor/{id}")
    public String verHechizo(@PathVariable long id, Model model){
    	Optional<Vendedor> v = vr.findById(id);
    	model.addAttribute("spell", v.get());
        return "verVendedor";
    }
    
    @GetMapping("/buscar")
    public String buscarCoPorMa(String nomMarca, Model model) {
    	model.addAttribute("coPorMa", mr.cochesPorMarca(nomMarca.toUpperCase()));
		return "cochesPorMarca";
    }
 
    @GetMapping("/add")
    public String nuevo(Model model){
    	model.addAttribute("coche", new Coche());
    	model.addAttribute("marcas", mr.findAll());
    	model.addAttribute("vendedores", vr.findAll());
        return "nuevo";
    }
    
    @GetMapping("/addMarca")
    public String nuevaMarca(Model model){
    	model.addAttribute("marca", new Marca());
        return "nuevaMarca";
    }
    
    @GetMapping("/addVendedor")
    public String nuevoVendedor(Model model){
    	model.addAttribute("vendedor", new Vendedor());
        return "nuevoVendedor";
    }
    
    @PostMapping("/crear")
    public String crear(Coche coche,
            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/add";
        }else{
        	cr.save(coche);
        	model.addAttribute("coches", cr.findAll());
            model.addAttribute("marcas", mr.findAll());
            model.addAttribute("vendedores", vr.findAll());
            return "redirect:/";
        }
    }
    
    @PostMapping("/crearMarca")
    public String crearMarca(Marca marca,
            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/addMarca";
        }else{
        	mr.save(marca);
        	model.addAttribute("marcas", mr.findAll());
            return "redirect:/marcas";
        }
    }
    
    @PostMapping("/crearVendedor")
    public String crearVendedor(Vendedor vendedor,
            BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/addVendedor";
        }else{
        	vr.save(vendedor);
        	model.addAttribute("vendedores", vr.findAll());
            return "redirect:/vendedores";
        }
    }
    
    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable long id, Model model){
    	Optional<Coche> c = cr.findById(id);
    	cr.delete(c.get());
        model.addAttribute("coches", cr.findAll());
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        return "redirect:/";
    }
    
    @GetMapping("/borrarMarca/{id}")
    public String borrarMarca(@PathVariable long id, Model model){
    	List<Marca> sl = mr.findAll();
    	for (Marca st : sl) {
    		if (st.getSpellknown() == id) st.setSpellknown(0);
    		hr.save(st);
    	}
    	Optional<Spell> sp = sr.findById(id);
    	sr.delete(sp.get());
        model.addAttribute("spells", sr.findAll());
        return "redirect:/spells";
    }
    
    @GetMapping("/borrarVendedor/{id}")
    public String borrarVendedor(@PathVariable long id, Model model){
    	List<Student> sl = hr.findAll();
    	for (Student st : sl) {
    		if (st.getSpellknown() == id) st.setSpellknown(0);
    		hr.save(st);
    	}
    	Optional<Spell> sp = sr.findById(id);
    	sr.delete(sp.get());
        model.addAttribute("spells", sr.findAll());
        return "redirect:/spells";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable long id, Model model){
    	Optional<Student> st = hr.findById(id);
    	model.addAttribute("student", st.get());
    	model.addAttribute("spells", sr.findAll());
        return "editar";
    }
    
    @GetMapping("/editarHechizo/{id}")
    public String editarHechizo(@PathVariable long id, Model model){
    	Optional<Spell> sp = sr.findById(id);
    	model.addAttribute("spell", sp.get());
        return "editarHechizo";
    }
     
    @PostMapping("/actualizar")
    public String actualizar(Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
        	model.addAttribute("users", hr.findAll());
            model.addAttribute("spells", sr.findAll());
        return "redirect:/";
        }
        Optional<Student> sl = hr.findById(student.getIdstudent());
        Student user = sl.get();
        user.setFullname(student.getFullname());
        user.setDni(student.getDni());
        user.setEmail(student.getEmail());
        user.setDni(student.getDni());
        user.setIsmuggle(student.getIsmuggle());
        user.setMatriculationdate(student.getMatriculationdate());
        user.setBirthdate(student.getBirthdate());
        user.setGender(student.getGender());
        user.setSpellknown(student.getSpellknown());
        hr.save(user);
        model.addAttribute("users", hr.findAll());
        model.addAttribute("spells", sr.findAll());
        return "redirect:/";
    }
    
    @PostMapping("/actualizarHechizo")
    public String actualizarHechizo(Spell spell, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("spells", sr.findAll());
            return "redirect:/spells";
        }
        Optional<Spell> sp = sr.findById(spell.getIdspell());
        Spell newSpell = sp.get();
        newSpell.setSpellname(spell.getSpellname());
        newSpell.setSpelldescription(spell.getSpelldescription());
        newSpell.setType(spell.getType());
        newSpell.setLevel(spell.getLevel());
        newSpell.setDamage(spell.getDamage());
        newSpell.setIslethal(spell.getIslethal());
        sr.save(newSpell);
        model.addAttribute("spells", sr.findAll());
        return "redirect:/spells";
    }
    
    @GetMapping("/students/{id}")
    public String estudiantePorId(@PathVariable long id, Model model){
    	model.addAttribute("users", hr.findByID(id));
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/year/{year}")
    public String estudiantePorAño(@PathVariable int year, Model model){
    	model.addAttribute("users", hr.findByYear(year));
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/birthyear/{year}")
    public String estudiantePorAñoNacimiento(@PathVariable int year, Model model){
    	model.addAttribute("users", hr.findByBirthYear(year));
        model.addAttribute("spells", sr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/spells/{id}")
    public String hechizoPorId(@PathVariable long id, Model model){
    	model.addAttribute("spells", sr.findByID(id));
        return "hechizos";
    }
    
    @GetMapping("/power/{dmg}")
    public String hechizoPorPoder(@PathVariable int dmg, Model model){
    	model.addAttribute("spells", sr.findByDmg(dmg));
        return "hechizos";
    }
    
    @GetMapping("/level/{lvl}")
    public String hechizoPorNivel(@PathVariable int lvl, Model model){
    	model.addAttribute("spells", sr.findByLevel(lvl));
        return "hechizos";
    }
}