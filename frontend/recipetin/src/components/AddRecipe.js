import React, { useState } from 'react';
import { InputGroup } from 'react-bootstrap';
import Form from 'react-bootstrap/Form';
import Ingredients from './Ingredients';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import Directions from './Directions';
const AddRecipe = props =>{


    const {handleAdd} = props;

    const changeHandler = (e) =>{
        console.log("change = " + e.target.value);
        setValue({
            ...value,
            [e.target.name]: e.target.value
        });
    };
    const [value,setValue] = useState({
        name: "",
        ingredients: [
            {
                id:0,
                name:"Orange",
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
    })
    
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
                    onChange={changeHandler}
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
                <input

                />
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
                <input 
                />
                <br/>
            </Card>
            <br/>
            <Button>save</Button>
            <br/>
        </div>
    );
};
export default AddRecipe;