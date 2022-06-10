package com.micropos.product.service;

import com.micropos.product.model.Product;
import com.micropos.product.repository.ProductRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

//    private List<Product> products = null;

    @Resource
    private ProductRepository productRepository;

//    public ProductServiceImpl(@Autowired ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public List<Product> products() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Product randomProduct() {
        return null;
    }


//    public static List<Product> parseJD(String keyword) throws IOException {
//        String url = "https://search.jd.com/Search?keyword=" + keyword;
//        Document document = Jsoup.parse(new URL(url), 1000);
//        Element element = document.getElementById("J_goodsList");
//        Elements elements = element.getElementsByTag("li");
//        List<Product> list = new ArrayList<>();
//
//        for (Element el : elements) {
//            String id = el.attr("data-spu");
//            String img = "https:".concat(el.getElementsByTag("img").eq(0).attr("data-lazy-img"));
//            String price = el.getElementsByAttribute("data-price").text();
//            String title = el.getElementsByClass("p-name").eq(0).text();
//            if (title.indexOf("，") >= 0)
//                title = title.substring(0, title.indexOf("，"));
//
//            Product product = new Product(id, title, Double.parseDouble(price), img);
//            list.add(product);
//        }
//        return list;
//    }
}
