package com.heitor.cursomc.resources;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.heitor.cursomc.domain.Categoria;
import com.heitor.cursomc.services.CategoriaService;

import io.restassured.http.ContentType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest
public class CategoriaResourceTest {

	@Autowired
	private CategoriaResource categoriaResource;
	
	@MockBean
	private CategoriaService categoriaService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.categoriaResource);
	}
	
	@Test
	public void retornarCategoria_QuandoBuscarCategoria() {
		when(this.categoriaService.find(1)).thenReturn(new Categoria(1, "Informática"));
		given().accept(ContentType.JSON).when().get("/categorias/{id}", 1).then().statusCode(HttpStatus.OK.value());
	}
	
	
}
