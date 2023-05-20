package ProductAPICrud.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import ProductAPICrud.Repository.ProductRepository;
import ProductAPICrud.bean.Categorie;
import ProductAPICrud.bean.Product;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            calculateFinalPrice(product);
        }
        return products;
    }

    public Product getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    public Product createProduct(Product product) {
        calculateFinalPrice(product);
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            updatedProduct.setProductId(productId);
            calculateFinalPrice(updatedProduct);
            return productRepository.save(updatedProduct);
        } else {
            return null;
        }
    }

    public boolean deleteProduct(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            productRepository.delete(productOptional.get());
            return true;
        } else {
            return false;
        }
    }

    private void calculateFinalPrice(Product product) {
        BigDecimal discount = product.getBasePrice().multiply(product.getDiscount().divide(BigDecimal.valueOf(100)));
        BigDecimal Price = product.getBasePrice().subtract(discount);
        BigDecimal gst = Price.multiply(product.getGst().divide(BigDecimal.valueOf(100)));
        BigDecimal deliveryCharge = product.getDeliveryCharge();
        BigDecimal finalPrice =Price.add(gst).add(deliveryCharge);

        product.setDiscount(discount);
        product.setGst(gst);
        product.setDeliveryCharge(deliveryCharge);
        product.setFinalPrice(finalPrice);
    }
}



