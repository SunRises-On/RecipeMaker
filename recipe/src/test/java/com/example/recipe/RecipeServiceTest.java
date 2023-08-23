package com.example.recipe;


import com.example.createrecipetin.models.Ingredients;
import com.example.createrecipetin.models.Instructions;
import com.example.createrecipetin.models.Recipe;
import com.example.createrecipetin.repositories.IngredientsRepo;
import com.example.createrecipetin.repositories.InstructionsRepo;
import com.example.createrecipetin.repositories.RecipeRepo;
import com.example.createrecipetin.service.IngredientService;
import com.example.createrecipetin.service.InstructionService;
import com.example.createrecipetin.service.RecipeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {
    // The @Mock annotation creates a mock implementation for the class it is annotated with.
    @Mock
    private RecipeRepo recipeRepo;
    @Mock
    private InstructionsRepo instructionsRepo;
    @Mock
    private IngredientsRepo ingredientsRepo;
    @Mock
    private InstructionService instructionService;
    @Mock
    private IngredientService ingredientService;

    // Create a Service object
    // @InjectMocks also creates the mock implementation of annotated type and injects the dependent mocks into it.
    @InjectMocks
    private RecipeService recipeService;

    @Captor
    private ArgumentCaptor<Recipe> recipeArgumentCaptor;
    @Captor
    private ArgumentCaptor<Ingredients> ingredientsArgumentCaptor;
    @Captor
    private ArgumentCaptor<Instructions> instructionsArgumentCaptor;
    private Recipe recipe;

    @Before
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    public void setup() throws Exception {
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);
    }

    @DisplayName("Test that save method in Recipe Repository is called with specific arguments.")
    @Test
    void save_RecipeRepoSaveMethodCalledWithSpecificArgument() throws Exception {
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);
        System.out.println(recipe);
        //When using a mock in a test, you need to tell the mock what to return
        Mockito.when(recipeRepo.save(ArgumentMatchers.any()))
                .thenReturn(recipe);

        recipeService.save(recipe);

        Mockito.verify(recipeRepo, Mockito.times(1))
                .save(recipeArgumentCaptor.capture());

        //Test to ensure method was called with a specific argument
        assertThat(recipeArgumentCaptor.getValue().getId()).isEqualTo(1L);
        assertThat(recipeArgumentCaptor.getValue().getName()).isEqualTo("Pad Thai");
    }
    /***
     * We are testing the recipe service method.
     * When the method is called what does it do?
     * It saves the recipe in the Recipe Repository.
     * It gets the Ingredient Records from the Recipe obj.
     * It sets the Recipe Record in the Ingredient Obj.
     * It gets Instruction Record from the Recipe obj.
     * It sets the Recipe Record in the Instruction Obj.
     */

    @DisplayName("Save(), Test that Ingredient Obj has a Recipe Obj attribute.")
    @Test
    void save_IngredientRepoSaveMethodCalledWithSpecificArgument() throws Exception {
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);
        System.out.println(recipe);
        //   ingredients.setRecipe(recipe);
        //    System.out.println(ingredients.getIngredient_1());

        //we are testing the recipeService method
        recipeService.save(recipe);
        Ingredients ingredients = recipe.getIngredient();
        System.out.println(ingredients);
        assertThat(ingredients.getRecipe()).isNotNull();
        assertThat(ingredients.getRecipe()).isEqualTo(recipe);
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
