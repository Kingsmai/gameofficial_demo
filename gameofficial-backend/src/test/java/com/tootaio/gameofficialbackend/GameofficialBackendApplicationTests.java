package com.tootaio.gameofficialbackend;

import com.tootaio.gameofficialbackend.service.AuthorizeService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameofficialBackendApplicationTests {

	@Resource
	AuthorizeService authorizeService;

	@Test
	void contextLoads() {
		authorizeService.Register("张三", "zhangsan1234", "zhangsan@example.com");
		authorizeService.Register("李四", "lisi1234", "lisi@example.com");
		authorizeService.Register("王五", "wangwu1234", "wangwu@example.com");
		authorizeService.Register("赵六", "zhaoliu1234", "zhaoliu@example.com");
	}
}
