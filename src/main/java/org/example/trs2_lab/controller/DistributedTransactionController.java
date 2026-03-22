package org.example.trs2_lab.controller;

import org.example.trs2_lab.dbType.DbType;
import org.example.trs2_lab.entity.Product;
import org.example.trs2_lab.repoProvider.ProductRepoProvider;
import org.example.trs2_lab.service.DistributedTransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("distributed-transaction")
public class DistributedTransactionController {
    private final DistributedTransactionService service;

    private final ProductRepoProvider provider;

    public DistributedTransactionController(DistributedTransactionService service,
                                            ProductRepoProvider provider) {
        this.service = service;
        this.provider = provider;
    }

    @ModelAttribute("mysqlProducts")
    public List<Product> mysqlProducts() {
        return provider.getRepo(DbType.MY_SQL).findAll();
    }

    @ModelAttribute("postgresProducts")
    public List<Product> postgresProducts() {
        return provider.getRepo(DbType.POSTGRES).findAll();
    }

    @RequestMapping("/")
    public String startPage() {
        return "distributed-transaction";
    }

    @RequestMapping("/execute-query")
    public String executeQuery(@RequestParam String query, Model model) {
        try {
            service.executeDistributedTransaction(query, query);
            model.addAttribute("message", "");
        } catch (RuntimeException e) {
            model.addAttribute("message", e.getMessage());
        }

        return "distributed-transaction";
    }
}
