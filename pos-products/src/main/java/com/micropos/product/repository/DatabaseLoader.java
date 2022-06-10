package com.micropos.product.repository;

import com.micropos.product.model.Product;
import com.micropos.product.service.ProductServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader {

    @Bean
    CommandLineRunner init(ProductRepository repository) throws IOException {

		return args -> {
			repository.save(new Product(1, "计算机软件硬件网络工程师运维电气工程师JAVA程序员电脑编程平面设计电子商务师考试IT证书考证培训 黑龙江省 详情咨询客服", 100, "https://img14.360buyimg.com/n1/s200x200_jfs/t1/84804/13/28175/280846/62739cf4E5ef93f8c/70ab7ace2fc353ca.jpg"));
			repository.save(new Product(2, "Java从入门到精通（第6版）（软件开发视频大讲堂） 图书嗨购日,品质好书每满100减50,满减叠券享600减400!(团购电话4006186622)点击", 80, "https://img13.360buyimg.com/n1/s200x200_jfs/t1/186038/9/7947/120952/60bdd993E41eea7e2/48ab930455d7381b.jpg"));
			repository.save(new Product(3, "Java核心技术 第11版 套装共2册 图书嗨购日,品质好书每满100减50,满减叠券享600减400!(团购电话4006186622)点击", 149, "https://img10.360buyimg.com/n1/s200x200_jfs/t1/146172/4/7453/357315/5f5099a8E331a2969/e8c60e5068541c7d.jpg"));
		};
	}
}
