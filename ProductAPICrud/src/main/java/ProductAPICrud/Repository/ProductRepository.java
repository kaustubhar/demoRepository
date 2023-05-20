package ProductAPICrud.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ProductAPICrud.bean.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
