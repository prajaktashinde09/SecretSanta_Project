import React from 'react';

export default class Dropdown extends React.Component{
    render(){
        return(
            <>
            <label>Select by category</label>
            <select>
            <option  value="Gourment">Gourment</option>
            <option value="Cake">Cake</option>
            <option value="Toys & Games">Toys & Games</option>
            <option value="Flowers">Flowers</option>
            <option value="Fashion & Style">Fashion & Style</option>
            <option value="Home & Living">Home & Living</option>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <label>Select by Occasion</label>
            <select>
            <option value="Birthday">Birthday</option>
            <option value="Anniversary">Anniversary</option>
            <option value="Festival">Festival</option>
            <option value="House Warming">House Warming</option>
            <option value="All Occasion">All Occasion</option>
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