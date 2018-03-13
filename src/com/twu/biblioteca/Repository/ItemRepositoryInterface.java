package com.twu.biblioteca.Repository;

import com.twu.biblioteca.Models.Item;

import java.util.List;

public interface ItemRepositoryInterface {

    List<Item> createItemList();
    List<Item> getItemList();
    void addItem(Item item);
    void removeItem(int index);
    List<Item> getCheckedoutItemList();
    void addCheckedoutItem(Item item);
    void removeCheckedoutItem(int index);
}
