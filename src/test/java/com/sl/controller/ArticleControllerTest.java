package com.sl.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Assert;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml","classpath:spring-mvc.xml"})
@WebAppConfiguration(value = "src/main/webapp")
public class ArticleControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;
    protected MockMvc mockMvc;
    
    @Before
    public void setup(){
        //加载web容器上下文
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void getByIdTest() throws Exception {
    	
//    	ResultActions resultActions = mockMvc.perform(
//				 MockMvcRequestBuilders
//				 .get("/article/getById")//开始的斜杠不能丢，否则404
//				 .contentType(MediaType.APPLICATION_FORM_URLENCODED)// 数据的格式 
//				 .param("id","5")// 添加参数
//				 );
//    	
//        MvcResult mvcResult = resultActions
//       		 .andExpect(MockMvcResultMatchers.status().isOk()) //判断返回状态是否200
//       		 .andReturn();
//        String result = mvcResult.getResponse().getContentAsString();
//        System.out.println("result:"+result);
        
        
        mockMvc.perform(MockMvcRequestBuilders.get("/article/getById")
                .param("id", "15")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(15))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("123456"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        
    }
    
    /**
	 * 写入数据库
     * @throws Exception 
	 */
	@Test
	public void addTest() throws Exception {
		
    	ResultActions resultActions = mockMvc.perform(
				 MockMvcRequestBuilders
				 .get("/article/add")//开始的斜杠不能丢，否则404
				 .contentType(MediaType.APPLICATION_FORM_URLENCODED)// 数据的格式 
				 .param("title", "测试用户1")
                 .param("classify", "123456")
	             .param("content", "123456"));
    	
        MvcResult mvcResult = resultActions
       		 .andExpect(MockMvcResultMatchers.status().isOk()) //判断返回状态是否200
       		 .andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("result:"+result);
	}
	
    /**
              * 加这个注释不会真正删除数据库，不破坏数据库，事务回滚
     * @throws Exception
     */
    @Transactional
    @Test
    public void delete() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.post("/article/delete")
                .param("id", "15"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
    @Test
    public void detailTest() throws Exception {
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/article/detail").param("id", "15"))
                .andExpect(MockMvcResultMatchers.view().name("page/detail"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    	Assert.assertNotNull(result.getModelAndView().getModel().get("article"));
    }
}
