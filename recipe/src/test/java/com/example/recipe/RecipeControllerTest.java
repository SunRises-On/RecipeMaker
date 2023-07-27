package com.example.recipe;


import com.example.createrecipetin.controller.RecipeController;
import com.example.createrecipetin.models.Recipe;
import com.example.createrecipetin.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(classes = {RecipeController.class, RecipeService.class})
//By setting controllers parameter we're telling Spring Boot to restrict the application context created for this test to the given controller bean and some framework beans needed for Spring Web MVC. All other beans we might need to be included separately or mocked away with @MockBean
@WebMvcTest(controllers=RecipeController.class)
public class RecipeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RecipeService recipeService;


    //use MockMvc bean instance to invoke APIs

    @Test
    // Nothing will be returned if the Method in Controller does not have a @ResponseBody !!
    public void testPostRecipe() throws Exception {
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);

        //When using a mock Service in a test, you need to tell the mock what to return
        when(recipeService.save(ArgumentMatchers.any())).thenReturn(recipe);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/recipe/upload")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("utf-8")
                        .content(jsonString))
                  .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.equalTo("Pad Thai")))
                .andReturn()
        ;

    }


    @Test
    public void testGetAllRecipe() throws Exception{
        List<Recipe> recipeList = new ArrayList<>();
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setName("recipe");
        recipeList.add(recipe);
        Mockito.when(recipeService.findAll()).thenReturn(recipeList);
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/recipe/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name",Matchers.equalTo("recipe")))
                .andReturn()
        ;

       // ).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testPutRecipe() throws Exception{
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);

    //    when(recipeService.)
    }

    public Recipe jsonStringToRecipe(String jsonString) throws Exception {
        Recipe recipe = null;
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            recipe = objectMapper.readValue(jsonString, Recipe.class);
            recipe.setId(1L);
        }catch (IOException e){
            e.printStackTrace();
        }

        return recipe;
    }
    public String returnJsonString() throws Exception {
        String path = "src/test/java/resources/json/recipe_1.json";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        String jsonString = readFileAsString(absolutePath);

        return jsonString;
    }
    public static String readFileAsString(String file)throws Exception
    {
        String s = "";
        try {
            s = new String(Files.readAllBytes(Paths.get(file)));
        }
        catch(NoSuchFileException noSuchFileException){
            System.out.println("File "+ file + " has not been found.");
        }
        return s;

    }

}
