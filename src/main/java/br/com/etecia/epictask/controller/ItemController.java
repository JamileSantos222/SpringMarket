package br.com.etecia.epictask.controller;

import br.com.etecia.epictask.model.Item;
import br.com.etecia.epictask.repository.ItemRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class ItemController {

    private final ItemRepository itemRepo;

    public ItemController(ItemRepository itemRepo) {
        this.itemRepo = itemRepo;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("itens", itemRepo.findAll());
        model.addAttribute("item", new Item());
        return "index";
    }

    @PostMapping("/adicionar")
    public String adicionar(Item item) {
        itemRepo.save(item);
        return "redirect:/";
    }

    @GetMapping("/comprar/{id}")
    public String marcarComoComprado(@PathVariable Long id) {
        var item = itemRepo.findById(id).orElse(null);
        if (item != null) {
            item.setComprado(!item.isComprado());
            itemRepo.save(item);
        }
        return "redirect:/";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        itemRepo.deleteById(id);
        return "redirect:/";
    }
}
