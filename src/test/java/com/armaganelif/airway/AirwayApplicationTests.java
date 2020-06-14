package com.armaganelif.airway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AirwayApplicationTests {

	@Test
	void contextLoads() {
		String cardNo="4221161122330005";

		String a = cardNo.replaceAll("\\b([0-9]{4})[0-9]{0,9}([0-9]{4})\\b", "*");
//		"\\b([0-9]{4})[0-9]{0,9}([0-9]{4})\\b"
		System.out.println("cardno: "  + a);
	}

}
