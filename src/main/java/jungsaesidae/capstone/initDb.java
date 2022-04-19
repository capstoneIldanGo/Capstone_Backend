package jungsaesidae.capstone;


import jungsaesidae.capstone.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class initDb {

    private final InitService initservice;

    @PostConstruct
    public void init() {
        initservice.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbInit() {
            Item item1 = createItem("Iphone");
            Item item2 = createItem("Galaxy");
            Item item3 = createItem("Macbook");
            Item item4 = createItem("Samsung laptop");
            Item item5 = createItem("Ipod");
            Item item6 = createItem("Airpod");
            em.persist(item1);
            em.persist(item2);
            em.persist(item3);
            em.persist(item4);
            em.persist(item5);
            em.persist(item6);

            Platform platform1 = createPlatform("Jongo Nara");
            Platform platform2 = createPlatform("Carrot market");
            Platform platform3 = createPlatform("JJang goo");
            Platform platform4 = createPlatform("Bung gae jangte");

            em.persist(platform1);
            em.persist(platform2);
            em.persist(platform3);
            em.persist(platform4);

            Location location1 = createLocation("seoul", "gwangjin");
            Location location2 = createLocation("incheon", "yeonsu");
            Location location3 = createLocation("gwangju", "dongo");
            Location location4 = createLocation("New York", "state");
            Location location5 = createLocation("LA", "Hilarois");
            Location location6 = createLocation("Paris", "D dong");
            em.persist(location1);
            em.persist(location2);
            em.persist(location3);
            em.persist(location4);
            em.persist(location5);
            em.persist(location6);

            User user1 = createUser("june", "010-1234-1234");
            em.persist(user1);
            User user2 = createUser("yewan", "010-3451-1327");
            em.persist(user2);
            User user3 = createUser("sujin", "010-2334-1234");
            em.persist(user3);
            User user4 = createUser("yerin", "010-9951-3227");
            em.persist(user4);

            MarketPrice marketPrice1 = MarketPrice.createMarketPrice(item1, 1000);
            MarketPrice marketPrice2 = MarketPrice.createMarketPrice(item2, 20000);
            MarketPrice marketPrice3 = MarketPrice.createMarketPrice(item1, 11000);
            MarketPrice marketPrice4 = MarketPrice.createMarketPrice(item1, 310000);
            MarketPrice marketPrice5 = MarketPrice.createMarketPrice(item1, 12000);
            MarketPrice marketPrice6 = MarketPrice.createMarketPrice(item2, 22000);
            em.persist(marketPrice1);
            em.persist(marketPrice2);
            em.persist(marketPrice3);
            em.persist(marketPrice4);
            em.persist(marketPrice5);
            em.persist(marketPrice6);

            Post post1 = Post.createPost(location1, platform1, marketPrice1, item5, "www.naver.com", false, false, LocalDateTime.now().minusDays(2));
            Post post2 = Post.createPost(location2, platform2, marketPrice2, item1, "www.google.com", false, false, LocalDateTime.now());
            Post post3 = Post.createPost(location3, platform4, marketPrice4, item6, "www.yahoo.com", true, true, LocalDateTime.now().minusDays(33));
            Post post4 = Post.createPost(location1, platform3, marketPrice3, item3, "www.yahhqa.com", false, false, LocalDateTime.now().minusDays(11));
            Post post5 = Post.createPost(location4, platform2, marketPrice3, item2, "www.hololoo.com", false, false, LocalDateTime.now().minusDays(5));
            Post post6 = Post.createPost(location5, platform1, marketPrice3, item1, "www.yho.com", true, true, LocalDateTime.now().minusDays(90));
            Post post7 = Post.createPost(location3, platform1, marketPrice4, item4, "www.qwe.com", false, true, LocalDateTime.now().minusDays(22));
            Post post8 = Post.createPost(location6, platform2, marketPrice2, item1, "www.sfs.com", false, false, LocalDateTime.now().minusDays(50));

            em.persist(post1);
            em.persist(post2);
            em.persist(post3);
            em.persist(post4);
            em.persist(post5);
            em.persist(post6);
            em.persist(post7);
            em.persist(post8);

            MyPost myPost1 = MyPost.createMyPost(post1, user1);
            MyPost myPost2 = MyPost.createMyPost(post2, user2);
            MyPost myPost3 = MyPost.createMyPost(post2, user3);
            MyPost myPost4 = MyPost.createMyPost(post4, user4);
            MyPost myPost5 = MyPost.createMyPost(post2, user1);
            MyPost myPost6 = MyPost.createMyPost(post4, user1);
            em.persist(myPost1);
            em.persist(myPost2);
            em.persist(myPost3);
            em.persist(myPost4);
            em.persist(myPost5);
            em.persist(myPost6);

            PriceAlarm priceAlarm1 = PriceAlarm.createPriceAlarm(user1, item1, 10000);
            PriceAlarm priceAlarm2 = PriceAlarm.createPriceAlarm(user1, item2, 6000);
            PriceAlarm priceAlarm3 = PriceAlarm.createPriceAlarm(user2, item1, 30000);
            PriceAlarm priceAlarm4 = PriceAlarm.createPriceAlarm(user2, item2, 40000);
            PriceAlarm priceAlarm5 = PriceAlarm.createPriceAlarm(user4, item1, 7000);
            PriceAlarm priceAlarm6 = PriceAlarm.createPriceAlarm(user3, item1, 7000);
            em.persist(priceAlarm1);
            em.persist(priceAlarm2);
            em.persist(priceAlarm3);
            em.persist(priceAlarm4);
            em.persist(priceAlarm5);
            em.persist(priceAlarm6);
        }

        private Item createItem(String name) {
            Item item = new Item();
            item.setName(name);
            return item;
        }

        private Platform createPlatform(String name) {
            Platform platform = new Platform();
            platform.setName(name);
            return platform;
        }

        private Location createLocation(String city, String state) {
            Location location = new Location();
            location.setCity(city);
            location.setState(state);
            return location;
        }

        private User createUser(String name, String contact) {
            User user = new User();
            user.setName(name);
            user.setContact(contact);
            return user;
        }

    }
}
