package org.example.trs2_lab.controller;

import org.example.trs2_lab.dbType.DbSelectionContext;
import org.example.trs2_lab.entity.Product;
import org.example.trs2_lab.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping("/products")
public class ProductController extends AbstractDbContextController<Product>{

    private final ProductService productService;

    public ProductController(ProductService productService,
                             DbSelectionContext dbContext) {
        this.productService = productService;
        super(dbContext, "mysqlProducts",
                "postgresProducts");
    }

    @GetMapping("/by-category")
    public String findByCategory(@RequestParam Long categoryId,
                                 Model model) {
        updateRelevantTable(productService.findByCategoryId(categoryId), model);
        return "products";
    }

    @GetMapping("/by-manufacturer")
    public String findByManufacturer(@RequestParam Long manufacturerId,
                                     Model model) {
        updateRelevantTable(productService.findByManufacturerId(manufacturerId), model);
        return "products";
    }

    @GetMapping("/by-price")
    public String findByPrice(@RequestParam BigDecimal priceStart,
                              @RequestParam BigDecimal priceEnd,
                              Model model) {
        updateRelevantTable(productService.findByPriceBetween(priceStart, priceEnd), model);
        return "products";
    }
}
