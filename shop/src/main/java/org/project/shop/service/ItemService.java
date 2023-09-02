package org.project.shop.service;

import org.project.shop.domain.Item;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {
    public void saveItem(Item Item, MultipartFile file) throws Exception;
    public Item findOneItem(Long itemId);
    public List<Item> findItems();
    public void updateItem(Long itemId, String name, int price, int stockQuantity);
}
