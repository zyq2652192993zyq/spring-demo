package com.ebay.ace.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebay.ace.demo.entiry.Node;
import com.ebay.ace.demo.entiry.Param;
import com.ebay.ace.demo.mapper.NodeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService extends ServiceImpl<NodeMapper, Node> {
    // Business logic methods

    public Node readNode(Long id) {
        Node node = this.getById(id);
        System.out.println("Node ID: " + node.getId() + ", Name: " + node.getName() + ", Parameters: " + node.getParameters());
        // Access the List<Param> directly
        List<Param> paramList = node.getParameters();
        for (Param param : paramList) {
            System.out.println("Param ID: " + param.getId() + ", Description: " + param.getDesc());
        }

        return node;
    }

    public Long insertNode(Node node) {
        // Access the List<Param> directly
        List<Param> paramList = node.getParameters();
        for (Param param : paramList) {
            System.out.println("Param ID: " + param.getId() + ", Description: " + param.getDesc());
        }

        return this.save(node) ? node.getId() : null;
    }
}
