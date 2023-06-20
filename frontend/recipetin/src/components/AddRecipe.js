import React, { useState } from 'react';
import { InputGroup } from 'react-bootstrap';
import Form from 'react-bootstrap/Form';
import AddIngredients from './AddIngredients';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Card from 'react-bootstrap/Card';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import AddDirections from './AddDirections';
import AddName from './AddName';
import { AddRecipeAxios } from '../services/RecipeService';
import { 
    faFloppyDisk
 } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCheck } from '@fortawesome/free-solid-svg-icons';

const deepCopyFunction = (inObject) => {
    let outObject, value, key
    if (typeof inObject !== "object" || inObject === null) {
        return inObject // Return the value if inObject is not an object
      }
    
      // Create an array or object to hold the values
      outObject = Array.isArray(inObject) ? [] : {}
    
      for (key in inObject) {
        value = inObject[key]
    
        // Recursively (deep) copy for nested objects, including arrays
        outObject[key] = deepCopyFunction(value)
      }
    
      return outObject

}

const AddRecipe = props =>{
    const [nameTemp, setNameTemp] = useState(" ")
    const [ingredientTemp,setIngredientTemp] = useState(" ")
    const [directionTemp, setDirectionTemp] = useState(" ")
    const [recipe,setRecipe] = useState({
        name: "",
        direction: {},
        ingredient: {}
    });
    const [value,setValue] = useState({
        name: [
            {
                id:0,
                name:' ',
                made: false,
                edit:false
            }
        ],
        ingredients: [
            {
                id:0,
                name:'Orange',
                edit:false
            
            },{
                id:1,
                name:'4 Chicken Breast',
                edit:true  
            }
        ],
        directions: [
            {
                id:0,
                name:'First cut the chicken breast into bite sized pieces.',
                edit: false
            },{
                id:1,
                name:'Then coat in a mixture of cornstarch and flour.',
                edit:true
            }
        ] 
    });

    const {handleAdd} = props;

    function addName(){
        const newList = deepCopyFunction(value);
        const newNameArray = [...newList.name];
        //change name 
        newNameArray.at(0).name = nameTemp; //change name
        newNameArray.at(0).made = !newNameArray.at(0).made;
        console.log("index : " + newNameArray.at(0));
        setValue({...newList});

        console.log("new value");
        console.log(value);
    }

    //Create a new Ingredient object
    function addIngredient(){
        
        const newList = deepCopyFunction(value);
        const newIngredientArray = [...newList.ingredients]; 
        const id = newIngredientArray.length;
        //create a new object of type ingredient
        const newIngredient = {id: id, name: ingredientTemp, edit: false};

        const Temp = {
            ...newList,
            ingredients:[
                ...newIngredientArray,
                newIngredient
            ]
        };

        setValue({...Temp});
    }

    function addDirection(){
        const newList = deepCopyFunction(value);
        const newDirectionArray = [...newList.directions];
        const id = newDirectionArray.length;

        const newDirection = {id:id, name: directionTemp, edit:false};

        const Temp = {
            ...newList,
            directions:[
                ...newDirectionArray,
                newDirection
            ]
        }
        setValue({...Temp});

    }
    
    /**
     * Handler methods
     * 
     */
    //Test if string is blank
    // !str = testing if string is falsey (string length is zero)
    // /^\s*$/ = check if string only contains whitespace
    // test() = executes a search for a match between
    //          a regular expression and a string, 
    //          true if there is a match; false otherwise.
    function isBlank(str){
        return (!str || /^\s*$/.test(str));
    }
    const handleNameSubmit=event=>{
        event.preventDefault(); // prevent page refresh

        if(isBlank(nameTemp)){
            alert("Empty submission not allowed");
        }else{
            addName(); // add new name
        }
        setNameTemp(' '); //clear input value
    }
    const handleIngredientSubmit=event=>{
        event.preventDefault(); //prevent page refresh

        if(isBlank(ingredientTemp)){
            alert("empty submission not allowed");
        } else{
            addIngredient(); //add new ingredient
        }
        setIngredientTemp(' '); //clear input value
    }

    const handleDirectionSubmit=event=>{
        event.preventDefault(); //prevent page refresh

        if(isBlank(directionTemp)){
            alert("Empty submission is not allowed");
        }else{
            addDirection(); // add new direction
        }
        setDirectionTemp(' '); //clear input value
        console.log("direction temp")
        console.log(directionTemp)
    }

    function handleRecipeAddAxios(){
        formatObject();
        AddRecipeAxios(recipe);
    }
//format array of objects value
    //So it can be correctly mapped by the
    //backend, into databases.
    function formatObject(){
        const newList = deepCopyFunction(value);
        const newNameArray = [...newList.name];
        const newDirectionArray=[...newList.directions];
        const newIngredientArray = [...newList.ingredients];

        const tempName = newNameArray.at(0).name; 

        //Javascript object is a collection of properties, and a property 
        //is an association between a name(or key) and a value
        //get rid of unneeded values and only keep name property ^^
        const tempDirectionArray = newDirectionArray.map((direction)=>{
            let num = direction.id + 1;
            const column = "direction_"+ num;
            const d = {[column] : direction.name}
            return d
        });
        console.log(tempDirectionArray)
        const tempIngredientArray = newIngredientArray.map((ingredient)=>{
            let num = ingredient.id + 1;
            const column = "ingredient_"+num;
            const i = {[column] : ingredient.name}
            return i
        })


        let tempDirectionObj = {};
        //Now convert array of objects into a single object
        for(let i =0; i< tempDirectionArray.length; i++){
            Object.assign(tempDirectionObj, tempDirectionArray[i]);
        }
        let tempIngredientObj = {};
        for(let i=0; i<tempIngredientArray.length; i++){
            Object.assign(tempIngredientObj, tempIngredientArray[i]);
        }

        console.log(tempIngredientArray)
        //turn into one object 
        const Temp = {
            name:tempName,
            direction:{tempDirectionObj},
            ingredient:{tempIngredientObj}
        };

        setRecipe({...Temp});
        console.log("Recipe = this ^^")
        console.log(recipe)
    }
    return(
        <div>
            
            <br/>
            <Container>
                <Row
                className="justify-content-md-center"
                >
                    <Col 
                    xs={12} lg={8}
                    >
                        <Card 
                        className="mx-auto my-auto p5"
                        >
                            <Card.Body>
                                <Card.Title>Enter New Recipe Name</Card.Title>
                                <hr/>
                                <form onSubmit={handleNameSubmit}>
                                    <AddName value={value}/>
                                    <InputGroup
                                    >
                                        <Form.Control
                                        type='text'
                                        name='nameTemp'
                                        value={nameTemp}
                                        onChange={
                                        e=> setNameTemp(e.target.value)
                                        }
                                        />
                                        <Button
                                        type="submit"
                                        variant="outline-secondary"
                                        >
                                            <FontAwesomeIcon icon={faFloppyDisk}/>
                                        </Button>
                                    </InputGroup>
                                </form>
                            </Card.Body>
                        </Card >
                    </Col>
                    <Col
                    xs={12} lg={8}
                    >
                        <Card
                        className="mx-auto my-auto p5"
                        >
                            <Card.Body>
                                <Card.Title>Ingredients : </Card.Title>
                                <hr/>
                                <AddIngredients value={value}/>
                                <form onSubmit={handleIngredientSubmit}>
                                    <InputGroup
                                    >
                                        <Form.Control
                                        as="textarea"
                                        type='text'
                                        name='ingredientTemp'
                                        value={ingredientTemp}
                                        onChange={
                                        e=> setIngredientTemp(e.target.value)
                                        }
                                        />
                                        <Button
                                        type="submit"
                                        variant="outline-secondary"
                                        >
                                            <FontAwesomeIcon icon={faFloppyDisk}/>
                                        </Button>
                                    </InputGroup>
                                </form>
                            </Card.Body>                
                        </Card>
                    </Col>
                    <Col
                    xs={12} lg={8}
                    >
                        <Card 
                        className="mx-auto my-auto p5"
                        >
                            <Card.Body>
                                <Card.Title>Directions : </Card.Title>
                                <hr/>
                                <AddDirections value={value} setValue={setValue} />
                                <form onSubmit={handleDirectionSubmit}>
                                    <InputGroup
                                    >
                                        <Form.Control
                                        as="textarea"
                                        type='text'
                                        name='directionTemp'
                                        value={directionTemp}
                                        onChange={
                                        e=> setDirectionTemp(e.target.value)
                                        }
                                        />
                                        <Button
                                        className = "text-nowrap"
                                        type="submit"
                                        variant="outline-secondary"
                                        >
                                            <FontAwesomeIcon icon={faFloppyDisk}/>
                                        </Button>
                                    </InputGroup>
                                </form>
                            </Card.Body>                
                        </Card>
                    </Col>
                </Row>
            </Container>
            
            
            <br/>
            <Button
            onClick={handleRecipeAddAxios}
            >save</Button>
            <br/>
        </div>
    );
};
export default AddRecipe;