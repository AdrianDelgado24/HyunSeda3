package co.com.hyunsedaProduct;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.CategoryEntity;
import co.com.hyunsedaProduct.infrastructure.output.persistence.entity.ProductEntity;
import co.com.hyunsedaProduct.infrastructure.output.persistence.repository.IProductRepository;
@SpringBootTest
class HyunSedaProductTests {
    @Autowired
    private IProductRepository repo;

    @Test
    public void testCreateProductEntity() {
        long productId = -1;

        String productName = "Bufanda turquesa"; /* Nombre del producto. */

        String productDescripcion = " Hecha a mano con hilos de seda devanados y burdo"; /* Descripción del producto. */

        double productPrice = 20000; /* Precio del producto. */

        long productStock = 1; /* Stock disponible del producto. */

        String keywords = ""; /* Palabras clave relacionadas con el producto. */

        String productCaracteristc = "Elaborada a mano"; /* Características del producto. */

        String productPhoto = "https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/thumbnail_product-10-image-2-053b771e-b32f-4ba1-8952-db0a5f10182d.jpg";

        int categoryId = 2;

        String categoryName = "Bufandas";

        List<ProductEntity> products = new ArrayList<ProductEntity>();

        CategoryEntity category = new CategoryEntity(categoryId, categoryName, products);

        List<CategoryEntity> categories = new ArrayList<CategoryEntity>();

        ProductEntity newProd = new ProductEntity(productId, productName, productDescripcion, productPrice,
                productStock, keywords, productCaracteristc, productPhoto, categories);

        products.add(newProd);

        category.setProducts(products);

        categories.add(category);

        newProd.setCategories(categories);

        ProductEntity savedProd = repo.save(newProd);

        assertThat(savedProd).isNotNull();

        assertThat(savedProd.getProductId()).isGreaterThan(0);
    }

}
