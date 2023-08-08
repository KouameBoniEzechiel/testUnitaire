package ci.smile.paris.rest.api;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ci.smile.paris.business.CategorieBusiness;
import ci.smile.paris.dao.entity.Categorie;
import ci.smile.paris.rest.fact.ControllerFactory;
import ci.smile.paris.utils.FunctionalError;
import ci.smile.paris.utils.TechnicalError;
import ci.smile.paris.utils.Utilities;
import ci.smile.paris.utils.Validate;
import ci.smile.paris.utils.contract.Request;
import ci.smile.paris.utils.contract.Response;
import ci.smile.paris.utils.dto.CategorieDto;
import ci.smile.paris.utils.dto.transformer.CategorieTransformer;
import ci.smile.paris.utils.enums.FunctionalityEnum;




@RunWith(SpringRunner.class)
@SpringBootTest
public class CategorieControllerTest {
	
	@Autowired
	private CategorieController categorieService;

	@Test
	public  void createCategoryTest() throws ParseException {
		
		CategorieDto categorieDto = new CategorieDto();
			
		categorieDto.setLibelleCategorie("Libelle Test");
		
		List<CategorieDto> dataList = new ArrayList<>();
		dataList.add(categorieDto);
		
		Request<CategorieDto> request = new Request<>();
		request.setDatas(dataList);
		request.setUser(3);
		

		Response<CategorieDto> response = categorieService.create(request);
		
		if(response.getItems() != null) {
			System.out.println(request.getDatas());
			System.out.println("Le test createCategory() a été exécuté avec succès !");
			System.out.println(response);		
		}
//		System.out.println(response);
//		System.out.println(request.getDatas().get());
		try {
//			System.out.println(categorieService.create(request));

//		    assertNotNull(request.getDatas());
//		    assertEquals(categorieDto.getId(), request.getDatas().get(1));
//		    assertEquals(categorieDto.getLibelleCategorie(), request.getData().getLibelleCategorie());
		} catch (Exception e) {
		    // Gérer les erreurs éventuelles ici (par exemple, journalisation ou traitement des erreurs)
		    e.printStackTrace();
		}
	
	}
	
	@Test
	public  void updateCategoryTest() throws ParseException {
		
		CategorieDto categorieDto = new CategorieDto();
		
		categorieDto.setId(1);
		categorieDto.setLibelleCategorie("Libelle Tesssssssssst");
		
		List<CategorieDto> dataList = new ArrayList<>();
		dataList.add(categorieDto);
		
		Request<CategorieDto> request = new Request<>();
		request.setDatas(dataList);
		request.setUser(2);
		Response<CategorieDto> response = categorieService.update(request);
		
		if (response.getItems() != null) {
			System.out.println(request.getDatas());
	        System.out.println("Le test updateCategory() a été exécuté avec succès !");
	        System.out.println(response);
	    } else {
	        System.out.println("La liste de réponse est vide !");
	    }
	}
	
	@Test
	public  void deleteCategoryTest() throws ParseException {
		
		CategorieDto categorieDto = new CategorieDto();
		
		categorieDto.setId(1);
		
		List<CategorieDto> dataList = new ArrayList<>();
		dataList.add(categorieDto);
		
		Request<CategorieDto> request = new Request<>();
		request.setDatas(dataList);
		request.setUser(3);
		
		Response<CategorieDto> response = categorieService.delete(request);
		
		if (response.getItems() == null) {
	        System.out.println("La liste de réponse est vide !");
	        System.out.println(response);
	    } else {
	        System.out.println("Le test deleteCategory() comporte une erreur !");
	        System.out.println(response.getItems());
	    }
	}
	
	@Test
	public  void getByCriteriaCategoryTest() throws ParseException {
		
		CategorieDto categorieDto = new CategorieDto();
		

		categorieDto.setId(1);

		
		Request<CategorieDto> request = new Request<>();
		request.setData(categorieDto);
		request.setUser(3);
			
		Response<CategorieDto> response = categorieService.getByCriteria(request);
		
		if (response.getItems() != null) {
			System.out.println(response);
	        System.out.println("Le test getByCriteriaCategory() a été exécuté avec succès !");
	        String message = String.format("ID: %d, Libelle: %s", response.getItems().get(0).getId(), response.getItems().get(0).getLibelleCategorie());
	        System.out.println(message);
	    } else {
	        System.out.println("La liste de réponse est vide !");
	        System.out.println(response.getItems());
	    }
	}


}
















