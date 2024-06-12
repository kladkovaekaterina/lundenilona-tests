package web.api;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class Api {

    @Step("Выполнить удаление всех товаров из корзины через API")
    public void makeClearCartPostRequest() {
        String data = """
                sessid=7546ebe01d056475d32c49e9b489761e&signedParamsString=YToxMTU6e3M6MTU6IkFDVElPTl9WQVJJQUJMRSI7czoxMjoiYmFza2V0QWN0aW9uIjtzOjE2OiJBVVRPX0NBTENVTEFUSU9OIjtzOjE6IlkiO3M6MjE6IkJBU0tFVF9JTUFHRVNfU0NBTElORyI7czo4OiJhZGFwdGl2ZSI7czoxNjoiQ09MVU1OU19MSVNUX0VYVCI7YTo3OntpOjA7czo0OiJOQU1FIjtpOjE7czoxNToiUFJFVklFV19QSUNUVVJFIjtpOjI7czo4OiJESVNDT1VOVCI7aTozO3M6NjoiREVMRVRFIjtpOjQ7czo1OiJQUklDRSI7aTo1O3M6MzoiU1VNIjtpOjY7czo4OiJRVUFOVElUWSI7fXM6MTk6IkNPTFVNTlNfTElTVF9NT0JJTEUiO2E6NDp7aTowO3M6MTU6IlBSRVZJRVdfUElDVFVSRSI7aToxO3M6ODoiRElTQ09VTlQiO2k6MjtzOjY6IkRFTEVURSI7aTo1O3M6MzoiU1VNIjt9czoxNToiQ09NUEFUSUJMRV9NT0RFIjtzOjE6IlkiO3M6MTM6IkNPUlJFQ1RfUkFUSU8iO3M6MToiWSI7czoxNjoiREVGRVJSRURfUkVGUkVTSCI7czoxOiJOIjtzOjI1OiJESVNDT1VOVF9QRVJDRU5UX1BPU0lUSU9OIjtzOjEyOiJib3R0b20tcmlnaHQiO3M6MTI6IkRJU1BMQVlfTU9ERSI7czo4OiJleHRlbmRlZCI7czoxNzoiR0lGVFNfQkxPQ0tfVElUTEUiO3M6NDc6ItCS0YvQsdC10YDQuNGC0LUg0L7QtNC40L0g0LjQtyDQv9C%2B0LTQsNGA0LrQvtCyIjtzOjIyOiJHSUZUU19DT05WRVJUX0NVUlJFTkNZIjtzOjE6Ik4iO3M6MjI6IkdJRlRTX0hJREVfQkxPQ0tfVElUTEUiO3M6MToiTiI7czoyNDoiR0lGVFNfSElERV9OT1RfQVZBSUxBQkxFIjtzOjE6Ik4iO3M6MTg6IkdJRlRTX01FU1NfQlROX0JVWSI7czoxNDoi0JLRi9Cx0YDQsNGC0YwiO3M6MjE6IkdJRlRTX01FU1NfQlROX0RFVEFJTCI7czoxODoi0J%2FQvtC00YDQvtCx0L3QtdC1IjtzOjI0OiJHSUZUU19QQUdFX0VMRU1FTlRfQ09VTlQiO3M6MToiNCI7czoxMToiR0lGVFNfUExBQ0UiO3M6NjoiQk9UVE9NIjtzOjI4OiJHSUZUU19QUk9EVUNUX1BST1BTX1ZBUklBQkxFIjtzOjQ6InByb3AiO3M6MzE6IkdJRlRTX1BST0RVQ1RfUVVBTlRJVFlfVkFSSUFCTEUiO3M6ODoicXVhbnRpdHkiO3M6Mjc6IkdJRlRTX1NIT1dfRElTQ09VTlRfUEVSQ0VOVCI7czoxOiJZIjtzOjE2OiJHSUZUU19TSE9XX0lNQUdFIjtzOjE6IlkiO3M6MTU6IkdJRlRTX1NIT1dfTkFNRSI7czoxOiJZIjtzOjIwOiJHSUZUU19TSE9XX09MRF9QUklDRSI7czoxOiJOIjtzOjIxOiJHSUZUU19URVhUX0xBQkVMX0dJRlQiO3M6MTQ6ItCf0L7QtNCw0YDQvtC6IjtzOjExOiJISURFX0NPVVBPTiI7czoxOiJOIjtzOjEwOiJMQUJFTF9QUk9QIjthOjA6e31zOjE3OiJMQUJFTF9QUk9QX01PQklMRSI7YTowOnt9czoxOToiTEFCRUxfUFJPUF9QT1NJVElPTiI7czo4OiJ0b3AtbGVmdCI7czoxMjoiT0ZGRVJTX1BST1BTIjthOjA6e31zOjEzOiJQQVRIX1RPX09SREVSIjtzOjIxOiIvcGVyc29uYWwvb3JkZXIvbWFrZS8iO3M6MTg6IlBSSUNFX0RJU1BMQVlfTU9ERSI7czoxOiJZIjtzOjIwOiJQUklDRV9WQVRfU0hPV19WQUxVRSI7czoxOiJOIjtzOjIwOiJQUk9EVUNUX0JMT0NLU19PUkRFUiI7czoxNzoicHJvcHMsc2t1LGNvbHVtbnMiO3M6MTQ6IlFVQU5USVRZX0ZMT0FUIjtzOjE6IlkiO3M6OToiU0VUX1RJVExFIjtzOjE6IlkiO3M6MjE6IlNIT1dfRElTQ09VTlRfUEVSQ0VOVCI7czoxOiJZIjtzOjExOiJTSE9XX0ZJTFRFUiI7czoxOiJZIjtzOjEyOiJTSE9XX1JFU1RPUkUiO3M6MToiWSI7czoxNDoiVEVNUExBVEVfVEhFTUUiO3M6NDoiYmx1ZSI7czoxOToiVE9UQUxfQkxPQ0tfRElTUExBWSI7YToxOntpOjA7czozOiJ0b3AiO31zOjE4OiJVU0VfRFlOQU1JQ19TQ1JPTEwiO3M6MToiWSI7czoyMjoiVVNFX0VOSEFOQ0VEX0VDT01NRVJDRSI7czoxOiJOIjtzOjk6IlVTRV9HSUZUUyI7czoxOiJZIjtzOjE0OiJVU0VfUFJFUEFZTUVOVCI7czoxOiJOIjtzOjE5OiJVU0VfUFJJQ0VfQU5JTUFUSU9OIjtzOjE6IlkiO3M6MTA6IkNBQ0hFX1RZUEUiO3M6MToiQSI7czoxMjoiQ0FDSEVfR1JPVVBTIjtzOjE6Ik4iO3M6OToiQUpBWF9QQVRIIjtzOjQ5OiIvbG9jYWwvY29tcG9uZW50cy9hd2cvc2FsZS5iYXNrZXQuYmFza2V0L2FqYXgucGhwIjtzOjE0OiJQQVRIX1RPX0JBU0tFVCI7czoxNToiL3BlcnNvbmFsL2NhcnQvIjtzOjEwOiJERVRBSUxfVVJMIjtzOjA6IiI7czoxMToiV0VJR0hUX0tPRUYiO2Q6MTtzOjExOiJXRUlHSFRfVU5JVCI7czoyOiLQsyI7czoxMjoiQ09MVU1OU19MSVNUIjthOjc6e2k6MDtzOjQ6Ik5BTUUiO2k6MTtzOjE1OiJQUkVWSUVXX1BJQ1RVUkUiO2k6MjtzOjg6IkRJU0NPVU5UIjtpOjM7czo2OiJERUxFVEUiO2k6NDtzOjU6IlBSSUNFIjtpOjU7czozOiJTVU0iO2k6NjtzOjg6IlFVQU5USVRZIjt9czoyOToiQkFTS0VUX1dJVEhfT1JERVJfSU5URUdSQVRJT04iO3M6MToiTiI7czoyNDoiQkFTS0VUX01BWF9DT1VOVF9UT19TSE9XIjtpOjU7czoyNToiQkFTS0VUX0hBU19CRUVOX1JFRlJFU0hFRCI7czoxOiJOIjtzOjE2OiJ%2BQUNUSU9OX1ZBUklBQkxFIjtzOjEyOiJiYXNrZXRBY3Rpb24iO3M6MTc6In5BVVRPX0NBTENVTEFUSU9OIjtzOjE6IlkiO3M6MjI6In5CQVNLRVRfSU1BR0VTX1NDQUxJTkciO3M6ODoiYWRhcHRpdmUiO3M6MTc6In5DT0xVTU5TX0xJU1RfRVhUIjthOjc6e2k6MDtzOjQ6Ik5BTUUiO2k6MTtzOjE1OiJQUkVWSUVXX1BJQ1RVUkUiO2k6MjtzOjg6IkRJU0NPVU5UIjtpOjM7czo2OiJERUxFVEUiO2k6NDtzOjU6IlBSSUNFIjtpOjU7czozOiJTVU0iO2k6NjtzOjg6IlFVQU5USVRZIjt9czoyMDoifkNPTFVNTlNfTElTVF9NT0JJTEUiO2E6NDp7aTowO3M6MTU6IlBSRVZJRVdfUElDVFVSRSI7aToxO3M6ODoiRElTQ09VTlQiO2k6MjtzOjY6IkRFTEVURSI7aTo1O3M6MzoiU1VNIjt9czoxNjoifkNPTVBBVElCTEVfTU9ERSI7czoxOiJZIjtzOjE0OiJ%2BQ09SUkVDVF9SQVRJTyI7czoxOiJZIjtzOjE3OiJ%2BREVGRVJSRURfUkVGUkVTSCI7czoxOiJOIjtzOjI2OiJ%2BRElTQ09VTlRfUEVSQ0VOVF9QT1NJVElPTiI7czoxMjoiYm90dG9tLXJpZ2h0IjtzOjEzOiJ%2BRElTUExBWV9NT0RFIjtzOjg6ImV4dGVuZGVkIjtzOjE4OiJ%2BR0lGVFNfQkxPQ0tfVElUTEUiO3M6NDc6ItCS0YvQsdC10YDQuNGC0LUg0L7QtNC40L0g0LjQtyDQv9C%2B0LTQsNGA0LrQvtCyIjtzOjIzOiJ%2BR0lGVFNfQ09OVkVSVF9DVVJSRU5DWSI7czoxOiJOIjtzOjIzOiJ%2BR0lGVFNfSElERV9CTE9DS19USVRMRSI7czoxOiJOIjtzOjI1OiJ%2BR0lGVFNfSElERV9OT1RfQVZBSUxBQkxFIjtzOjE6Ik4iO3M6MTk6In5HSUZUU19NRVNTX0JUTl9CVVkiO3M6MTQ6ItCS0YvQsdGA0LDRgtGMIjtzOjIyOiJ%2BR0lGVFNfTUVTU19CVE5fREVUQUlMIjtzOjE4OiLQn9C%2B0LTRgNC%2B0LHQvdC10LUiO3M6MjU6In5HSUZUU19QQUdFX0VMRU1FTlRfQ09VTlQiO3M6MToiNCI7czoxMjoifkdJRlRTX1BMQUNFIjtzOjY6IkJPVFRPTSI7czoyOToifkdJRlRTX1BST0RVQ1RfUFJPUFNfVkFSSUFCTEUiO3M6NDoicHJvcCI7czozMjoifkdJRlRTX1BST0RVQ1RfUVVBTlRJVFlfVkFSSUFCTEUiO3M6ODoicXVhbnRpdHkiO3M6Mjg6In5HSUZUU19TSE9XX0RJU0NPVU5UX1BFUkNFTlQiO3M6MToiWSI7czoxNzoifkdJRlRTX1NIT1dfSU1BR0UiO3M6MToiWSI7czoxNjoifkdJRlRTX1NIT1dfTkFNRSI7czoxOiJZIjtzOjIxOiJ%2BR0lGVFNfU0hPV19PTERfUFJJQ0UiO3M6MToiTiI7czoyMjoifkdJRlRTX1RFWFRfTEFCRUxfR0lGVCI7czoxNDoi0J%2FQvtC00LDRgNC%2B0LoiO3M6MTI6In5ISURFX0NPVVBPTiI7czoxOiJOIjtzOjExOiJ%2BTEFCRUxfUFJPUCI7YTowOnt9czoxODoifkxBQkVMX1BST1BfTU9CSUxFIjthOjA6e31zOjIwOiJ%2BTEFCRUxfUFJPUF9QT1NJVElPTiI7czo4OiJ0b3AtbGVmdCI7czoxMzoifk9GRkVSU19QUk9QUyI7YTowOnt9czoxNDoiflBBVEhfVE9fT1JERVIiO3M6MjE6Ii9wZXJzb25hbC9vcmRlci9tYWtlLyI7czoxOToiflBSSUNFX0RJU1BMQVlfTU9ERSI7czoxOiJZIjtzOjIxOiJ%2BUFJJQ0VfVkFUX1NIT1dfVkFMVUUiO3M6MToiTiI7czoyMToiflBST0RVQ1RfQkxPQ0tTX09SREVSIjtzOjE3OiJwcm9wcyxza3UsY29sdW1ucyI7czoxNToiflFVQU5USVRZX0ZMT0FUIjtzOjE6IlkiO3M6MTA6In5TRVRfVElUTEUiO3M6MToiWSI7czoyMjoiflNIT1dfRElTQ09VTlRfUEVSQ0VOVCI7czoxOiJZIjtzOjEyOiJ%2BU0hPV19GSUxURVIiO3M6MToiWSI7czoxMzoiflNIT1dfUkVTVE9SRSI7czoxOiJZIjtzOjE1OiJ%2BVEVNUExBVEVfVEhFTUUiO3M6NDoiYmx1ZSI7czoyMDoiflRPVEFMX0JMT0NLX0RJU1BMQVkiO2E6MTp7aTowO3M6MzoidG9wIjt9czoxOToiflVTRV9EWU5BTUlDX1NDUk9MTCI7czoxOiJZIjtzOjIzOiJ%2BVVNFX0VOSEFOQ0VEX0VDT01NRVJDRSI7czoxOiJOIjtzOjEwOiJ%2BVVNFX0dJRlRTIjtzOjE6IlkiO3M6MTU6In5VU0VfUFJFUEFZTUVOVCI7czoxOiJOIjtzOjIwOiJ%2BVVNFX1BSSUNFX0FOSU1BVElPTiI7czoxOiJZIjtzOjExOiJ%2BQ0FDSEVfVFlQRSI7czoxOiJBIjtzOjEzOiJ%2BQ0FDSEVfR1JPVVBTIjtzOjE6Ik4iO3M6MTA6In5BSkFYX1BBVEgiO3M6NDk6Ii9sb2NhbC9jb21wb25lbnRzL2F3Zy9zYWxlLmJhc2tldC5iYXNrZXQvYWpheC5waHAiO3M6MTU6In5QQVRIX1RPX0JBU0tFVCI7czoxNToiL3BlcnNvbmFsL2NhcnQvIjtzOjExOiJ%2BREVUQUlMX1VSTCI7czowOiIiO3M6MTI6In5XRUlHSFRfS09FRiI7ZDoxO3M6MTI6In5XRUlHSFRfVU5JVCI7czoyOiLQsyI7czoxMzoifkNPTFVNTlNfTElTVCI7YTo3OntpOjA7czo0OiJOQU1FIjtpOjE7czoxNToiUFJFVklFV19QSUNUVVJFIjtpOjI7czo4OiJESVNDT1VOVCI7aTozO3M6NjoiREVMRVRFIjtpOjQ7czo1OiJQUklDRSI7aTo1O3M6MzoiU1VNIjtpOjY7czo4OiJRVUFOVElUWSI7fXM6MzA6In5CQVNLRVRfV0lUSF9PUkRFUl9JTlRFR1JBVElPTiI7czoxOiJOIjtzOjI1OiJ%2BQkFTS0VUX01BWF9DT1VOVF9UT19TSE9XIjtpOjU7czoyNjoifkJBU0tFVF9IQVNfQkVFTl9SRUZSRVNIRUQiO3M6MToiTiI7czozMzoiTElTVF9TSE9XX0FERF9UT19GQVZPUklURVNfQlVUVE9OIjtiOjE7fQ%3D%3D.784537117e04f5383e176085a7d6a4f8887f17330116983e02c4c454f30e1fc3&template=ilona.cca59f83e097662fac0167393af6e7ac15b1adad71451e781b7ef9448ddce9e7&via_ajax=Y&basketAction=recalculateAjax&BasketClear=Y""";
         given()
                .log().uri()
                .log().method()
                .log().body()
                .log().headers()
                .contentType(ContentType.URLENC)
                .body(data)

                .when()
                .post("/local/components/awg/sale.basket.basket/ajax.php")

                .then()
                .log().status()
                .log().body()
                .log().all()
                .statusCode(200)
                //.contentType(ContentType.JSON)
                .body("BASKET_REFRESHED", is("true"));
    }
}