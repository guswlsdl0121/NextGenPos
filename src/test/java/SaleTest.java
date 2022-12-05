import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//Sale에 대한 Test
class SaleTest {
    static Sale sale;

    @BeforeAll  //모든 메소드의 실행 전에 수행되는 메소드
    static void makeNewSale() {
        sale = new Sale();
        //sale객체 생성 확인
        assertNotNull(sale);
    }

    @Test
    void enterltem() {
        ProductCatalog catalog = new ProductCatalog();
        //ProductCatalog에서 삽입된 샘플 데이터(아이셔, 차카니)
        ItemID aisheoID = new ItemID("1");
        ItemID chaID = new ItemID("2");
        //테스트를 위해 사용된 존재하지 않는 데이터
        ItemID notExistId = new ItemID("1000");

        ProductSpecification aiSpec = catalog.getSpecification(aisheoID);
        assertEquals(aiSpec.getDescription(), "아이셔");
        ProductSpecification chaSpec = catalog.getSpecification(chaID);
        assertEquals(chaSpec.getDescription(), "차카니");

        //존재하지 않는 ItemID에 대해선 null값이 반환
        ProductSpecification wrongSpec = catalog.getSpecification(notExistId);
        assertNull(wrongSpec);

        //구매 목록에 상품정보와 수량 추가.
        //이 부분은 상품들이 구매목록에 모두 추가될때까지 반복적으로 실행.
        sale.makeLineltem(aiSpec, 2);
        sale.makeLineltem(chaSpec, 1);
    }

    @Test
    void endSale() {
        sale.becomeComplete();
        assertTrue(sale.isComplete());  //isComplete변수 확인(true)
    }

    @Test
    void makePayment () {
        //해당 메소드를 통해 지불금엑에 따른 payment 객체 생성
        Money cashTendered = new Money(3000);
        sale.makePayment(cashTendered);
    }

    @Test  //영수증 출력
    void checkReceipt() {
        System.out.println("영수증 출력\n");
        System.out.println(sale.toString());
    }

}