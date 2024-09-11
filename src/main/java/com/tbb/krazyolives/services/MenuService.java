package com.tbb.krazyolives.services;

import com.tbb.krazyolives.data.ItemRepository;
import com.tbb.krazyolives.data.MenuRepository;
import com.tbb.krazyolives.models.Item;
import com.tbb.krazyolives.models.Menu;
import com.tbb.krazyolives.models.Reservation;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class MenuService {

    MenuRepository menuRepository;
    ItemRepository itemRepository;

    public MenuService(MenuRepository menuRepository, ItemRepository itemRepository) {
        this.menuRepository = menuRepository;
        this.itemRepository = itemRepository;
    }

//    public List<Menu> findMenuItems(long id){
//        return Menu.findMenuItems(id);
//    }

    public List<Menu> getAllMenus() {
        return null;
    }


    public void saveMenu(Menu menu) {


    }


    public Reservation getMenuById(long id) {
        return null;
    }


    public void deleteMenuById(long id) {

    }


//    @Transactional(rollbackOn = {NoSuchElementException.class})
//    public void addCourse(String email, Course c) throws NoSuchElementException{
//
//        Student s = studentRepository.findById(email).orElseThrow();
//        c = courseRepository.save(c);
//        s.addCourse(c);
//        studentRepository.save(s);
//    }
    // action allowed by admin only

    @PersistenceContext
    EntityManager em;
    @Transactional(rollbackOn = {NoSuchElementException.class})
    public void addItemToMenu(long id, long item_id){
        Menu menu = em.find(Menu.class, id);
        Item item = em.find(Item.class, item_id);
        menu.getItems().add(item);
        item.setMenus((Set<Menu>) menu);

    }
}
