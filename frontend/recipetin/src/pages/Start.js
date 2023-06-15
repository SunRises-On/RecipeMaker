import React from 'react';
import './styles/HomeStyle.css';
import AddRecipe from '../components/AddRecipe'

export default function Start(){
    const handleAdd = ()=>{
        console.log("Add new recipe")
    }
    return(
            <div className="main">
                <AddRecipe handleAdd={handleAdd}/>
            </div>

    );
}