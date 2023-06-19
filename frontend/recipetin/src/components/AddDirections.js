import React, { useState } from 'react';
import { 
    InputGroup,
    Button,
    Form,
    Container
 } from 'react-bootstrap';

import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { 
    faTrash,
    faPenToSquare,
    faFloppyDisk
 } from '@fortawesome/free-solid-svg-icons';


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


const AddDirections = ({value, setValue})=>{

    function updateEdit(index){
        console.log("in updateEdit()")
        console.log(value)
        
        const newList = deepCopyFunction(value)
        const newDirectionArray = [...newList.directions]; // direction array 

        const newDirection = newDirectionArray.find( // find needed index 
            d => d.id === index 
        );
        newDirection.edit = !newDirection.edit; // edit is opposite
        
        //Note that the ... spread syntax is “shallow”—
        //it only copies things one level deep.
        // This makes it fast, but it also means that 
        //if you want to update a nested property, you’ll have to use it more than once.
        
        setValue({...newList}) //Now point value to our new created object
        
    }
    function deleteDirection(index){
        console.log("in deleteDirection()")
        console.log(value)

        const newList = deepCopyFunction(value);
        const oldDirectionArray = [...newList.directions]; // direction array 
        const newDirectionArray = oldDirectionArray.filter(
            d => d.id === index
        )
        //change ids
        console.log(newDirectionArray);
        const Temp = {
            ...newList,
            directions:newDirectionArray            
        }
        setValue({...Temp});
        
        console.log(value);
    }
    function handleDirectionChange(event, index){

        const newList = deepCopyFunction(value);
        const newDirectionArray = [...newList.directions];

        const newDirection = newDirectionArray.find(
            d => d.id === index
        )
        newDirection.name = event.target.value;

        setValue({...newList})

    }

    return(
        <ol type="1">
            {value.directions?.map(item =>
                <li key={item.id}>
                    {item.edit?(
                        <InputGroup>
                            <Form.Control
                            type='text'
                            value={item.name}
                            onChange={
                                e=> 
                                handleDirectionChange(e, item.id)
                            }
                            />
                            <Button
                                onClick={()=>{updateEdit(item.id)}}
                                variant="outline-primary"
                            >
                                <FontAwesomeIcon icon={faFloppyDisk}/>
                            </Button>
                            <Button
                                onClick={()=>{deleteDirection(item.id)}}
                                varaint="outline-danger"
                            >
                                <FontAwesomeIcon icon={faTrash}/>
                            </Button>
                        </InputGroup>
                        
                        
                    ):(
                        <Container
                        style={{display:"flex"}}
                        >
                            <div
                            style={{flex:"1",
                              padding:"10px",
                            }}
                            >
                                <p                             
                                style={{
                                margin: '0em',
                                //display: 'flex', 
                                //overflowWrap: 'break-word',
                                wordBreak:'break-all',
                                whiteSpace:'pre-wrap',
                                //whiteSpace: 'normal',
                                //justifyContent:'left',
                                textAlign:'left'
                                }}
                                >
                                    {item.name}
                                </p>
                            </div>
                            <div
                            style={{display:'flex', alignItems:'center'}}
                            >
                                <Button
                                onClick={
                                    ()=>{
                                        updateEdit(item.id);
                                    }
                                }
                                variant="outline-success"
                                >
                                    <FontAwesomeIcon icon={faPenToSquare}/>
                                </Button>
                            </div>
                        </Container>
                        
                    )}
                    
                </li>
            )}
        </ol>
    );
};
export default AddDirections;