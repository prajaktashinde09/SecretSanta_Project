import React from 'react';

export default class Dropdown2 extends React.Component{
    render(){
        return(
            <>
            <label>Select by Gift_For</label>
            <select>
            <option value="Men">Men</option>
            <option value="Women">Women</option>
            <option value="Kids">Kids</option>
            <option value="Couples">Couples</option>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <label>Select by Price</label>
            <select>
            <option value="0-500">0-500</option>
            <option value="501-1000">501-1000</option>
            <option value="1000-3000 ">1000-3000 </option>
            <option value="above 3000">above 3000</option>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button class="btn btn-success" type="button">Find Gifts</button>
            </>
        )
    }
}