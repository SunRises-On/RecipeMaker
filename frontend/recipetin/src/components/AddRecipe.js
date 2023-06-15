import React, { useState } from 'react';
import { InputGroup } from 'react-bootstrap';
import Form from 'react-bootstrap/Form';
import Ingredients from './Ingredients';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Directions from './Directions';

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
    const [ingredientTemp,setIngredientTemp] = useState(" ")
    const [directionTemp, setDirectionTemp] = useState(" ")
    const [value,setValue] = useState({
        name: ' ',
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
        }

        setValue({...Temp})
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
    const nameHandler = (e) =>{
        console.log("change = " + e.target.value);
        setValue({
            ...value,
            [e.target.name]: e.target.value
        });
    };

    //Test if string is blank
    // !str = testing if string is falsey (string length is zero)
    // /^\s*$/ = check if string only contains whitespace
    // test() = executes a search for a match between
    //          a regular expression and a string, 
    //          true if there is a match; false otherwise.
    function isBlank(str){
        return (!str || /^\s*$/.test(str));
    }
    const handleIngredientSubmit=event=>{
        event.preventDefault(); //prevent page refresh

        if(isBlank(ingredientTemp)){
            alert("empty submission not allowed");
        } else{
            addIngredient(); //add new ingredient
        }
        setIngredientTemp(' '); //clear input value
        console.log("ingredient temp")
        console.log(ingredientTemp);
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
    
    return(
        <div>
            
            <br/>
            <Card
                 className="mx-auto my-auto p5" 
                 style={{width: '75%',}}>
                <Card.Body>
                    <Card.Title>Enter New Recipe Name</Card.Title>
                </Card.Body>
                <input
                    value={value.name}
                    type='text'
                    name='name'
                    onChange={nameHandler}
                />
                <br/>
            </Card >
                <br/>
            <Card
                className="mx-auto my-auto p5"
                style={{width: '75%',}}>
                <Card.Body>
                    <Card.Title>Ingredients : </Card.Title>
                </Card.Body>
                <Ingredients value={value}/>
                <div>
                    <form onSubmit={handleIngredientSubmit}>
                        <input
                        value={ingredientTemp}
                        type='text'
                        name='ingredientTemp'
                        onChange={event => {
                            setIngredientTemp(event.target.value)
                        }}
                        />
                        <Button
                        type="submit"
                        >Save</Button>
                    </form>
                </div>
                <br/>
            </Card>
                <br/>
            <Card 
                className="mx-auto my-auto p5"
                style={{width: '75%',}}>
                <Card.Body>
                    <Card.Title>Directions : </Card.Title>
                </Card.Body>
                <Directions value={value} setValue={setValue} />
                <div>
                    <form onSubmit={handleDirectionSubmit}>
                        <input
                        value={directionTemp}
                        type='text'
                        name='directionTemp'
                        onChange={event => {
                            setDirectionTemp(event.target.value)
                        }}
                        />
                        <Button
                        type="submit"
                        >Save</Button>
                    </form>
                </div>
                <br/>
            </Card>
            <br/>
            <Button>save</Button>
            <br/>
        </div>
    );
};
export default AddRecipe;