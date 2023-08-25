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
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


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

        verify(recipeRepo, times(1))
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

    @DisplayName("Save(), Test that Ingredients Obj has a Recipe Obj attribute.")
    @Test
    void save_checkIngredientObjHasAttributeRecipe() throws Exception {
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);
        System.out.println(recipe);

        Mockito.when(recipeRepo.save(ArgumentMatchers.any()))
                .thenReturn(recipe);

        recipeService.save(recipe);

        Ingredients ingredients = recipe.getIngredient();
        System.out.println(ingredients);

        assertThat(ingredients.getRecipe()).isNotNull();
        assertThat(ingredients.getRecipe()).isEqualTo(recipe);
    }
    @DisplayName("Save(), Test that Instructions Obj has a Recipe Obj attribute.")
    @Test
    void save_checkInstructionsObjHasAttributeRecipe() throws Exception{
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);
        System.out.println(recipe);

        Mockito.when(recipeRepo.save(ArgumentMatchers.any()))
                .thenReturn(recipe);

        recipeService.save(recipe);

        Instructions instructions = recipe.getInstruction();
        System.out.println(instructions);

        assertThat(instructions.getRecipe()).isNotNull();
        assertThat(instructions.getRecipe()).isEqualTo(recipe);
    }

    //public List<Recipe> findAll(){
    //    List<Recipe> recipeList= recipeRepo.findAll();
    //    return  recipeList;
    //}
    @DisplayName("FindAll(), test that Recipe Repository findAll() works.")
    @Test
    void findAll_testFindAllWithOneRecipeObj() throws Exception{
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);
        List<Recipe> list = new ArrayList<>();

        list.add(recipe);

        Mockito.when(recipeRepo.findAll()).thenReturn(list);

        List<Recipe> recipeList = recipeService.findAll();

        verify(recipeRepo, times(1)).findAll();
        verifyNoMoreInteractions(recipeRepo);

        assertThat(recipeList).hasSize(1);

        System.out.println("Recipe List: ");
        System.out.println(recipeList.toString());
    }
    @DisplayName("FindAll(), test that Recipe Repository findAll() will return empty if no records are in the Repository.")
    @Test
    void findAll_testForNoEntries() throws Exception{
        List<Recipe> list = new ArrayList<>();

        Mockito.when(recipeRepo.findAll()).thenReturn(list);

        List<Recipe> recipeList = recipeService.findAll();
        assertThat(recipeList).isEmpty();
    }


    @DisplayName("Update(), test that Recipe object will update.")
    @Test
    public void update_test()throws Exception{
        //set up
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);
        //stub
        Mockito.when(recipeRepo.findById(ArgumentMatchers.any())).thenReturn(Optional.ofNullable(recipe));
        Mockito.when(recipeRepo.save(ArgumentMatchers.any())).thenReturn(recipe);
        //change obj
        recipe.setName("Spicy Pad Thai");
        //call method
        Optional<Recipe> newRecipe = recipeService.update(recipe, 1L);

        assertThat( newRecipe.get().getName()).isEqualTo("Spicy Pad Thai");

    }

    @DisplayName("GetById(), Test that Recipe object will be returned.")
    @Test
    public void getById_testThatObjWillBeReturned() throws Exception {
        //set up
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);
        //stub
        Mockito.when(recipeRepo.findById(ArgumentMatchers.any())).thenReturn(Optional.ofNullable(recipe));
        //call method
        Optional<Recipe> foundRecipe = recipeService.getById(1L);
        //test

        //Verify method will pass if .findBId(1L) is called only once on
        //the mocked object.
        verify(recipeRepo, times(1)).findById(1L);
        verifyNoMoreInteractions(recipeRepo);

        assertThat(foundRecipe).isNotEmpty();
        assertThat(foundRecipe.get().getId()).isEqualTo(1L);
    }
    @DisplayName("GetById(), Test that empty Optional Obj will be returned for Recipe Repository with zero entries")
    @Test
    public void getById_testThatEmptyOptionalObjectWillBeReturned(){
        //stub
        Mockito.when(recipeRepo.findById(ArgumentMatchers.any())).thenReturn(Optional.ofNullable(recipe));
        //call method
        Optional<Recipe> foundRecipe = recipeService.getById(1L);
        //test
        verify(recipeRepo, times(1)).findById(1L);
        verifyNoMoreInteractions(recipeRepo);

        assertThat(foundRecipe).isEmpty();
    }
    //public void deleteById(Long id){
    //    recipeRepo.deleteById(id);
  //  }

    @DisplayName("DeleteById(), Test when Recipe Obj is found and deleted.")
    @Test
    public void deleteById_testThatRecipeIsDeleted() throws Exception {
        //set up
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);

        when(recipeRepo.findById(1L)).thenReturn(Optional.ofNullable(recipe));

        Recipe r = recipeService.deleteById(1l).get();

        verify(recipeRepo, times(1)).findById(1L);
        verify(recipeRepo, times(1)).delete(recipe);
        verifyNoMoreInteractions(recipeRepo);

        assertEquals(recipe, r);
    }

    @DisplayName("DeleteById(), Test when Recipe Obj is not found.")
    @Test
    public void deleteById_testWhenRecipeIsNotFound() throws Exception{

        when(recipeRepo.findById(1L)).thenReturn(null);

        recipeService.deleteById(1L);

        verify(recipeRepo, times(1)).findById(1L);
        verifyNoMoreInteractions(recipeRepo);
    }

   // public void deleteAll(){
   //     recipeRepo.deleteAll();
    //}
    @DisplayName("DeleteAll(), Test deleteAll().")
    @Test
    public void deleteAll_test() throws Exception{
        //set up
        String jsonString = returnJsonString();
        Recipe recipe = jsonStringToRecipe(jsonString);

        List<Recipe> list = new ArrayList<Recipe>(Arrays.asList(recipe));

        when(recipeRepo.findAll()).thenReturn(list);

        recipeService.deleteAll();

        verify(recipeRepo, times(1)).findAll();
        verify(recipeRepo,times(1)).deleteAll(list);
        verifyNoMoreInteractions(recipeRepo);

    }

    @DisplayName("DeleteAll(), test when there are no Recipe objects in the Repository.")
    @Test
    public void deleteAll_testWhenRecipeNotFound() throws Exception {
        when(recipeRepo.findAll()).thenReturn(new ArrayList<>());

        recipeService.deleteAll();

        verify(recipeRepo, times(1)).findAll();
        verify(recipeRepo,times(1)).deleteAll(new ArrayList<>());
        verifyNoMoreInteractions(recipeRepo);
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
