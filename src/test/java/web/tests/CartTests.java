package web.tests;

import io.qameta.allure.Issue;
import org.junit.jupiter.api.Disabled;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.api.AuthApi;

import static web.tests.TestData.userPass;

@Issue("HOMEWORK-1263")
@Disabled("Необходимо разобраться как вытащить скрытый session id из cookies и local storage")
@Tag("cart")
@Owner("e.kladkova")
@DisplayName("WEB. Проверка действий пользователя в корзине товаров")
public class CartTests extends TestBaseWebWithAttach {

    AuthApi authApi = new AuthApi();

    @Test
    @DisplayName("WEB. Проверка удаления товара из списка")
    void successfulDeletionItemTest() {
        authApi.makeAuthApiPostRequest(userPass);
        authApi.checkSuccessfulAuthApiResponse();
        //api.setCookie();
        //api.makeClearCartPostRequest();
        //api.makeAddItemsPostRequest();
        //cartPage.openCartPage()
        //cartPage.checkLoginResult()
        //cartPage.checkItemsWereAdded()
        //cartPage.deleteItems() //UI deletion
        //cartPage.checkItemsWereDeleted();
    }
}