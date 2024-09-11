package com.tbb.krazyolives.models;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Slf4j
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Entity
@Table(name = "menu")




public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NonNull
//    @Column(name = "item_name")
    String name;

    @NonNull
//    @Column(name = "item_desc")
    String description;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "menu_items",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items = new LinkedHashSet<>();

    @OneToMany(mappedBy = "menu", orphanRemoval = true)
    private Set<User> users = new LinkedHashSet<>();

//    public static List<Menu> findMenuItems(long id) {
//        item.add(item);
//        findMenuItems().add(this)
//    }


    //Helper method
    public void addItem(Item item) {
        items.add(item);
        item.getMenus().add(this);
    }
}