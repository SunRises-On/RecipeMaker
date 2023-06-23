package com.example.recipe;


import java.rmi.server.*;


import com.example.createrecipetin.controller.RecipeController;
import com.example.createrecipetin.repositories.IngredientsRepo;
import com.example.createrecipetin.repositories.InstructionsRepo;
import com.example.createrecipetin.repositories.RecipeRepo;
import com.example.createrecipetin.service.RecipeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RecipeController.class, RecipeService.class, RecipeRepo.class, InstructionsRepo.class, IngredientsRepo.class})
@WebMvcTest(value = RecipeController.class)
public class RecipeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RecipeController recipeController;
    @MockBean(answer = Answers.CALLS_REAL_METHODS)
    private RecipeService recipeService;
    @MockBean
    private RecipeRepo recipeRepo;
    @MockBean
    private InstructionsRepo instructionsRepo;
    @MockBean
    private IngredientsRepo ingredientsRepo;
    //use MockMvc bean instance to invoke APIs
    @Test
    public void createRecipe() throws Exception{
        System.out.println("dlkjadslkjads");

        String path  = "src/test/resources/json/recipe_1.json";
        File file = new File(path);
        String aboslutePath = file.getAbsolutePath();

        String json = readFileAsString(aboslutePath);

    //    InputStream inputStream = getInputStream();


        mockMvc.perform(MockMvcRequestBuilders
                .post("/api/v1/recipe/upload")
                .content(json)
                        .contentType("application/json")
                        .accept("application/json"))
                .andDo(MockMvcResultHandlers.print()) //print request and response
                .andExpect(status().isOk());
                //.andExpect(MockMvcResultHandlers.model())
        //.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
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
