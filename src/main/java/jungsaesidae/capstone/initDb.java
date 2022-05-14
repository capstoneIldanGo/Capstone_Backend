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
            Item item7 = createItem("Samsung TV");
            Item item8 = createItem("LG Gram");
            Item item9 = createItem("LG TV");
            Item item10 = createItem("Buzz");
            em.persist(item1);
            em.persist(item2);
            em.persist(item3);
            em.persist(item4);
            em.persist(item5);
            em.persist(item6);
            em.persist(item7);
            em.persist(item8);
            em.persist(item9);
            em.persist(item10);

            Platform platform1 = createPlatform("Jongo Nara");
            Platform platform2 = createPlatform("Carrot market");
            Platform platform3 = createPlatform("Hello market");
            Platform platform4 = createPlatform("Bung gae jangtu");

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
            User user5 = createUser("gwangjin", "010-4039-2019");
            em.persist(user5);
            User user6 = createUser("taehoon", "010-5312-7658");
            em.persist(user6);
            User user7 = createUser("woosang", "010-7569-4312");
            em.persist(user7);

            MarketPrice marketPrice1 = MarketPrice.createMarketPrice(item1, 1000);
            MarketPrice marketPrice2 = MarketPrice.createMarketPrice(item2, 20000);
            MarketPrice marketPrice3 = MarketPrice.createMarketPrice(item1, 11000);
            MarketPrice marketPrice4 = MarketPrice.createMarketPrice(item1, 310000);
            MarketPrice marketPrice5 = MarketPrice.createMarketPrice(item1, 12000);
            MarketPrice marketPrice6 = MarketPrice.createMarketPrice(item2, 22000);
            MarketPrice marketPrice7 = MarketPrice.createMarketPrice(item1, 19000);
            MarketPrice marketPrice8 = MarketPrice.createMarketPrice(item2, 30000);
            MarketPrice marketPrice9 = MarketPrice.createMarketPrice(item1, 6000);
            MarketPrice marketPrice10 = MarketPrice.createMarketPrice(item1, 70000);
            MarketPrice marketPrice11 = MarketPrice.createMarketPrice(item1, 32000);
            MarketPrice marketPrice12 = MarketPrice.createMarketPrice(item2, 120000);
            em.persist(marketPrice1);
            em.persist(marketPrice2);
            em.persist(marketPrice3);
            em.persist(marketPrice4);
            em.persist(marketPrice5);
            em.persist(marketPrice6);
            em.persist(marketPrice7);
            em.persist(marketPrice8);
            em.persist(marketPrice9);
            em.persist(marketPrice10);
            em.persist(marketPrice11);
            em.persist(marketPrice12);

            Post post1 = Post.createPost(location1, platform1, marketPrice1, item4, "https://m.joongna.com/product-detail/44356854?transactionId=1652367861311_-2316380558694945254&abTestType=null&productPositionNo=6", false, false, LocalDateTime.now().minusDays(2), "삼성노트북9", "image1");
            Post post2 = Post.createPost(location2, platform2, marketPrice2, item4, "https://www.daangn.com/articles/394132410", false, false, LocalDateTime.now(),"삼성 갤럭시북s 초경량 터치스크린 노트북 삼성노트북 i5 256기가", "image1");
            Post post3 = Post.createPost(location3, platform4, marketPrice4, item6, "https://m.bunjang.co.kr/products/187681288", true, true, LocalDateTime.now().minusDays(33),"임영웅 대전 Vip, S석 팜", "image1");
            Post post4 = Post.createPost(location1, platform3, marketPrice3, item4, "https://www.hellomarket.com/item/173203797?viewPath=search_list&clickPath=search&feedPosition=35", false, false, LocalDateTime.now().minusDays(11),"윈도우11 i3 삼성노트북 램8 SSD256기가", "image1");
            Post post5 = Post.createPost(location4, platform2, marketPrice9, item4, "https://www.daangn.com/articles/403125457", false, false, LocalDateTime.now().minusDays(5),"삼성노트북 sens R530노트북 팜니다", "image1");
            Post post6 = Post.createPost(location5, platform1, marketPrice3, item4, "https://m.joongna.com/product-detail/42666914?transactionId=1652367861311_-2316380558694945254&abTestType=null&productPositionNo=7", true, true, LocalDateTime.now().minusDays(93),"♡개인♡램8G♡슬림제품♡삼성 화이트 노트북♡", "image1");
            Post post7 = Post.createPost(location3, platform1, marketPrice4, item4, "https://m.joongna.com/product-detail/44344068?transactionId=1652367861311_-2316380558694945254&abTestType=null&productPositionNo=8", false, true, LocalDateTime.now().minusDays(72),"삼성 고사양 슬림형 경량 노트북 팔아요 ~ 부산", "image1");
            Post post8 = Post.createPost(location6, platform2, marketPrice9, item4, "https://www.daangn.com/articles/403019686", false, false, LocalDateTime.now().minusDays(50),"삼성 노트북 Odyssey NT800G5H-X716A GTX1060 + 2Tera i7 게이밍 노트북 팝니다", "image1");
            Post post11 = Post.createPost(location1, platform1, marketPrice3, item5, "https://m.joongna.com/product-detail/44393254?transactionId=1652369237734_-8104792347058203000&abTestType=null&productPositionNo=1", false, false, LocalDateTime.now().minusDays(20),"아이패드 에어4 wifi 64GB 미개봉 스그 팝니다", "image1");
            Post post21 = Post.createPost(location2, platform2, marketPrice10, item4, "https://www.daangn.com/articles/400580957", false, false, LocalDateTime.now(),"삼성노트북 s910s5k 15인치 노트북 팝니다.", "image1");
            Post post31 = Post.createPost(location3, platform4, marketPrice3, item6, "https://m.bunjang.co.kr/products/187683058", true, true, LocalDateTime.now().minusDays(33),"산리오 서프라이즈 마이 키링 양도", "image1");
            Post post41 = Post.createPost(location1, platform3, marketPrice5, item4, "https://www.hellomarket.com/item/173491648?viewPath=search_list&clickPath=search&feedPosition=36", false, false, LocalDateTime.now().minusDays(110),"윈도우11 i5 삼성노트북", "image1");
            Post post51 = Post.createPost(location4, platform2, marketPrice6, item6, "https://www.daangn.com/articles/401695283", false, false, LocalDateTime.now().minusDays(5),"에어팟 프로 ( Air pods pro )", "image1");
            Post post61 = Post.createPost(location5, platform1, marketPrice8, item5, "https://m.joongna.com/product-detail/44215829?transactionId=1652369237734_-8104792347058203000&abTestType=null&productPositionNo=3", true, true, LocalDateTime.now().minusDays(42),"아이패드프로5세대 11 미개봉 새상품", "image1");
            Post post71 = Post.createPost(location3, platform4, marketPrice9, item4, "https://m.bunjang.co.kr/products/187682022", false, true, LocalDateTime.now().minusDays(22),"졸업사진 개화기 의상 판매", "image1");
            Post post81 = Post.createPost(location6, platform2, marketPrice11, item6, "https://www.daangn.com/articles/402821862", false, false, LocalDateTime.now().minusDays(50),"Air Pods Pro", "image1");
            Post post12 = Post.createPost(location1, platform1, marketPrice5, item5, "https://m.joongna.com/product-detail/44355468?transactionId=1652369237734_-8104792347058203000&abTestType=null&productPositionNo=10", false, false, LocalDateTime.now().minusDays(29),"아이패드 에어3 wifi 64g + 애플펜슬 1세대", "image1");
            Post post22 = Post.createPost(location2, platform2, marketPrice1, item6, "https://www.daangn.com/articles/400004645", false, false, LocalDateTime.now(),"에어팟 프로 / air pods pro 팝니다", "image1");
            Post post32 = Post.createPost(location3, platform4, marketPrice2, item6, "https://m.bunjang.co.kr/products/187508220", true, true, LocalDateTime.now().minusDays(33),"콘스탄틴 디스페랄 2017", "image1");
            Post post42 = Post.createPost(location1, platform4, marketPrice1, item10, "https://m.bunjang.co.kr/products/187646229?q=%EB%B2%84%EC%A6%88&ref=%EA%B2%80%EC%83%89%EA%B2%B0%EA%B3%BC", false, false, LocalDateTime.now().minusDays(51),"갤럭시 버즈2 (미개봉 새상품)", "image1");
            Post post52 = Post.createPost(location4, platform2, marketPrice12, item6, "https://www.daangn.com/articles/399500440", false, false, LocalDateTime.now().minusDays(5),"air pods3 에어팟3세대 정품. 거의 새상품", "image1");
            Post post62 = Post.createPost(location5, platform4, marketPrice12, item1, "https://m.bunjang.co.kr/products/168582055", true, true, LocalDateTime.now().minusDays(90),"졸업사진 컨셉 해적 코스프레 의상 대여", "image1");
            Post post72 = Post.createPost(location3, platform1, marketPrice7, item8, "https://m.joongna.com/product-detail/44379751?transactionId=1652369407197_4707925103118368500&abTestType=null&productPositionNo=1", false, true, LocalDateTime.now().minusDays(22),"21년식 lg 그램 팝니다(박스는 없어요)", "image1");
            Post post82 = Post.createPost(location6, platform2, marketPrice1, item7, "https://www.daangn.com/articles/402963114", false, false, LocalDateTime.now().minusDays(50),"삼성 TV 43인치 팝니다. 티비 텔레비전", "image1");

            Post post13 = Post.createPost(location1, platform1, marketPrice5, item8, "https://m.joongna.com/product-detail/44134166?transactionId=1652369407197_4707925103118368500&abTestType=null&productPositionNo=3", false, false, LocalDateTime.now().minusDays(12),"LG그램 15인치 노트북", "image1");
            Post post23 = Post.createPost(location2, platform2, marketPrice10, item7, "https://www.daangn.com/articles/401726366", false, false, LocalDateTime.now(),"32인치 삼성 led티비 텔레비전 삼성TV", "image1");
            Post post33 = Post.createPost(location3, platform4, marketPrice2, item6, "https://m.bunjang.co.kr/products/187684271", true, true, LocalDateTime.now().minusDays(33),"앙스타장터 로제트 이타백 판매 양도 시광뱃지 이베코레", "image1");
            Post post43 = Post.createPost(location1, platform4, marketPrice7, item10, "https://m.bunjang.co.kr/products/187430587?q=%EB%B2%84%EC%A6%88&ref=%EA%B2%80%EC%83%89%EA%B2%B0%EA%B3%BC", false, false, LocalDateTime.now().minusDays(17),"버즈 라이브 블랙 미개봉 새상품 판매", "image1");
            Post post53 = Post.createPost(location4, platform2, marketPrice11, item7, "https://www.daangn.com/articles/403264880", false, false, LocalDateTime.now().minusDays(5),"TV, 티비, 텔레비전, 삼성 티비", "image1");
            Post post63 = Post.createPost(location5, platform4, marketPrice8, item1, "https://m.bunjang.co.kr/products/186383190", true, true, LocalDateTime.now().minusDays(90),"엔진11 크릿디 블러드오렌지 개급처", "image1");
            Post post73 = Post.createPost(location3, platform1, marketPrice2, item8, "https://m.joongna.com/product-detail/42981732?transactionId=1652369407197_4707925103118368500&abTestType=null&productPositionNo=4", false, true, LocalDateTime.now().minusDays(25),"lg그램 15인치 15ZD90N-VX70K", "image1");

            em.persist(post1);
            em.persist(post2);
            em.persist(post3);
            em.persist(post4);
            em.persist(post5);
            em.persist(post6);
            em.persist(post7);
            em.persist(post8);
            em.persist(post11);
            em.persist(post21);
            em.persist(post31);
            em.persist(post41);
            em.persist(post51);
            em.persist(post61);
            em.persist(post71);
            em.persist(post81);
            em.persist(post12);
            em.persist(post22);
            em.persist(post32);
            em.persist(post42);
            em.persist(post52);
            em.persist(post62);
            em.persist(post72);
            em.persist(post82);

            em.persist(post13);
            em.persist(post23);
            em.persist(post33);
            em.persist(post43);
            em.persist(post53);
            em.persist(post63);
            em.persist(post73);

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
