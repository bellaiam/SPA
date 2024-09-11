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
@Table(name = "items")

//
//@NamedNativeQuery(name = "Course.findStudentCourses", query = "select c.id, c.name, c.instructor from course as c join student_courses as sc on c.id = sc.course_id join student as s on s.email = sc.student_email where s.email = :email", resultSetMapping = "Mapping.findStudentCourses")
//@SqlResultSetMapping(name = "Mapping.findStudentCourses", classes = @ConstructorResult(targetClass = Course.class, columns = {@ColumnResult(name = "id"), @ColumnResult(name = "name"), @ColumnResult(name = "instructor")}))
//
@NamedNativeQuery(name = "Item.findAllMenuItems", query = "select  item.name, item.description, item.price item.available from item join menu_items as mi on item.id  = mi.item_id  join menu on menu.id = mi.menu_id", resultSetMapping = "Mapping.findAllMenuItems")
@SqlResultSetMapping(name = "Mapping.findAllMenuItems", classes = @ConstructorResult(targetClass = Menu.class, columns = {@ColumnResult(name = "id"), @ColumnResult(name = "item_name"), @ColumnResult(name = "item_desc"), @ColumnResult(name = "item_price"),@ColumnResult(name = "availability")}))


public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NonNull
//    @Column(name = "item_name")
    String name;

    @NonNull
//    @Column(name = "item_desc")
    String description;

    @NonNull
//    @Column(name = "item_price")
    Double price;

    @NonNull
    boolean available;

    public Item(long id, @NonNull String name, @NonNull String description, @NonNull Double price, @NonNull boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;

    }

    @ManyToMany(mappedBy = "items", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Set<Menu> menus = new LinkedHashSet<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
        menu.getItems().add(this);

    }
}