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
    	model.addAttribute("coches", cr.findByOrderByModeloAsc());
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        model.addAttribute("type", "asc");
        return "index";
    }
    
    @GetMapping("/desc")
    public String listaUsuariosDesc(Model model){
    	model.addAttribute("coches", cr.findByOrderByModeloDesc());
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
    public String verVendedor(@PathVariable long id, Model model){
    	Optional<Vendedor> v = vr.findById(id);
    	model.addAttribute("vendedor", v.get());
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
            return "redirect:/vendedores";
        }
    }
    
    @GetMapping("/borrar/{id}")
    public String borrar(@PathVariable long id, Model model){
    	Optional<Coche> c = cr.findById(id);
    	cr.delete(c.get());
        return "redirect:/";
    }
    
    @GetMapping("/borrarMarca/{id}")
    public String borrarMarca(@PathVariable long id, Model model){
    	List<Coche> cl = cr.findAll();
    	for (Coche c : cl) {
    		//Si se borra una marca de coches, guardar los coches de dicha marca no tendría sentido
    		if (c.getIdmarca() == id) cr.delete(c);
    	}
    	Optional<Marca> m = mr.findById(id);
    	mr.delete(m.get());
        return "redirect:/marcas";
    }
    
    @GetMapping("/borrarVendedor/{id}")
    public String borrarVendedor(@PathVariable long id, Model model){
    	List<Coche> cl = cr.findAll();
    	for (Coche c : cl) {
    		if (c.getIdvendedor() == id) c.setIdvendedor(0);
    		cr.save(c);
    	}
    	Optional<Vendedor> v = vr.findById(id);
    	vr.delete(v.get());
        return "redirect:/vendedores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable long id, Model model){
    	Optional<Coche> c = cr.findById(id);
    	model.addAttribute("coche", c.get());
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        return "editar";
    }
    
    @GetMapping("/editarMarca/{id}")
    public String editarMarca(@PathVariable long id, Model model){
    	Optional<Marca> m = mr.findById(id);
    	model.addAttribute("marca", m.get());
        return "editarMarca";
    }
    
    @GetMapping("/editarVendedor/{id}")
    public String editarVendedor(@PathVariable long id, Model model){
    	Optional<Vendedor> v = vr.findById(id);
    	model.addAttribute("vendedor", v.get());
        return "editarVendedor";
    }
     
    @PostMapping("/actualizar")
    public String actualizar(Coche coche, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
        	return "redirect:/";
        }
        Optional<Coche> sl = cr.findById(coche.getIdcoche());
        Coche newCar = sl.get();
        newCar.setModelo(coche.getModelo());
        newCar.setIdmarca(coche.getIdmarca());
        newCar.setAnyofabricacion(coche.getAnyofabricacion());
        newCar.setPrecio(coche.getPrecio());
        newCar.setMoneda(coche.getMoneda());
        newCar.setIdvendedor(coche.getIdvendedor());
        cr.save(coche);
        return "redirect:/";
    }
    
    @PostMapping("/actualizarMarca")
    public String actualizarMarca(Marca marca, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("marcas", mr.findAll());
            return "redirect:/marcas";
        }
        Optional<Marca> m = mr.findById(marca.getIdmarca());
        Marca newBrand = m.get();
        newBrand.setIdmarca(marca.getIdmarca());
        newBrand.setNombremarca(marca.getNombremarca());
        newBrand.setFundacion(marca.getFundacion());
        newBrand.setPatrimonio(marca.getPatrimonio());
        newBrand.setMoneda(marca.getMoneda());
        mr.save(newBrand);
        return "redirect:/marcas";
    }
    
    @PostMapping("/actualizarVendedor")
    public String actualizarVendedor(Vendedor vendedor, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "redirect:/vendedores";
        }
        Optional<Vendedor> v = vr.findById(vendedor.getIdvendedor());
        Vendedor newSeller = v.get();
        newSeller.setIdvendedor(vendedor.getIdvendedor());
        newSeller.setNombre(vendedor.getNombre());
        newSeller.setApellidos(vendedor.getApellidos());
        newSeller.setFechanacimiento(vendedor.getFechanacimiento());
        newSeller.setDni(vendedor.getDni());
        newSeller.setCargo(vendedor.getCargo());
        vr.save(newSeller);
        return "redirect:/vendedores";
    }
    
    @GetMapping("/students/{id}")
    public String estudiantePorId(@PathVariable long id, Model model){
    	model.addAttribute("coches", cr.findByID(id));
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/year/{year}")
    public String estudiantePorAño(@PathVariable int year, Model model){
    	model.addAttribute("coches", cr.findByYear(year));
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/manufactureYear/{year}")
    public String estudiantePorAñoFabricacion(@PathVariable int year, Model model){
    	model.addAttribute("coches", cr.findByYear(year));
        model.addAttribute("marcas", mr.findAll());
        model.addAttribute("vendedores", vr.findAll());
        model.addAttribute("type", "base");
        return "index";
    }
    
    @GetMapping("/marcas/{id}")
    public String marcaPorId(@PathVariable long id, Model model){
    	model.addAttribute("marcas", mr.findByID(id));
        return "marcas";
    }
    
    @GetMapping("/vendedores/{id}")
    public String vendedorPorId(@PathVariable long id, Model model){
    	model.addAttribute("vendedores", vr.findByID(id));
        return "vendedores";
    }
    
    @GetMapping("/patrimony/{money}")
    public String hechizoPorPoder(@PathVariable int money, Model model){
    	model.addAttribute("marcas", mr.findByPatrimonio(money));
        return "hechizos";
    }
    
    @GetMapping("/nombre/{name}")
    public String hechizoPorNivel(@PathVariable String name, Model model){
    	model.addAttribute("marcas", mr.findByNombre(name));
        return "hechizos";
    }
}