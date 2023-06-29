package com.business.delivery.controller;

import com.business.delivery.config.security.CustomUserDetails;
import com.business.delivery.model.*;
import com.business.delivery.repository.DistritoRepository;
import com.business.delivery.repository.PersonaRepository;
import com.business.delivery.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class ShoopingController {

    @Autowired
    private ProductoRepository productRepo;

    @Autowired
    private DistritoRepository distritoRepo;
    @Autowired
    private PersonaRepository personaRepo;

    Pedido pedidoAux = new Pedido();

    int posProducto = 0;

    Persona clienteSesion;

    double monto_total = 0;

    @GetMapping("/pedido")
    public String agregarAlPedido(@RequestParam(value = "id") int id, Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        List<Producto> productos = productRepo.findAll();
        cargarAlPedido(buscarProducto(productos, id));

        List<Distrito> distritos = distritoRepo.findAll();
        model.addAttribute("distritos", distritos);
        model.addAttribute("produc", this.pedidoAux.getListaProductosPedidos());
        model.addAttribute("pedido", this.pedidoAux);
        //model.addAttribute("client", this.clienteSesion);
        //model.addAttribute("conexion", this.conex);
        model.addAttribute("monto", this.monto_total);
        if(userDetails != null){
            String emailUser = userDetails.getUsername();
            Persona persona = personaRepo.findByEmailEnable(emailUser, 1);
            model.addAttribute("persona",persona);
        }
        return "Pedido";

    }


    private void cargarAlPedido(Producto p) {
        ProductoPedido ppAux = null;
            ProductoPedido productoPedido = null;
                System.out.println(p+" - ");
            for (ProductoPedido pp : this.pedidoAux.getListaProductosPedidos()) {
                System.out.println(pp.getProducto());
                if (pp.getProducto().getIdProducto()==p.getIdProducto()) {
                    System.out.println("Encontro Producto");
                    ppAux = pp;
                    int cant = pp.getCantidad() + 1;
                    pp.setCantidad(cant);
                    this.monto_total += p.getPrecioUnitario();
                    productoPedido = pp;
                    //this.pedidoAux.getListaProductosPedidos().remove(ppAux);
                    //this.pedidoAux.getListaProductosPedidos().add(productoPedido);
                    break;
                }
            }
            if (productoPedido == null) {
                ProductoPedido productoAux = new ProductoPedido(1, p.getPrecioUnitario(), p);
                ProductoPedidoID id = new ProductoPedidoID(p.getIdProducto());
                productoAux.setId(id);
                this.pedidoAux.addProducto(productoAux);
                this.monto_total += p.getPrecioUnitario();
             }
            /*
            if (productoPedido != null) {
                int cant = productoPedido.getCantidad() + 1;
                this.monto_total += p.getPrecioUnitario();
                productoPedido.setCantidad(cant);
                this.pedidoAux.getListaProductosPedidos().remove(ppAux);
                this.pedidoAux.getListaProductosPedidos().add(productoPedido);
            }else {
                ProductoPedido productoAux = new ProductoPedido(1, p.getPrecioUnitario(), p);
                ProductoPedidoID id = new ProductoPedidoID(p.getIdProducto());
                productoAux.setId(id);
                this.pedidoAux.addProducto(productoAux);
                this.monto_total += p.getPrecioUnitario();
            }*/

    }

    @GetMapping("/cantidad")
    public String cantidadMod(@RequestParam(value = "id") int id, @RequestParam(value = "cantidad") int cantidad, @RequestParam(value = "tipo") int tipo, Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {
        if (tipo == 1) {//resta

            for (ProductoPedido pp : this.pedidoAux.getListaProductosPedidos()) {
                if (pp.getProducto().getIdProducto() == id) {
                    int cant = pp.getCantidad() -1;
                    pp.setCantidad(cant);
                    this.monto_total -= pp.getPrecio_unitario();
                    //this.pedidoAux.getListaProductosPedidos().remove(ppAux);
                    //this.pedidoAux.getListaProductosPedidos().add(productoPedido);
                    break;
                }
            }

            /*
            int cant = this.pedidoAux.getListaProductosPedidos().get(pos).getCantidad() - 1;
            this.monto_total -= this.pedidoAux.getListaProductosPedidos().get(pos).getPrecio_unitario();
            this.pedidoAux.getListaProductosPedidos().get(pos).setCantidad(cant);*/
        } else {//suma
            for (ProductoPedido pp : this.pedidoAux.getListaProductosPedidos()) {
                System.out.println(pp.getProducto());
                if (pp.getProducto().getIdProducto()==id) {
                    int cant = pp.getCantidad() +1;
                    pp.setCantidad(cant);
                    this.monto_total += pp.getPrecio_unitario();
                    //this.pedidoAux.getListaProductosPedidos().remove(ppAux);
                    //this.pedidoAux.getListaProductosPedidos().add(productoPedido);
                    break;
                }
            }
            /*
            int cant = this.pedidoAux.getListaProductosPedidos().get(pos).getCantidad() + 1;
            this.monto_total += this.pedidoAux.getListaProductosPedidos().get(pos).getPrecio_unitario();
            this.pedidoAux.getListaProductosPedidos().get(pos).setCantidad(cant);*/
        }
        List<Distrito> distritos = distritoRepo.findAll();
        model.addAttribute("distritos", distritos);
        model.addAttribute("produc", this.pedidoAux.getListaProductosPedidos());
        model.addAttribute("pedido", this.pedidoAux);
        //model.addAttribute("client", this.clienteSesion);
        //model.addAttribute("conexion", this.conex);
        model.addAttribute("monto", this.monto_total);
        if(userDetails != null){
            String emailUser = userDetails.getUsername();
            Persona persona = personaRepo.findByEmailEnable(emailUser, 1);
            model.addAttribute("persona",persona);
        }

        return "Pedido";
    }


    public Producto buscarProducto(List<Producto> productos, int buscado) {
        Producto prod = new Producto();
        for (Producto producto : productos) {
            if (buscado == producto.getIdProducto()) {
                prod = producto;
                break;
            }
        }
        return prod;
    }

    /*
    public boolean productoRepetido(Producto p) {
        boolean rpta = false;
        for (int i = 0; i < this.pedidoAux.getListaProductosPedidos().size(); i++) {
            if (this.pedidoAux.getListaProductosPedidos().get(i).getProducto().getId_producto() == p.getId_producto()) {
                this.posProducto = i;
                rpta = true;
            }
        }
        return rpta;
    }*/

    @RequestMapping(value = "/comprar", method = RequestMethod.POST)
    public String comprarProductos(@RequestParam("distrito") String distrito, @RequestParam("direccion") String direccion, @RequestParam("tipo_pago") String tipo_pago, @RequestParam("destinatario") String destinatario, Model model, RedirectAttributes redirectAttributes, @AuthenticationPrincipal CustomUserDetails userDetails) {
        String dir = distrito + " - " + direccion;
        this.pedidoAux.setDireccion(dir);
        long now = System.currentTimeMillis();
        this.pedidoAux.setFecha_pedido(new Date(now));
        this.pedidoAux.setNombre_destinatario(destinatario);
        this.pedidoAux.setTipo_pago(tipo_pago);
        this.pedidoAux.setEstado("Pendiente");

        if(userDetails != null){
            String emailUser = userDetails.getUsername();
            Persona persona = personaRepo.findByEmailEnable(emailUser, 1);
            persona.addPedido(this.pedidoAux);
            //System.out.println(pedidoAux.toString());
            this.personaRepo.save(persona);
        }
        this.pedidoAux = new Pedido();
        this.monto_total = 0;
        redirectAttributes.addFlashAttribute("pedido", this.pedidoAux);
        redirectAttributes.addFlashAttribute("monto", this.monto_total);
        return "redirect:/";
    }


}
