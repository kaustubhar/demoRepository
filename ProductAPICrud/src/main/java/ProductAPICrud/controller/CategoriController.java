package ProductAPICrud.controller;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProductAPICrud.bean.Categorie;
import ProductAPICrud.service.CategoriService;
@RestController

public class CategoriController {
	
	@Autowired
	private CategoriService categoriservice;
	
	@GetMapping("/api/categories")
    public List<Categorie> getCategories(){
        return categoriservice.getCategories();
    }
	
    @GetMapping("api/categories/{id}")
    public Categorie getCategory(@PathVariable int id) throws NotFoundException{
        return categoriservice.getCategory(id);
    }
    
    @PostMapping("api/categories")
    public Categorie addCategori(@RequestBody Categorie categorie){
        return categoriservice.getCategory(categorie);
    }
    @PutMapping("api/categories/{id}")
    public Categorie updateCategory(@PathVariable int id,@RequestBody Categorie categorie){
        return categoriservice.updateCategory(id,categorie);
    }
    @DeleteMapping("api/categories/{id}")
    public void deleteCategory(@PathVariable int id){
    	categoriservice.deleteCategory(id);
    }
	
	
	 
}
