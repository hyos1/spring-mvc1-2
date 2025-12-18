package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //실무에선 ConcurrentHashMap사용
    private static long sequence = 0L; //static 실무에선 atomicLong 같은 거 사용

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);

        return item;
    }

    public Item findById(Long itemId) {
        return store.get(itemId);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = store.get(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }

//    public Item save(Item item) {
//        item.setId(++sequence);
//        store.put(item.getId(), item);
//        return item;
//    }
//
//    public Item findById(Long id) {
//        return store.get(id);
//    }
//
//    public List<Item> findAll() {
//        return new ArrayList<>(store.values());
//    }
//
//    public void update(Long itemId, Item updateParam) {
//        Item findItem = findById(itemId);
//        findItem.setItemName(updateParam.getItemName());
//        findItem.setPrice(updateParam.getPrice());
//        findItem.setQuantity(updateParam.getQuantity());
//    }
//
//    public void clearStore() {
//        store.clear();
//    }
}
