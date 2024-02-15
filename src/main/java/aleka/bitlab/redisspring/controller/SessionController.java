package aleka.bitlab.redisspring.controller;

import aleka.bitlab.redisspring.model.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SessionController {

    @GetMapping
    public String welcomePage() {
        return "Welcome Page";
    }

    @GetMapping("/session")
    public String getSesssion(HttpSession session) {
        return "session: " + session;
    }

    @GetMapping("/setup/{name}")
    public String setup(@PathVariable("name") String name, HttpSession session) {
        session.setAttribute("userName", name);
        return "redirect:/";
    }

    @GetMapping("/current-user")
    public String getCurrentUser(HttpSession session) {
        return (String) session.getAttribute("userName");
    }

    @PostMapping("/add-item")
    public String addItem(@RequestBody Product product, HttpSession session) {
        ArrayList<Product> productList;
        Object sessionObject = session.getAttribute("products");
        if (sessionObject == null) {
            productList = new ArrayList<>();
        } else {
            productList = (ArrayList<Product>) sessionObject;
        }
        productList.add(product);
        session.setAttribute("products", productList);
        return "saved";
    }

    @GetMapping("/list-item")
    public ArrayList<Product> listItems(HttpSession session) {
        ArrayList<Product> productList;
        Object sessionObject = session.getAttribute("products");
        if (sessionObject == null) {
            productList = new ArrayList<>();
        } else {
            productList = (ArrayList<Product>) sessionObject;
        }

        return productList;
    }
}
