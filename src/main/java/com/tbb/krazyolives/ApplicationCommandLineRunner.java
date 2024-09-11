package com.tbb.krazyolives;

import com.tbb.krazyolives.data.*;
import com.tbb.krazyolives.models.*;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalTime;

@Component @Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ApplicationCommandLineRunner  implements CommandLineRunner {

    ReservationRepository reservationRepository;
    AuthGroupRepository authGroupRepository;
    UserRepository userRepository;
    MenuRepository menuRepository;

    ItemRepository itemRepository;

    public ApplicationCommandLineRunner(ReservationRepository reservationRepository, AuthGroupRepository authGroupRepository, UserRepository userRepository, MenuRepository menuRepository, ItemRepository itemRepository) {
        this.reservationRepository = reservationRepository;
        this.authGroupRepository = authGroupRepository;
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
        this.itemRepository = itemRepository;
    }

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
    static String PASSWORD = encoder.encode("password");


    static final  String BELLAID = "baminov@gmail.com";
    static final  String LANAID ="lboulton@gmail.com";
    static final  String LUIBOVID ="ldavidova@gmail.com";
    static final  String VITAID = "vfilip@gmail.com";
    static final  String VIKAID = "vv@gmail.com";
    static final  String LILYID = "lhe@gmail.com";
    static final  String ROLE_ADMIN = "ROLE_ADMIN";
    static final  String ROLE_USER = "ROLE_USER";


    @PostConstruct
    public void postConstruct(){
        log.warn("============ Application CommandLine Runner ============");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.of(00, 00, 00);
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.save(new User("Bella", "Aminov",BELLAID, PASSWORD ));
        userRepository.save(new User("Lana", "Boulton", LANAID, PASSWORD));
        userRepository.save(new User("Luibov",  "Davidova",LUIBOVID, PASSWORD ));
        userRepository.save(new User("Vita", "Filip", VITAID, PASSWORD ));
        userRepository.save(new User("Vika", "N", VIKAID, PASSWORD ));
        userRepository.save(new User("Lily", "He", LILYID, PASSWORD ));

        authGroupRepository.save(new AuthGroup(BELLAID, ROLE_ADMIN));
        authGroupRepository.save(new AuthGroup(BELLAID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(LANAID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(LUIBOVID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(VITAID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(VIKAID, ROLE_USER));
        authGroupRepository.save(new AuthGroup(LILYID, ROLE_USER));





        reservationRepository.save(new Reservation("Bella","Aminov", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "baminov@gmail.com", "4", "Massage for 4"));
        reservationRepository.save(new Reservation("Lana","Boulton", LocalDate.now(),  LocalTime.of(12,00,00), "1234567890", "lboulton@gmail.com", "4", "Massage for 4"));
        reservationRepository.save(new Reservation("Luibov","Davidova", LocalDate.now(), LocalTime.of(15,00,00), "1234567890", "lola@gmail.com", "2", "pair romantic massage"));
        reservationRepository.save(new Reservation("Vita","Filip", LocalDate.now(), LocalTime.of(11,30,00),"1234567890", "vfilip@gmail.com", "6", "aroma massage"));
        reservationRepository.save(new Reservation("Vika","V", LocalDate.now(),LocalTime.of(20,00,00), "1234567890", "vv@gmail.com", "2", "chocolate massage"));
        reservationRepository.save(new Reservation("Lily","He", LocalDate.now(),LocalTime.of(14,15,00), "1234567890", "lhe@gmail.com", "2", "stone massage"));

        menuRepository.save(new Menu("Massage", "Deep tissue massage"));
        menuRepository.save(new Menu("Massage", "Swedish massage"));
        menuRepository.save(new Menu("Massage", "Thai massage"));
        menuRepository.save(new Menu("Massage", "Sports massage"));
        menuRepository.save(new Menu("Massage", "Shiatsu massage"));
        menuRepository.save(new Menu("Massage", "Lymphatic drainage massage"));
        menuRepository.save(new Menu("Massage", "Reflexology"));




        itemRepository.save(new Item("Deep tissue massage", "1 hour", 100.00, true));
        itemRepository.save(new Item("Swedish massage", "1.5 hour", 150.00, true));
        itemRepository.save(new Item("Sports massage", "2 hours", 200.00, true));
        itemRepository.save(new Item("Reflexology", "30 minutes", 80.00, true));
        itemRepository.save(new Item("Shiatsu massage", "1 hour", 130.00, true));
        itemRepository.save(new Item("Thai massage", "1 hour", 100.00, false));
        itemRepository.save(new Item("Lymphatic drainage massage", "2 hours", 250.00, true));
        itemRepository.save(new Item("Deep tissue massage", "2 hour", 200.00, true));
        itemRepository.save(new Item("Swedish massage", "1 hour", 100.00, true));
        itemRepository.save(new Item("Sports massage", "1 hours", 100.00, true));
        itemRepository.save(new Item("Reflexology", "60 minutes", 160.00, true));
        itemRepository.save(new Item("Shiatsu massage", "2 hour", 260.00, true));
        itemRepository.save(new Item("Thai massage", "2 hour", 200.00, false));
        itemRepository.save(new Item("Lymphatic drainage massage", "1 hours", 125.00, true));

    }


}
