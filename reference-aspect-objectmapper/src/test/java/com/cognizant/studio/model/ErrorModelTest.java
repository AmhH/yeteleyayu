package com.cognizant.studio.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorModelTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void test() throws Exception {
        //read in the source file
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileCopyUtils.copy(new ClassPathResource("json/error-collection.json").getInputStream(),bos);
        String json = new String(bos.toByteArray());
        //execute
        ErrorModel errorModel = objectMapper.readValue(json,ErrorModel.class);
        assertNotNull(errorModel);
        assertTrue(0 == errorModel.getAnotherCount());
        assertEquals("blah",errorModel.getName());
    }
}
