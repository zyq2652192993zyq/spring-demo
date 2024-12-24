package com.ebay.ace.demo.controller;

import com.ebay.ace.demo.entiry.Node;
import com.ebay.ace.demo.entiry.Param;
import com.ebay.ace.demo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private NodeService nodeService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/node")
    public Long createNode(@RequestParam("name") String name, @RequestBody List<Param> param) {
        Node n = new Node();
        n.setName(name);
        n.setParameters(param);
        return nodeService.insertNode(n);
    }

    @GetMapping("/node/{id}")
    public Node readNode(@PathVariable("id") Long id) {
        return nodeService.readNode(id);
    }
}
