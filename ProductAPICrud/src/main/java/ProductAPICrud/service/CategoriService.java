package ProductAPICrud.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import ProductAPICrud.Repository.CategoriRepository;
import ProductAPICrud.bean.Categorie;

import java.util.Optional;
@Service
public class CategoriService {
	
	@Autowired
	private CategoriRepository categorirepository;

	  
	public List<Categorie> getCategories(){
        return categorirepository.findAll();
    }
	
    public Categorie getCategory(int id) throws NotFoundException{
        Optional<Categorie> country = categorirepository.findById(id);
        if(!country.isPresent())
                throw new NotFoundException();
        return country.get();
    }
    
    public Categorie getCategory(Categorie categorie){
        return categorirepository.save(categorie);
    }
    
	/*
	 * public Categorie updateCountry(int id,Categorie country){
	 * Categorie.setCountryId(id); return categorirepository.save(country); }
	 */
    
    public void deleteCategory(int id){
    	categorirepository.deleteById(id);
    }

	public Categorie updateCategory(int id, Categorie categories) {
		//Categorie.
        return categorirepository.save(categories);
		 
	}
    
    
}






	

	 


