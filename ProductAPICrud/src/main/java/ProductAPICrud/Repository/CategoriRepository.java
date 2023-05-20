package ProductAPICrud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProductAPICrud.bean.Categorie;

public interface CategoriRepository extends JpaRepository<Categorie,Integer> {

}
