package web.tests;

import org.junit.jupiter.api.Disabled;
import web.api.Api;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.api.AuthApi;

import static web.tests.TestData.userPass;

@Tag("cart")
@Owner("e.kladkova")
@DisplayName("Проверка действий пользователя в корзине товаров")
public class CartTests extends TestBaseWebWithAttach {

    AuthApi authApi = new AuthApi();
    Api api = new Api();

    @Disabled
    @Test
    @DisplayName("Проверка удаления товара из списка")
    void deleteProductTest() {
        authApi.makeAuthApiPostRequest(userPass);
        authApi.checkSuccessfulAuthApiResponse();
        api.makeClearCartPostRequest();


//                .setCookie()
//                .makeDeleteAllBooksRequest()
//                .makeBookPostRequest("9781449365035");
//        profilePage.openProfilePage()
//                .checkLoginResult()
//                .checkBooksWereAdded()
//                .deleteBooks()
//                .checkBooksWereDeleted();
    }
}